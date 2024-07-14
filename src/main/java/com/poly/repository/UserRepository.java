package com.poly.repository;

import com.poly.entity.User;
import java.util.List;

public interface UserRepository {

    User create(User entity);

    User update(User entity);

    public User remove(Integer id);

    public User findById(Integer id);

    List<User> findAll();
}
