import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;



public class LineReporter implements Reporter
{
private DefaultCategoryDataset dataset;
private int index = 0 ;
public class LineChart_AWT extends ApplicationFrame
{
   public LineChart_AWT( String applicationTitle , String chartTitle )
   {
      super(applicationTitle);
      JFreeChart lineChart = ChartFactory.createLineChart(
         chartTitle,
         "Index","Value",
         dataset,
         PlotOrientation.VERTICAL,
         true,true,false);
         
      ChartPanel chartPanel = new ChartPanel( lineChart );
      chartPanel.setPreferredSize( new java.awt.Dimension( 560 , 367 ) );
      setContentPane( chartPanel );
   }   
}
public void init()
{
  dataset = new DefaultCategoryDataset( );
 
}
public void addValue(double val)
{
  dataset.addValue( val , "Index", String.valueOf(index));
  index++;  
}
public void report()
{
  LineReporter.LineChart_AWT chart =
     new LineReporter.LineChart_AWT( "Node Value" ,
      "Value");
  chart.pack();
  RefineryUtilities.centerFrameOnScreen( chart );
  chart.setVisible( true );
      
}   
}