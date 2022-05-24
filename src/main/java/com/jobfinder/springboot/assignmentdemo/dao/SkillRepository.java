package com.jobfinder.springboot.assignmentdemo.dao;


import com.jobfinder.springboot.assignmentdemo.entity.Skill;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillRepository extends JpaRepository<Skill, Integer> {


	
}
