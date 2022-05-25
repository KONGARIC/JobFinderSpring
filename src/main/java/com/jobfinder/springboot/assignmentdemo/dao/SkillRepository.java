package com.jobfinder.springboot.assignmentdemo.dao;


import com.jobfinder.springboot.assignmentdemo.entity.Job;
import com.jobfinder.springboot.assignmentdemo.entity.Skill;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface SkillRepository extends JpaRepository<Skill, Integer> {

    @Query(value="select job_id from skills where skill IN :skills",nativeQuery = true)
    @Modifying
    @Transactional
    public List<Integer>  getIdsWithSkills(@Param("skills") String skills[]);


	
}
