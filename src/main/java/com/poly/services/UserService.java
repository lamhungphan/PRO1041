package com.poly.services;

import com.poly.entity.User;
import java.util.List;

public interface UserService {

    User save(User entity, String nameRole);

    User update(User entity);

    User delete(Integer id);

    User findById(Integer id);

    User findByUsername(String name);

    List<User> findAll();

    List<User> findByRole(String... role);

    User findByEmail(String email);

    User doLogin(User userRequest);

    User updatePassword(String email, String newPassword);
}
