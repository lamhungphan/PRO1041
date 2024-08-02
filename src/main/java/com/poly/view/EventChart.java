//package com.poly.view;
//
//import com.poly.services.EventService;
//import com.poly.services.impl.EventServiceImpl;
//import org.jfree.chart.ChartFactory;
//import org.jfree.chart.ChartPanel;
//import org.jfree.chart.JFreeChart;
//import org.jfree.chart.plot.PlotOrientation;
//import org.jfree.data.category.DefaultCategoryDataset;
//import java.util.List;
//import javax.swing.*;
//import java.awt.*;
//
//public class EventChart extends JFrame {
//
//    private EventServiceImpl eventServiceImpl;
//
//    public EventChart(EventServiceImpl eventServiceImpl) {
//        this.eventServiceImpl = eventServiceImpl;
//        initialize();
//
//
//        private void initialize () {
//            List<Object[]> data = eventServiceImpl.getMemberCountByEvent();
//            DefaultCategoryDataset dataset = new DefaultCategoryDataset();
//
//            for (Object[] row : data) {
//                String eventName = (String) row[0];
//                Long memberCount = (Long) row[1];
//                dataset.addValue(memberCount, "Thành viên", eventName);
//            }
//            JFreeChart barChart = ChartFactory.createBarChart(
//                    "Thành viên tham gia sự kiện",
//                    "Sự kiện",
//                    "Số lượng thành viên",
//                    dataset,
//                    PlotOrientation.VERTICAL,
//                    true, true, false);
//
//            ChartPanel chartPanel = new ChartPanel(barChart);
//            chartPanel.setPreferredSize(new java.awt.Dimension(560, 367));
//            add(chartPanel);
//        }
//    }
//        public static void main (String[] args){
//
//        }
//    }
//}
