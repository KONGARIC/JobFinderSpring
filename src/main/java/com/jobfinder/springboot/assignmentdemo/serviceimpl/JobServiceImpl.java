package com.jobfinder.springboot.assignmentdemo.serviceimpl;


import com.jobfinder.springboot.assignmentdemo.dao.JobRepository;

import com.jobfinder.springboot.assignmentdemo.entity.Job;


import com.jobfinder.springboot.assignmentdemo.exception.JobNotFoundException;
import com.jobfinder.springboot.assignmentdemo.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobServiceImpl implements JobService {

    private JobRepository jobRepository;

    @Autowired
    public JobServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }



    @Override
    public List<Job> findAll() {
        return jobRepository.findAll();
    }



    @Override
    public void deleteJob(int id) {
        jobRepository.deleteById(id);
    }

    @Override
    public Job findJobById(int id) {
        Optional<Job> result = jobRepository.findById(id);
        Job job = null;
        if (result.isPresent()) {
            job = result.get();
        }
        return job;
    }




    @Override
    public void save(Job job) {
        jobRepository.save(job);
    }

    @Override
    public List<Job> getJobsByIds(List<Integer> ids) {
        return jobRepository.getJobsByIds(ids);
    }


}
