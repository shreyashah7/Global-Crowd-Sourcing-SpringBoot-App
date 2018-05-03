/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.freelancer.repository;

import com.freelancer.entity.Project;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author shahs
 */
public interface ProjectRepository extends CrudRepository<Project, Long> {

    @Query(value = "SELECT P1,count(*) as bid_count,avg(pu_info.bid_rate) as avg_rate FROM Project as P1"
            + " LEFT JOIN UserProjects as pu_info ON P1.id = pu_info.project.id WHERE pu_info.project.id=:projectId")
    Object getProjectById(@Param("projectId") Long projectId);

    List<Project> findByEmployer(Long employer);

    @Query(value = "SELECT P1,COUNT(pu_info.project.id) AS bid_count,avg(pu_info.bid_rate) as avg_rate FROM Project AS P1"
            + " LEFT JOIN UserProjects as pu_info ON P1.id = pu_info.project.id WHERE P1.status = 'OPEN' GROUP BY P1.id ORDER BY P1.id")
    List<Object[]> getOpenProjects();

}
