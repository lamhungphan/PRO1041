/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.poly.repository;

import com.poly.entity.Role;
import com.poly.entity.User;
import java.util.List;

/**
 *
 * @author Computer
 */
public interface UserRepository {

    public User create(User entity);

    public User update(User entity);

    public User remove(String id);

    public User findById(String id);

    public List<User> findAll();
}
