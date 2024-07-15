package com.poly.services;

import com.poly.entity.Role;
import java.util.List;

public interface RoleService {

    Role save(Role entity);

    Role update(Role entity);

    Role delete(String id);

    Role findById(String id);

    List<Role> findAll();

    Role findByNameRole(String NameRole);

}
