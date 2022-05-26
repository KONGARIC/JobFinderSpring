package com.jobfinder.springboot.assignmentdemo.serviceimpl;

import com.jobfinder.springboot.assignmentdemo.dao.LocationRepository;

import com.jobfinder.springboot.assignmentdemo.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LocationServiceImpl implements LocationService {

    private LocationRepository locationRepository;
    @Autowired
    public LocationServiceImpl(LocationRepository locationRepository){
        this.locationRepository=locationRepository;
    }


    @Override
    public List<Integer> getJobIdsInLocation(String[] locations) {
        return locationRepository.getJobIdsInLocation(locations);
    }
}
