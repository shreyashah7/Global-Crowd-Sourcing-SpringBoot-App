/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.freelancer.repository;

import com.freelancer.entity.UserProjects;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author shahs
 */
public interface UserProjectRepository extends CrudRepository<UserProjects, Long> {
    
    //Fetch Projects associated with user having many-to-one relationship
    List<UserProjects> findByUserId(Long userId);
    
    //Fetch Users associated with project having many-to-one relationship
    List<UserProjects> findByProjectId(Long projectId);
    
}
