/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.utils;

import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.util.Date;
import javax.swing.JTextField;

/**
 *
 * @author seastone01202
 */
public class RegExInputFields {


    public static boolean checkNameMember(JTextField txtFullname) {
        String fullname = txtFullname.getText().trim();
        // Kiểm tra tên không được để trống
        if (fullname.isEmpty()) {
            MsgBox.alert(null, "Name cannot be empty.");
            txtFullname.setBackground(Color.PINK); // Đổi màu nền để cảnh báo
            return false;
        }
        // Kiểm tra tên không có số
        if (!fullname.matches("[\\p{L}\\s]+")) {
            MsgBox.alert(null, "Name cannot contain numbers.");
            txtFullname.setBackground(Color.PINK); // Đổi màu nền để cảnh báo
            return false;
        }
        // Nếu tất cả các kiểm tra đều vượt qua, đặt lại màu nền
        txtFullname.setBackground(Color.WHITE);
        return true;
    }


    public static boolean checkPhoneMember(JTextField phoneMemberField) {
        String phoneNumber = phoneMemberField.getText().trim();
        // Biểu thức chính quy cho số điện thoại Việt Nam
        String regex = "^(0[3|5|7|8|9])+([0-9]{8})$";
        // Kiểm tra số điện thoại không được để trống và phải hợp lệ
        if (phoneNumber.isEmpty()) {
            MsgBox.alert(null, "Phone number cannot be empty.");
            phoneMemberField.setBackground(Color.PINK); // Đổi màu nền để cảnh báo
            return false;
        } else if (!phoneNumber.matches(regex)) {
            MsgBox.alert(null, "Invalid phone number. Please enter a valid Vietnam phone number.");
            phoneMemberField.setBackground(Color.PINK); // Đổi màu nền để cảnh báo
            return false;
        }
        // Nếu tất cả các kiểm tra đều vượt qua, đặt lại màu nền
        phoneMemberField.setBackground(Color.WHITE);
        return true;
    }
    
    public static boolean checkEmail(JTextField emailField) {
        String email = emailField.getText().trim();

        // Biểu thức chính quy cho email
        String regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";

        // Kiểm tra email không được để trống và phải hợp lệ
        if (email.isEmpty()) {
            MsgBox.alert(null, "Email cannot be empty.");
            emailField.setBackground(Color.PINK); // Đổi màu nền để cảnh báo
            return false;
        } else if (!email.matches(regex)) {
            MsgBox.alert(null, "Invalid email address. Please enter a valid email.");
            emailField.setBackground(Color.PINK); // Đổi màu nền để cảnh báo
            return false;
        }

        // Nếu tất cả các kiểm tra đều vượt qua, đặt lại màu nền
        emailField.setBackground(Color.WHITE);
        return true;
    }
    
    public static boolean checkAddress(JTextField addressField){
        String address = addressField.getText().trim();
        if (address.isEmpty()) {
            MsgBox.alert(null, "Address cannot be empty.");
            addressField.setBackground(Color.PINK); // Đổi màu nền để cảnh báo
            return false;
        }
        addressField.setBackground(Color.WHITE);
        return true;
    }
    
    public static boolean checkBirthday(Date birthDay) {
        // Kiểm tra xem ngày sinh có rỗng hay không
        if (birthDay == null) {
            MsgBox.alert(null,"Birthday cannot be empty.");
            return false; // Ngày sinh không hợp lệ
        }
        return true; // Ngày sinh hợp lệ
    }
}
