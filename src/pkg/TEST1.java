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
               "����������", // ͼ����� 
              "��������", // Ŀ¼�����ʾ��ǩ 
              "����", // ��ֵ�����ʾ��ǩ 
              dataset, // ���ݼ� 
              PlotOrientation.VERTICAL, // ͼ����ˮƽ����ֱ 
              true,      // �Ƿ���ʾͼ��(���ڼ򵥵���״ͼ������false) 
              false,     // �Ƿ����ɹ��� 
              false      // �Ƿ�����URL���� 
              ); 
    //�����￪ʼ 
    CategoryPlot plot=chart.getCategoryPlot();//��ȡͼ��������� 
    CategoryAxis domainAxis=plot.getDomainAxis();     //ˮƽ�ײ��б� 
     domainAxis.setLabelFont(new Font("����",Font.BOLD,14));     //ˮƽ�ײ����� 
     domainAxis.setTickLabelFont(new Font("����",Font.BOLD,12)); //��ֱ���� 
     ValueAxis rangeAxis=plot.getRangeAxis();//��ȡ��״ 
     rangeAxis.setLabelFont(new Font("����",Font.BOLD,15)); 
     chart.getLegend().setItemFont(new Font("����", Font.BOLD, 15)); 
     chart.getTitle().setFont(new Font("����",Font.BOLD,20));//���ñ������� 
     //�������������Ȼ�����е�࣬��ֻΪһ��Ŀ�ģ���������������� 
     frame1=new ChartFrame(null, chart,true); 
     frame1.pack();//����Ҳ������chartFrame,����ֱ������һ��������Frame 
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
			dataset.addValue(cou, String.valueOf(carId+i), "����"); 
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