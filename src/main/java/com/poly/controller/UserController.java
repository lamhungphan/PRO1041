/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.controller;

import com.poly.entity.User;
import com.poly.services.AuthorizationService;
import com.poly.services.UserService;
import com.poly.utils.MsgBox;
import com.poly.view.Main;

/**
 *
 * @author Computer
 */
public class UserController {

    private final UserService service;
    private final AuthorizationService authorizationService;
    private Main mainFrame;

    public UserController(UserService service, AuthorizationService authorizationService, Main mainFrame) {
        this.service = service;
        this.authorizationService = authorizationService;
        this.mainFrame = mainFrame;
    }

    public void doLogin(User userRequest) {
        User loginedUser = service.doLogin(userRequest);
        if (loginedUser == null) {
            MsgBox.alert(null, "Đăng nhập không thành công");
        } else {
            MsgBox.alert(null, "Đăng nhập thành công");
            new Main().setVisible(true);
        }
    }

    public void showWorkspaceByRolename(User userLogined) {
        if (authorizationService.isAdmin(userLogined)) {
            
        } else if (authorizationService.isEventManager(userLogined)) {
            new Main().setVisible(true);

        }
    }
}
