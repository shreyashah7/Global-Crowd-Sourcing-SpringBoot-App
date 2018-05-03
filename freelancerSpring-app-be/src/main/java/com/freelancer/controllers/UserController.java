/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.freelancer.controllers;

import com.freelancer.entity.User;
import com.freelancer.services.UserService;
import com.freelancer.utility.ResponseFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author shahs
 */
@Controller
@CrossOrigin(origins = "*", allowCredentials = "true", allowedHeaders = "*")
public class UserController {

    @Autowired
    UserService userService;

    ResponseFormat responseObject = new ResponseFormat();

    @GetMapping(path = "/user/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getUserDetails(@PathVariable Long userId) {
        User dbUserEntity = userService.getUserDetails(userId);
        if (dbUserEntity != null) {
            responseObject.setData(dbUserEntity);
            responseObject.setMeta("User retrieved successfully.");
            return new ResponseEntity(responseObject, HttpStatus.OK);
        } else {
            responseObject.setData(dbUserEntity);
            responseObject.setMeta("User not found with this id");
            return new ResponseEntity(responseObject, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(path = "/user/{userId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateUser(@PathVariable Long userId, @RequestBody User user) {
        User dbUserEntity = userService.updateUser(user);
        if (dbUserEntity != null) {
            responseObject.setData(dbUserEntity);
            responseObject.setMeta("User updated successfully.");
            return new ResponseEntity(responseObject, HttpStatus.OK);
        } else {
            responseObject.setData(dbUserEntity);
            responseObject.setMeta("User not found with this id");
            return new ResponseEntity(responseObject, HttpStatus.NOT_FOUND);
        }
    }
}
