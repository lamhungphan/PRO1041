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
public class Requirement implements Serializable{

    private Integer id;
    private String content;
    private String status;
    private Date createdDate;
    private Date updatedDate;
    private Boolean isActived;

    public Requirement() {
    }

    public Requirement(Integer id, String content, String status, Date createdDate, Date updatedDate, Boolean isActived) {
        this.id = id;
        this.content = content;
        this.status = status;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
        this.isActived = isActived;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public String getContent() {
        return content;
    }

    public String getStatus() {
        return status;
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
