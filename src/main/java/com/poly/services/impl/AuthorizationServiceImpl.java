/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.services.impl;

import com.poly.constant.RoleConstant;
import com.poly.entity.Event;
import com.poly.entity.User;
import com.poly.injection.EventInjector;
import com.poly.injection.UserInjector;
import com.poly.services.AuthorizationService;
import com.poly.services.EventService;
import com.poly.services.RoleService;
import com.poly.services.UserService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Computer
 */
public class AuthorizationServiceImpl implements AuthorizationService {
    @Override
    public Boolean isAdmin(User user) {
        return user.getRole().getRoleName().equalsIgnoreCase(RoleConstant.CHU_NHIEM);
    }

    @Override
    public Boolean isEventManager(User user) {
        return user.getRole().getRoleName().equalsIgnoreCase(RoleConstant.PHO_CHU_NHIEM);
    }

    @Override
    public Boolean isMember(User user) {
        return user.getRole().getRoleName().equalsIgnoreCase(RoleConstant.THANH_VIEN);
    }

    @Override
    public Boolean isAccoutant(User user) {
        return user.getRole().getRoleName().equalsIgnoreCase(RoleConstant.THU_QUY);
    }
}
