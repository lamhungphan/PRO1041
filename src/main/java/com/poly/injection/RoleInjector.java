/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.injection;

import com.poly.repository.RoleRepository;
import com.poly.repository.impl.RoleRepoImpl;
import com.poly.services.RoleService;
import com.poly.services.impl.RoleServiceImpl;

/**
 *
 * @author Computer
 */
public class RoleInjector {

    private static RoleInjector instance;

    private RoleRepository roleRepository;
    private RoleService roleService;

    private RoleInjector() {
        this.roleRepository = new RoleRepoImpl();
        this.roleService = new RoleServiceImpl(roleRepository);
    }

    public static RoleInjector getInstance() {
        if (instance == null) {
            instance = new RoleInjector();
        }
        return instance;
    }

    public RoleRepository getRoleRepository() {
        return roleRepository;
    }

    public RoleService getRoleService() {
        return roleService;
    }

}
