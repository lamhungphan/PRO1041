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
    Boolean isAdmin(User user);
    Boolean isEventManager(User user);
    Boolean isMember(User user);
    Boolean isAccoutant(User user);
}
