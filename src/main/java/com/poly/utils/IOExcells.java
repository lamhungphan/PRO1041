package com.poly.utils;

import com.poly.entity.Event;
import com.poly.entity.User;
import java.io.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
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
            MsgBox.alert(null, "Lưu thành công file: " + fileName.getName() + "\n" + "Đường dẫn tệp: " + filePath);
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

    public static void exportToExcelMember(List<User> data) {
        if (data == null || data.isEmpty()) {
            System.err.println("No data provided for export.");
            MsgBox.alert(null, "Dữ liệu lỗi !");
            return; // Trả về nếu không có dữ liệu
        }

        String filePath = openSaveFileExport();
        if (filePath == null || filePath.isEmpty()) {
            MsgBox.alert(null, "Đường dẫn không tồn tại !");
            return;
        }

        try (XSSFWorkbook workbook = new XSSFWorkbook()) {
            XSSFSheet sheet = workbook.createSheet("ExcellExport");

            // Tạo hàng tiêu đề
            Row headerRow = sheet.createRow(0);
            String[] columns = {"ID", "Fullname", "Email", "Phone", "Birthday", "Score", "Address"};
            for (int i = 0; i < columns.length; i++) {
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(columns[i]);
            }

            // Điền dữ liệu vào các hàng
            int rowNum = 1;
            for (User user : data) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(user.getId() != null ? user.getId().toString() : "Không có dữ liệu !");
                row.createCell(1).setCellValue(user.getFullname() != null ? user.getFullname().toString() : "Không có dữ liệu !");
                row.createCell(2).setCellValue(user.getEmail() != null ? user.getEmail().toString() : "Không có dữ liệu !");
                row.createCell(3).setCellValue(user.getPhone() != null ? user.getPhone().toString() : "Không có dữ liệu !");
                row.createCell(4).setCellValue(user.getBirthday() != null ? user.getBirthday().toString() : "Không có dữ liệu !"); // Chuyển đổi ngày tháng thành chuỗi
                row.createCell(5).setCellValue(user.getScore() != null ? user.getScore().toString() : "Không có dữ liệu !");
                row.createCell(6).setCellValue(user.getAddress() != null ? user.getAddress().toString() : "Không có dữ liệu !");
            }

            // Ghi workbook vào tệp
            try (FileOutputStream outputStream = new FileOutputStream(filePath)) {
                workbook.write(outputStream);
            }

            File fileName = new File(filePath);
            MsgBox.alert(null, "Lưu thành công file: " + fileName.getName());
        } catch (IOException e) {
            System.err.println("Error while exporting to Excel: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void exportToExcelEvent(List<Event> data) {
        if (data == null || data.isEmpty()) {
            System.err.println("No data provided for export.");
            MsgBox.alert(null, "Dữ liệu lỗi !");
            return; // Trả về nếu không có dữ liệu
        }

        String filePath = openSaveFileExport();
        if (filePath == null || filePath.isEmpty()) {
            MsgBox.alert(null, "Đường dẫn không tồn tại !");
            return;
        }

        try (XSSFWorkbook workbook = new XSSFWorkbook()) {
            XSSFSheet sheet = workbook.createSheet("ExcellExport");

            // Tạo hàng tiêu đề
            Row headerRow = sheet.createRow(0);
            String[] columns = {"ID", "Fullname", "Email", "Phone", "Birthday", "Score", "Address"};
            for (int i = 0; i < columns.length; i++) {
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(columns[i]);
            }

            // Điền dữ liệu vào các hàng
            int rowNum = 1;
            for (Event event : data) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(event.getId() != null ? event.getId().toString() : "Không có dữ liệu !");
                row.createCell(1).setCellValue(event.getUser().getFullname() != null ? event.getUser().getFullname().toString() : "Không có dữ liệu !");
                row.createCell(2).setCellValue(event.getTitle() != null ? event.getTitle().toString() : "Không có dữ liệu !");
                row.createCell(3).setCellValue(event.getContent() != null ? event.getContent().toString() : "Không có dữ liệu !");
                row.createCell(4).setCellValue(event.getStartedDate() != null ? event.getStartedDate().toString() : "Không có dữ liệu !"); // Chuyển đổi ngày tháng thành chuỗi
                row.createCell(5).setCellValue(event.getEndedDate() != null ? event.getEndedDate().toString() : "Không có dữ liệu !");
                row.createCell(6).setCellValue(event.getLocation() != null ? event.getLocation().toString() : "Không có dữ liệu !");
            }

            // Ghi workbook vào tệp
            try (FileOutputStream outputStream = new FileOutputStream(filePath)) {
                workbook.write(outputStream);
            }

            File fileName = new File(filePath);
            MsgBox.alert(null, "Lưu thành công file: " + fileName.getName());
        } catch (IOException e) {
            System.err.println("Error while exporting to Excel: " + e.getMessage());
            e.printStackTrace();
        }
    }

public static List<User> importToExcelMember() throws ParseException {
        FileInputStream fis = null;
        List<User> userList = new ArrayList<>();
        try {
            String filePath = openSaveFileExport();
            System.out.println(filePath);
            if (filePath == null || filePath.isEmpty()) {
                MsgBox.alert(null, "Đường dẫn không tồn tại !");
                return userList;
            }
            fis = new FileInputStream(new File(filePath)); // use path choose 
            XSSFWorkbook wb = new XSSFWorkbook(fis); // use XSSFWorkbook file .xlsx
            XSSFSheet sheet = wb.getSheetAt(0);
            FormulaEvaluator formulaEvaluator = wb.getCreationHelper().createFormulaEvaluator();

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            for (Row row : sheet) {
                if (row.getRowNum() == 0) {
                    continue;
                }
                String fullname = null;
                String email = null;
                String phone = null;
                Date birthday = null;
                String score = null;
                String address = null;

                for (Cell cell : row) {
                    switch (cell.getColumnIndex()) {
                        case 1:
                            fullname = cell.getStringCellValue();
                            break;
                        case 2:
                            email = cell.getStringCellValue();
                            break;
                        case 3:
                            phone = cell.getStringCellValue();
                            break;
                        case 4:
                            if (cell.getCellType() == CellType.STRING) {
                                birthday = InputFields.getDateSQL(sdf.parse(cell.getStringCellValue()));
                            } else if (cell.getCellType() == CellType.NUMERIC) {
                                birthday = InputFields.getDateSQL(cell.getDateCellValue());
                            }
                            break;
                        case 5:
                            if (cell.getCellType() == CellType.NUMERIC) {
                                score = String.valueOf(cell.getNumericCellValue());
                            } else if (cell.getCellType() == CellType.STRING) {
                                score = cell.getStringCellValue();
                            }
                            break;
                        case 6:
                            address = cell.getStringCellValue();
                            break;
                        default:
                            break;
                    }
                }

                User user = new User();
                user.setFullname(fullname);
                user.setAddress(address);
                if (birthday != null) {
                    user.setBirthday(new java.sql.Date(birthday.getTime())); // Chuyển đổi sang java.sql.Date
                }
                user.setPhone(phone);
                user.setScore(score);
                user.setEmail(email);
                userList.add(user);
            }
        } catch (IOException ex) {
            Logger.getLogger(IOExcells.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException ex) {
                    Logger.getLogger(IOExcells.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        for(User user: userList){
            System.out.println(user.toString());
        }
        return userList;
    }

    public static List<Event> importToExcelEvent() throws ParseException {
        FileInputStream fis = null;
        List<Event> eventList = new ArrayList<>();
        try {
            String filePath = openSaveFileExport();
            System.out.println(filePath);
            if (filePath == null || filePath.isEmpty()) {
                MsgBox.alert(null, "Đường dẫn không tồn tại !");
                return eventList;
            }
            fis = new FileInputStream(new File(filePath)); // use path choose
            XSSFWorkbook wb = new XSSFWorkbook(fis); // use XSSFWorkbook file .xlsx
            XSSFSheet sheet = wb.getSheetAt(0);
            FormulaEvaluator formulaEvaluator = wb.getCreationHelper().createFormulaEvaluator();

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            for (Row row : sheet) {
                if (row.getRowNum() == 0) {
                    continue;
                }
                Integer idUserEvent = null;
                String fullname = null;
                String title = null;
                String content = null;
                Date startedDate = null;
                Date endedDate = null;
                String room = null;

                for (Cell cell : row) {
                    switch (cell.getColumnIndex()) {
                        case 0:
                            idUserEvent = Integer.valueOf(cell.getStringCellValue());
                        case 1:
                            fullname = cell.getStringCellValue();
                            break;
                        case 2:
                            title = cell.getStringCellValue();
                            break;
                        case 3:
                            content = cell.getStringCellValue();
                            break;
                        case 4:
                            if (cell.getCellType() == CellType.STRING) {
                                startedDate = InputFields.getDateSQL(sdf.parse(cell.getStringCellValue()));
                            } else if (cell.getCellType() == CellType.NUMERIC) {
                                startedDate = InputFields.getDateSQL(cell.getDateCellValue());
                            }
                            break;
                        case 5:
                            if (cell.getCellType() == CellType.STRING) {
                                endedDate = InputFields.getDateSQL(sdf.parse(cell.getStringCellValue()));
                            } else if (cell.getCellType() == CellType.NUMERIC) {
                                endedDate = InputFields.getDateSQL(cell.getDateCellValue());
                            }
                            break;
                        case 6:
                            room = cell.getStringCellValue();
                            break;
                        default:
                            break;
                    }
                }

                Event event = new Event();
                User userEvent = new User();
                userEvent.setId(idUserEvent);
                event.setUser(userEvent);
                event.setTitle(title);
                event.setContent(content);
                if (startedDate != null) {
                    event.setStartedDate(new java.sql.Date(startedDate.getTime())); // Chuyển đổi sang java.sql.Date
                }
                if (endedDate != null) {
                    event.setStartedDate(new java.sql.Date(endedDate.getTime())); // Chuyển đổi sang java.sql.Date
                }
                event.setLocation(room);
                eventList.add(event);
            }
        } catch (IOException ex) {
            Logger.getLogger(IOExcells.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException ex) {
                    Logger.getLogger(IOExcells.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        for(Event event: eventList){
            System.out.println(event.toString());
        }
        return eventList;
    }

     
    public static void main(String[] args) {
        try {
            importToExcelEvent();
        } catch (ParseException ex) {
            Logger.getLogger(IOExcells.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
