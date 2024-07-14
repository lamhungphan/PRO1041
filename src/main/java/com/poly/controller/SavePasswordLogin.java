package com.poly.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import org.apache.commons.codec.digest.DigestUtils;

public class SavePasswordLogin {

    private String getFilePath() {
        String osName = System.getProperty("os.name").toLowerCase(); // Biến check OS hệ thống
        String addressFile = osName.contains("win") ? System.getProperty("user.home") + "\\Documents\\" :
                osName.contains("mac") ? System.getProperty("user.home") + "/Documents/" :
                        (osName.contains("nix") || osName.contains("nux") || osName.contains("aix")) ? System.getProperty("user.home") + "/Documents/" :
                                "/media/seastone01202/New Volume/WorkSpace/"; // Sử dụng toán tử ba ngôi để xác định đường dẫn cho tệp dựa trên hệ điều hành
        return addressFile + "password.txt"; // Kết hợp đường dẫn với tên file
    }

    public void savePassword(JTextField usernameField, JPasswordField passwordField) {
        String filePath = getFilePath(); //Bien chua duong dan den OS cua may tinh
        String username = usernameField.getText(); // Biến chứa tham số đầu vào Username
        String password = new String(passwordField.getPassword()); // Biến chứa tham số đầu vào Password
        /*Bien nay co 2 tac dung: bam username va password thanh md5 va gop lai ngan cach
        nhau giua dau cach <space>        */
        String md5Hex = DigestUtils.md5Hex(username) + " " + DigestUtils.md5Hex(password);
        try {
            Files.write(Paths.get(filePath), (md5Hex + System.lineSeparator()).getBytes(), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
            System.out.println("Đã ghi nội dung vào tệp thành công tại: " + filePath);
        } catch (IOException e) {
            System.out.println("Có lỗi xảy ra khi ghi tệp: " + e.getMessage());
        }
    }

    public void findPassword(JTextField usernameField, JPasswordField passwordField) {

    }
}
