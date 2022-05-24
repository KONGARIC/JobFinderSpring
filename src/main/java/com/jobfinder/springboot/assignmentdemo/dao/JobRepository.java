package com.jobfinder.springboot.assignmentdemo.dao;


import com.jobfinder.springboot.assignmentdemo.entity.Job;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface JobRepository extends JpaRepository<Job,Integer> , JpaSpecificationExecutor<Job> {


    @Query(value ="select * from jobs where id in (select s.job_id from skills s where s.skill= :skill)", nativeQuery = true)
    public List<Job> filterJobBasedOnSkill(@Param("skill") String skill);



}
