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


    @Query(value ="select * from jobs j where title= :skill", nativeQuery = true)
    public Job filterJobBasedOnSkill(@Param("skill") String skill);

    @Query(value="select * from jobs where title IN :title",nativeQuery = true)
    @Modifying
    @Transactional
    public List<Job> findByTitle(@Param("title") String title[]);


    @Query(value="select * from jobs where id IN :ids",nativeQuery = true)
    @Modifying
    @Transactional
    public List<Job> getJobsByIds(@Param("ids") List<Integer> ids);


    @Query(
            value="select * from jobs where id IN " +
                    "(select job_id from skills " +
                    "case when :skills is null then true else  skill IN :skills end " +
                    "INTERSECT " +
                    "select job_id from location " +
                    "case when :locations is null then true else  location IN :locations end )",nativeQuery = true)
    @Modifying
    @Transactional
    public List<Job> filter(@Param("skills") String skills[],@Param("locations") String[] locations);

//    @Query(
//            value="select * from jobs where id IN " +
//                    "( if(:skills , " +
//                    "select job_id from skills , " +
//                    "select job_id from skills where skill IN :skills ) " +
//                    "INTERSECT " +
//                    "if(:locations , " +
//                    "select job_id from location , " +
//                    "select job_id from location where location IN :locations ) )",nativeQuery = true)
//    @Modifying
//    @Transactional
//    public List<Job> filter(@Param("skills") String skills[],@Param("locations") String[] locations);


    int n1 = 5, n2 = 10;

    public final static String SKILL_TABLE_REQUEST =" select job_id from skills where skill IN :skills ";
    public final static String LOCATION_TABLE_REQUEST=" select job_id from location where location IN :locations ";
    public final static String JOBS_TABLE_REQUEST="select * from jobs where id IN ( "+SKILL_TABLE_REQUEST+"INTERSECT"+LOCATION_TABLE_REQUEST+")";


    // Largest among n1 and n2
    final static String max = (":locations"==null) ? "" : "";



}
