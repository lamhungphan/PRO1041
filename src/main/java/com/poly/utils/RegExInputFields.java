package com.poly.utils;

import com.poly.controller.UserController;
import com.poly.entity.User;
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
        if (!checkNameMember(txtFullname)) {
            txtFullname.setText(""); // Clear the input field for re-entry
            txtFullname.requestFocus();
            return null;
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
        if (!checkPhoneMember(phoneMemberField)) {
            phoneMemberField.setText(""); // Clear the input field for re-entry
            phoneMemberField.requestFocus();
            return null;
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
        if (!checkEmail(emailField)) {
            emailField.setText(""); // Clear the input field for re-entry
            MsgBox.alert(null, "Email không hợp lệ. Vui lòng nhập lại.");
            emailField.requestFocus();
            return null;
        }
        return InputFields.getTextFieldtoString(emailField);
    }

    public static boolean checkAddress(JTextField addressField) {
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
        if (!checkAddress(addressField)) {
            addressField.setText(""); // Clear the input field for re-entry
            MsgBox.alert(null, "Địa chỉ không hợp lệ. Vui lòng nhập lại.");
            addressField.requestFocus();
            return null;
        }
        return InputFields.getTextFieldtoString(addressField);
    }

    public static boolean checkBirthday(Date birthDay) {
        if (birthDay == null) {
            MsgBox.alert(null, "Ngày sinh đang trống.");
            return false;
        } else if (birthDay.after(new Date())) {
            MsgBox.alert(null, "Ngày sinh không hợp lệ. Vui lòng nhập lại.");
            return false;
        }

        return true;
    }

    public static java.sql.Date getCheckBirthday(JDateChooser dateChooser) {
        java.sql.Date birthDay = InputFields.getDateChoosetoDateSQL(dateChooser);
        if (checkBirthday(birthDay)) {
            return birthDay;
        }
        dateChooser.setDate(null);
        dateChooser.requestFocus();
        return null;

    }

    public static boolean checkUsername(JTextField txtUsernameEvent) {
        String Username = txtUsernameEvent.getText();
        User userCreated = new UserController().readUserByUserName(Username);
        if (Username.isEmpty()) {
            MsgBox.alert(null, "Username người tạo trống.");
            txtUsernameEvent.setBackground(Color.PINK);
            return false;
        } else if (Username.matches("^[a-zA-Z][a-zA-Z0-9_]{4,19}$")) {
            MsgBox.alert(null, "Username không hợp lệ. Username phải bắt đầu bằng chữ cái, dài từ 5 đến 20 ký tự, chỉ chứa chữ cái, số và dấu gạch dưới.");
            return false;
        } else if (userCreated == null) {
            txtUsernameEvent.setBackground(Color.PINK);
            MsgBox.alert(null, Username + " không tồn tại!");
            return false;
        }
        txtUsernameEvent.setBackground(Color.WHITE);
        return true;
    }

    public static String getCheckUsername(JTextField txtUsername) {
        while (!checkUsername(txtUsername)) {
            txtUsername.setText("");
            txtUsername.requestFocus();
            return null;
        }
        return InputFields.getTextFieldtoString(txtUsername);
    }

    public static boolean checkEventTitle(JTextField txtEventTitle) {
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
        if (!checkEventTitle(txtEventTitle)) {
            txtEventTitle.setText(""); // Clear the input field for re-entry
            txtEventTitle.requestFocus();
            return null;
        }
        return InputFields.getTextFieldtoString(txtEventTitle);
    }

    public static boolean checkEventContent(JTextArea txtEventContent) {
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
        if (!checkEventContent(txtEventContent)) {
            txtEventContent.setText(""); // Clear the input field for re-entry
            txtEventContent.requestFocus();
            return null;
        }
        return txtEventContent.getText().trim();
    }

    public static boolean checkDayStartedAndEndedCompare(JDateChooser startedDate, JDateChooser endedDate) {

        java.sql.Date startDate = InputFields.getDateSQL(startedDate.getDate());
        java.sql.Date endDate = InputFields.getDateSQL(endedDate.getDate());

        if (startDate == null) {
            MsgBox.alert(null, "Ngày bắt đầu trống.");
            return false;
        } else if (endDate == null) {
            MsgBox.alert(null, "Ngày kết thúc trống.");
            return false;
        } else if (startDate.after(endDate)) {
            MsgBox.alert(null, "Ngày bắt đầu lớn hơn kết thúc.");
            return false;
        }
        return true;
    }

    public static java.sql.Date getDateStarted(JDateChooser startedDate, JDateChooser endedDate) {
        java.sql.Date startDate = InputFields.getDateSQL(startedDate.getDate());

        if (checkDayStartedAndEndedCompare(startedDate, endedDate)) {
            return startDate;
        }
        return null;
    }

    public static java.sql.Date getDateEnded(JDateChooser startedDate, JDateChooser endedDate) {
        java.sql.Date endDate = InputFields.getDateSQL(endedDate.getDate());

        if (checkDayStartedAndEndedCompare(startedDate, endedDate)) {
            return endDate;
        }
        return null;
    }
}
