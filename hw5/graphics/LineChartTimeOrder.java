package hw5.graphics;

import hw5.Order;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class LineChartTimeOrder extends JFrame {

    public LineChartTimeOrder(ArrayList<Order> ordersList) {

        initUI( ordersList);
    }

    private void initUI(ArrayList<Order> ordersList) {

        XYDataset dataset = createDataset( ordersList);
        JFreeChart chart = createChart(dataset);
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        chartPanel.setBackground(Color.white);
        add(chartPanel);

        pack();
        setTitle("Line chart");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private XYDataset createDataset(ArrayList<Order> ordersList) {

        XYSeries series = new XYSeries("orders");
        for(int i = 0;i<ordersList.size();i++) {
            if (ordersList.get(i).gettOrder() < 180)
                series.add(i+1, ordersList.get(i).gettOrder());
            else {
                series.add(i + 1, ordersList.get(i).gettOrder());

            }
        }
        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series);

        return dataset;
    }

    private JFreeChart createChart(XYDataset dataset) {

        JFreeChart chart = ChartFactory.createXYLineChart(
                "All TimeOfOrders Chart",
                "Id of order",
                "TimeOfOrder",
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );

        XYPlot plot = chart.getXYPlot();

        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        renderer.setSeriesPaint(0, Color.GREEN);
        renderer.setSeriesStroke(0, new BasicStroke(2.0f));

        plot.setRenderer(renderer);
        plot.setBackgroundPaint(Color.white);

        plot.setRangeGridlinesVisible(true);
        plot.setRangeGridlinePaint(Color.BLACK);

        plot.setDomainGridlinesVisible(true);
        plot.setDomainGridlinePaint(Color.BLACK);

        chart.getLegend().setFrame(BlockBorder.NONE);

        chart.setTitle(new TextTitle("All TimeOfOrders of this Algorythm",
                        new Font("Serif", java.awt.Font.BOLD, 18)
                )
        );

        return chart;

    }

    public static void drawDelay(ArrayList<Order> ordersList) {

        SwingUtilities.invokeLater(() -> {
            LineChartTimeOrder ex = new LineChartTimeOrder( ordersList);
            ex.setVisible(true);
        });
    }


}