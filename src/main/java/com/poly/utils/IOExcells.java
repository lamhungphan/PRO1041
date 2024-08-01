package com.poly.utils;

import java.io.File;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;

public class IOExcells implements Serializable{

    public static void exportToExcel(List<List<Object>> data) {
    if (data == null || data.isEmpty()) {
        System.err.println("No data provided for export.");
        return; // Trả về nếu không có dữ liệu
    }

    String projectPath = System.getProperty("user.dir");
    String filePath = projectPath + File.separator + "Other Sources" + File.separator + "m2m_excell_output.xlsx";
        System.out.println(filePath);
        
    File directory = new File(projectPath + File.separator + "Other Sources");
    if (!directory.exists()) {
        directory.mkdirs(); // Tạo thư mục nếu chưa tồn tại
    }

    try (XSSFWorkbook workbook = new XSSFWorkbook()) {
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

        try (FileOutputStream outputStream = new FileOutputStream(filePath)) {
            workbook.write(outputStream);
        }
    } catch (IOException e) {
        System.err.println("Error while exporting to Excel: " + e.getMessage());
        e.printStackTrace();
    }
}



}
