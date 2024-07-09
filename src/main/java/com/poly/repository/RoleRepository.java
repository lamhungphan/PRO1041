/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.repository;

import com.poly.entity.Role;
import java.util.List;

/**
 *
 * @author Computer
 */
public interface RoleRepository {

    public Role create(Role entity);

    public Role update(Role entity);

    public Role remove(String id);

    public Role findById(String id);

    public List<Role> findAll();

}
