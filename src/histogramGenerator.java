/**
 * Created by raoyinchen on 3/7/17.
 */
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.statistics.HistogramBin;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class histogramGenerator extends ApplicationFrame
{
    static HashMap<String, Integer>  table = new HashMap<String, Integer>() {{
        put("gas",1);
        put("income",2);
        put("rent",3);
        put("others",5);
    }};


    public histogramGenerator( String applicationTitle)
    {
        super( applicationTitle );
        generateBarChart();
    }
    public static ChartPanel generateBarChart() {
        JFreeChart barChart = ChartFactory.createBarChart(
                "money spent during the period",
                "Category",
                "Score",
                createDataset(),
                PlotOrientation.VERTICAL,
                true, true, false);

        ChartPanel chartPanel = new ChartPanel( barChart );
        chartPanel.setPreferredSize(new java.awt.Dimension( 560 , 367 ) );
        return chartPanel;
    }
    private static CategoryDataset createDataset( ) {

        final DefaultCategoryDataset dataset =
                new DefaultCategoryDataset( );

        if(trackBoard.displayType.equals("All")) {
            for (String type : table.keySet()) {
            dataset.addValue( table.get(type) , type, "how much has spent");
        }
    }else {
            dataset.addValue( table.get(trackBoard.displayType), trackBoard.displayType, "how much has spent");
        };

        return dataset;
    }
    public static void main( String[ ] args )
    {
        histogramGenerator chart = new histogramGenerator("Money Usage Statistics");
        chart.pack( );
        RefineryUtilities.centerFrameOnScreen( chart );
        chart.setVisible( true );
    }
}
