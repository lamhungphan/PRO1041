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
import com.poly.services.MemberService;
import com.poly.services.RoleService;
import com.poly.services.UserService;
import com.poly.services.impl.MemberServiceImpl;
import com.poly.services.impl.RoleServiceImpl;
import com.poly.services.impl.UserServiceImpl;

/**
 *
 * @author Computer
 */
public class MemberInjector {

    private static MemberInjector instance;

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final RoleService roleService;
    private final MemberService memberService;

    private MemberInjector() {
        this.userRepository = new UserRepoImpl();
        this.roleRepository = new RoleRepoImpl();

        this.roleService = new RoleServiceImpl(roleRepository);
        this.memberService = new MemberServiceImpl(userRepository, roleService);
    }

    public static MemberInjector getInstance() {
        if (instance == null) {
            instance = new MemberInjector();
        }
        return instance;
    }

    public MemberService getMemberService() {
        return memberService;
    }

}
