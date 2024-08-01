/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.controller;

import com.poly.constant.RoleConstant;
import com.poly.entity.Role;
import com.poly.entity.User;
import com.poly.injection.UserInjector;
import com.poly.services.AuthorizationService;
import com.poly.services.RoleService;
import com.poly.services.UserService;
import com.poly.utils.ComponentManagement;
import com.poly.utils.InputFields;
import com.poly.utils.MsgBox;
import com.poly.utils.NavigationButtons;
import com.poly.view.*;


import com.toedter.calendar.JDateChooser;

import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

/**
 * @author Computer
 */
public class UserController {

    private final AuthorizationService authorizationService = UserInjector.getInstance().getAuthorizationService();
    private final UserService userService = UserInjector.getInstance().getUserService();
    private final String[] GET_METHOD_NAME_USER = {"getId", "getFullname", "getEmail", "getPhone", "getBirthday", "getScore", "getAddress"};
    private final List<User> listAllUser = getAllUsers();
    private final RoleService roleService = UserInjector.getInstance().getRoleService();

    public void doLogin(User userRequest, Login loginFrame, Main mainFrame) {
        User loginedUser = userService.doLogin(userRequest);
        if (loginedUser == null) {
            MsgBox.alert(null, "Đăng nhập không thành công");
        } else {
            MsgBox.alert(null, "Đăng nhập thành công");
            loginFrame.dispose();
            showWorkspaceByRolename(loginedUser, mainFrame);
        }
    }

    public void doLogout(Main mainFrame) {
        mainFrame.dispose();
        new Login().setVisible(true);
    }

    public void showWorkspaceByRolename(User userLogined, Main mainFrame) {
        JPanel eventPanel = mainFrame.getPnlEvent();
        JPanel adminPanel = mainFrame.getPnlAdmin();
        JPanel notificationPanel = mainFrame.getPnlNotification();
        JPanel memberPanel = mainFrame.getPnlMember();
        if (authorizationService.isAdmin(userLogined)) {
            mainFrame.setVisible(true);
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

    public User createUser(User user, String roleName) {
        User createdUser = userService.save(user, roleName);
        if (createdUser != null) {
            MsgBox.alert(null, "Tạo người dùng thành công!");
            return createdUser;
        } else {
            MsgBox.alert(null, "Không thể tạo người dùng.");
            return null;
        }
    }

    public User readUserById(Integer id) {
        return userService.findById(id);
    }

    public User readUserByUserName(String username) {
        return userService.findByUsername(username);
    }

    public void updateUser(User user) {
        User updatedUser = userService.update(user);
        if (updatedUser != null) {
            MsgBox.alert(null, "Cập nhật người dùng thành công!");
        } else {
            MsgBox.alert(null, "Không thể cập nhật người dùng.");
        }
    }

    public User deleteUser(Integer id) {
        User deletedUser = userService.delete(id);
        if (deletedUser != null) {
            MsgBox.alert(null, "Xóa người dùng thành công!");
            return deletedUser;
        } else {
            MsgBox.alert(null, "Không thể xóa người dùng.");
            return null;
        }
    }

    public List<User> getAllUsers() {
        return userService.findAll();
    }

    public List<User> getListAllUser() {
        String[] roles = {RoleConstant.CHU_NHIEM, RoleConstant.PHO_CHU_NHIEM, RoleConstant.THU_QUY};
        return userService.findByRole(roles);
    }

    public boolean updatePassword(String email, String newPassword) {
        User user = userService.findByEmail(email);
        if (user != null) {
            user.setPassword(newPassword);
            userService.update(user);
            return true;
        }
        return false;
    }

}
