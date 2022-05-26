package com.jobfinder.springboot.assignmentdemo.service;

import com.jobfinder.springboot.assignmentdemo.dao.LocationRepository;
import com.jobfinder.springboot.assignmentdemo.serviceimpl.LocationServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class LocationServiceImplTest {

    @Mock
    private LocationRepository locationRepository;

    @InjectMocks
    private LocationServiceImpl locationService;

    @Test
    void getJobIdsInLocation() {

        locationService = new LocationServiceImpl(locationRepository);

        List<Integer> ids=new ArrayList<>();
        ids.add(1);
        ids.add(2);

        String[] locations={"Hyderabad","Hyderabad"};

        when(locationRepository.getJobIdsInLocation(locations)).thenReturn(ids);

        List<Integer> expectedList = locationService.getJobIdsInLocation(locations);

        assertEquals(2, expectedList.size());
    }
}