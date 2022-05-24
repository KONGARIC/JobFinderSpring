package com.jobfinder.springboot.assignmentdemo.serviceimpl;

import com.jobfinder.springboot.assignmentdemo.dao.LocationRepository;
import com.jobfinder.springboot.assignmentdemo.entity.Skill;
import com.jobfinder.springboot.assignmentdemo.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LocationServiceImpl implements LocationService {
    @Autowired
    private LocationRepository locationRepository;
    @Override
    public List<Skill> findAll() {
        return null;
    }

    @Override
    public Skill findSkillById(int id) {
        return null;
    }

    @Override
    public void deleteSkill(int id) {
        locationRepository.deleteById(id);
    }

    @Override
    public void save(Skill skill) {

    }
}
