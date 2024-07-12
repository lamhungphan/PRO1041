/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.services.impl;

import com.poly.entity.User;
import com.poly.repository.impl.RoleRepoImpl;
import com.poly.repository.Impl.UserRepoImpl;
import com.poly.repository.RoleRepository;
import com.poly.repository.UserRepository;
import com.poly.services.RoleService;
import com.poly.services.UserService;
import java.util.List;

/**
 *
 * @author Computer
 */
public class UserServiceImpl implements UserService {

    private final UserRepository repo;
    private final RoleService roleService;

    public UserServiceImpl(UserRepository repo, RoleService roleService) {
        this.repo = repo;
        this.roleService = roleService;
    }

    @Override
    public User save(User entity, String nameRole) {
        entity.setRole(roleService.findByNameRole(nameRole));
        return repo.create(entity);
    }

    @Override
    public User update(User entity) {
        return repo.update(entity);
    }

    @Override
    public User delete(String id) {
        return repo.remove(id);
    }

    @Override
    public User findById(String id) {
        return repo.findById(id);
    }

    @Override
    public List<User> findAll() {
        return repo.findAll();
    }

    @Override
    public User findByName(String name) {
        List<User> list = this.findAll();
        for (User user : list) {
            if (user.getFullname().equalsIgnoreCase(name)) {
                return user;
            }
        }
        return null;
    }
//Test
    public static void main(String[] args) {
        UserRepository userRepository = new UserRepoImpl();
        RoleRepository roleRepository = new RoleRepoImpl();
        RoleServiceImpl roleService = new RoleServiceImpl(roleRepository);

        UserServiceImpl userService = new UserServiceImpl(userRepository, roleService);

        // Tạo một user với role "admin"
        User newUser = new User();
        newUser.setUsername("adminUser");
        newUser.setPassword("adminPass");
        newUser.setFullname("Admin User");
        newUser.setAddress("123 Admin Street");
        newUser.setPhone("1234567890");
        newUser.setEmail("admin@example.com");
        newUser.setIsActived(true);

        User savedUser = userService.save(newUser, "Chủ nhiệm");
        System.out.println("Saved User: " + savedUser);
    }
}
