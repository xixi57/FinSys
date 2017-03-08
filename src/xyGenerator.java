/**
 * Created by raoyinchen on 3/7/17.
 */
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;

import org.jfree.chart.JFreeChart;

import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;


import javax.swing.*;
import java.awt.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;


import javax.swing.*;

/***/
public class xyGenerator extends JFrame {
    public static ArrayList<Integer> gas_x = new ArrayList<>(Arrays.asList(1,2,3,4,5));
    public static ArrayList<Integer> gas_y = new ArrayList<>(Arrays.asList(2,3,4,4,5));
    public  static ArrayList<Integer> income_x = new ArrayList<>(Arrays.asList(1,2,3,4,5));
    public static ArrayList<Integer> income_y= new ArrayList<>(Arrays.asList(0,2,5,6,5));
    public static ArrayList<Integer> rent_x = new ArrayList<>(Arrays.asList(1,2,3,4,5));
    public static ArrayList<Integer> rent_y = new ArrayList<>(Arrays.asList(1,5,5,6,8));
    public static ArrayList<Integer> others_x = new ArrayList<>(Arrays.asList(1,2,3,4,5));
    public static ArrayList<Integer> others_y = new ArrayList<>(Arrays.asList(1,5,5,6,8));// the display data are made up. REal dara from database should be put in.


    public static XYSeries gas = new XYSeries("gas");
    public static XYSeries income = new XYSeries("income");
    public  static XYSeries rent = new XYSeries("rent");
    public static XYSeries others = new XYSeries("others");



    public static HashMap<String, XYSeries> table = new HashMap<>();


    public xyGenerator() {
        super("XY Line Chart Example with JFreechart");

        table.put("gas",gas);
        table.put("income",income);

        table.put("rent",rent);
        table.put("others",others);

        JPanel chartPanel = createChartPanel();
        add(chartPanel, BorderLayout.CENTER);

        setSize(640, 480);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static JPanel createChartPanel() {
        String chartTitle = "Objects Movement Chart";
        String xAxisLabel = "X";
        String yAxisLabel = "Y";

        XYDataset dataset = createDataset();

        JFreeChart chart = ChartFactory.createXYLineChart(chartTitle,
                xAxisLabel, yAxisLabel, dataset);


        return new ChartPanel(chart);
    }


    public static XYDataset createDataset() {

        XYSeriesCollection dataset = new XYSeriesCollection();
        for(int i = 0; i < gas_x.size(); i++) {
            gas.add(gas_x.get(i),gas_y.get(i));//should be sorted?
        }

        for(int i = 0; i < income_x.size(); i++) {
            income.add(income_x.get(i),income_y.get(i));//should be sorted?
        }

        for(int i = 0; i < rent_x.size(); i++) {
            rent.add(rent_x.get(i),rent_y.get(i));//should be sorted?
        }
        for(int i = 0; i < others_x.size(); i++) {
            others.add(others_x.get(i),others_y.get(i));//should be sorted?
        }


        if("All".equals(trackBoard.displayType))
        {
            dataset.addSeries(gas);
            dataset.addSeries(income);
            dataset.addSeries(rent);
            dataset.addSeries(others);
            System.out.print("All");
        } else if ("income".equals(trackBoard.displayType)) {
            dataset.addSeries(income);
        } else if ("gas".equals(trackBoard.displayType)) {
            dataset.addSeries(gas);
        } else if ("rent".equals(trackBoard.displayType)) {
            dataset.addSeries(rent);
        } else if ("others".equals(trackBoard.displayType)) {
            dataset.addSeries(others);
        }

        return dataset;
    }



    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new xyGenerator().setVisible(true);
            }
        });

    }
}