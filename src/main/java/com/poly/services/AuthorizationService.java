/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.services;

import com.poly.entity.User;

/**
 *
 * @author Computer
 */
public interface AuthorizationService {
    public Boolean isAdmin(User user);
    public Boolean isEventManager(User user);
    public Boolean isMember(User user);
    public Boolean isAccoutant(User user);
}
