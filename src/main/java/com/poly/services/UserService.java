package com.poly.services;

import com.poly.entity.User;
import java.util.List;

public interface UserService {

    User save(User entity, String nameRole);

    User update(User entity);

    public User delete(Integer id);

    public User findById(Integer id);

    public User findByUsername(String name);

    public List<User> findAll();

    public User doLogin(User userRequest);
}
