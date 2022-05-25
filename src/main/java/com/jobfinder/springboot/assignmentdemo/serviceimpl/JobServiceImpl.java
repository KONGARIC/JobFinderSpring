package com.jobfinder.springboot.assignmentdemo.serviceimpl;


import com.jobfinder.springboot.assignmentdemo.dao.JobRepository;

import com.jobfinder.springboot.assignmentdemo.entity.Job;


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
    public Job filterAllJobBasedOnSkill(String skill) {
        return jobRepository.filterJobBasedOnSkill(skill);
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
        } else {
            //throw new RecordNotFoundException("Did not find Category Id - " + id);
        }
        return job;
    }

    @Override
    public List<Job> findJobTitle(String str[]) {
        return jobRepository.findByTitle(str);
    }

    @Override
    public List<Job> filter(String[] skills, String[] locations) {
        return jobRepository.filter(skills,locations);
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
