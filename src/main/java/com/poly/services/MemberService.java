package com.poly.services;

import com.poly.entity.User;
import java.util.List;

public interface MemberService {

    User save(User entity, String nameRole);

    User update(User entity);

    User delete(Integer id);

    User findById(Integer id);

    User findByUsername(String name);

    List<User> findAll();

}
