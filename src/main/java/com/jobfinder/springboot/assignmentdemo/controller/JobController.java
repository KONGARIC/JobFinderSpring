package com.jobfinder.springboot.assignmentdemo.controller;


import com.jobfinder.springboot.assignmentdemo.entity.Job;


import com.jobfinder.springboot.assignmentdemo.service.JobService;
import com.jobfinder.springboot.assignmentdemo.service.LocationService;
import com.jobfinder.springboot.assignmentdemo.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
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
            throw new RuntimeException("Job id is not found");

        }
        return theJob;
    }


    //Delete job
    @DeleteMapping("jobs/{jobId}")
    public String deleteJob(@PathVariable int jobId){
        jobService.deleteJob(jobId);
        return "deleted job with id"+jobId;
    }


    @GetMapping("/jobs/filter")
    public List<Job> filter(@RequestParam(required=false) String skills[],@RequestParam(required=false) String locations[]){

        System.out.println(skills[0]);
        System.out.println(locations[0]);





        List<Integer>  ids=skillService.getIdsWithSkills(skills);
        System.out.println(ids);

        //List<Job> theJob=jobService.getJobsByIds(ids);
        List<Job> theJob=jobService.filter(skills,locations);
        if(theJob==null){
            throw new RuntimeException("No Jobs is not found");

        }
        return theJob;
    }








    //Delete job
//    @DeleteMapping("jobs/{jobId}")
//    public String deleteJob(@PathVariable int jobId){
//        locationService.deleteSkill(jobId);
//        return "deleted job with id"+jobId;
//    }





}
