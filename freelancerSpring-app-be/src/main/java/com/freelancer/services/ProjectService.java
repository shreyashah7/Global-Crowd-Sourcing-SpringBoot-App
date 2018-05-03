/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.freelancer.services;

import com.freelancer.entity.BidInfo;
import com.freelancer.entity.Project;
import com.freelancer.entity.User;
import com.freelancer.entity.UserBidInfo;
import com.freelancer.entity.UserProjects;
import com.freelancer.repository.ProjectRepository;
import com.freelancer.repository.UserProjectRepository;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author shahs
 */
@Service
public class ProjectService {

    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    UserProjectRepository userProjectRepository;

    public Object getProjectById(Long projectId) {
        Object projectObj = projectRepository.getProjectById(projectId);
        return projectObj;
    }

    public Project postProject(Project projectObj) {
        if (projectObj != null) {
            Date today = new Date();
            projectObj.setCreated_at(today);
            projectObj.setUpdated_at(today);
            projectObj.setStatus("OPEN");
            Project savedProjectObj = projectRepository.save(projectObj);
            return savedProjectObj;
        }
        return null;
    }

    public List<?> getLoggedInUserProjects(User user) {
        if (user.getRole().equals(1)) {
            return getEmployerProjects(user.getId());
        } else {
            return getFreelancerProjects(user.getId());
        }
    }

    public List<?> getEmployerProjects(Long employerId) {
        return projectRepository.findByEmployer(employerId);
    }

    public List<?> getFreelancerProjects(Long freelancerId) {
        List<UserProjects> userProjectses = userProjectRepository.findByUserId(freelancerId);
        List<BidInfo> bidInfos = new ArrayList<>();
        userProjectses.stream().map((userProjectse) -> {
            BidInfo bidInfo = new BidInfo();
            bidInfo.setBid_rate(userProjectse.getBid_rate());
            bidInfo.setBid_type(userProjectse.getBid_type());
            bidInfo.setDescription(userProjectse.getProject().getDescription());
            bidInfo.setEmployer(userProjectse.getProject().getEmployer());
            bidInfo.setFreelancer(userProjectse.getProject().getFreelancer());
            bidInfo.setId(userProjectse.getProject().getId());
            bidInfo.setJob_rate(userProjectse.getProject().getJob_rate());
            bidInfo.setJob_type(userProjectse.getProject().getJob_type());
            bidInfo.setProject_name(userProjectse.getProject().getProject_name());
            bidInfo.setSkills(userProjectse.getProject().getSkills());
            bidInfo.setStatus(userProjectse.getProject().getStatus());
            return bidInfo;
        }).forEachOrdered((bidInfo) -> {
            bidInfos.add(bidInfo);
        });
        return bidInfos;
    }

    public Project updateProject(Project project) {
        Optional<Project> projectObj = projectRepository.findById(project.getId());
        Project savedProjectObj = null;
        if (projectObj.isPresent()) {
            savedProjectObj = projectRepository.save(project);
        }
        return savedProjectObj;
    }

    public List<Project> getOpenProjects() {
        List<Object[]> openProjects = projectRepository.getOpenProjects();
        List<Project> projectBidInfos = new ArrayList<>();
        openProjects.forEach((openProject) -> {
            projectBidInfos.add((Project) openProject[0]);
        });
        return projectBidInfos;
    }

}
