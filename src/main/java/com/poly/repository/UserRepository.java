package com.poly.repository;

import com.poly.entity.User;
import java.util.List;

public interface UserRepository {

    User create(User entity);

    User update(User entity);

    User remove(String id);

    User findById(String id);

    List<User> findAll();
}
