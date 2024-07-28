package com.poly.controller;

import com.poly.constant.MailConstant;
import com.poly.injection.UserInjector;
import com.poly.services.UserService;
import com.poly.services.impl.MailServiceImpl;

import javax.swing.*;

public class MailController {

    private UserService userService = UserInjector.getInstance().getUserService();
    // Tạo đối tượng MailService
    private MailServiceImpl mailService = new MailServiceImpl(userService);

    public void sendEmails(String subject, String content) {
        try {
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

        MailController mailController = new MailController();
        mailController.sendEmails("Test email", "This is a test email.");
    }
}
