package com.poly.view;

import com.poly.services.EventService;
import com.poly.services.impl.EventServiceImpl;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import java.util.List;
import javax.swing.*;
import java.awt.*;
import org.jfree.data.category.CategoryDataset;

public class EventChart extends JFrame {

    private EventServiceImpl eventServiceImpl;

    public EventChart(String title) {
        super(title);
//        this.eventServiceImpl = new EventServiceImpl(); // Khởi tạo eventServiceImpl

        // Tạo dataset
        CategoryDataset dataset = createDataset();

        // Tạo biểu đồ
        JFreeChart barChart = ChartFactory.createBarChart(
                "Thành viên tham gia sự kiện",
                "Sự kiện",
                "Số lượng thành viên",
                dataset,
                PlotOrientation.VERTICAL,
                true, true, false);

        // Tạo ChartPanel và thêm vào JFrame
        ChartPanel chartPanel = new ChartPanel(barChart);
        chartPanel.setPreferredSize(new Dimension(800, 600));
        setContentPane(chartPanel);
    }

    private CategoryDataset createDataset() {
//        List<Object[]> data = eventServiceImpl.getMemberCountByEvent();
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(10, "Thành viên", "Sự kiện A");
        dataset.addValue(15, "Thành viên", "Sự kiện B");
        dataset.addValue(20, "Thành viên", "Sự kiện C");
        dataset.addValue(25, "Thành viên", "Sự kiện D");
        return dataset;
    }
}
