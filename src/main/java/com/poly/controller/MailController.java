package com.poly.controller;

import com.poly.constant.MailConstant;
import com.poly.repository.RoleRepository;
import com.poly.repository.UserRepository;
import com.poly.repository.impl.RoleRepoImpl;
import com.poly.repository.impl.UserRepoImpl;
import com.poly.services.UserService;
import com.poly.services.impl.AuthorizationServiceImpl;
import com.poly.services.impl.RoleServiceImpl;
import com.poly.services.impl.UserServiceImpl;
import com.poly.services.impl.MailServiceImpl;

import javax.swing.*;

public class MailController {
    private final UserService userService;

    public MailController(UserService userService) {
        this.userService = userService;
    }

    public void sendEmails(String subject, String content) {
        try {
            // Tạo đối tượng MailService
            MailServiceImpl mailService = new MailServiceImpl(userService);
            // Gửi email cho người dùng và quản trị viên
            mailService.sendEmailsToUsersAndAdmin(MailConstant.FROM, MailConstant.USERNAME, MailConstant.PASSWORD, MailConstant.HOST, subject, content);
            // Hiển thị thông báo thành công
            JOptionPane.showMessageDialog(null, "Gửi Email thành công", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            // Hiển thị thông báo lỗi
            JOptionPane.showMessageDialog(null, "Gửi Email thất bại: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        UserRepository userRepository = new UserRepoImpl();
        RoleRepository roleRepository = new RoleRepoImpl();
        UserService userService = new UserServiceImpl(userRepository, new RoleServiceImpl(roleRepository), new AuthorizationServiceImpl());
        MailController mailController = new MailController(userService);
        mailController.sendEmails("Test email", "This is a test email.");
    }
}
