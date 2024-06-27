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
public class Fund implements Serializable{
    
    private Integer id;
    private String fundName;
    private float totalAmount;
    private float deductAmount;
    private float balanceAmount;
    private Date createdDate;
    private Date updatedDate;

    public Fund() {
    }

    public Fund(Integer id, String fundName, float totalAmount, float deductAmount, float balanceAmount, Date createdDate, Date updatedDate) {
        this.id = id;
        this.fundName = fundName;
        this.totalAmount = totalAmount;
        this.deductAmount = deductAmount;
        this.balanceAmount = balanceAmount;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setFundName(String fundName) {
        this.fundName = fundName;
    }

    public void setTotalAmount(float totalAmount) {
        this.totalAmount = totalAmount;
    }

    public void setDeductAmount(float deductAmount) {
        this.deductAmount = deductAmount;
    }

    public void setBalanceAmount(float balanceAmount) {
        this.balanceAmount = balanceAmount;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public Integer getId() {
        return id;
    }

    public String getFundName() {
        return fundName;
    }

    public float getTotalAmount() {
        return totalAmount;
    }

    public float getDeductAmount() {
        return deductAmount;
    }

    public float getBalanceAmount() {
        return balanceAmount;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }
    
    
}
