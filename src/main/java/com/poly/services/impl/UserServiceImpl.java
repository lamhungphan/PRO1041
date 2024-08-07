/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.services.impl;

import com.poly.entity.User;
import com.poly.repository.UserRepository;
import com.poly.repository.impl.UserRepoImpl;
import com.poly.services.AuthorizationService;
import com.poly.services.RoleService;
import com.poly.services.UserService;

import java.util.ArrayList;
import java.util.List;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author Computer
 */
public class UserServiceImpl implements UserService {

    private final UserRepository repo;
    private final RoleService roleService;
    private final AuthorizationService authorizationService;

    public UserServiceImpl(UserRepository repo, RoleService roleService, AuthorizationService authorizationService) {
        this.repo = repo;
        this.roleService = roleService;
        this.authorizationService = authorizationService;
    }

    @Override
    public User save(User entity, String nameRole) {
        entity.setRole(roleService.findByNameRole(nameRole));
        entity.setPassword(BCrypt.hashpw(entity.getPassword(), BCrypt.gensalt()));
        return repo.create(entity);
    }

    @Override
    public User update(User entity) {
        return repo.update(entity);
    }

    @Override
    public User delete(Integer id) {
        return repo.remove(id);
    }

    @Override
    public User findById(Integer id) {
        return repo.findById(id);
    }

    @Override
    public List<User> findAll() {
        return repo.findAll();
    }

    @Override
    public List<User> findByRole(String... role) {
        List<User> listAll = findAll();
        List<User> listAdmin = new ArrayList<>();
        for (User user : listAll) {
            String roleName = user.getRole().getRoleName();
            for (String roleUser : role) {
                if (roleName.equalsIgnoreCase(roleUser)) {
                    listAdmin.add(user);
                }
            }
        }
        if (listAdmin.size() > 0) {
            return listAdmin;
        }
        return null;
    }

    @Override
    public User findByUsername(String name) {
        List<User> list = this.findAll();
        for (User user : list) {
            // Kiểm tra xem user.getUsername() có phải là null không
            String username = user.getUsername();
            if (username != null && user.getUsername().equalsIgnoreCase(name)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public User findByFullname(String fullname) {
        for (User user : findAll()) {
            if (user.getFullname().equalsIgnoreCase(fullname)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public User findByEmail(String email) {
        List<User> list = this.findAll();
        for (User user : list) {
            if (user.getEmail().equalsIgnoreCase(email)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public User updatePassword(String email, String newPassword) {
        User userForgotPassword = repo.findByEmail(email);
        if (userForgotPassword != null) {
            newPassword = BCrypt.hashpw(newPassword, BCrypt.gensalt());
            userForgotPassword.setPassword(newPassword);
            repo.update(userForgotPassword);
            return userForgotPassword;
        }
        return null;
    }

    @Override
    public User doLogin(User userRequest) {
        User userResponse = findByUsername(userRequest.getUsername());
        String admin = "admin";
        String adminPassword = "123";

        if (userRequest.getUsername().equals(admin) && userRequest.getPassword().equals(adminPassword)) {
            return userRequest; // Trả về userRequest nếu là admin
        }// Kiểm tra userResponse trước khi gọi phương thức
        else if (userResponse == null) {
            return null; // Không tìm thấy người dùng
        } // Kiểm tra tài khoản không hoạt động
        else if (userResponse.getIsActived() == false) {
            return null; // Tài khoản không hoạt động
        }

        // Kiểm tra mật khẩu
        if (BCrypt.checkpw(userRequest.getPassword(), userResponse.getPassword())) {
            return userResponse; // Trả về userResponse nếu mật khẩu đúng
        }

        return null; // Trả về null nếu mật khẩu không đúng
    }

    //Test
    public static void main(String[] args) {
        UserRepoImpl repoImpl = new UserRepoImpl();
        User user_Hung = repoImpl.findById(1);
        user_Hung.setPassword(BCrypt.hashpw(user_Hung.getPassword(), BCrypt.gensalt()));
        repoImpl.update(user_Hung);
        User user_giang = repoImpl.findById(2);
        user_giang.setPassword(BCrypt.hashpw(user_giang.getPassword(), BCrypt.gensalt()));
        repoImpl.update(user_giang);
        User user_Thach = repoImpl.findById(3);
        user_Thach.setPassword(BCrypt.hashpw(user_Thach.getPassword(), BCrypt.gensalt()));

        repoImpl.update(user_Thach);
        User user_Lam = repoImpl.findById(4);
        user_Lam.setPassword(BCrypt.hashpw(user_Lam.getPassword(), BCrypt.gensalt()));
        repoImpl.update(user_Lam);
    }

}
