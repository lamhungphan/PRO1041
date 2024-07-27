/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.utils;

import javax.swing.*;

/**
 *
 * @author ACER
 */
public class ComponentManagement {

    public static void setEnabledRecursively(JComponent component, boolean enabled) {
        component.setEnabled(enabled);
//        for (Component child : component.getComponents()) {
//            if (child instanceof JComponent) {
//                setEnabledRecursively((JComponent) child, enabled);
//            }
//        }
    }
}
