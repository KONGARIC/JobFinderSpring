package com.jobfinder.springboot.assignmentdemo.controller;


import com.jobfinder.springboot.assignmentdemo.entity.Job;
import com.jobfinder.springboot.assignmentdemo.entity.Skill;
import com.jobfinder.springboot.assignmentdemo.service.JobService;
import com.jobfinder.springboot.assignmentdemo.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class SkillController {

    private SkillService skillService;

    private JobService jobService;
    public SkillController(){}

    @Autowired
    public SkillController(SkillService skillService,JobService jobService) {
        this.jobService = jobService;
        this.skillService=skillService;
    }

    @GetMapping("jobs/{jobId}/skills")
    public List<Skill> getSkills(){
        return skillService.findAll();
    }

    @GetMapping("/skills/{skillId}")
    public Job getJob(@PathVariable int jobId){
        Job theJob=jobService.findJobById(jobId);
        if(theJob==null){
            throw new RuntimeException("Job id is not found");

        }
        return theJob;
    }




//    @PostMapping("jobs/1/skills")
//    public Skill addSkill(@PathParam("jobId") Integer jobId, @RequestBody Skill skills[]){
//        jobId=1;
//        for(Skill skill:skills){
//            skill.setId(0);
//            skill.setJob(1);
//
//            skillService.save(skill);
//
//        }
//
//        return skills[0];
//    }
}
