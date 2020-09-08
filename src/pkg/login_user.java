package pkg;
import java.sql.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;

import java.awt.Font;

import javax.swing.JTextPane;

import java.awt.Color;

import javax.swing.JFormattedTextField;
import javax.swing.JButton;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Statement;

import javax.swing.JLabel;

public class login_user extends JFrame {

	private JPanel contentPane;
	private JButton µÇÂ¼;
	static String UserId;
	private JTextField confirmText;
	ValidCode vcode;
	
	/**
	 * Launch the application.
	 * 
	 */
	public static void login_u(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login_user frame = new login_user();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public boolean isValidCodeRight() {
		System.out.println(vcode.getCode());
		System.out.println(confirmText.getText());
		if (confirmText == null) {
			return false;
		}
		if (vcode == null) {
			return true;
		}
		if (vcode.getCode().equals(confirmText.getText())) {
			return true;
		}
		return false;
	}


	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public login_user() throws SQLException {
		getContentPane().setLayout(null);
		final Main a=new Main();
		a.dbConn=Main.link();
		JButton button = new JButton("New button");
		button.setBounds(60, 97, 93, 23);
		getContentPane().add(button);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(650, 300, 485,301);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JButton ×¢²á = new JButton("\u5FEB\u901F\u6CE8\u518C");
		×¢²á.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				sign_up.sign(null);
			}
		});
	
		confirmText = new JTextField();
		confirmText.setBounds(128, 198, 66, 21);
		contentPane.add(confirmText);
		confirmText.setColumns(10);
		
		vcode=new ValidCode();
		vcode.setBounds(200, 178, 66,21);
		contentPane.add(vcode);
		
		×¢²á.setBounds(331, 10, 93, 23);
		contentPane.add(×¢²á);
		
		final JFormattedTextField userId = new JFormattedTextField();
		userId.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
			}
		});
		userId.setBounds(128, 115, 149, 21);
		contentPane.add(userId);
		
		final JFormattedTextField userPwd = new JFormattedTextField();
		userPwd.setBounds(128, 153, 149, 21);
		contentPane.add(userPwd);
		
		JButton µÇÂ¼ = new JButton("\u767B\u5F55");
		µÇÂ¼.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.print("a");
				String sql="select username,password,sex from Userdetails where UserId =? ";
				PreparedStatement sql1;
				try {
					
					sql1 = a.dbConn.prepareStatement(sql);
					sql1.setInt(1, Integer.parseInt(userId.getText()));
					ResultSet rs=sql1.executeQuery();
					System.out.print(rs);
					if(rs.next()) { //±éÀú½á¹û¼¯
						String password = rs.getString("password");
						if(password.equals(userPwd.getText()) )
						{UserId=userId.getText();
						String userName = rs.getString("username");
						String sex = rs.getString("sex");
						if(isValidCodeRight())
						System.out.print("b");
						if(sex.equals("ÄÐ"))
						{JOptionPane.showMessageDialog(null, "µÇÂ¼³É¹¦"+userName+"ÏÈÉú");
						usermodel.um(null);
						}
						else
							{JOptionPane.showMessageDialog(null, "µÇÂ¼³É¹¦"+userName+"Å®Éú");
							usermodel.um(null);
							}
						}
						
						else{
							JOptionPane.showMessageDialog(null, "µÇÂ¼Ê§°Ü");
							}
						
						}
						
						
					else{
						System.out.println("error");
						}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		        
				
			}
		});
		
		
		
		µÇÂ¼.setBounds(151, 229, 93, 23);
		contentPane.add(µÇÂ¼);
		
		
		
		JLabel label = new JLabel("\u8BF7\u8F93\u5165\u60A8\u7684\u8D26\u53F7\u4E0E\u5BC6\u7801");
		label.setFont(new Font("ËÎÌå", Font.PLAIN, 18));
		label.setBounds(113, 69, 198, 36);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u7528\u6237\uFF1A");
		label_1.setBounds(82, 118, 36, 15);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("\u5BC6\u7801\uFF1A");
		label_2.setBounds(82, 156, 54, 15);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("\u9A8C\u8BC1\u7801\uFF1A");
		label_3.setBounds(82, 197, 54, 15);
		contentPane.add(label_3);

	}
}
