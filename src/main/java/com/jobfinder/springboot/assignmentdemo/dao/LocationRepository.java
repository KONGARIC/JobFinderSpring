package com.jobfinder.springboot.assignmentdemo.dao;

import com.jobfinder.springboot.assignmentdemo.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Integer> {
}
