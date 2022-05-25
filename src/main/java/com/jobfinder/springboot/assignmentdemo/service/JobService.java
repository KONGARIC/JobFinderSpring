package com.jobfinder.springboot.assignmentdemo.service;


import com.jobfinder.springboot.assignmentdemo.entity.Job;


import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface JobService {


	public List<Job> findAll();
	public Job filterAllJobBasedOnSkill(String skill);

	public void deleteJob(int id);

	public Job findJobById(int id);

	public List<Job> findJobTitle(String str[]);

	public List<Job> filter(String skills[],String[] locations);

	public void save(Job job);
	public List<Job> getJobsByIds(List<Integer> ids);

	
}
