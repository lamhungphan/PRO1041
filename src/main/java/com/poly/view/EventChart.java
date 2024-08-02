package com.poly.view;

import com.poly.services.EventService;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import java.util.List;
import javax.swing.*;
import java.awt.*;

public class EventChart extends JFrame {

    private EventService eventService;

    public EventChart(EventService eventService) {
        this.eventService = eventService;
        initialize();

//        // Tạo dataset
//        DefaultCategoryDataset dataset = createDataset();
//
//        // Tạo biểu đồ
//        JFreeChart chart = ChartFactory.createBarChart(
//                "Tổng lượt tham gia sự kiện",
//                "Tháng",
//                "Thành viên",
//                dataset,
//                PlotOrientation.VERTICAL,
//                true, true, false);
//
//        // Tùy chỉnh biểu đồ
//        ChartPanel chartPanel = new ChartPanel(chart);
//        chartPanel.setPreferredSize(new Dimension(800, 600));
//        setContentPane(chartPanel);
    }

    private void initialize() {
        List<Object[]> data = eventService.getMemberCountByEvent();
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        for (Object[] row : data) {
            String eventName = (String) row[0];
            Long memberCount = (Long) row[1];
            dataset.addValue(memberCount, "Members", eventName);
        }
        JFreeChart barChart = ChartFactory.createBarChart(
                "Member Participation by Event",
                "Event",
                "Number of Members",
                dataset,
                PlotOrientation.VERTICAL,
                true, true, false);

        ChartPanel chartPanel = new ChartPanel(barChart);
        chartPanel.setPreferredSize(new java.awt.Dimension(560, 367));
        add(chartPanel);
    }

//    private DefaultCategoryDataset createDataset() {
//        String series1 = "Không tham gia";
//        String series2 = "Tham gia";
//
//        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
//
//        dataset.addValue(5, series1, "Tháng 7");
//        dataset.addValue(1, series1, "Tháng 8");
//        dataset.addValue(3, series1, "Tháng 9");
//
//        dataset.addValue(54, series2, "Tháng 7");
//        dataset.addValue(29, series2, "Tháng 8");
//        dataset.addValue(48, series2, "Tháng 9");
//
//        return dataset;
//    }
    public static void main(String[] args) {
//        SwingUtilities.invokeLater(() -> {
//            BarChart example = new BarChart("Ví dụ JFreeChart");
//            example.setSize(800, 600);
//            example.setLocationRelativeTo(null);
//            example.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//            example.setVisible(true);
//        });
    }
}
