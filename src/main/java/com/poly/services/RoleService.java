/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.poly.services;

import com.poly.entity.Role;
import java.util.List;

/**
 *
 * @author Computer
 */
public interface RoleService {

    public Role save(Role entity);

    public Role update(Role entity);

    public Role delete(String id);

    public Role findById(String id);

    public List<Role> findAll();

    public Role findByNameRole(String NameRole);

}
