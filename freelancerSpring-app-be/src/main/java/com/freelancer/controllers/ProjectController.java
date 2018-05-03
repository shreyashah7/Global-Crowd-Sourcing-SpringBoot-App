/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.freelancer.controllers;

import com.freelancer.entity.Project;
import com.freelancer.entity.User;
import com.freelancer.entity.UserBidInfo;
import com.freelancer.services.ProjectService;
import com.freelancer.utility.ResponseFormat;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author shahs
 */
@Controller
@CrossOrigin(origins = "*", allowCredentials = "true", allowedHeaders = "*")
public class ProjectController {

    @Autowired
    ProjectService projectService;

    ResponseFormat responseObject = new ResponseFormat();
    
    @GetMapping(path = "/project/{projectId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getProjectById(@PathVariable Long projectId) {
        Object dbProjectEntity = projectService.getProjectById(projectId);
        if (dbProjectEntity != null) {
            responseObject.setData(dbProjectEntity);
            responseObject.setMeta("Project retrieved successfully.");
            return new ResponseEntity(responseObject, HttpStatus.OK);
        } else {
            responseObject.setData(dbProjectEntity);
            responseObject.setMeta("Project not found with this id");
            return new ResponseEntity(responseObject, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(path = "/project", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> postProject(@RequestBody Project project) {
        Project projectObj = projectService.postProject(project);
        if (projectObj != null) {
            responseObject.setData(projectObj);
            responseObject.setMeta("Project posted successfully.");
            return new ResponseEntity(responseObject, HttpStatus.OK);
        } else {
            responseObject.setData(projectObj);
            responseObject.setMeta("Issue with Posting your project.");
            return new ResponseEntity(responseObject, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(path = "/userprojects", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getLoggedInUserProjects(@RequestBody User userObj) {
        List<?> loggedInUserProjects = projectService.getLoggedInUserProjects(userObj);
        System.out.println("loggedInUserProjects :" + loggedInUserProjects);
        if (!loggedInUserProjects.isEmpty()) {
            responseObject.setData(loggedInUserProjects);
            responseObject.setMeta("Project retrived successfully.");
            return new ResponseEntity(responseObject, HttpStatus.OK);
        } else {
            responseObject.setData(loggedInUserProjects);
            responseObject.setMeta("No projects available");
            return new ResponseEntity(responseObject, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(path = "/project", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateProject(@RequestBody Project projectObj) {
        Project projectEntity = projectService.updateProject(projectObj);
        if (projectEntity != null) {
            responseObject.setData(projectEntity);
            responseObject.setMeta("Hired freelancer successfully.");
            return new ResponseEntity(responseObject, HttpStatus.OK);
        } else {
            responseObject.setData(projectEntity);
            responseObject.setMeta("Issue with hiring the freelancer.");
            return new ResponseEntity(responseObject, HttpStatus.NOT_FOUND);
        }
    }
    
    @GetMapping(path = "/projects", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getOpenProjects() {
        List<Project> openProjects = projectService.getOpenProjects();
        System.out.println("openProjects :"+openProjects);
        if (!openProjects.isEmpty()) {
            responseObject.setData(openProjects);
            responseObject.setMeta("Open Projects retrieved successfully.");
            return new ResponseEntity(responseObject, HttpStatus.OK);
        } else {
            responseObject.setData(openProjects);
            responseObject.setMeta("No projects found");
            return new ResponseEntity(responseObject, HttpStatus.NOT_FOUND);
        }
    }

}
