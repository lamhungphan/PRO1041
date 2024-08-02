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
        while (!checkNameMember(txtFullname)) {
            txtFullname.setText(""); // Clear the input field for re-entry
            MsgBox.alert(null, "Tên không hợp lệ. Vui lòng nhập lại.");
        }
        return InputFields.getTextFieldtoString(txtFullname);
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
        while (!checkPhoneMember(phoneMemberField)) {
            phoneMemberField.setText(""); // Clear the input field for re-entry
            MsgBox.alert(null, "Số điện thoại không hợp lệ. Vui lòng nhập lại.");
        }
        return InputFields.getTextFieldtoString(phoneMemberField);
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
        while (!checkEmail(emailField)) {
            emailField.setText(""); // Clear the input field for re-entry
            MsgBox.alert(null, "Email không hợp lệ. Vui lòng nhập lại.");
        }
        return InputFields.getTextFieldtoString(emailField);
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
        while (!checkAddress(addressField)) {
            addressField.setText(""); // Clear the input field for re-entry
            MsgBox.alert(null, "Địa chỉ không hợp lệ. Vui lòng nhập lại.");
        }
        return InputFields.getTextFieldtoString(addressField);
    }

    public static boolean checkBirthday(Date birthDay) {
        if (birthDay == null) {
            MsgBox.alert(null, "Ngày sinh đang trống.");
            return false;
        }
        return true;
    }

    public static Date getCheckBirthday(JDateChooser dateChooser) {
        while (true) {
            Date birthDay = dateChooser.getDate();
            if (checkBirthday(birthDay)) {
                return birthDay;
            } else {
                dateChooser.setDate(null); // Clear the date chooser for re-entry
                MsgBox.alert(null, "Ngày sinh không hợp lệ. Vui lòng nhập lại.");
            }
        }
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
        while (!checkEventUserId(txtUserIdEvent)) {
            txtUserIdEvent.setText(""); // Clear the input field for re-entry
            MsgBox.alert(null, "Id người tạo không hợp lệ. Vui lòng nhập lại.");
        }
        return InputFields.getTextFieldtoString(txtUserIdEvent);
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
        while (!checkEventTitle(txtEventTitle)) {
            txtEventTitle.setText(""); // Clear the input field for re-entry
            MsgBox.alert(null, "Tên sự kiện không hợp lệ. Vui lòng nhập lại.");
        }
        return InputFields.getTextFieldtoString(txtEventTitle);
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
        while (!checkEventContent(txtEventContent)) {
            txtEventContent.setText(""); // Clear the input field for re-entry
            MsgBox.alert(null, "Nội dung sự kiện không hợp lệ. Vui lòng nhập lại.");
        }
        return txtEventContent.getText().trim();
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

    public static boolean checkDayStartedAndEndedCompare(JDateChooser startChooser, JDateChooser endChooser) {
        while (true) {
            Date startedDate = startChooser.getDate();
            Date endedDate = endChooser.getDate();
            if (startedDate == null || endedDate == null || startedDate.after(endedDate)) {
                startChooser.setDate(null);
                endChooser.setDate(null);
                MsgBox.alert(null, "Ngày bắt đầu và kết thúc không hợp lệ. Vui lòng nhập lại.");
            } else {
                return true;
            }
        }
    }
}
