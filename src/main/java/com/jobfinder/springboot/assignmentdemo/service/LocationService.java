package com.jobfinder.springboot.assignmentdemo.service;

import com.jobfinder.springboot.assignmentdemo.entity.Skill;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface LocationService {
    public List<Skill> findAll();

    public Skill findSkillById(int id);

    public void deleteSkill(int id);

    public void save(Skill skill);
}