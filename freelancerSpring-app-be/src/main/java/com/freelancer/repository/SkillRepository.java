/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.freelancer.repository;

import com.freelancer.entity.Skill;
import org.springframework.data.repository.CrudRepository;

/**s
 *
 * @author shahs
 */
public interface SkillRepository extends CrudRepository<Skill, Long> {
    
}
