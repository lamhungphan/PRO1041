/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.poly.services;

import com.poly.entity.User;
import java.util.List;

/**
 *
 * @author Computer
 */
public interface UserService {

    public User save(User entity, String nameRole);

    public User update(User entity);

    public User delete(Integer id);

    public User findById(Integer id);

    public User findByUsername(String name);

    public List<User> findAll();
    
    public User doLogin(User userRequest);
}
