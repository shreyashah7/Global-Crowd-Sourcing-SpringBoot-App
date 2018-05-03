/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.freelancer.controllers;

import com.freelancer.entity.Skill;
import com.freelancer.services.SkillService;
import com.freelancer.utility.ResponseFormat;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author shahs
 */
@Controller
@CrossOrigin(origins = "*", allowCredentials = "true", allowedHeaders = "*")
public class SkillController {
    
    @Autowired
    SkillService skillService;
    
    ResponseFormat responseObject = new ResponseFormat();
    
    @GetMapping(path = "/skills", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getUserDetails() {
        List<Skill> skills = skillService.getSkills();
        if (!skills.isEmpty()) {
            responseObject.setData(skills);
            responseObject.setMeta("Skills retrieved successfully.");
            return new ResponseEntity(responseObject, HttpStatus.OK);
        } else {
            responseObject.setData(skills);
            responseObject.setMeta("Skills not found");
            return new ResponseEntity(responseObject, HttpStatus.NOT_FOUND);
        }
    }
    
    
}
