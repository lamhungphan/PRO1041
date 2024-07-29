package com.poly.utils;

import java.awt.Component;
import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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

    public static String getSelectedRadiobutton(JRadioButton rdo_1, JRadioButton rdo_2) {
        if (rdo_1.isSelected()) {
            return rdo_1.getText();
        } else if (rdo_2.isSelected()) {
            return rdo_2.getText();
        }
        return null;
    }

    public static String getComboBoxString(JComboBox<String> cbx) {
        return (String) cbx.getSelectedItem();
    }

    private static Boolean isNumber(String numb) {
        try {
            Double.valueOf(numb);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
