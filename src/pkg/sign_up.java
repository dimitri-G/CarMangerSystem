package pkg;
import java.sql.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class sign_up extends JFrame {

	private JPanel contentPane;
	private JTextField username;
	private JTextField age;
	private JTextField sex;
	private JTextField phone;
	private JTextField driverType;
	private JTextField driverId;
	private JTextField address;
	private JTextField IDnumber;
	private JTextField pwd1;
	private JTextField pwd2;

	/**
	 * Launch the application.
	 */
	public static void sign(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					sign_up frame = new sign_up();
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
	public sign_up() throws SQLException {
		final Main a=new Main();
		a.dbConn=Main.link();
		
		
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(550, 300, 495, 338);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u7528\u6237\u6CE8\u518C");
		label.setForeground(Color.MAGENTA);
		label.setFont(new Font("楷体", Font.PLAIN, 20));
		label.setBounds(170, 0, 92, 25);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u59D3\u540D                  *");
		label_1.setBounds(10, 38, 182, 15);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("\u5E74\u9F84                  ");
		label_2.setBounds(10, 63, 155, 15);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("\u6027\u522B                  *");
		label_3.setBounds(10, 88, 140, 15);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("\u7535\u8BDD\u53F7\u7801                       *");
		label_4.setBounds(10, 113, 194, 15);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("\u9A7E\u7167\u7C7B\u578B              *");
		label_5.setBounds(10, 138, 155, 15);
		contentPane.add(label_5);
		
		JLabel label_6 = new JLabel("\u9A7E\u7167\u53F7\u7801                       *");
		label_6.setBounds(10, 163, 194, 15);
		contentPane.add(label_6);
		
		JLabel label_7 = new JLabel("\u5BB6\u5EAD\u5730\u5740                       *");
		label_7.setBounds(10, 188, 205, 15);
		contentPane.add(label_7);
		
		JLabel label_8 = new JLabel("\u8EAB\u4EFD\u8BC1\u53F7                       *");
		label_8.setBounds(10, 213, 194, 15);
		contentPane.add(label_8);
		
		username = new JTextField();
		username.setBounds(70, 35, 66, 21);
		contentPane.add(username);
		username.setColumns(10);
		
		age = new JTextField();
		age.setBounds(70, 60, 66, 21);
		contentPane.add(age);
		age.setColumns(10);
		
		sex = new JTextField();
		sex.setBounds(70, 85, 66, 21);
		contentPane.add(sex);
		sex.setColumns(10);
		
		phone = new JTextField();
		phone.setBounds(70, 110, 122, 21);
		contentPane.add(phone);
		phone.setColumns(10);
		
		driverType = new JTextField();
		driverType.setBounds(70, 135, 66, 21);
		contentPane.add(driverType);
		driverType.setColumns(10);
		
		driverId = new JTextField();
		driverId.setBounds(70, 160, 122, 21);
		contentPane.add(driverId);
		driverId.setColumns(10);
		
		address = new JTextField();
		address.setBounds(70, 188, 122, 21);
		contentPane.add(address);
		address.setColumns(10);
		
		IDnumber = new JTextField();
		IDnumber.setBounds(70, 210, 122, 21);
		contentPane.add(IDnumber);
		IDnumber.setColumns(10);
		
		JLabel label_9 = new JLabel("\u7528\u6237\u5BC6\u7801                 *");
		label_9.setBounds(245, 38, 179, 15);
		contentPane.add(label_9);
		
		pwd1 = new JTextField();
		pwd1.setBounds(298, 35, 92, 21);
		contentPane.add(pwd1);
		pwd1.setColumns(10);
		
		JLabel label_10 = new JLabel("\u786E\u8BA4\u5BC6\u7801                 *");
		label_10.setBounds(245, 63, 179, 15);
		contentPane.add(label_10);
		
		pwd2 = new JTextField();
		pwd2.setBounds(298, 60, 92, 21);
		contentPane.add(pwd2);
		pwd2.setColumns(10);
		
		JButton button = new JButton("\u8FDB\u884C\u6CE8\u518C");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.print("a");
				if(pwd1.getText().equals(pwd2.getText())){
					if(!username.getText().equals("") && !pwd1.getText().equals("")&& !sex.getText().equals("") && !age.getText().equals("") && 
							!phone.getText().equals("")&&!driverType.getText().equals("")&&!driverId.getText().equals("")
							&&!address.getText().equals("")&&!IDnumber.getText().equals("") )
							
					{	
						String sql="insert into Userdetails(username,password,sex,age,phone,driverType,driverId,address,IDnumber) "
								+ "values(?,?,?,?,?,?,?,?,?) ";
						
						try {
							PreparedStatement sql1 = a.dbConn.prepareStatement(sql);
							sql1.setString(1, username.getText());
							sql1.setString(2,pwd1.getText());
							sql1.setString(3,sex.getText());
							sql1.setString(4,age.getText());
							sql1.setString(5,phone.getText());
							sql1.setString(6,driverType.getText());
							sql1.setString(7,driverId.getText());
							sql1.setString(8,address.getText());
							sql1.setString(9,IDnumber.getText());
							int rs=sql1.executeUpdate();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						int id=1;
						try {
							PreparedStatement sql2=a.dbConn.prepareStatement("select UserId from Userdetails where username=?");
							sql2.setString(1, username.getText());
							ResultSet rs=sql2.executeQuery();
							
							if(rs.next()){
							id=rs.getInt("UserId");
							}
							}
						 catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
				
						JOptionPane.showMessageDialog(null, "创建成功，您的账户是"+id+"请妥善保管");
						login_user.login_u(null);
					}
					else{
						JOptionPane.showMessageDialog(null, "创建失败，有必填项未填");
					}
				}
				else{
					JOptionPane.showMessageDialog(null, "创建失败，密码不一致");
				}
			}

			private void showMessageDialog(Object object, String string) {
				// TODO Auto-generated method stub
				
			}
		});
		button.setBounds(298, 209, 93, 23);
		contentPane.add(button);
		
		JButton button_1 = new JButton("\u5DF2\u6709\u8D26\u53F7\uFF1F");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				login_user.login_u(null);
			}
		});
		button_1.setBounds(297, 163, 93, 23);
		contentPane.add(button_1);
	}
}
