/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.entity;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author seastone01202
 */
@Getter
@Setter
@AllArgsConstructor
public class PersonInfo {

    private Date date;
    private String fullName;
    private java.util.Date birthDate;
    private String address;
    private String phoneNumber;
    private String major;
    private String email;
    private String question;


}
