/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.freelancer.services;

import com.freelancer.entity.User;
import com.freelancer.repository.UserRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author shahs
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User getUserDetails(Long userId) {
        Optional<User> userObj = userRepository.findById(userId);
        User dbUserObj = null;
        if (userObj.isPresent()) {
            dbUserObj = userObj.get();
        }
        return dbUserObj;
    }

    public User updateUser(User user) {
        Optional<User> userObj = userRepository.findById(user.getId());
        User savedUserObj = null;
        if (userObj.isPresent()) {
            savedUserObj = userRepository.save(user);
        }
        return savedUserObj;
    }
}
