package com.poly.controller;

import com.poly.entity.PasswordResetToken;
import com.poly.entity.User;
import com.poly.injection.UserInjector;
import com.poly.services.PasswordResetTokenService;
import com.poly.services.UserService;
import com.poly.services.impl.PasswordResetTokenServiceImpl;
import com.poly.utils.MailSender;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.util.UUID;

public class PasswordResetController {

    private PasswordResetTokenService passwordResetService;
    private UserService userService = UserInjector.getInstance().getUserService();
    // Tạo đối tượng PasswordResetTokenService
    private PasswordResetTokenServiceImpl passwordResetTokenService = new PasswordResetTokenServiceImpl();

    public void showResetPasswordForm() {
        JFrame frame = new JFrame("Reset Password");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 150);

        JPanel panel = new JPanel(new GridLayout(3, 2));

        JLabel emailLabel = new JLabel("Email:");
        JTextField emailField = new JTextField();

        JButton resetButton = new JButton("Send Reset Link");

        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = emailField.getText();
                sendResetLink(email, frame);
            }
        });

        panel.add(emailLabel);
        panel.add(emailField);
        panel.add(new JLabel());
        panel.add(resetButton);
        frame.add(panel);
        frame.setVisible(true);
    }

    public void sendResetLink(String email, JFrame frame) {
        // Kiểm tra xem email có tồn tại trong database không
        User user = userService.findByEmail(email);
        if (user == null) {
            JOptionPane.showMessageDialog(frame, "Email không tồn tại trong hệ thống.");
            return;
        }

        // Tạo token vơ UUID của Java
        String token = UUID.randomUUID().toString();
        LocalDateTime expirationDate = LocalDateTime.now().plusMinutes(10);

        // Tạo PasswordResetToken entity
        PasswordResetToken resetToken = new PasswordResetToken();
        resetToken.setEmail(email);
        resetToken.setToken(token);
        resetToken.setExpirationdate(expirationDate);

        // Lưu token vào database
        passwordResetTokenService.save(resetToken);

        // Gửi mail cho user
        String message = "Dưới đây là mã đặt lại mật khẩu của bạn: " + token;
        MailSender.sendEmailresetpassword(email, token, message); // Giả sử MailSender đã được triển khai
        JOptionPane.showMessageDialog(frame, "Liên kết đặt lại mật khẩu đã được gửi đến email của bạn.");
    }

    public void showVerifyTokenForm() {
        JFrame frame = new JFrame("Enter Token and New Password");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        JPanel panel = new JPanel(new GridLayout(4, 2));

        JLabel tokenLabel = new JLabel("Token:");
        JTextField tokenField = new JTextField();

        JLabel newPasswordLabel = new JLabel("New Password:");
        JPasswordField newPasswordField = new JPasswordField();

        JButton verifyButton = new JButton("Verify and Reset Password");

        verifyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String token = tokenField.getText();
                String newPassword = new String(newPasswordField.getPassword());
                resetPassword(token, newPassword);
            }
        });

        panel.add(tokenLabel);
        panel.add(tokenField);
        panel.add(newPasswordLabel);
        panel.add(newPasswordField);
        panel.add(new JLabel());
        panel.add(verifyButton);
        frame.add(panel);
        frame.setVisible(true);
    }

    public void resetPassword(String token, String newPassword) {
        PasswordResetToken resetToken = passwordResetTokenService.findBytoken(token);
        if (resetToken != null) {
            System.out.println("Token expiration date: " + resetToken.getExpirationdate());
            System.out.println("Current date: " + LocalDateTime.now());

            if (resetToken.getExpirationdate().isAfter(LocalDateTime.now())) {
                userService.updatePassword(resetToken.getEmail(), newPassword);
                passwordResetTokenService.deleteByToken(resetToken.getToken());
                JOptionPane.showMessageDialog(null, "Đặt lại mật khẩu thành công.");
            } else {
                JOptionPane.showMessageDialog(null, "Token không hợp lệ hoặc đã hết hạn.");
            }
        }
    }

    public static void main(String[] args) {
        PasswordResetController controller = new PasswordResetController();
        controller.showResetPasswordForm();
        controller.showVerifyTokenForm();
    }
}
