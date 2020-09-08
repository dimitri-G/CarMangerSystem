package pkg;

import java.awt.Font; 
import java.sql.*;

import org.jfree.chart.ChartFactory; 
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel; 
import org.jfree.chart.JFreeChart; 
import org.jfree.chart.axis.CategoryAxis; 
import org.jfree.chart.axis.ValueAxis; 
import org.jfree.chart.plot.CategoryPlot; 
import org.jfree.chart.plot.PlotOrientation; 
import org.jfree.data.category.CategoryDataset; 
import org.jfree.data.category.DefaultCategoryDataset; 
public class TEST1 { 
  static ChartFrame frame1; 
  public TEST1() throws SQLException{ 
    CategoryDataset dataset = getDataSet(); 
    JFreeChart chart = ChartFactory.createBarChart3D( 
               "车辆租借情况", // 图表标题 
              "车号种类", // 目录轴的显示标签 
              "数量", // 数值轴的显示标签 
              dataset, // 数据集 
              PlotOrientation.VERTICAL, // 图表方向：水平、垂直 
              true,      // 是否显示图例(对于简单的柱状图必须是false) 
              false,     // 是否生成工具 
              false      // 是否生成URL链接 
              ); 
    //从这里开始 
    CategoryPlot plot=chart.getCategoryPlot();//获取图表区域对象 
    CategoryAxis domainAxis=plot.getDomainAxis();     //水平底部列表 
     domainAxis.setLabelFont(new Font("黑体",Font.BOLD,14));     //水平底部标题 
     domainAxis.setTickLabelFont(new Font("宋体",Font.BOLD,12)); //垂直标题 
     ValueAxis rangeAxis=plot.getRangeAxis();//获取柱状 
     rangeAxis.setLabelFont(new Font("黑体",Font.BOLD,15)); 
     chart.getLegend().setItemFont(new Font("黑体", Font.BOLD, 15)); 
     chart.getTitle().setFont(new Font("宋体",Font.BOLD,20));//设置标题字体 
     //到这里结束，虽然代码有点多，但只为一个目的，解决汉字乱码问题 
     frame1=new ChartFrame(null, chart,true); 
     frame1.pack();//这里也可以用chartFrame,可以直接生成一个独立的Frame 
  } 
    private static CategoryDataset getDataSet() throws SQLException { 
    	final Main a=new Main();
		a.dbConn=Main.link();
		int carId=4;
		int all=2;
		int i=0;
		DefaultCategoryDataset dataset = new DefaultCategoryDataset(); 
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
			dataset.addValue(cou, String.valueOf(carId+i), "车号"); 
			i++;
		}
		
		
      
     
      return dataset; 
} 
public ChartFrame getChartPanel(){ 
  return frame1; 
} 
public static void t1() throws SQLException {
	//frame1.setBounds(550,330, 450, 300);
	TEST1 A=new TEST1();
	A.getChartPanel().setVisible(true);
}

} 