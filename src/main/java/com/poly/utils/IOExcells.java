package com.poly.utils;

import java.io.File;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javax.swing.JFileChooser;

public class IOExcells implements Serializable {

    private static String openSaveFileExport() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Chọn nơi để lưu file!");
        fileChooser.setSelectedFile(new File("demo.xlsx"));
        int userSelection = fileChooser.showSaveDialog(null);
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            return fileToSave.getAbsolutePath();
        }
        return null;
    }
    
    private static String openReadFileExport() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Chọn nơi để lưu file!");
        fileChooser.setSelectedFile(new File("demo.xlsx"));
        int userSelection = fileChooser.showSaveDialog(null);
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            return fileToSave.getAbsolutePath();
        }
        return null;
    }

    public static void exportToExcelGGSheet(List<List<Object>> data) {
        if (data == null || data.isEmpty()) {
            System.err.println("No data provided for export.");
            MsgBox.alert(null, "Dữ liệu lỗi !");
            return; // Trả về nếu không có dữ liệu
        }

        String filePath = openSaveFileExport();
        System.out.println(filePath);
        if (filePath.isEmpty() || filePath == null) {
            MsgBox.alert(null, "Đường dẫn không tồn tại !");
            return;
        }
        try {
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("ExcellExport");

            int rowNum = 0;
            for (List<Object> rowData : data) {
                Row row = sheet.createRow(rowNum++);
                int colNum = 0;
                for (Object field : rowData) {
                    Cell cell = row.createCell(colNum++);
                    if (field instanceof String) {
                        cell.setCellValue((String) field);
                    } else if (field instanceof Integer) {
                        cell.setCellValue((Integer) field);
                    } else if (field instanceof Double) {
                        cell.setCellValue((Double) field);
                    }
                }
            }
            FileOutputStream outputStream = new FileOutputStream(filePath);
            workbook.write(outputStream);
            File fileName = new File(filePath);
            MsgBox.alert(null, "Lưu thành công file: " + fileName.getName());
        } catch (IOException e) {
            System.err.println("Error while exporting to Excel: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void exportToExcelObject(List<Object> data) {
        if (data == null || data.isEmpty()) {
            System.err.println("No data provided for export.");
            MsgBox.alert(null, "Dữ liệu lỗi !");
            return; // Trả về nếu không có dữ liệu
        }

        String filePath = openSaveFileExport();
        System.out.println(filePath);
        if (filePath.isEmpty() || filePath == null) {
            MsgBox.alert(null, "Đường dẫn không tồn tại !");
            return;
        }
        try {
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("ExcellExport");

            Row row = sheet.createRow(0); // Tạo hàng đầu tiên
            int colNum = 0;
            for (Object field : data) {
                Cell cell = row.createCell(colNum++);
                if (field instanceof String) {
                    cell.setCellValue((String) field);
                } else if (field instanceof Integer) {
                    cell.setCellValue((Integer) field);
                } else if (field instanceof Double) {
                    cell.setCellValue((Double) field);
                } else if (field instanceof Boolean) {
                    cell.setCellValue((Boolean) field);
                } else if (field instanceof java.util.Date) {
                    cell.setCellValue((java.util.Date) field);
                } else {
                    cell.setCellValue(field.toString()); // Xử lý kiểu dữ liệu khác thành chuỗi
                }
            }
            FileOutputStream outputStream = new FileOutputStream(filePath);
            workbook.write(outputStream);
            File fileName = new File(filePath);
            MsgBox.alert(null, "Lưu thành công file: " + fileName.getName());
        } catch (IOException e) {
            System.err.println("Error while exporting to Excel: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
