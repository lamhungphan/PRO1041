package com.poly.repository;

import com.poly.entity.Role;
import java.util.List;

public interface RoleRepository {

    Role create(Role entity);

    Role update(Role entity);

    Role remove(String id);

    Role findById(String id);

    List<Role> findAll();
}
