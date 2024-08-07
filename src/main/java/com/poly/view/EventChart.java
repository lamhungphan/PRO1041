//package com.poly.view;
//
//import com.poly.injection.EventInjector;
//import com.poly.services.EventService;
//import com.poly.services.impl.EventServiceImpl;
//import com.poly.repository.impl.EventRepoImpl;
//import org.jfree.chart.ChartFactory;
//import org.jfree.chart.ChartPanel;
//import org.jfree.chart.JFreeChart;
//import org.jfree.chart.plot.PlotOrientation;
//import org.jfree.data.category.DefaultCategoryDataset;
//import java.util.List;
//import javax.swing.*;
//import java.awt.*;
//import org.hibernate.cfg.Configuration;
//import org.hibernate.SessionFactory;
//import org.jfree.data.category.CategoryDataset;
//
//public class EventChart extends JFrame {
//
//    private EventService eventService;
//
//    public EventChart(String title) {
//        super(title);
//        // Khởi tạo EventService thông qua EventInjector
//        eventService = EventInjector.getEventService();
//
//        // Tạo dataset
//        CategoryDataset dataset = createDataset();
//
//        // Tạo biểu đồ
//        JFreeChart barChart = ChartFactory.createBarChart(
//                "Thành viên tham gia sự kiện", // Tiêu đề
//                "Sự kiện", // trục X
//                "Số lượng thành viên", // trục Y
//                dataset,
//                PlotOrientation.VERTICAL,
//                true, true, false);
//
//        // Tạo ChartPanel và thêm vào JFrame
//        ChartPanel chartPanel = new ChartPanel(barChart);
//        chartPanel.setPreferredSize(new Dimension(800, 600));
//        setContentPane(chartPanel);
//    }
//
//    private CategoryDataset createDataset() {
//        List<Object[]> data = eventService.getMemberCountByEvent();
//        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
//
//        dataset.addValue(10, "Thành viên", "Tháng 6");
//        dataset.addValue(15, "Thành viên", "Tháng 7");
//        dataset.addValue(20, "Thành viên", "Tháng 8");
//        dataset.addValue(5, "Thành viên", "Tháng 9");
//        
////        for (Object[] row : data) {
////            if (row.length >= 2) {
////                String eventName = (String) row[0];
////                Long memberCount = (Long) row[1];
////                dataset.addValue(memberCount, "Thành viên", eventName);
////            }
////        }
//        return dataset;
//    }
//
//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(() -> {
//            EventChart example = new EventChart("Biểu đồ cột JFreeChart ví dụ");
//            example.setSize(800, 600);
//            example.setLocationRelativeTo(null);
//            example.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//            example.setVisible(true);
//        });
//    }
//}
