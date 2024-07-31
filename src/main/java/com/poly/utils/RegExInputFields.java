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
        if (fullname.isEmpty()) {
            MsgBox.alert(null, "Tên không được trống.");
            txtFullname.setBackground(Color.PINK);
            return false;
        }
        if (!fullname.matches("[\\p{L}\\s]+")) {
            MsgBox.alert(null, "Tên có số bên trong.");
            txtFullname.setBackground(Color.PINK);
            return false;
        }
        txtFullname.setBackground(Color.WHITE);
        return true;
    }

    public static String getCheckNameMember(JTextField txtFullname) {
        return checkNameMember(txtFullname) ? InputFields.getTextFieldtoString(txtFullname) : null;
    }

    public static boolean checkPhoneMember(JTextField phoneMemberField) {
        String phoneNumber = phoneMemberField.getText().trim();
        String regex = "^(0[3|5|7|8|9])+([0-9]{8})$";
        if (phoneNumber.isEmpty()) {
            MsgBox.alert(null, "Số điện thoại trống.");
            phoneMemberField.setBackground(Color.PINK);
            return false;
        } else if (!phoneNumber.matches(regex)) {
            MsgBox.alert(null, "Số điện thoại phải đủ 10 số.");
            phoneMemberField.setBackground(Color.PINK);
            return false;
        }
        phoneMemberField.setBackground(Color.WHITE);
        return true;
    }

    public static String getCheckPhoneMember(JTextField phoneMemberField) {
        return checkPhoneMember(phoneMemberField) ? InputFields.getTextFieldtoString(phoneMemberField) : null;
    }

    public static boolean checkEmail(JTextField emailField) {
        String email = emailField.getText().trim();
        String regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
        if (email.isEmpty()) {
            MsgBox.alert(null, "Email đang trống.");
            emailField.setBackground(Color.PINK);
            return false;
        } else if (!email.matches(regex)) {
            MsgBox.alert(null, "Lỗi cấu trúc Email.");
            emailField.setBackground(Color.PINK);
            return false;
        }
        emailField.setBackground(Color.WHITE);
        return true;
    }

    public static String getCheckEmail(JTextField emailField) {
        return checkEmail(emailField) ? InputFields.getTextFieldtoString(emailField) : null;
    }

    public static boolean checkAddress(JTextField addressField){
        String address = addressField.getText().trim();
        if (address.isEmpty()) {
            MsgBox.alert(null, "Địa chỉ đang trống.");
            addressField.setBackground(Color.PINK);
            return false;
        }
        addressField.setBackground(Color.WHITE);
        return true;
    }

    public static String getCheckAddress(JTextField addressField) {
        return checkAddress(addressField) ? InputFields.getTextFieldtoString(addressField) : null;
    }

    public static boolean checkBirthday(Date birthDay) {
        if (birthDay == null) {
            MsgBox.alert(null, "Ngày sinh đang trống.");
            return false;
        }
        return true;
    }

    public static Date getCheckBirthday(JDateChooser dateChooser) {
        Date birthDay = dateChooser.getDate();
        return checkBirthday(birthDay) ? birthDay : null;
    }

    public static boolean checkEventUserId(JTextField txtUserIdEvent) {
        String userId = txtUserIdEvent.getText();
        if (userId.isEmpty()) {
            MsgBox.alert(null, "Id người tạo trống.");
            txtUserIdEvent.setBackground(Color.PINK);
            return false;
        } else if (!userId.matches("\\d+")) {
            MsgBox.alert(null, "Id chỉ được chứa ký tự số.");
            txtUserIdEvent.setBackground(Color.PINK);
            return false;
        }
        txtUserIdEvent.setBackground(Color.WHITE);
        return true;
    }

    public static String getCheckEventUserId(JTextField txtUserIdEvent) {
        return checkEventUserId(txtUserIdEvent) ? InputFields.getTextFieldtoString(txtUserIdEvent) : null;
    }

    public static boolean checkEventTitle(JTextField txtEventTitle){
        String eventTitle = txtEventTitle.getText().trim();
        if (eventTitle.isEmpty()) {
            MsgBox.alert(null, "Tên sự kiện trống.");
            txtEventTitle.setBackground(Color.PINK);
            return false;
        }
        txtEventTitle.setBackground(Color.WHITE);
        return true;
    }

    public static String getCheckEventTitle(JTextField txtEventTitle) {
        return checkEventTitle(txtEventTitle) ? InputFields.getTextFieldtoString(txtEventTitle) : null;
    }

    public static boolean checkEventContent(JTextArea txtEventContent){
        String eventContent = txtEventContent.getText().trim();
        if (eventContent.isEmpty()) {
            MsgBox.alert(null, "Nội dung sự kiện trống.");
            txtEventContent.setBackground(Color.PINK);
            return false;
        }
        txtEventContent.setBackground(Color.WHITE);
        return true;
    }

    public static String getCheckEventContent(JTextArea txtEventContent) {
        return checkEventContent(txtEventContent) ? txtEventContent.getText().trim() : null;
    }

    public static boolean checkDayStartedAndEndedCompare(Date startedDate, Date endedDate) {
        if (startedDate == null) {
            MsgBox.alert(null, "Ngày bắt đầu trống.");
            return false; 
        } else if (endedDate == null) {
            MsgBox.alert(null, "Ngày kết thúc trống.");
            return false; 
        } else if (startedDate.after(endedDate)) {
            MsgBox.alert(null, "Ngày bắt đầu lớn hơn kết thúc.");
            return false; 
        }
        return true; 
    }

    public static Date getValidStartDate(JDateChooser startChooser) {
        Date startedDate = startChooser.getDate();
        if (startedDate == null) {
            MsgBox.alert(null, "Ngày bắt đầu trống.");
            return null;
        }
        return startedDate;
    }

    public static Date getValidEndDate(JDateChooser endChooser) {
        Date endedDate = endChooser.getDate();
        if (endedDate == null) {
            MsgBox.alert(null, "Ngày kết thúc trống.");
            return null;
        }
        return endedDate;
    }

    public static boolean checkDayStartedAndEndedCompare(JDateChooser startChooser, JDateChooser endChooser) {
        Date startedDate = startChooser.getDate();
        Date endedDate = endChooser.getDate();
        if (startedDate == null || endedDate == null) {
            return false;
        }
        if (startedDate.after(endedDate)) {
            MsgBox.alert(null, "Ngày bắt đầu lớn hơn kết thúc.");
            return false;
        }
        return true;
    }
}

