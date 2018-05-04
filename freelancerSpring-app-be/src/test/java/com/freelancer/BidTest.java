/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.freelancer;

import com.freelancer.entity.Project;
import com.freelancer.entity.User;
import com.freelancer.entity.UserProjects;
import com.freelancer.repository.ProjectRepository;
import com.freelancer.repository.UserProjectRepository;
import com.freelancer.repository.UserRepository;
import static org.junit.Assert.assertNotEquals;
import org.junit.Before;
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
public class BidTest {

    @Autowired
    UserProjectRepository userProjectRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ProjectRepository projectRepository;

    private User userObj;
    private Project projectObj;
    private static final String email = "JunitTest-" + Math.random() * 49 + 1 + "@gmail.com";

    @Before
    public void setUp() {
        User user = new User();
        user.setEmail(email);
        user.setPassword("Testing@123");
        user.setFirst_name("Test");
        user.setLast_name("Admin");
        user.setRole(1);
        userObj = userRepository.save(user);
        Project project = new Project();
        project.setProject_name("Test Project");
        project.setStatus("OPEN");
        project.setDescription("Test Project Description");
        project.setJob_rate(25l);
        project.setJob_type("HOURLY");
        project.setEmployer(1l);
        project.setSkills("Logo Design,Website Design");
        projectObj = projectRepository.save(project);
    }

    @Test
    public void testPlaceBid() {
        UserProjects userProjects = new UserProjects();
        userProjects.setBid_limit(20l);
        userProjects.setBid_rate(20l);
        userProjects.setBid_type("HOURLY");
        userProjects.setProject(projectObj);
        userProjects.setUser(userObj);
        
        userProjects = userProjectRepository.save(userProjects);
        String bidId = String.valueOf(userProjects.getId());
        assertNotEquals("Bid Created", Long.parseLong(bidId), 0);
    }

}
