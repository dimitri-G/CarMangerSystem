package pkg;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;

public class srhcar extends JFrame {
	private JTable table;
	int FLAG=0;
	private final JScrollPane scrollPane = new JScrollPane();

	private JTextField way;
	private JTextField key;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void sc(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					srhcar frame = new srhcar();
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
	public srhcar() throws SQLException {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(350, 100, 1166, 759);
				final Main a=new Main();
				a.dbConn=Main.link();
				way = new JTextField();
				way.setBounds(119, 7, 93, 21);
				getContentPane().add(way);
				way.setColumns(10);
				
				JLabel label_1 = new JLabel("\u5173\u952E\u5B57");
				label_1.setFont(new Font("宋体", Font.PLAIN, 20));
				label_1.setBounds(10, 46, 86, 18);
				getContentPane().add(label_1);
				
				JLabel label = new JLabel("\u67E5\u627E\u65B9\u5F0F");
				label.setFont(new Font("宋体", Font.PLAIN, 20));
				label.setBounds(10, 10, 109, 21);
				getContentPane().add(label);
				
				key = new JTextField();
				key.setBounds(119, 43, 93, 21);
				getContentPane().add(key);
				key.setColumns(10);
				final JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(0, 176, 1150, 544);
				getContentPane().add(scrollPane);
				
				table = new JTable();
				scrollPane.setViewportView(table);
				final String[] table1={"用户编号","用户名","密码","性别","年龄","电话","驾照类型","地址","身份证号码"};
				final String[] table2={"车辆编号","车牌号","车型","颜色","品牌","周租","日租","状态"};
				final String[] table3={"订单编号","创建日期","归还日期","费用","用户编号","用户名"};
				final String[] table4={"供销商编号","供销商名","供销商地址"};
				final String[][] raw={};
				final DefaultTableModel model = new DefaultTableModel(raw,table2);
				table.setModel(model);
				scrollPane.setViewportView(table);
				
						
						final JButton find = new JButton("\u67E5\u627E");
						find.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent e) {
								System.out.print("a");
								try {
									/*for(int i=FLAG-2;i>=0;i--)
										model.removeRow(i);
									FLAG=0;*/
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
						}			
									
								} catch (NumberFormatException | SQLException e1) {
								}
							}
						});
						find.setBounds(331, 25, 93, 23);
						getContentPane().add(find);
						
				
						JLabel lblNewLabel = new JLabel("");
						lblNewLabel.setIcon(new ImageIcon("C:\\Users\\hasee\\Desktop\\35352da30436343cee7a37b7ad4b7d0e.jpg"));
						lblNewLabel.setBounds(0, 0, 1150, 720);
						getContentPane().add(lblNewLabel);
					
				
				getContentPane().setLayout(null);
				
}}
