package com.jobfinder.springboot.assignmentdemo.service;

import com.jobfinder.springboot.assignmentdemo.dao.SkillRepository;
import com.jobfinder.springboot.assignmentdemo.serviceimpl.SkillServiceImpl;
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
class SkillServiceImplTest {

    @Mock
    private SkillRepository skillRepository;

    @InjectMocks
    private SkillServiceImpl skillService;

    @Test
    void getIdsWithSkills() {

        skillService = new SkillServiceImpl(skillRepository);

        List<Integer> ids=new ArrayList<>();
        ids.add(1);
        ids.add(2);

        String[] skills={"Java","SQL"};

        when(skillRepository.getIdsWithSkills(skills)).thenReturn(ids);

        List<Integer> expectedList = skillService.getIdsWithSkills(skills);

        assertEquals(2, expectedList.size());
    }
}