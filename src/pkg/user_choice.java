package pkg;
import java.sql.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.WindowConstants;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.util.Date;;
public class user_choice extends JFrame {
	int FLAG;
	private JPanel contentPane;
	private JTable table;
	private JTextField Ono;

	/**
	 * Launch the application.
	 */
	public static void rt(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					user_choice frame = new user_choice();
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
	public user_choice() throws SQLException {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(550, 200, 714, 540);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		final Main a=new Main();
		a.dbConn=Main.link();
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 76, 691, 422);
		contentPane.add(scrollPane);
		
		table = new JTable();
		
		final String[] table3={"订单编号","创建日期","归还日期","费用","用户编号","用户名"};
		final String[][] raw={};
		final DefaultTableModel model = new DefaultTableModel(raw,table3);
		table.setModel(model);
		scrollPane.setViewportView(table);
		
		table.getColumnModel().getColumn(0).setPreferredWidth(64);
		table.getColumnModel().getColumn(1).setPreferredWidth(64);
		scrollPane.setViewportView(table);
		
		JLabel label = new JLabel("\u60A8\u7684\u672A\u5B8C\u6210\u8BA2\u5355\u5982\u4E0B");
		label.setBounds(10, 51, 130, 15);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u8BF7\u60A8\u5C06\u8981\u5B8C\u6210\u7684\u8BA2\u5355\u53F7\u63D0\u4EA4");
		label_1.setBounds(123, 10, 154, 15);
		contentPane.add(label_1);
		
		Ono = new JTextField();
		Ono.setBounds(287, 7, 41, 21);
		contentPane.add(Ono);
		Ono.setColumns(10);
		
		for(int i=FLAG-2;i>=0;i--)
			model.removeRow(i);
			FLAG=0;
			String sql="select orders.*,Userdetails.username from orders , Userdetails where orders.UserId =? and Userdetails.UserId=?  and cost is null ";
			final PreparedStatement sql1 = a.dbConn.prepareStatement(sql);
			sql1.setInt(1,Integer.parseInt(login_user.UserId));
			sql1.setInt(2,Integer.parseInt(login_user.UserId));
			ResultSet rs=sql1.executeQuery();
			//for()
			while(rs.next()){
				String UserId=rs.getString("orderId");
				String username=rs.getString("createDate");
				String password=rs.getString("returnDate");
				String sex=rs.getString("cost");
				String age=rs.getString("UserId");
				String age2=rs.getString("username");
				String[] user={UserId,username,password,sex,age,age2};
				model.addRow(user);
				FLAG++;
			}
		JButton button = new JButton("\u63D0\u4EA4");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.print("a");
				try {String sql2="update orders set returnDate =? where orderId=? and cost is null";
					PreparedStatement sql3 = a.dbConn.prepareStatement(sql2);
					Date now=new Date();
					java.sql.Date now1=new java.sql.Date(now.getTime());
					sql3.setDate(1,now1);
					sql3.setInt(2,Integer.parseInt(Ono.getText()));
					int rs0=sql3.executeUpdate();
					if(rs0==0)
						JOptionPane.showMessageDialog(null, "未找到订单");
						
						
					System.out.print("b");
					
					
					sql2="select orders.*,Includes.model,cars.week_rental,cars.day_rental,convert(int,datediff(day,createDate,returnDate) )as diff from orders ,cars, Includes where orders.orderId =? and Includes.OrderId=orders.orderId and Includes.CarId=cars.CarId and cost is null";
					sql3 = a.dbConn.prepareStatement(sql2);
					sql3.setString(1,Ono.getText());
					float cost=0;
					int time=0;
					float cost2=0;
					ResultSet rs3=sql3.executeQuery();
					if(rs3.next()){
						time=rs3.getInt("diff");
						System.out.print(time);
						System.out.print(rs3.getString("model"));
						if(rs3.getInt("diff")==0)
							time++;
						if(rs3.getString("model").equals("日租"))
							{cost2+=rs3.getFloat("day_rental")*time;
							System.out.print(rs3.getInt("diff"));}
						else if(rs3.getString("model").equals("周租"))
						{	System.out.print(rs3.getInt("diff"));
							if(rs3.getInt("diff")<=7)
								cost2+=rs3.getFloat("week_rental");
							else
								cost2+=rs3.getFloat("week_rental")+rs3.getFloat("day_rental")*(time-7);
						}
						time=0;
					}
					System.out.print("c");
					sql2="update orders set cost =? where orderId=? and cost is null";
					sql3 = a.dbConn.prepareStatement(sql2);
					
					sql3.setFloat(1,cost2);
					sql3.setInt(2,Integer.parseInt(Ono.getText()));
					int rs4=sql3.executeUpdate();
					
					if(rs4>0)
						JOptionPane.showMessageDialog(null, "归还成功");
					
					System.out.print("d");
					for(int i=FLAG-2;i>=0;i--)
					model.removeRow(i);
					FLAG=0;
					String sql="select orders.*,Userdetails.username from orders , Userdetails where orders.UserId =? and Userdetails.UserId=?and cost is null ";
					final PreparedStatement sql1 = a.dbConn.prepareStatement(sql);
					sql1.setInt(1,Integer.parseInt(login_user.UserId));
					sql1.setInt(2,Integer.parseInt(login_user.UserId));
					ResultSet rs=sql1.executeQuery();
					//for()
					while(rs.next()){
						String UserId=rs.getString("orderId");
						String username=rs.getString("createDate");
						String password=rs.getString("returnDate");
						String sex=rs.getString("cost");
						String age=rs.getString("UserId");
						String age2=rs.getString("username");
						String[] user={UserId,username,password,sex,age,age2};
						model.addRow(user);
						FLAG++;
		}			
				} catch (NumberFormatException | SQLException e1) {
				}
			}
		});
		button.setBounds(338, 6, 66, 23);
		contentPane.add(button);
		//frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
	
}
			}
