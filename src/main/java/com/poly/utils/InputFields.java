package com.poly.utils;

import com.toedter.calendar.JDateChooser;
import java.sql.Date;
import javax.swing.*;

public class InputFields {

    public static void setTextFieldNumber(String numb, JTextField txt) {
        if (isNumber(numb)) {
            txt.setText(numb);
        } else {
            MsgBox.alert(null, "Invalid input: Not a number");
        }

    }

    public static String getTextFieldtoString(JTextField txt) {
        if(txt.getText().equals("") || txt.getText().equals(" ") || txt.getText().equals("null")) {
            MsgBox.alert(null, "Vui lòng nhập vào!");
            txt.requestFocus();
            return getTextFieldtoString(txt);
        }
        return txt.getText();
    }

    public static String getTextAreatoString(JTextArea txa) {
        return txa.getText();
    }

    public static Double getTextFieldtoDouble(JTextField txt) {
        try {
            return Double.valueOf(txt.getText());
        } catch (NumberFormatException e) {
            MsgBox.alert(null, e.getMessage());
            throw new RuntimeException();
        }
    }

    public static Integer getTextFieldtoInteger(JTextField txt) {
        try {
            return Integer.valueOf(txt.getText());
        } catch (NumberFormatException e) {
            MsgBox.alert(null, e.getMessage());
            throw new RuntimeException();
        }
    }

    public static Float getTextFieldtoFloat(JTextField txt) {
        try {
            return Float.valueOf(txt.getText());
        } catch (NumberFormatException e) {
            MsgBox.alert(null, e.getMessage());
            throw new RuntimeException();
        }
    }

    public static boolean getSelectedRadiobutton(JRadioButton rdo_1, JRadioButton rdo_2) {
        if (rdo_1.isSelected()) {
            rdo_1.setSelected(true);
            return true;
        } else if (rdo_2.isSelected()) {
            rdo_2.setSelected(true);
            return true;
        } else {
            return false;
        }
    }

    public static String getComboBoxString(JComboBox<String> cbx) {
        return (String) cbx.getSelectedItem();
    }

    public static Integer getComboBoxInteger(JComboBox<Integer> cbx) {
        return cbx.getSelectedIndex();
    }

    public static Boolean isNumber(String numb) {
        try {
            Double.valueOf(numb);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static Date getDateSQL(java.util.Date getDateUtil) {
        Date newDate = new Date(getDateUtil.getTime());
        return newDate;
    }

    public static Date getDateChoosetoDateSQL(JDateChooser dateChooser) {
        return dateChooser != null ? getDateSQL(dateChooser.getDate()) : null;
    }
}
