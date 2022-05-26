package com.jobfinder.springboot.assignmentdemo.service;

import com.jobfinder.springboot.assignmentdemo.entity.Job;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface JobService {


	public List<Job> findAll();


	public void deleteJob(int id);

	public Job findJobById(int id);



	public void save(Job job);
	public List<Job> getJobsByIds(List<Integer> ids);

	
}
