/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.freelancer.controllers;

import com.freelancer.entity.UserBidInfo;
import com.freelancer.entity.UserProjects;
import com.freelancer.services.UserProjectService;
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
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author shahs
 */
@Controller
@CrossOrigin(origins = "*", allowCredentials = "true", allowedHeaders = "*")
public class UserProjectController {

    @Autowired
    UserProjectService userProjectService;

    ResponseFormat responseObject = new ResponseFormat();

    @PostMapping(path = "/placebid", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> placeBid(@RequestBody UserProjects userProjects) {
        UserProjects userProjectObj = userProjectService.saveBid(userProjects);
        if (userProjectObj != null) {
            responseObject.setData(userProjectObj);
            responseObject.setMeta("Bid Placed successfully.");
            return new ResponseEntity(responseObject, HttpStatus.OK);
        } else {
            responseObject.setData(userProjectObj);
            responseObject.setMeta("Issue with Placing Bid.");
            return new ResponseEntity(responseObject, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(path = "/bids/{projectId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAllBidsByProject(@PathVariable Long projectId) {
        List<UserBidInfo> userBidInfos = userProjectService.getAllBidsByProject(projectId);
        if (!userBidInfos.isEmpty()) {
            responseObject.setData(userBidInfos);
            responseObject.setMeta("Bids for Project retrieved successfully.");
            return new ResponseEntity(responseObject, HttpStatus.OK);
        } else {
            responseObject.setData(userBidInfos);
            responseObject.setMeta("Project not found with this id");
            return new ResponseEntity(responseObject, HttpStatus.NOT_FOUND);
        }
    }
}
