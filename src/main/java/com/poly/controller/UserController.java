/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.controller;

import com.poly.entity.User;
import com.poly.injection.UserInjector;
import com.poly.services.AuthorizationService;
import com.poly.services.UserService;
import com.poly.utils.ComponentManagement;
import com.poly.utils.InputFields;
import com.poly.utils.MsgBox;
import com.poly.view.Login;
import com.poly.view.Main;
import java.util.List;

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
     // CRUD operations
    public void createUser(User user, String roleName) {
        User createdUser = userService.save(user, roleName);
        if (createdUser != null) {
            MsgBox.alert(null, "Tạo người dùng thành công!");
        } else {
            MsgBox.alert(null, "Không thể tạo người dùng.");
        }
    }

    public User readUser(Integer id) {
        return userService.findById(id);
    }

    public void updateUser(User user) {
        User updatedUser = userService.update(user);
        if (updatedUser != null) {
            MsgBox.alert(null, "Cập nhật người dùng thành công!");
        } else {
            MsgBox.alert(null, "Không thể cập nhật người dùng.");
        }
    }

    public void deleteUser(Integer id) {
        User deletedUser = userService.delete(id);
        if (deletedUser != null) {
            MsgBox.alert(null, "Xóa người dùng thành công!");
        } else {
            MsgBox.alert(null, "Không thể xóa người dùng.");
        }
    }

    public List<User> getAllUsers() {
        return userService.findAll();
    }
    public static void main(String[] args) {
        UserController controller = new UserController();
    }
}
