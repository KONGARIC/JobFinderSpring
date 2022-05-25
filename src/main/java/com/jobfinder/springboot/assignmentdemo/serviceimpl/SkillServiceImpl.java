package com.jobfinder.springboot.assignmentdemo.serviceimpl;


import com.jobfinder.springboot.assignmentdemo.dao.SkillRepository;
import com.jobfinder.springboot.assignmentdemo.entity.Skill;
import com.jobfinder.springboot.assignmentdemo.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class SkillServiceImpl implements SkillService {

    @Autowired
    private SkillRepository skillRepository;

    @Override
    public List<Skill> findAll() {
        return skillRepository.findAll();
    }

    @Override
    public Skill findSkillById(int id) {
        Optional<Skill> result = skillRepository.findById(id);
        Skill skill = null;
        if(result.isPresent()) {
            skill = result.get();
        }
        else {
           // throw new RecordNotFoundException("Did not find item id - " + id);
        }
        return skill;
    }

    @Override
    public void deleteSkill(int id) {
        skillRepository.deleteById(id);
    }

    @Override
    public void save(Skill skill) {
        skillRepository.save(skill);
    }

    @Override
    public List<Integer> getIdsWithSkills(String[] skills) {
        return skillRepository.getIdsWithSkills(skills);
    }
}
