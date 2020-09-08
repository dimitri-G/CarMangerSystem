package pkg;
import java.sql.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JMenuItem;
import javax.swing.event.MenuDragMouseListener;
import javax.swing.event.MenuDragMouseEvent;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JDesktopPane;

import java.awt.Color;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Font;

public class adminmodel extends JFrame {
	private JTable table;
	int FLAG=0;
	private final JScrollPane scrollPane = new JScrollPane();
	JLabel lblNewLabel;
	private JTextField way;
	private JTextField key;
	/**
	 * Launch the application.
	 */
	public static void am(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					adminmodel frame = new adminmodel();
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
	public adminmodel() throws SQLException {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(350, 100, 1166, 759);
		final login_admin a=new login_admin();
		try {
			a.dbConn=login_admin.link(login_admin.n,login_admin.p);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		way = new JTextField();
		way.setBounds(121, 9, 125, 21);
		getContentPane().add(way);
		way.setColumns(10);
		
		JLabel label_1 = new JLabel("\u5173\u952E\u5B57");
		label_1.setFont(new Font("宋体", Font.PLAIN, 20));
		label_1.setBounds(10, 60, 85, 24);
		getContentPane().add(label_1);
		
		JLabel label = new JLabel("\u67E5\u627E\u65B9\u5F0F");
		label.setFont(new Font("宋体", Font.PLAIN, 20));
		label.setBounds(10, 9, 125, 21);
		getContentPane().add(label);
		
		key = new JTextField();
		key.setBounds(121, 64, 125, 21);
		getContentPane().add(key);
		key.setColumns(10);
		final JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 225, 1150, 474);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		final String[] table1={"用户编号","用户名","密码","性别","年龄","电话","驾照类型","地址","身份证号码"};
		final String[] table2={"车辆编号","车牌号","车型","颜色","品牌","周租","日租","状态"};
		final String[] table3={"订单编号","创建日期","归还日期","费用","用户编号","用户名"};
		final String[] table4={"供销商编号","供销商名","供销商地址"};
		final String[][] raw={};
		DefaultTableModel model = new DefaultTableModel(raw,table1);
		table.setModel(model);
		scrollPane.setViewportView(table);
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menu = new JMenu("\u7BA1\u7406\u7528\u6237\u4FE1\u606F");
		menuBar.add(menu);
		
		JMenuItem menuItem = new JMenuItem("\u589E\u52A0\u7528\u6237\u4FE1\u606F");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.print("a");
				sign_up.sign(null);
			}
		});
		
		menu.add(menuItem);
		
		JMenuItem menuItem_1 = new JMenuItem("\u5220\u9664\u7528\u6237\u4FE1\u606F");
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delete.de(1);
			}
		});
		menu.add(menuItem_1);
		
		JMenuItem menuItem_2 = new JMenuItem("\u67E5\u8BE2\u7528\u6237\u4FE1\u606F");
		menuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				final DefaultTableModel model = new DefaultTableModel(raw,table1);
				table.setModel(model);
				scrollPane.setViewportView(table);
				getContentPane().remove(lblNewLabel);
				final JButton find = new JButton("\u67E5\u627E");
				find.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						System.out.print("a");
						try {
							/*for(int i=FLAG-2;i>=0;i--)
								model.removeRow(i);
							FLAG=0;*/
							System.out.print(FLAG);
							String IdType=way.getText();
							String sql="select * from Userdetails where "+IdType+" =? ";
							final PreparedStatement sql1 = a.dbConn.prepareStatement(sql);
							if(way.getText().equals("UserId"))
								sql1.setInt(1, Integer.parseInt(key.getText()));
							else
								sql1.setString(1, key.getText());
							ResultSet rs=sql1.executeQuery();
							//for()
							while(rs.next()){
								String UserId=rs.getString("UserId");
								String username=rs.getString("username");
								String password=rs.getString("password");
								String sex=rs.getString("sex");
								String age=rs.getString("age");
								String phone=rs.getString("phone");
								String driverType=rs.getString("driverType");
								String IDnumber=rs.getString("IDnumber");
								String[] user={UserId,username,password,sex,age,phone,driverType,IDnumber};
								model.addRow(user);
								FLAG++;
				}			
							getContentPane().remove(find);
						} catch (NumberFormatException | SQLException e1) {
						}
					}
				});
				find.setBounds(331, 47, 93, 23);
				getContentPane().add(find);
				lblNewLabel.setIcon(new ImageIcon("C:\\Users\\hasee\\Desktop\\35352da30436343cee7a37b7ad4b7d0e.jpg"));
				lblNewLabel.setBounds(0, 0, 1150, 720);
				getContentPane().add(lblNewLabel);
				
			}
			
			});
		
		menu.add(menuItem_2);
		
		JMenuItem menuItem_3 = new JMenuItem("\u4FEE\u6539\u7528\u6237\u4FE1\u606F");
		menuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			update.ud(1);
			}
		});
		menu.add(menuItem_3);
		
		JMenu menu_1 = new JMenu("\u7BA1\u7406\u8F66\u8F86\u4FE1\u606F");
		menuBar.add(menu_1);
		
		JMenuItem menuItem_4 = new JMenuItem("\u589E\u52A0\u8F66\u8F86\u4FE1\u606F");
		menuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addcar.ac(null);
			}
		});
		menu_1.add(menuItem_4);
		
		JMenuItem menuItem_5 = new JMenuItem("\u5220\u9664\u8F66\u8F86\u4FE1\u606F");
		menuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delete.de(2);
			}
		});
		menu_1.add(menuItem_5);
		
		JMenuItem menuItem_6 = new JMenuItem("\u67E5\u8BE2\u8F66\u8F86\u4FE1\u606F");
		menuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				final DefaultTableModel model = new DefaultTableModel(raw,table2);
				table.setModel(model);
				scrollPane.setViewportView(table);
				getContentPane().remove(lblNewLabel);
				final JButton find2 = new JButton("\u67E5\u627E");
				find2.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						System.out.print("a");
						try {
							getContentPane().remove(lblNewLabel);
							FLAG=0;
							System.out.print(FLAG);
							String IdType=way.getText();
							String sql="select * from cars where "+IdType+" =? ";
							final PreparedStatement sql1 = a.dbConn.prepareStatement(sql);
							if(way.getText().equals("CarId"))
								sql1.setInt(1, Integer.parseInt(key.getText()));
							else
								sql1.setString(1, key.getText());
							ResultSet rs=sql1.executeQuery();
							//for()
							while(rs.next()){
								String UserId=rs.getString("CarId");
								String username=rs.getString("carNum");
								String password=rs.getString("CarType");
								String sex=rs.getString("color");
								String age=rs.getString("brand");
								String phone=rs.getString("week_rental");
								String driverType=rs.getString("day_rental");
								String IDnumber=rs.getString("state");
								String[] user={UserId,username,password,sex,age,phone,driverType,IDnumber};
								model.addRow(user);
								FLAG++;
				}			getContentPane().remove(find2);
						} catch (NumberFormatException | SQLException e1) {
						}
					}
				});
				find2.setBounds(331, 47, 93, 23);
				getContentPane().add(find2);
				lblNewLabel.setIcon(new ImageIcon("C:\\Users\\hasee\\Desktop\\35352da30436343cee7a37b7ad4b7d0e.jpg"));
				lblNewLabel.setBounds(0, 0, 1150, 720);
				getContentPane().add(lblNewLabel);
			}
		});
		menu_1.add(menuItem_6);
		
		JMenuItem menuItem_7 = new JMenuItem("\u4FEE\u6539\u8F66\u8F86\u4FE1\u606F");
		menuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				update.ud(3);
			}
		});
		menu_1.add(menuItem_7);
		
		JMenu menu_2 = new JMenu("\u7BA1\u7406\u8BA2\u5355\u4FE1\u606F");
		menuBar.add(menu_2);
		
		JMenuItem menuItem_8 = new JMenuItem("\u589E\u52A0\u8BA2\u5355\u4FE1\u606F");
		menu_2.add(menuItem_8);
		
		JMenuItem menuItem_9 = new JMenuItem("\u5220\u9664\u8BA2\u5355\u4FE1\u606F");
		menuItem_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delete.de(3);
			}
		});
		menu_2.add(menuItem_9);
		
		JMenuItem menuItem_10 = new JMenuItem("\u67E5\u8BE2\u8BA2\u5355\u4FE1\u606F");
		menuItem_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				final DefaultTableModel model = new DefaultTableModel(raw,table3);
				table.setModel(model);
				scrollPane.setViewportView(table);
				getContentPane().remove(lblNewLabel);
				final JButton find3 = new JButton("\u67E5\u627E");
				find3.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						System.out.print("a");
						try {
							
							FLAG=0;
							System.out.print(FLAG);
							String IdType=way.getText();
							String sql="select * from orders where "+IdType+" =? ";
							final PreparedStatement sql1 = a.dbConn.prepareStatement(sql);
							if(way.getText().equals("orderId"))
								sql1.setInt(1, Integer.parseInt(key.getText()));
							else
								sql1.setString(1, key.getText());
							ResultSet rs=sql1.executeQuery();
							//for()
							while(rs.next()){
								String UserId=rs.getString("orderId");
								String username=rs.getString("createDate");
								String password=rs.getString("returnDate");
								String sex=rs.getString("cost");
								String age=rs.getString("UserId");
								
								String[] user={UserId,username,password,sex,age};
								model.addRow(user);
								FLAG++;
				}			getContentPane().remove(find3);
						} catch (NumberFormatException | SQLException e1) {
						}
					}
				});
				find3.setBounds(331, 47, 93, 23);
				getContentPane().add(find3);
				lblNewLabel.setIcon(new ImageIcon("C:\\Users\\hasee\\Desktop\\35352da30436343cee7a37b7ad4b7d0e.jpg"));
				lblNewLabel.setBounds(0, 0, 1150, 720);
				getContentPane().add(lblNewLabel);
			}
		});
		menu_2.add(menuItem_10);
		
		JMenuItem menuItem_11 = new JMenuItem("\u4FEE\u6539\u8BA2\u5355\u4FE1\u606F");
		menuItem_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				update.ud(2);
			}
		});
		menu_2.add(menuItem_11);
		
		JMenu menu_3 = new JMenu("\u7BA1\u7406\u4F9B\u9500\u5546\u4FE1\u606F");
		menuBar.add(menu_3);
		
		JMenuItem menuItem_12 = new JMenuItem("\u589E\u52A0\u4F9B\u9500\u5546\u4FE1\u606F");
		menuItem_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addSup.as(null);
			}
		});
		menu_3.add(menuItem_12);
		
		JMenuItem menuItem_13 = new JMenuItem("\u5220\u9664\u4F9B\u9500\u5546\u4FE1\u606F");
		menuItem_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delete.de(4);
			}
		});
		menu_3.add(menuItem_13);
		
		JMenuItem menuItem_14 = new JMenuItem("\u67E5\u8BE2\u4F9B\u9500\u5546\u4FE1\u606F");
		menuItem_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				final DefaultTableModel model = new DefaultTableModel(raw,table4);
				table.setModel(model);
				scrollPane.setViewportView(table);
				getContentPane().remove(lblNewLabel);
				final JButton find4 = new JButton("\u67E5\u627E");
				find4.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						System.out.print("a");
						try {
							
							System.out.print(FLAG);
							String IdType=way.getText();
							String sql="select * from Suppliers where "+IdType+" =? ";
							final PreparedStatement sql1 = a.dbConn.prepareStatement(sql);
							if(way.getText().equals("SupId"))
								sql1.setInt(1, Integer.parseInt(key.getText()));
							else
								sql1.setString(1, key.getText());
							ResultSet rs=sql1.executeQuery();
							//for()
							while(rs.next()){
								String UserId=rs.getString("SupId");
								String username=rs.getString("SupName");
								String password=rs.getString("SupAddress");
								String[] user={UserId,username,password};
								model.addRow(user);
								FLAG++;
				}			getContentPane().remove(find4);
						} catch (NumberFormatException | SQLException e1) {
						}
					}
				});
				find4.setBounds(331, 47, 93, 23);
				getContentPane().add(find4);
				lblNewLabel.setIcon(new ImageIcon("C:\\Users\\hasee\\Desktop\\35352da30436343cee7a37b7ad4b7d0e.jpg"));
				lblNewLabel.setBounds(0, 0, 1150, 720);
				getContentPane().add(lblNewLabel);
			}
		});
		menu_3.add(menuItem_14);
		
		JMenuItem menuItem_15 = new JMenuItem("\u66F4\u6539\u4F9B\u9500\u5546\u4FE1\u606F");
		menuItem_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				update.ud(4);
			}
		});
		menu_3.add(menuItem_15);
		getContentPane().setLayout(null);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\hasee\\Desktop\\35352da30436343cee7a37b7ad4b7d0e.jpg"));
		lblNewLabel.setBounds(0, 0, 1150, 720);
		getContentPane().add(lblNewLabel);
		
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
	}
}
