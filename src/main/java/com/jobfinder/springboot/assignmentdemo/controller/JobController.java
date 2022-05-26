package com.jobfinder.springboot.assignmentdemo.controller;


import com.jobfinder.springboot.assignmentdemo.entity.Job;



import com.jobfinder.springboot.assignmentdemo.exception.JobNotFoundException;
import com.jobfinder.springboot.assignmentdemo.service.JobService;
import com.jobfinder.springboot.assignmentdemo.service.LocationService;
import com.jobfinder.springboot.assignmentdemo.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;


import java.util.Arrays;
import java.util.List;

@RestController
public class JobController {

    private SkillService skillService;

    private JobService jobService;

    private LocationService locationService;

    public JobController(){}

    @Autowired
    public JobController(SkillService skillService,JobService jobService,LocationService locationService) {
        this.jobService = jobService;
        this.skillService=skillService;
        this.locationService=locationService;
    }



    //post job
    @PostMapping("jobs")
    public Job addJob(@RequestBody Job job){
        job.setId(0);
        jobService.save(job);
        return job;
    }

    //update job
    @PutMapping("jobs")
    public Job updateJob(@RequestBody Job job){
        jobService.save(job);
        return job;
    }


    //get all jobs
    @GetMapping("/jobs")
    public List<Job> getJobs(){

        return jobService.findAll();
    }

    //get job
    @GetMapping("/jobs/{jobId}")
    public Job getJob(@PathVariable int jobId){
        Job theJob=jobService.findJobById(jobId);
        if(theJob==null){
            throw new JobNotFoundException("Job id is not found");

        }
        return theJob;
    }


    //Delete job
    @DeleteMapping("jobs/{jobId}")
    public String deleteJob(@PathVariable int jobId){



        Job job=jobService.findJobById(jobId);

        if(job==null){
            throw new JobNotFoundException("No job found with id "+jobId);
        }
        jobService.deleteJob(jobId);
        return "Deleted job with id "+jobId;
    }

    public void isAllStrings(String strings[],String type) throws Exception {
        for(int i=0;i<strings.length;i++){
            String location = strings[i];
            boolean isNumeric = location.chars().allMatch( Character::isDigit );
            if(isNumeric){
                throw new Exception("Please provide valid "+type);
            }
        }

    }

    @GetMapping("/jobs/filter")
    public List<Job> filter(@RequestParam(required=false) String locations[],@RequestParam(required=false) String skills[]) throws Exception {
        List<Job> jobs;

        Boolean skillsGiven=false;
        Boolean locationsGiven=false;


        if(skills==null || skills.length==0){

            isAllStrings(locations,"locations");
            skillsGiven=false;
            List<Integer>  ids=locationService.getJobIdsInLocation(locations);
            jobs=jobService.getJobsByIds(ids);
        }
        else if(locations==null || locations.length==0){
            isAllStrings(skills,"skills");
            locationsGiven=false;
            List<Integer> ids=skillService.getIdsWithSkills(skills);
            jobs=jobService.getJobsByIds(ids);
        }
        else {
            isAllStrings(locations,"locations");
            isAllStrings(skills,"skills");
            List<Integer>  idsInLocation=locationService.getJobIdsInLocation(locations);
            List<Integer> idsWithSkills=skillService.getIdsWithSkills(skills);
            idsWithSkills.retainAll(idsInLocation);
            jobs=jobService.getJobsByIds(idsWithSkills);
        }

        if(jobs==null || jobs.isEmpty()){
            if(locationsGiven){
                throw new JobNotFoundException("Currently No Jobs available In this locations "+Arrays.toString(locations));
            }
            else if(skillsGiven){
                throw new JobNotFoundException("Currently No Jobs available with these skills "+ Arrays.toString(skills));
            }
            else {
                throw new JobNotFoundException("Currently No Jobs available In this locations "+Arrays.toString(locations)+" with these skills"+Arrays.toString(skills));
            }


        }
        return jobs;
    }








}
