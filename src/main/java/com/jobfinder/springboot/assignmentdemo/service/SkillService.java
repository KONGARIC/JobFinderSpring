package com.jobfinder.springboot.assignmentdemo.service;


import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SkillService {

    public List<Integer>  getIdsWithSkills(String[] skills);
}
