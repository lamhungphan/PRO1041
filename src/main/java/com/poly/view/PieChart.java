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
                "Nội dung sự kiện",
                dataset,
                true, true, false);

        // Tùy chỉnh biểu đồ
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(800, 600));
        setContentPane(chartPanel);
    }

    private DefaultPieDataset createDataset() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Core", 45.0);
        dataset.setValue("Advance", 30.0);
        dataset.setValue("Soft skill", 25.0);

        return dataset;
    }
}
