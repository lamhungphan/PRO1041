package com.poly.controller;

import com.poly.entity.PasswordResetToken;
import com.poly.entity.User;
import com.poly.injection.UserInjector;
import com.poly.services.PasswordResetTokenService;
import com.poly.services.UserService;
import com.poly.services.impl.PasswordResetTokenServiceImpl;
import com.poly.utils.MailSender;
import com.poly.utils.MsgBox;
import com.poly.utils.RegExInputFields;

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
        JFrame frame = new JFrame("Quên mật khẩu");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(700, 270);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setBackground(new Color(173, 216, 230));  // Màu nền xanh nhạt

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);  // Khoảng cách giữa các thành phần

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setFont(new Font("Arial", Font.BOLD, 14));
        JTextField emailField = new JTextField(30);

        JButton resetButton = new JButton("    Gửi Mail    ");
        resetButton.setFont(new Font("Arial", Font.PLAIN, 14));
        resetButton.setBackground(new Color(30, 144, 255));  // Màu nền nút xanh dương
        resetButton.setForeground(Color.WHITE);  // Màu chữ trắng
        resetButton.setFocusPainted(false);

        JLabel noteLabel = new JLabel("Nhập vào email của bạn để nhận mã xác nhận (token) dùng cập nhật mật khẩu mới.");
        noteLabel.setFont(new Font("Arial", Font.ITALIC, 12));

        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = emailField.getText();
                sendResetLink(email, frame);
            }
        });

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST;
        panel.add(emailLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(emailField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(resetButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(noteLabel, gbc);

        frame.add(panel);
        frame.setVisible(true);
    }

    public void sendResetLink(String email, JFrame currentFrame) {
        if(checkEmail(email)){
            // Kiểm tra xem email có tồn tại trong database không
            User user = userService.findByEmail(email);
            if (user == null) {
                MsgBox.alert(currentFrame,"Sai Email !" );
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
            MsgBox.alert(currentFrame, "Liên kết đặt lại mật khẩu đã được gửi đến email của bạn.");
            showVerifyTokenForm();
            currentFrame.dispose();
        }

    }

    public void showVerifyTokenForm() {
        JFrame frame = new JFrame("Xác nhận token và cài đặt lại mật khẩu");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400, 250);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setBackground(new Color(173, 216, 230));  // Màu nền xanh nhạt

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);  // Khoảng cách giữa các thành phần

        JLabel tokenLabel = new JLabel("Token:");
        tokenLabel.setFont(new Font("Arial", Font.BOLD, 14));
        JTextField tokenField = new JTextField(20);

        JLabel newPasswordLabel = new JLabel("Mật khẩu mới:");
        newPasswordLabel.setFont(new Font("Arial", Font.BOLD, 14));
        JPasswordField newPasswordField = new JPasswordField(20);

        JButton verifyButton = new JButton("Đặt lại mật khẩu ");
        verifyButton.setFont(new Font("Arial", Font.PLAIN, 14));
        verifyButton.setBackground(new Color(30, 144, 255));  // Màu nền nút xanh dương
        verifyButton.setForeground(Color.WHITE);  // Màu chữ trắng
        verifyButton.setFocusPainted(false);

        verifyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String token = tokenField.getText();
                String newPassword = new String(newPasswordField.getPassword());
                resetPassword(token, newPassword, frame); // truyền frame vào đây
            }
        });

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST;
        panel.add(tokenLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(tokenField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.EAST;
        panel.add(newPasswordLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(newPasswordField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(verifyButton, gbc);

        frame.add(panel);
        frame.setVisible(true);
    }

    public User resetPassword(String token, String newPassword, JFrame currentFrame) {
        PasswordResetToken resetToken = passwordResetTokenService.findBytoken(token);
        if (resetToken != null) {
            System.out.println("Token expiration date: " + resetToken.getExpirationdate());
            System.out.println("Current date: " + LocalDateTime.now());
            if (resetToken.getExpirationdate().isAfter(LocalDateTime.now())) {
                User userAfterSetPass = userService.updatePassword(resetToken.getEmail(), newPassword);
                passwordResetTokenService.deleteByToken(resetToken.getToken());
                JOptionPane.showMessageDialog(currentFrame, "Đặt lại mật khẩu thành công.");
                currentFrame.dispose(); // đóng JFrame hiện tại
                return userAfterSetPass;
            } else {
                MsgBox.alert(currentFrame, "Token hết hạn !");
                return null;
            }
        }else {
            MsgBox.alert(currentFrame, "Token không hợp lệ !");
            return null;
        }
    }

    public static boolean checkEmail(String email) {
        String regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
        if (email.isEmpty()) {
            MsgBox.alert(null, "Email đang trống.");
            return false;
        } else if (!email.matches(regex)) {
            MsgBox.alert(null, "Lỗi cấu trúc Email.");
            return false;
        }
        return true;
    }
//    public static void main(String[] args) {
//        PasswordResetController controller = new PasswordResetController();
//        controller.showResetPasswordForm();
//        controller.showVerifyTokenForm();
//    }
}
