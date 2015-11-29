
import java.awt.Color; 
import java.awt.BasicStroke; 
import org.jfree.chart.ChartPanel; 
import org.jfree.chart.JFreeChart; 
import org.jfree.data.xy.XYDataset; 
import org.jfree.data.xy.XYSeries; 
import org.jfree.ui.ApplicationFrame; 
import org.jfree.ui.RefineryUtilities; 
import org.jfree.chart.plot.XYPlot; 
import org.jfree.chart.ChartFactory; 
import org.jfree.chart.plot.PlotOrientation; 
import org.jfree.data.xy.XYSeriesCollection; 
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;



public class LineReporter implements Reporter
{
private XYSeriesCollection dataset;
private XYSeries data;
private int index = 0 ;
public class XYLineChart_AWT extends ApplicationFrame
{
   public XYLineChart_AWT( String applicationTitle , String chartTitle )
   {
     
      super(applicationTitle);
      JFreeChart xylineChart = ChartFactory.createXYLineChart(
         chartTitle ,
         "Category" ,
         "Score" ,
         dataset ,
         PlotOrientation.VERTICAL ,
         true , true , false);
         
      ChartPanel chartPanel = new ChartPanel( xylineChart );
      chartPanel.setPreferredSize( new java.awt.Dimension( 560 , 367 ) );
      final XYPlot plot = xylineChart.getXYPlot( );
      XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer( );
      renderer.setSeriesPaint( 0 , Color.RED );
      renderer.setSeriesStroke( 0 , new BasicStroke( 4.0f ) );
     
      plot.setRenderer( renderer ); 
      setContentPane( chartPanel ); 
   }   
}
public void init()
{
  dataset = new XYSeriesCollection();
  data = new XYSeries( "Data" );
  dataset.addSeries( data );  
   
}
public void addValue(double val)
{
  data.add( index , val);
  index++;  
}
public void report()
{
  LineReporter.XYLineChart_AWT chart =
     new LineReporter.XYLineChart_AWT( "Node Value" ,
      "Value");
  chart.pack();
  RefineryUtilities.centerFrameOnScreen( chart );
  chart.setVisible( true );
      
}   
}