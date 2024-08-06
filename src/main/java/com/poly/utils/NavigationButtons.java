package com.poly.utils;

import javax.swing.JTable;

public class NavigationButtons {

    public static int navButton(String button_direction, JTable table, int currentRow) {
        switch (button_direction) {
            case "first":
                currentRow = 0;
                break;
            case "previous":
                if (currentRow > 0) {
                    currentRow--;
                }
                break;
            case "next":
                if (currentRow < table.getRowCount() - 1) {
                    currentRow++;
                }
                break;
            case "last":
                currentRow = table.getRowCount() - 1;
                break;
        }
        edit(table, currentRow);
        System.out.println("Current row is: " + currentRow);
        return currentRow;
    }

    public static int navButtonInForm(String button_direction,int sizeOfList ,int currentRow) {
        switch (button_direction) {
            case "first":
                currentRow = 0;
                break;
            case "previous":
                if (currentRow > 0) {
                    currentRow--;
                }
                break;
            case "next":
                if (currentRow < sizeOfList - 1) {
                    currentRow++;
                }
                break;
            case "last":
                currentRow = sizeOfList - 1;
                break;
        }
        System.out.println("Current row is: " + currentRow);
        return currentRow;
    }
    private static void edit(JTable table, int rowIndex) {
        table.setRowSelectionInterval(rowIndex, rowIndex);
    }
}
