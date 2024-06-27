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
public class Posts implements Serializable{
    private Integer id;
    private String title;
    private String content;
    private String url;
    private Date createdDate;
    private Date updatedDate;
    private Boolean isActived;

    public Posts() {
    }

    public Posts(Integer id, String title, String content, String url, Date createdDate, Date updatedDate, Boolean isActived) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.url = url;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
        this.isActived = isActived;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getUrl() {
        return url;
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

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setUrl(String url) {
        this.url = url;
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
    
}
