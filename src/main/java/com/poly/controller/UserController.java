/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.controller;

import com.poly.entity.User;
import com.poly.services.AuthorizationService;
import com.poly.services.UserService;
import com.poly.utils.ComponentManagement;
import com.poly.utils.InputFields;
import com.poly.utils.MsgBox;
import com.poly.view.Login;
import com.poly.view.Main;

import javax.swing.*;

/**
 *
 * @author Computer
 */
public class UserController {

    private final UserService service;
    private final AuthorizationService authorizationService;
    private final Main mainFrame = new Main();

    public UserController(UserService service, AuthorizationService authorizationService) {
        this.service = service;
        this.authorizationService = authorizationService;
    }

    public void doLogin(User userRequest) {
        User loginedUser = service.doLogin(userRequest);
        if (loginedUser == null) {
            MsgBox.alert(null, "Đăng nhập không thành công");
        } else {
            MsgBox.alert(null, "Đăng nhập thành công");
            showWorkspaceByRolename(loginedUser);
        }
    }
//    public void dologout() {
//        mainFrame.dispose();
//        new Login(UserController.this).setVisible(true);
//    }

    public void showWorkspaceByRolename(User userLogined) {
        JPanel eventPanel = mainFrame.getPnlEvent();
        JPanel adminPanel = mainFrame.getPnlAdmin();
        JPanel notificationPanel = mainFrame.getPnlNotification();
        JPanel memberPanel = mainFrame.getPnlUser();
        if (authorizationService.isAdmin(userLogined)) {
            new Main().setVisible(true);
        } else if (authorizationService.isEventManager(userLogined)) {
            mainFrame.setVisible(true);
            ComponentManagement.setEnabledRecursively(eventPanel, true);
            ComponentManagement.setEnabledRecursively(adminPanel, false);
            ComponentManagement.setEnabledRecursively(notificationPanel, false);
            ComponentManagement.setEnabledRecursively(memberPanel, false);

        } else if (authorizationService.isMember(userLogined)) {
            mainFrame.setVisible(true);
            ComponentManagement.setEnabledRecursively(eventPanel, false);
            ComponentManagement.setEnabledRecursively(adminPanel, false);
            ComponentManagement.setEnabledRecursively(notificationPanel, false);
            ComponentManagement.setEnabledRecursively(memberPanel, true);
        } else if (authorizationService.isAccoutant(userLogined)) {
            mainFrame.setVisible(true);
            ComponentManagement.setEnabledRecursively(eventPanel, false);
            ComponentManagement.setEnabledRecursively(adminPanel, false);
            ComponentManagement.setEnabledRecursively(notificationPanel, true);
            ComponentManagement.setEnabledRecursively(memberPanel, false);
        }
    }
}
