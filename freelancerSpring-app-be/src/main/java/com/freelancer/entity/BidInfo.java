/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.freelancer.entity;

/**
 *
 * @author shahs
 */
public class BidInfo {
    
    private Long id;
    private String project_name;
    private String description;
    private String job_type;
    private Long job_rate;
    private Long employer;
    private String skills;
    private String status;
    private Long freelancer;
    private Long bid_rate;
    private String bid_type;

    public BidInfo() {
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

    public Long getBid_rate() {
        return bid_rate;
    }

    public void setBid_rate(Long bid_rate) {
        this.bid_rate = bid_rate;
    }

    public String getBid_type() {
        return bid_type;
    }

    public void setBid_type(String bid_type) {
        this.bid_type = bid_type;
    }

    @Override
    public String toString() {
        return "BidInfo{" + "id=" + id + ", project_name=" + project_name + ", description=" + description + ", job_type=" + job_type + ", job_rate=" + job_rate + ", employer=" + employer + ", skills=" + skills + ", status=" + status + ", freelancer=" + freelancer + ", bid_rate=" + bid_rate + ", bid_type=" + bid_type + '}';
    }
    
}
