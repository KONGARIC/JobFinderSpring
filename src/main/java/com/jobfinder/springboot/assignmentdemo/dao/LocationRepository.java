package com.jobfinder.springboot.assignmentdemo.dao;


import com.jobfinder.springboot.assignmentdemo.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface LocationRepository extends JpaRepository<Location, Integer> {
    @Query(value="select job_id from location where location IN :locations",nativeQuery = true)
    @Modifying
    @Transactional
    public List<Integer> getJobIdsInLocation(@Param("locations") String locations[]);

}
