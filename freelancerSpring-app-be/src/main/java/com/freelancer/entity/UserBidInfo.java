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
public class UserBidInfo {

    private Long id;
    private String user_name;
    private String skills;
    private String avatar;
    private Long bid_rate;
    private String bid_type;
    private Date created_at;

    public UserBidInfo() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
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

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    @Override
    public String toString() {
        return "UserBidInfo{" + "id=" + id + ", user_name=" + user_name + ", skills=" + skills + ", avatar=" + avatar + ", bid_rate=" + bid_rate + ", bid_type=" + bid_type + ", created_at=" + created_at + '}';
    }

}
