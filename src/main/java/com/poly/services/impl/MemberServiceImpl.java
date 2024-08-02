/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.services.impl;

import com.poly.entity.User;
import com.poly.repository.UserRepository;
import com.poly.services.AuthorizationService;
import com.poly.services.MemberService;
import com.poly.services.RoleService;

import java.util.ArrayList;
import java.util.List;

import com.poly.utils.MsgBox;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author Computer
 */
public class MemberServiceImpl implements MemberService {

    private final UserRepository repo;
    private final RoleService roleService;

    public MemberServiceImpl(UserRepository repo, RoleService roleService) {
        this.repo = repo;
        this.roleService = roleService;
    }

    @Override
    public User save(User entity, String nameRole) {
        entity.setRole(roleService.findByNameRole(nameRole));
        entity.setPassword(BCrypt.hashpw(entity.getPassword(), BCrypt.gensalt()));
        return repo.create(entity);
    }

    @Override
    public User update(User entity) {
        return repo.update(entity);
    }

    @Override
    public User delete(Integer id) {
        return repo.remove(id);
    }

    @Override
    public User findById(Integer id) {
        return repo.findById(id);
    }

    @Override
    public User findByFullname(String name) {
        List<User> list = this.findAll();
        for (User user : list) {
            if (user.getFullname().equalsIgnoreCase(name)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public List<User> findAll() {
        return repo.findAll();
    }

    @Override
    public List<User> findMembersByRole(String role) {
        List<User> listAllUser = findAll();
        List<User> members = new ArrayList<User>();
        for (User user : listAllUser) {
            String roleNameMember = user.getRole().getRoleName();
            if (role.equalsIgnoreCase(roleNameMember)) {
                members.add(user);
            }
        }
        if (members.isEmpty()) {
            MsgBox.alert(null, "Không tìm thấy danh sách thành viên!");
            return null;
        }
        return members;
    }

    public int getTotalMembers() {
        return repo. countTotalMembers();
    }
}
