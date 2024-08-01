package com.poly.view;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.awt.*;

public class LineChart extends JFrame {

    public LineChart(String title) {
        super(title);

        // Tạo dataset
        DefaultCategoryDataset dataset = createDataset();

        // Tạo biểu đồ
        JFreeChart chart = ChartFactory.createLineChart(
                "Biểu đồ Doanh số",
                "Năm",
                "Doanh số (triệu VND)",
                dataset,
                PlotOrientation.VERTICAL,
                true, true, false);

        // Tùy chỉnh biểu đồ
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(800, 600));
        setContentPane(chartPanel);
    }

    private DefaultCategoryDataset createDataset() {
        String series1 = "Sản phẩm A";
        String series2 = "Sản phẩm B";

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        dataset.addValue(1000, series1, "2020");
        dataset.addValue(1500, series1, "2021");
        dataset.addValue(1300, series1, "2022");

        dataset.addValue(1200, series2, "2020");
        dataset.addValue(1600, series2, "2021");
        dataset.addValue(1100, series2, "2022");

        return dataset;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            LineChart example = new LineChart("Ví dụ JFreeChart");
            example.setSize(800, 600);
            example.setLocationRelativeTo(null);
            example.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            example.setVisible(true);
        });
    }
}
