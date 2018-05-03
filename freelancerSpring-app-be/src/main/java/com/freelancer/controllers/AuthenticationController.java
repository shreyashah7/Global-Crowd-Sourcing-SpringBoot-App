package com.freelancer.controllers;

import com.freelancer.entity.User;
import com.freelancer.services.AuthenticationService;
import com.freelancer.utility.ResponseFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;

@Controller
@CrossOrigin(origins = "*", allowCredentials = "true", allowedHeaders = "*")
public class AuthenticationController {

    @Autowired
    AuthenticationService authenticationService;

    ResponseFormat responseObject = new ResponseFormat();
    
    @PostMapping(path = "/login", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> login(@RequestBody User userEntity, HttpSession session) {
        System.out.println("inside login-------------" + userEntity.getEmail());
        User dbUserEntity = authenticationService.login(userEntity);
        if (dbUserEntity != null) {
            session.setAttribute("userId", dbUserEntity.getId());
            session.setAttribute("email", dbUserEntity.getEmail());
            responseObject.setData(dbUserEntity);
            responseObject.setMeta("You are logged In Successfully.");
            return new ResponseEntity(responseObject, HttpStatus.OK);
        } else {
            responseObject.setData(dbUserEntity);
            responseObject.setMeta("Login Failed. Issue With username or password.");
            return new ResponseEntity(responseObject, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(path = "/signup", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> signUp(@RequestBody User userEntity, HttpSession session) {
        Boolean passwordValidity = authenticationService.checkPasswordPattern(userEntity.getPassword());
        if (!passwordValidity) {
            responseObject.setData(null);
            responseObject.setMeta("The password is too weak");
            return new ResponseEntity(responseObject, HttpStatus.BAD_REQUEST);
        }
        User existedUser = authenticationService.checkUserExist(userEntity);
        if (existedUser != null) {
            responseObject.setData(null);
            responseObject.setMeta("User Already Exist in the system with this email address.");
            return new ResponseEntity(responseObject, HttpStatus.BAD_REQUEST);
        }
        User dbUserDatabean = authenticationService.signUp(userEntity);
        if (dbUserDatabean != null) {
            responseObject.setData(dbUserDatabean);
            responseObject.setMeta("Your account has been created successfully.");
            return new ResponseEntity(responseObject, HttpStatus.OK);
        } else {
            responseObject.setData(dbUserDatabean);
            responseObject.setMeta("Signup Failed.");
            return new ResponseEntity(responseObject, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(path = "/logout", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> logout(HttpSession session) {
        System.out.println("SESSION ATTRIBUTE"+session.getAttribute("email"));
        session.invalidate();
        return new ResponseEntity(HttpStatus.OK);
    }
}
