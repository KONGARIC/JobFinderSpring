package com.jobfinder.springboot.assignmentdemo.service;

import com.jobfinder.springboot.assignmentdemo.dao.JobRepository;
import com.jobfinder.springboot.assignmentdemo.entity.Job;
import com.jobfinder.springboot.assignmentdemo.serviceimpl.JobServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class JobServiceImplTest {

    @Mock
    private JobRepository jobRepository;

    @InjectMocks
    private JobServiceImpl jobService;

    @Test
    void findAll() {

        jobService = new JobServiceImpl(jobRepository);

        List<Job> jobList = new ArrayList<>();

        Job job1=new Job("Software Developer","Zemoso Labs");
        Job job2=new Job("Frontend Developer","Zemoso Labs");
        jobList.add(job1);
        jobList.add(job2);


        when(jobRepository.findAll()).thenReturn(jobList);

        List<Job> expectedList = jobService.findAll();

        assertEquals(2, expectedList.size());
    }

    @Test
    void deleteJob() {
        jobService.deleteJob(1);
        verify(jobRepository).deleteById(1);
    }

    @Test
    void findJobById() {

        when(jobRepository.findById(1)).thenReturn(Optional.of(new Job("Java Developer", "Zemoso")));
        Job job = jobService.findJobById(1);

        Assertions.assertThat(job.getTitle()).isEqualTo("Java Developer");
        Assertions.assertThat(job.getCompanyName()).isEqualTo("Zemoso");

        verify(jobRepository,times(1)).findById(1);

    }

    @Test
    void save() {
        Job job1=new Job("Software Developer","Zemoso Labs");
        jobService.save(job1);
        verify(jobRepository).save(job1);
    }

    @Test
    void getJobsByIds() {

        jobService = new JobServiceImpl(jobRepository);

        List<Job> jobList = new ArrayList<>();

        Job job1=new Job("Software Developer","Zemoso Labs");
        Job job2=new Job("Frontend Developer","Zemoso Labs");
        jobList.add(job1);
        jobList.add(job2);
        List<Integer> ids=new ArrayList<>();
        ids.add(1);
        ids.add(2);


        when(jobRepository.getJobsByIds(ids)).thenReturn(jobList);


        List<Job> expectedList = jobService.getJobsByIds(ids);

        assertEquals(2, expectedList.size());


    }
}