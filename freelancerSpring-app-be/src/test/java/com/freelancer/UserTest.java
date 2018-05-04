/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.freelancer;

import com.freelancer.entity.User;
import com.freelancer.repository.UserRepository;
import static org.junit.Assert.assertNotEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author shahs
 */
@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@SpringBootTest
@DataJpaTest
@AutoConfigureTestDatabase(replace = NONE)
public class UserTest {

    @Autowired
    private UserRepository userRepository;
    private static final String email = "JunitTest-" + Math.random() * 49 + 1 + "@gmail.com";
    private static final String updatedFirstName = "Updated - Test";

    @Test
    public void testCreateUser() {
        User user = new User();
        user.setEmail(email);
        user.setPassword("Testing@123");
        user.setFirst_name("Test");
        user.setLast_name("Admin");
        user.setRole(1);

        user = userRepository.save(user);
        System.out.println("user :" + user);
        String userid = String.valueOf(user.getId());
        assertNotEquals("User Created", Long.parseLong(userid), 0);
    }

    @Test
    public void testGetUserByEmail() {
        User user = new User();
        user.setEmail(email);
        user.setPassword("Testing@123");
        user.setFirst_name("Test");
        user.setLast_name("Admin");
        user.setRole(1);
        user = userRepository.save(user);

        User userObj = userRepository.findByEmail(email);
        assertNotEquals("User found", null, userObj);
    }

    @Test
    public void testUpdateUser() {
        User user = new User();
        user.setEmail(email);
        user.setPassword("Testing@123");
        user.setFirst_name("Test");
        user.setLast_name("Admin");
        user.setRole(1);
        user = userRepository.save(user);
        user.setFirst_name(updatedFirstName);
        User userObj = userRepository.save(user);
        assertNotEquals("User Updated", userObj.getFirst_name(), "Test");
    }

}
