/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.services.impl;

import com.poly.entity.Role;
import com.poly.repository.RoleRepository;
import com.poly.services.RoleService;
import java.util.List;

/**
 *
 * @author Computer
 */
public class RoleServiceImpl implements RoleService {

    private RoleRepository repo;

    public RoleServiceImpl(RoleRepository repo) {
        this.repo = repo;
    }

    @Override
    public Role save(Role entity) {
        return repo.create(entity);
    }

    @Override
    public Role update(Role entity) {
        return repo.update(entity);
    }

    @Override
    public Role delete(String id) {
        return repo.remove(id);
    }

    @Override
    public Role findById(String id) {
        return repo.findById(id);
    }

    @Override
    public List<Role> findAll() {
        return repo.findAll();
    }

    @Override
    public Role findByNameRole(String nameRole) {
        List<Role> list = this.findAll();
        for (Role role : list) {
            if (role.getRoleName().equalsIgnoreCase(nameRole)) {
                return role;
            }
        }
        return null;
    }

}
