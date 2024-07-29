/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.utils;

import java.awt.Component;
import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author seastone01202
 */

public class ComponentManagement {
    
    public static <T> void fillDataTableComponent(List<T> list, JTable tableChoose, String[] methodNames) {
        DefaultTableModel model = (DefaultTableModel) tableChoose.getModel();
        model.setRowCount(0);
        try {
            for (T instance : list) {
                Object[] row = new Object[methodNames.length];
                for (int i = 0; i < methodNames.length; i++) {
                    Method method = instance.getClass().getMethod(methodNames[i]);
                    row[i] = method.invoke(instance);
                }
                model.addRow(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
        public static void setEnabledRecursively(Container container, boolean enabled) {
        Component[] components = container.getComponents();
        for (Component component : components) {
            component.setEnabled(enabled);
            if (component instanceof Container) {
                setEnabledRecursively((Container) component, enabled);
            }
        }
        if(enabled == false){
            addClickListener(container);
        }
    }
        
        private static void addClickListener(Container panel) {
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Hiển thị thông báo khi nhấp vào panel
                String message = "Không có quyền truy cập";
                MsgBox.alert(null, message);
            }
        });
    }
}
