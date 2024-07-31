/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.utils;

import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.util.Date;
import javax.swing.JTextArea;
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
            MsgBox.alert(null, "Tên không được trống.");
            txtFullname.setBackground(Color.PINK); // Đổi màu nền để cảnh báo
            return false;
        }
        // Kiểm tra tên không có số
        if (!fullname.matches("[\\p{L}\\s]+")) {
            MsgBox.alert(null, "Tên có số bên trong.");
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
            MsgBox.alert(null, "Số điện thoại trống.");
            phoneMemberField.setBackground(Color.PINK); // Đổi màu nền để cảnh báo
            return false;
        } else if (!phoneNumber.matches(regex)) {
            MsgBox.alert(null, "Số điện thoại phải đủ 10 số.");
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
            MsgBox.alert(null, "Email đang trống.");
            emailField.setBackground(Color.PINK); // Đổi màu nền để cảnh báo
            return false;
        } else if (!email.matches(regex)) {
            MsgBox.alert(null, "Lỗi cấu trúc Email.");
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
            MsgBox.alert(null, "Địa chỉ đang trống.");
            addressField.setBackground(Color.PINK); // Đổi màu nền để cảnh báo
            return false;
        }
        addressField.setBackground(Color.WHITE);
        return true;
    }
    
    public static boolean checkBirthday(Date birthDay) {
        // Kiểm tra xem ngày sinh có rỗng hay không
        if (birthDay == null) {
            MsgBox.alert(null,"Ngày sinh đang trống.");
            return false; // Ngày sinh không hợp lệ
        }
        return true; // Ngày sinh hợp lệ
    }
    
    public static boolean checkEventUserId(JTextField txtUserIdEvent) {
    String userId = txtUserIdEvent.getText();
    if (userId.isEmpty()) {
        MsgBox.alert(null, "Id người tạo trống.");
        txtUserIdEvent.setBackground(Color.PINK); // Đổi màu nền để cảnh báo
        return false;
    } else if (!userId.matches("\\d+")) {
        MsgBox.alert(null, "Id chỉ được chứa ký tự số.");
        txtUserIdEvent.setBackground(Color.PINK); // Đổi màu nền để cảnh báo
        return false;
    }
    txtUserIdEvent.setBackground(Color.WHITE);
    return true;
}

    
    public static boolean checkEventTitle(JTextField txtEventTitle){
        String eventTitle = txtEventTitle.getText().trim();
        if(eventTitle.isEmpty()){
            MsgBox.alert(null, "Tên sự kiện trống.");
            txtEventTitle.setBackground(Color.PINK); // Đổi màu nền để cảnh báo
            return false;
        }
        txtEventTitle.setBackground(Color.WHITE);
        return true;
    }
    
        
    public static boolean checkEventContent(JTextArea txtEventContent){
        String eventContent = txtEventContent.getText().trim();
        if(eventContent.isEmpty()){
            MsgBox.alert(null, "Nội dung sự kiện trống.");
            txtEventContent.setBackground(Color.PINK); // Đổi màu nền để cảnh báo
            return false;
        }
        txtEventContent.setBackground(Color.WHITE);
        return true;
    }
    
    public static boolean checkDayStartedAndEndedCompare(Date startedDate, Date endedDate) {
        // Kiểm tra xem ngày sinh có rỗng hay không
        if (startedDate == null) {
            MsgBox.alert(null,"Ngày bắt đầu trống.");
            return false; 
        } else if(endedDate == null){
            MsgBox.alert(null,"Ngày kết thúc trống.");
            return false; 
        } else if(startedDate.after(endedDate)){
            MsgBox.alert(null,"Ngày bắt đầu lớn hơn kết thúc.");
            return false; 
        }
        return true; 
    }
}
