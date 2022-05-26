package com.jobfinder.springboot.assignmentdemo.service;


import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LocationService {

    public List<Integer>  getJobIdsInLocation(String[] locations);
}