/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.controller;

import com.poly.constant.RoleConstant;
import com.poly.entity.User;
import com.poly.injection.UserInjector;
import com.poly.services.AuthorizationService;
import com.poly.services.RoleService;
import com.poly.services.UserService;
import com.poly.utils.ComponentManagement;
import com.poly.utils.MsgBox;
import com.poly.view.*;



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
        return createdUser;
    }

    public User readUserById(Integer id) {
        return userService.findById(id);
    }

    public User readUserByUserName(String username) {
        return userService.findByUsername(username);
    }

    public User readUserByFullname(String fullname) {
        return userService.findByFullname(fullname);
    }

    public User readUserByEmail(String email) {
        return userService.findByEmail(email);
    }

    public User updateUser(User user) {
        User updatedUser = userService.update(user);
            return updatedUser;
    }

    public User deleteUser(Integer id) {
        User deletedUser = userService.delete(id);
        return deletedUser;
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
