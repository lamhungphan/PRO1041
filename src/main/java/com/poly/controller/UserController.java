/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.controller;

import com.poly.entity.User;
import com.poly.services.UserService;
import com.poly.utils.MsgBox;
import com.poly.view.Main;

/**
 *
 * @author Computer
 */
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    public void doLogin(User userRequest){
        User loginedUser = service.doLogin(userRequest);
        if(loginedUser == null){
            MsgBox.alert(null, "Đăng nhập không thành công");
        }else {
            MsgBox.alert(null, "Đăng nhập thành công");
            new Main().setVisible(true);
        }
    }
}
