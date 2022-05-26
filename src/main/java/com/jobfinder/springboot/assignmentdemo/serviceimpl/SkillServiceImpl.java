package com.jobfinder.springboot.assignmentdemo.serviceimpl;



import com.jobfinder.springboot.assignmentdemo.dao.SkillRepository;

import com.jobfinder.springboot.assignmentdemo.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class SkillServiceImpl implements SkillService {

    @Autowired
    private SkillRepository skillRepository;
    @Autowired
    public SkillServiceImpl(SkillRepository skillRepository){
        this.skillRepository=skillRepository;
    }




    @Override
    public List<Integer> getIdsWithSkills(String[] skills) {
        return skillRepository.getIdsWithSkills(skills);
    }
}
