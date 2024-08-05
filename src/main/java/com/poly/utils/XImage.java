package com.poly.utils;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import javax.swing.*;

public class XImage {

    /**
     * Ảnh biểu tượng của ứng dụng, xuất hiện trên mọi cửa sổ
     *
     * @return
     */
//    public static Image getAppIcon() {
//        String file = "/icon/fpt.png";
//        URL location = XImage.class.getResource(file);
//        Image icon = new ImageIcon(location).getImage();
//        return icon;
//    }

    /**
     * Sao chép file logo chuyên đề vào thư mục logo
     *
     * @param src là đối tượng file ảnh
     */
    public static void save(File src) {
        File dst = new File("resources/avatar", src.getName());
        if (!dst.getParentFile().exists()) {
            dst.getParentFile().mkdirs();
        }
        try {
            Path from = Paths.get(src.getAbsolutePath());
            Path to = Paths.get(dst.getAbsolutePath());

            Files.copy(from, to, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
     /**
     * Đọc hình ảnh logo chuyên đề
     * @param fileName  là tên file logo
     * @return ảnh đọc được
     */   
    public static ImageIcon read(JLabel label,String fileName){
        File path = new File("resources/avatar", fileName);
        return scaleImageToLabel(label, path.getAbsolutePath());
    }

    public static ImageIcon scaleImageToLabel(JLabel label, String imagePath) {
        // Tạo ImageIcon từ đường dẫn ảnh
        ImageIcon icon = new ImageIcon(imagePath);

        // Lấy kích thước của JLabel
        int labelWidth = label.getWidth();
        int labelHeight = label.getHeight();

        // Lấy Image từ ImageIcon và scale theo kích thước của JLabel
        Image scaledImage = icon.getImage().getScaledInstance(labelWidth, labelHeight, Image.SCALE_SMOOTH);

        // Tạo lại ImageIcon từ ảnh đã scale
        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        // Gán ImageIcon đã scale vào JLabel
        label.setIcon(scaledIcon);
        return scaledIcon;
    }
}
