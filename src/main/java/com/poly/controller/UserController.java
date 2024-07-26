/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.controller;

import com.poly.entity.User;
import com.poly.injection.UserInjector;
import com.poly.services.AuthorizationService;
import com.poly.services.UserService;
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

    AuthorizationService authorizationService = UserInjector.getInstance().getAuthorizationService();
    UserService userService = UserInjector.getInstance().getUserService();
    private final Main mainFrame = new Main();

    

    public void doLogin(User userRequest) {
        User loginedUser = userService.doLogin(userRequest);
        if (loginedUser == null) {
            MsgBox.alert(null, "Đăng nhập không thành công");
        } else {
            MsgBox.alert(null, "Đăng nhập thành công");
            showWorkspaceByRolename(loginedUser);
        }
    }
    public void dologout() {
        mainFrame.dispose();
        new Login().setVisible(true);
    }

    public void showWorkspaceByRolename(User userLogined) {
        JPanel eventPanel = mainFrame.getPnlEvent();
        JPanel adminPanel = mainFrame.getPnlAdmin();
        JPanel notificationPanel = mainFrame.getPnlNotification();
        JPanel memberPanel = mainFrame.getPnlUser();
        if (authorizationService.isAdmin(userLogined)) {
            new Main().setVisible(true);
        } else if (authorizationService.isEventManager(userLogined)) {
            mainFrame.setVisible(true);
            InputFields.setEnabledRecursively(eventPanel, true);
            InputFields.setEnabledRecursively(adminPanel, false);
            InputFields.setEnabledRecursively(notificationPanel, false);
            InputFields.setEnabledRecursively(memberPanel, false);

        } else if (authorizationService.isMember(userLogined)) {
            mainFrame.setVisible(true);
            InputFields.setEnabledRecursively(eventPanel, false);
            InputFields.setEnabledRecursively(adminPanel, false);
            InputFields.setEnabledRecursively(notificationPanel, false);
            InputFields.setEnabledRecursively(memberPanel, true);
        } else if (authorizationService.isAccoutant(userLogined)) {
            mainFrame.setVisible(true);
            InputFields.setEnabledRecursively(eventPanel, false);
            InputFields.setEnabledRecursively(adminPanel, false);
            InputFields.setEnabledRecursively(notificationPanel, true);
            InputFields.setEnabledRecursively(memberPanel, false);
        }
    }
}
