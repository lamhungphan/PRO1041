/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.entity;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author Computer
 */
public class User implements Serializable{

    private Integer id;
    private String username;
    private String password;
    private String fullname;
    private String address;
    private String phone;
    private String email;
    private Date birthday;
    private Date createdDate;
    private Date updatedDate;
    private Boolean isActived;

    public User() {
    }

    public User(Integer id, String username, String password, String fullname, String address, String phone, String email, Date birthday, Date createdDate, Date updatedDate, Boolean isActived) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.fullname = fullname;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.birthday = birthday;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
        this.isActived = isActived;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public void setIsActived(Boolean isActived) {
        this.isActived = isActived;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public Boolean getIsActived() {
        return isActived;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getFullname() {
        return fullname;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public Date getBirthday() {
        return birthday;
    }

}
