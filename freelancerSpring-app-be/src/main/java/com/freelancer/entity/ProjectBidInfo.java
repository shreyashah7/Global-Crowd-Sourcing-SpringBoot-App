/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.freelancer.entity;

import java.util.Date;

/**
 *
 * @author shahs
 */
public class ProjectBidInfo {

    private Long id;
    private String project_name;
    private String description;
    private String job_type;
    private Long job_rate;
    private Long employer;
    private String skills;
    private String status;
    private Long freelancer;
    private Date created_at;
    private Date updated_at;
    private Integer bid_count;
    private Integer avg_rate;

    public ProjectBidInfo() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProject_name() {
        return project_name;
    }

    public void setProject_name(String project_name) {
        this.project_name = project_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getJob_type() {
        return job_type;
    }

    public void setJob_type(String job_type) {
        this.job_type = job_type;
    }

    public Long getJob_rate() {
        return job_rate;
    }

    public void setJob_rate(Long job_rate) {
        this.job_rate = job_rate;
    }

    public Long getEmployer() {
        return employer;
    }

    public void setEmployer(Long employer) {
        this.employer = employer;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getFreelancer() {
        return freelancer;
    }

    public void setFreelancer(Long freelancer) {
        this.freelancer = freelancer;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    public Integer getBid_count() {
        return bid_count;
    }

    public void setBid_count(Integer bid_count) {
        this.bid_count = bid_count;
    }

    public Integer getAvg_rate() {
        return avg_rate;
    }

    public void setAvg_rate(Integer avg_rate) {
        this.avg_rate = avg_rate;
    }

    @Override
    public String toString() {
        return "ProjectBidInfo{" + "id=" + id + ", project_name=" + project_name + ", description=" + description + ", job_type=" + job_type + ", job_rate=" + job_rate + ", employer=" + employer + ", skills=" + skills + ", status=" + status + ", freelancer=" + freelancer + ", created_at=" + created_at + ", updated_at=" + updated_at + ", bid_count=" + bid_count + ", avg_rate=" + avg_rate + '}';
    }
}
