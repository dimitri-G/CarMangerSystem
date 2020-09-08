package pkg;

import java.awt.Font; 
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat; 
import java.text.NumberFormat; 

import javax.swing.JPanel; 

import org.jfree.chart.ChartFactory; 
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel; 
import org.jfree.chart.JFreeChart; 
import org.jfree.chart.labels.StandardPieSectionLabelGenerator; 
import org.jfree.chart.plot.PiePlot; 
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset; 
public class TEST2 { 
	ChartFrame frame1; 
  public TEST2() throws SQLException{ 
     DefaultPieDataset data = getDataSet(); 
     JFreeChart chart = ChartFactory.createPieChart3D("车辆租借量",data,true,false,false); 
    //设置百分比 
     PiePlot pieplot = (PiePlot) chart.getPlot(); 
     DecimalFormat df = new DecimalFormat("0.00%");//获得一个DecimalFormat对象，主要是设置小数问题 
     NumberFormat nf = NumberFormat.getNumberInstance();//获得一个NumberFormat对象 
     StandardPieSectionLabelGenerator sp1 = new StandardPieSectionLabelGenerator("{0} {2}", nf, df);//获得StandardPieSectionLabelGenerator对象 
     pieplot.setLabelGenerator(sp1);//设置饼图显示百分比 
   //没有数据的时候显示的内容 
     pieplot.setNoDataMessage("无数据显示"); 
     pieplot.setCircular(false); 
     pieplot.setLabelGap(0.02D); 
     pieplot.setIgnoreNullValues(true);//设置不显示空值 
     pieplot.setIgnoreZeroValues(true);//设置不显示负值 
     frame1=new ChartFrame (null, chart,true); 
     frame1.pack();
     chart.getTitle().setFont(new Font("宋体",Font.BOLD,20));//设置标题字体 
     PiePlot piePlot= (PiePlot) chart.getPlot();//获取图表区域对象 
     piePlot.setLabelFont(new Font("宋体",Font.BOLD,10));//解决乱码 
     chart.getLegend().setItemFont(new Font("黑体",Font.BOLD,10)); 
  } 
  private static DefaultPieDataset getDataSet() throws SQLException { 
    DefaultPieDataset dataset = new DefaultPieDataset(); 
    
    
    final Main a=new Main();
	a.dbConn=Main.link();
	int carId=4;
	int all=2;
	int i=0; 
	String sql2="select count(cars.carId) as cou from cars";
	final PreparedStatement sql12= a.dbConn.prepareStatement(sql2);
	ResultSet rs;
	ResultSet rs12=sql12.executeQuery();
	rs12.next();
	all=rs12.getInt("cou");
	
	String sql="select count(Includes.carId) as cou from Includes , cars where Includes.CarId =cars.CarId group by cars.CarId   ";
	final PreparedStatement sql1 = a.dbConn.prepareStatement(sql);

	 rs=sql1.executeQuery();
	//for()
	while(rs.next()){
		int cou=rs.getInt("cou");
		dataset.setValue( String.valueOf(carId+i),cou); 
		i++;
	}
     
    return dataset; 
} 
  public ChartFrame getChartPanel(){ 
    return frame1; 
  } 
public static void t2() throws SQLException {
		//frame1.setBounds(550,330, 450, 300);
		TEST2 A=new TEST2();
		A.getChartPanel().setVisible(true);
	}
} 