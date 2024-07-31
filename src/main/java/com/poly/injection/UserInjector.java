/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.injection;

import com.poly.repository.RoleRepository;
import com.poly.repository.UserRepository;
import com.poly.repository.impl.RoleRepoImpl;
import com.poly.repository.impl.UserRepoImpl;
import com.poly.services.AuthorizationService;
import com.poly.services.RoleService;
import com.poly.services.UserService;
import com.poly.services.impl.RoleServiceImpl;
import com.poly.services.impl.UserServiceImpl;
import com.poly.view.Main;

/**
 *
 * @author Computer
 */
public class UserInjector {

    private static UserInjector instance;

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final RoleService roleService;
    private final UserService userService;
    private final AuthorizationService authorizationService;
    private Main mainFrame;

    private UserInjector() {
        this.userRepository = new UserRepoImpl();
        this.roleRepository = new RoleRepoImpl();
        this.authorizationService = AuthorizationInjector.getInstance().getAuthorizationService();
        this.roleService = new RoleServiceImpl(roleRepository);
        this.userService = new UserServiceImpl(userRepository, roleService, authorizationService);
        this.mainFrame = UserInjector.getInstance().getMainFrame();
    }

    public static UserInjector getInstance() {
        if (instance == null) {
            instance = new UserInjector();
        }
        return instance;
    }

    public UserRepository getUserRepository() {
        return userRepository;
    }

    public RoleRepository getRoleRepository() {
        return roleRepository;
    }

    public RoleService getRoleService() {
        return roleService;
    }

    public UserService getUserService() {
        return userService;
    }

    public AuthorizationService getAuthorizationService() {
        return authorizationService;
    }

    public Main getMainFrame(){
        return mainFrame;
    }
}
