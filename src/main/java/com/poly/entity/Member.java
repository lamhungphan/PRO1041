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
public class Member implements Serializable{

    private Integer id;
    private String fullname;
    private String address;
    private String phone;
    private String email;
    private Date birthday;
    private Date createdDate;
    private Date updatedDate;
    private Boolean isActived;

    public Member() {
    }

    public Member(Integer id, String fullname, String address, String phone, String email, Date birthday, Date createdDate, Date updatedDate, Boolean isActived) {
        this.id = id;
        this.fullname = fullname;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.birthday = birthday;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
        this.isActived = isActived;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public void setIsActived(Boolean isActived) {
        this.isActived = isActived;
    }

    public Integer getId() {
        return id;
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

    public Date getCreatedDate() {
        return createdDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public Boolean getIsActived() {
        return isActived;
    }

}
