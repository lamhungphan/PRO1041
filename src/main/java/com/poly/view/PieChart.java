package com.poly.view;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

import javax.swing.*;
import java.awt.*;

public class PieChart extends JFrame {

    public PieChart(String title) {
        super(title);

        // Tạo dataset
        DefaultPieDataset dataset = createDataset();

        // Tạo biểu đồ
        JFreeChart chart = ChartFactory.createPieChart(
                "Biểu đồ Phân phối",
                dataset,
                true, true, false);

        // Tùy chỉnh biểu đồ
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(800, 600));
        setContentPane(chartPanel);
    }

    private DefaultPieDataset createDataset() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Category 1", 45.0);
        dataset.setValue("Category 2", 30.0);
        dataset.setValue("Category 3", 25.0);

        return dataset;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            PieChart example = new PieChart("Ví dụ JFreeChart");
            example.setSize(800, 600);
            example.setLocationRelativeTo(null);
            example.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            example.setVisible(true);
        });
    }
}
