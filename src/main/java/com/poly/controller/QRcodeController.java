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

    public void createAndShowGUI() {
        JFrame frame = new JFrame("Tạo QR code");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(500, 600);

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
        generateButton.setSize(100, 50);
        generateButton.setBackground(Color.BLUE);
        generateButton.setForeground(Color.WHITE);

        JLabel qrCodeLabel = new JLabel("", SwingConstants.CENTER);
        qrCodeLabel.setPreferredSize(new Dimension(300, 300));
        qrCodeLabel.setOpaque(true);  // Thiết lập để có thể thay đổi màu nền
        qrCodeLabel.setBackground(Color.WHITE);  // Đặt màu nền cho mã QR
        qrCodeLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        
        JTextField textField1 = new JTextField();
        textField1.setFont(new Font("Arial", Font.PLAIN, 20));
        textField1.setBackground(Color.WHITE);
        textField1.setForeground(Color.BLACK);
        textField1.setBorder(BorderFactory.createTitledBorder("Nếu bạn không nhận được đường dẫn đến form hỏi đáp thì vui lòng nhấn vào button tạo QR sau đó quét mã để được dẫn form hỏi đáp"));
        
        generateButton.addActionListener(e -> {
            String text = textField.getText();
            String textDefault = "https://docs.google.com/forms/d/e/1FAIpQLSc9eknnBQZc2gfG-WEZ8HoR1BT2ZMV0cDp5UyfCcf1dNyCqGg/viewform";
            if (!textDefault.isEmpty() || !text.isEmpty()) {
                if (text.isEmpty()) {
                    text = textDefault;
                }
                BufferedImage qrCodeImage = generateQRCodeImage(text, 300, 300);
                if (qrCodeImage != null) {
                    qrCodeLabel.setIcon(new ImageIcon(qrCodeImage));
                    JOptionPane.showMessageDialog(frame, "Tạo QR code thành công", "Success", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(frame, "Không thể tạo mã QR", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        panel.add(textField, BorderLayout.NORTH);
        panel.add(generateButton, BorderLayout.CENTER);

        JPanel southPanel = new JPanel();
        southPanel.setLayout(new BorderLayout());
        southPanel.add(qrCodeLabel, BorderLayout.NORTH);
        southPanel.add(textField1, BorderLayout.SOUTH);

        panel.add(southPanel, BorderLayout.SOUTH);

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

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new QRcodeController().createAndShowGUI());
    }
}
