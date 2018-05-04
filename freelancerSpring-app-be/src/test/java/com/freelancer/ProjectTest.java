package com.freelancer;

import com.freelancer.entity.Project;
import com.freelancer.repository.ProjectRepository;
import java.util.Optional;
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author shahs
 */
@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@SpringBootTest
@DataJpaTest
@AutoConfigureTestDatabase(replace = NONE)
public class ProjectTest {

    @Autowired
    private ProjectRepository projectRepository;

    @Test
    public void testCreateProject() {
        Project project = new Project();
        project.setProject_name("Test Project");
        project.setStatus("OPEN");
        project.setDescription("Test Project Description");
        project.setJob_rate(25l);
        project.setJob_type("HOURLY");
        project.setEmployer(1l);
        project.setSkills("Logo Design,Website Design");

        project = projectRepository.save(project);
        String projectid = String.valueOf(project.getId());
        assertNotEquals("Project Created", Long.parseLong(projectid), 0);
    }

    @Test
    public void testGetProjectDetails() {
        Project project = new Project();
        project.setProject_name("Test Project");
        project.setStatus("OPEN");
        project.setDescription("Test Project Description");
        project.setJob_rate(25l);
        project.setJob_type("HOURLY");
        project.setEmployer(1l);
        project.setSkills("Logo Design,Website Design");

        project = projectRepository.save(project);

        Optional<Project> projectDetails = projectRepository.findById(project.getId());
        assertNotEquals("Project Details Found", false, projectDetails.isPresent());
    }
}
