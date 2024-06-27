/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.entity;

import java.io.Serializable;

/**
 *
 * @author Computer
 */
public class Role implements Serializable{
    private Integer id;
    private String description;
    private Boolean isActived;

    public Role() {
    }

    public Role(Integer id, String description, Boolean isActived) {
        this.id = id;
        this.description = description;
        this.isActived = isActived;
    }

    public Integer getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public Boolean getIsActived() {
        return isActived;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setIsActived(Boolean isActived) {
        this.isActived = isActived;
    }
    
    
}
