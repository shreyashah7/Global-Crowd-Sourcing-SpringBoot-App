/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.freelancer.services;

import com.freelancer.entity.Project;
import com.freelancer.entity.User;
import com.freelancer.entity.UserBidInfo;
import com.freelancer.entity.UserProjects;
import com.freelancer.repository.ProjectRepository;
import com.freelancer.repository.UserProjectRepository;
import com.freelancer.repository.UserRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author shahs
 */
@Service
public class UserProjectService {
    
    @Autowired
    UserProjectRepository userProjectRepository;
    
    @Autowired
    ProjectRepository projectRepository;
    
    @Autowired
    UserRepository userRepository;
    
    public UserProjects saveBid(UserProjects userProjects){
        Optional<Project> projectObj = projectRepository.findById(userProjects.getProject_id());
        Optional<User> userObj = userRepository.findById(userProjects.getUser_id());
        if(projectObj.isPresent() && userObj.isPresent()){
            userProjects.setProject(projectObj.get());
            userProjects.setUser(userObj.get());
            return userProjectRepository.save(userProjects);
        }
        return null;
    }
    
     public List<UserBidInfo> getAllBidsByProject(Long projectId){
        List<UserProjects> userProjects = userProjectRepository.findByProjectId(projectId);
        List<UserBidInfo> userBidInfos = new ArrayList<>();
         for (UserProjects userProject : userProjects) {
             UserBidInfo userBidInfo = new UserBidInfo();
             userBidInfo.setAvatar(userProject.getUser().getAvatar());
             userBidInfo.setBid_rate(userProject.getBid_rate());
             userBidInfo.setBid_type(userProject.getBid_type());
             userBidInfo.setCreated_at(userProject.getCreated_at());
             userBidInfo.setId(userProject.getUser().getId());
             userBidInfo.setSkills(userProject.getUser().getSkills());
             userBidInfo.setUser_name(userProject.getUser().getFirst_name() + " " + userProject.getUser().getLast_name());
             userBidInfos.add(userBidInfo);
         }
        return userBidInfos;
    }
    
}
