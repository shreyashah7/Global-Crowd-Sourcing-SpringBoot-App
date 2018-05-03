/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.freelancer.services;

import com.freelancer.entity.Skill;
import com.freelancer.entity.User;
import com.freelancer.repository.SkillRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author shahs
 */
@Service
public class SkillService {

    @Autowired
    private SkillRepository skillRepository;

    public List<Skill> getSkills() {
        Iterable<Skill> skills = skillRepository.findAll();
        List<Skill> skillList = new ArrayList<>();
        skills.forEach(skillList::add);
        return skillList;
    }

}
