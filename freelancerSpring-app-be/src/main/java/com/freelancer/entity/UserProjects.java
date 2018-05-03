/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.freelancer.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author shahs
 */
@Entity
@Table(name = "user_project_info")
public class UserProjects implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "project_id", nullable = false)
    private Project project;
    @Transient
    private Long project_id;
    @Transient
    private Long user_id;
    private Long bid_rate;
    private String bid_type;
    private Long bid_limit;
    private Date created_at;
    private Date updated_at;

    public UserProjects() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
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

    public Long getBid_limit() {
        return bid_limit;
    }

    public void setBid_limit(Long bid_limit) {
        this.bid_limit = bid_limit;
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

    public Long getProject_id() {
        return project_id;
    }

    public void setProject_id(Long project_id) {
        this.project_id = project_id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "UserProjects{" + "id=" + id + ", user=" + user + ", project=" + project + ", project_id=" + project_id + ", user_id=" + user_id + ", bid_rate=" + bid_rate + ", bid_type=" + bid_type + ", bid_limit=" + bid_limit + ", created_at=" + created_at + ", updated_at=" + updated_at + '}';
    }


}
