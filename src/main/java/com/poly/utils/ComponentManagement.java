package com.poly.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

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
}
