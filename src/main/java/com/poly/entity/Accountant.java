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
public class Accountant implements Serializable{

    private Integer id;
    private float inventory;
    private Integer quantity;
    private float amountMoney;
    private Boolean isActived;

    public Accountant() {
    }

    public Accountant(Integer id, float inventory, Integer quantity, float amountMoney, Boolean isActived) {
        this.id = id;
        this.inventory = inventory;
        this.quantity = quantity;
        this.amountMoney = amountMoney;
        this.isActived = isActived;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setInventory(float inventory) {
        this.inventory = inventory;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setAmountMoney(float amountMoney) {
        this.amountMoney = amountMoney;
    }

    public void setIsActived(Boolean isActived) {
        this.isActived = isActived;
    }

    public Integer getId() {
        return id;
    }

    public float getInventory() {
        return inventory;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public float getAmountMoney() {
        return amountMoney;
    }

    public Boolean getIsActived() {
        return isActived;
    }
    
    
}
