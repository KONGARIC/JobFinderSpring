package com.jobfinder.springboot.assignmentdemo.dao;


import com.jobfinder.springboot.assignmentdemo.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface JobRepository extends JpaRepository<Job,Integer> {


    @Query(value="select * from jobs where id IN :ids",nativeQuery = true)
    @Modifying
    @Transactional
    public List<Job> getJobsByIds(@Param("ids") List<Integer> ids);










}
