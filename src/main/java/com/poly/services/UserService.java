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

    public User delete(String id);

    public User findById(String id);

    public User findByName(String name);

    public List<User> findAll();
}
