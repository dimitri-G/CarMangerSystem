package pkg;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JRadioButton;
import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
public class rent extends JFrame {

	private JPanel contentPane;
	private JTextField cId;
	private JTextField cNm;
	int orderId=0;
	/**
	 * Launch the application.
	 */
	public static void rent(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					rent frame = new rent();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public rent() throws SQLException {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(550, 200, 500, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		final Main a=new Main();
		a.dbConn=Main.link();
		
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd ");
		Date now=new Date();
		String sql="insert into orders (createDate,UserId) values(?,?)";
		PreparedStatement sql1;
		
		try {
			sql1 = a.dbConn.prepareStatement(sql);
			java.sql.Date now1=new java.sql.Date(now.getTime());
			sql1.setDate(1,  now1);
			sql1.setInt(2, Integer.parseInt(login_user.UserId));
			int rs=sql1.executeUpdate();
			PreparedStatement sql2 = a.dbConn.prepareStatement("select orderId from orders where UserId=?");
			sql2.setInt(1, Integer.parseInt(login_user.UserId));
			ResultSet rs2 =sql2.executeQuery();
			while(rs2.next()){
				orderId=rs2.getInt("orderId");
				System.out.println(orderId);
			}
			System.out.println(orderId);
			
			
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
		
		
		JLabel label = new JLabel("\u521B\u5EFA\u8BA2\u5355");
		label.setFont(new Font("宋体", Font.PLAIN, 20));
		label.setBounds(166, 10, 96, 33);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u8F66\u8F86\u53F7");
		label_1.setBounds(40, 58, 36, 15);
		contentPane.add(label_1);
		
		cId = new JTextField();
		cId.setBounds(166, 55, 139, 21);
		contentPane.add(cId);
		cId.setColumns(10);
		
		cNm = new JTextField();
		cNm.setBounds(166, 101, 139, 21);
		contentPane.add(cNm);
		cNm.setColumns(10);
		
		JLabel label_2 = new JLabel("\u8F66\u724C\u53F7");
		label_2.setBounds(40, 104, 54, 15);
		contentPane.add(label_2);
		
		JPanel panel = new JPanel();
		panel.setBounds(93, 145, 258, 39);
		contentPane.add(panel);
		ButtonGroup group1=new ButtonGroup();
		ButtonGroup group2=new ButtonGroup();
		
		final JRadioButton carid = new JRadioButton("\u4EE5\u8F66\u8F86\u53F7\u521B\u5EFA",true);
		panel.add(carid);
		
		group1.add(carid);
		JRadioButton carnum = new JRadioButton("\u4EE5\u8F66\u724C\u53F7\u521B\u5EFA",false);
		panel.add(carnum);
		group1.add(carnum);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(104, 194, 212, 33);
		contentPane.add(panel_1);
		
		final JRadioButton day = new JRadioButton("\u65E5\u79DF",true);
		panel_1.add(day);
		group2.add(day);
		JRadioButton week = new JRadioButton("\u5468\u79DF",false);
		panel_1.add(week);
		group2.add(week);
		
		
		
		JLabel label_3 = new JLabel("\u521B\u5EFA\u65B9\u5F0F");
		label_3.setBounds(40, 156, 54, 15);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("\u79DF\u501F\u6A21\u5F0F");
		label_4.setBounds(40, 194, 54, 15);
		contentPane.add(label_4);
		
		
		
		JButton button = new JButton("\u63D0\u4EA4\u8BA2\u5355");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(carid.isSelected()){
					if(cId.getText().equals("")){
						JOptionPane.showMessageDialog(null, "车辆号不可为空");
					}
					else{
						try {
							PreparedStatement sql4 = a.dbConn.prepareStatement("select CarId from cars where CarId="+Integer.parseInt(cId.getText())+"and state='空闲'");
							ResultSet rs=sql4.executeQuery();
							if(rs!=null)
							{PreparedStatement sql3 = a.dbConn.prepareStatement("insert into Includes(OrderId, CarId,model)"
									+ "values(?,?,?)");
							sql3.setInt(1, orderId);
							sql3.setInt(2, Integer.parseInt(cId.getText()));
							if(day.isSelected())
								sql3.setString(3,"日租");
							else
								sql3.setString(3,"周租");
							System.out.println("A");
							int rs3=sql3.executeUpdate();}
							else
							{
								JOptionPane.showMessageDialog(null, "无可用车辆");
							}
					
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
					}
				
			}
			else{
				if(cNm.getText().equals("")){
					JOptionPane.showMessageDialog(null, "车辆号不可为空");
				}
				else{
					try {
						
						
						PreparedStatement sql4 = a.dbConn.prepareStatement("select CarId from cars where carNum="+Integer.parseInt(cNm.getText())+"and state='空闲'");
						ResultSet rs=sql4.executeQuery();
						if(rs!=null)
						{PreparedStatement sql3 = a.dbConn.prepareStatement("insert into Includes(orderId, CarId,model)"
								+ "values(?,?,?)");
						sql3.setInt(1, orderId);
						sql3.setString(2, rs.getString("CarId"));
						if(day.isSelected())
							sql3.setString(3,"日租");
						else
							sql3.setString(3,"周租");
						int rs3=sql3.executeUpdate();
						}
						else
						{
							JOptionPane.showMessageDialog(null, "无可用车辆");
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
			}
				JOptionPane.showMessageDialog(null, "订单已提交");
				dispose();
				
			}
		});
		button.setBounds(331, 228, 93, 23);
		contentPane.add(button);
		
		JButton button_1 = new JButton("\u7EE7\u7EED\u6DFB\u52A0\u8F66\u8F86");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("A");
				if(carid.isSelected()){
						if(cId.getText().equals("")){
							JOptionPane.showMessageDialog(null, "车辆号不可为空");
						}
						else{System.out.println("A");
							try {
								PreparedStatement sql4 = a.dbConn.prepareStatement("select CarId from cars where CarId="+Integer.parseInt(cId.getText())+"and state='空闲'");
								ResultSet rs=sql4.executeQuery();
								if(rs!=null)
								{PreparedStatement sql3 = a.dbConn.prepareStatement("insert into Includes(OrderId, CarId,model)"
										+ "values(?,?,?)");
								sql3.setInt(1, orderId);
								sql3.setInt(2, Integer.parseInt(cId.getText()));
								if(day.isSelected())
									sql3.setString(3, "日租");
								else
									sql3.setString(3, "周租");
								int rs3=sql3.executeUpdate();}
								else
								{
									JOptionPane.showMessageDialog(null, "无可用车辆");
								}
						
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							
						}
					
				}
				else{
					if(cNm.getText().equals("")){
						JOptionPane.showMessageDialog(null, "车辆号不可为空");
					}
					else{
						try {
							
							
							PreparedStatement sql4 = a.dbConn.prepareStatement("select CarId from cars where carNum="+Integer.parseInt(cNm.getText())+"and state='空闲'");
							ResultSet rs=sql4.executeQuery();
							if(rs!=null)
							{PreparedStatement sql3 = a.dbConn.prepareStatement("insert into Includes(orderId, CarId,model)"
									+ "values(?,?,?)");
							sql3.setInt(1, orderId);
							sql3.setString(2, rs.getString("CarId"));
							if(day.isSelected())
								sql3.setString(3, "日租");
							else
								sql3.setString(3, "周租");
							int rs3=sql3.executeUpdate();}
							else
							{
								JOptionPane.showMessageDialog(null, "无可用车辆");
							}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
					}
				}
			}
		});
		button_1.setBounds(331, 190, 93, 23); 
		contentPane.add(button_1);
		
		
	}
}
