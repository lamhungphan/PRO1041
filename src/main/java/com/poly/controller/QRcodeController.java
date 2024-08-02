package com.poly.controller;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.image.BufferedImage;
// Sử dụng thư viện Swing để tạo ra cái Hình QR code
public class QRcodeController {

    private void createAndShowGUI() {
        JFrame frame = new JFrame("Tạo QR code");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout(10, 10));
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));
        panel.setBackground(Color.LIGHT_GRAY);

        JTextField textField = new JTextField();
        textField.setFont(new Font("Arial", Font.PLAIN, 20));
        textField.setBackground(Color.WHITE);
        textField.setForeground(Color.BLACK);

        JButton generateButton = new JButton("Tạo mã QR");
        generateButton.setFont(new Font("Arial", Font.BOLD, 20));
        generateButton.setBackground(Color.BLUE);
        generateButton.setForeground(Color.WHITE);

        JLabel qrCodeLabel = new JLabel("", SwingConstants.CENTER);
        qrCodeLabel.setPreferredSize(new Dimension(300, 300));
        qrCodeLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        generateButton.addActionListener(e -> {
            String text = textField.getText();
            if (!text.isEmpty()) {
                BufferedImage qrCodeImage = generateQRCodeImage(text, 300, 300);
                if (qrCodeImage != null) {
                    qrCodeLabel.setIcon(new ImageIcon(qrCodeImage));
                    JOptionPane.showMessageDialog(frame, "Tạo QR code thành công ", "Success", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(frame, "Không thể tạo mã QR", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        panel.add(textField, BorderLayout.NORTH);
        panel.add(generateButton, BorderLayout.CENTER);
        panel.add(qrCodeLabel, BorderLayout.SOUTH);

        frame.add(panel);
        frame.setVisible(true);
    }

    private BufferedImage generateQRCodeImage(String text, int width, int height) {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        try {
            BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);
            return MatrixToImageWriter.toBufferedImage(bitMatrix);
        } catch (WriterException e) {
            e.printStackTrace();
            return null;
        }
    }

//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(() -> {
//            QRcodeController controller = new QRcodeController(); Muốn sài QR code này thì gọi lại cho nó vào cái button nào đó nha
//            controller.createAndShowGUI();
//        });
//    }
}