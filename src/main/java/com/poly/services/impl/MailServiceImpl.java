package com.poly.services.impl;
import com.poly.utils.MailSender;
import com.poly.entity.User;
import com.poly.services.MailService;
import com.poly.services.UserService;

import java.util.List;

public class MailServiceImpl implements MailService {

    private UserService userService;

    public MailServiceImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void sendEmailsToUsersAndAdmin(String from, String username, String password, String host, String subject, String content) {
        List<User> users = userService.findAll();
        for (User user : users) {
            String to = user.getEmail();
            String role = String.valueOf(user.getRole().getRoleName());

            // Gửi email dựa trên vai trò
            if (!"Chủ nhiệm".equalsIgnoreCase(role)) {// Gửi email cho user
                MailSender.sendEmail(to, from, username, password, host, subject, content);
            } else {
                // Gửi email cho admin
                String adminEmail = "hung@example.com"; // Địa chỉ email của admin
                MailSender.sendEmail(adminEmail, from, username, password, host, subject, content);
            }

            // Gửi email cho quản trị viên (admin) cụ thể

        }
    }

    private void sendMailTakePassword(String email, String from, String username, String host, String subject, String content) {
        List<User> users = userService.findAll();
        for (User user : users) {
        String to = user.getEmail();
           String password = String.valueOf(user.getPassword());
            if (email.equals(to)) {
                MailSender.sendEmail(to, from, username, password, host, subject, content);
            }
        }
    }
}


