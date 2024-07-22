/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.services.impl;

import com.poly.entity.User;
import com.poly.repository.impl.RoleRepoImpl;
import com.poly.repository.RoleRepository;
import com.poly.repository.UserRepository;
import com.poly.repository.impl.UserRepoImpl;
import com.poly.services.AuthorizationService;
import com.poly.services.RoleService;
import com.poly.services.UserService;
import com.poly.utils.MsgBox;
import com.poly.view.Main;
import java.util.List;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author Computer
 */
public class UserServiceImpl implements UserService {

    private final UserRepository repo;
    private final RoleService roleService;
    private final AuthorizationService authorizationService;

    public UserServiceImpl(UserRepository repo, RoleService roleService, AuthorizationService authorizationService) {
        this.repo = repo;
        this.roleService = roleService;
        this.authorizationService = authorizationService;
    }

    @Override
    public User save(User entity, String nameRole) {
        entity.setRole(roleService.findByNameRole(nameRole));
        entity.setPassword(BCrypt.hashpw(entity.getPassword(), BCrypt.gensalt()));
        return repo.create(entity);
    }

    @Override
    public User update(User entity) {
        entity.setPassword(BCrypt.hashpw(entity.getPassword(), BCrypt.gensalt()));
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
    public List<User> findAll() {
        return repo.findAll();
    }

    @Override
    public User findByUsername(String name) {
        List<User> list = this.findAll();
        for (User user : list) {
            if (user.getUsername().equalsIgnoreCase(name)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public User doLogin(User userRequest) {
        User userResponse = findByUsername(userRequest.getUsername());
        if (userResponse.getIsActived() == false || userResponse == null) {
            return null;
        }
        if (BCrypt.checkpw(userRequest.getPassword(), userResponse.getPassword())) {
            return userResponse;
        }
        return null;
    }

//Test
    public static void main(String[] args) {
        UserRepoImpl repoImpl = new UserRepoImpl();
        User user_Hung = repoImpl.findById(1);
        user_Hung.setPassword(BCrypt.hashpw(user_Hung.getPassword(), BCrypt.gensalt()));
        repoImpl.update(user_Hung);
        User user_giang = repoImpl.findById(2);
        user_giang.setPassword(BCrypt.hashpw(user_giang.getPassword(), BCrypt.gensalt()));
        repoImpl.update(user_giang);
        User user_Thach = repoImpl.findById(3);
        user_Thach.setPassword(BCrypt.hashpw(user_Thach.getPassword(), BCrypt.gensalt()));

        repoImpl.update(user_Thach);
        User user_Lam = repoImpl.findById(4);
        user_Lam.setPassword(BCrypt.hashpw(user_Lam.getPassword(), BCrypt.gensalt()));
        repoImpl.update(user_Lam);
    }

}
