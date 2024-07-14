package com.poly.services;

import com.poly.entity.User;
import java.util.List;

public interface UserService {

    User save(User entity, String nameRole);

    User update(User entity);

    User delete(String id);

    User findById(String id);

    User findByName(String name);

    List<User> findAll();
}
