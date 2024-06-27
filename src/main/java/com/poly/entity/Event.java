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
public class Event implements Serializable{

    private Integer id;
    private String title;
    private String content;
    private Integer attendees;
    private Date startedDate;
    private Date endedDate;
    private String address;
    private Boolean isActived;

    public Event() {
    }

    public Event(Integer id, String title, String content, Integer attendees, Date startedDate, Date endedDate, String address, Boolean isActived) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.attendees = attendees;
        this.startedDate = startedDate;
        this.endedDate = endedDate;
        this.address = address;
        this.isActived = isActived;
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

    public void setAttendees(Integer attendees) {
        this.attendees = attendees;
    }

    public void setStartedDate(Date startedDate) {
        this.startedDate = startedDate;
    }

    public void setEndedDate(Date endedDate) {
        this.endedDate = endedDate;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setIsActived(Boolean isActived) {
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

    public Integer getAttendees() {
        return attendees;
    }

    public Date getStartedDate() {
        return startedDate;
    }

    public Date getEndedDate() {
        return endedDate;
    }

    public String getAddress() {
        return address;
    }

    public Boolean getIsActived() {
        return isActived;
    }

}
