package pkg;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class login_admin extends JFrame {
	
	private JPanel contentPane;
	private JTextField n_1;
	private JTextField p_1;

	static String n=null;
	static String p=null;
	
	public Connection dbConn;
	public static Connection link(String n,String p) throws SQLException{
		 String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
		  String dbURL="jdbc:sqlserver://localhost:1433;DatabaseName=汽车租赁管理系统";//这里是写你的数据库名字。上面是新建立了Test，所以填Test
		  String userName=n;//这里是写你的登陆数据库的名，安装完默认是sa
		  String userPwd=p;//这里是写你的登陆数据库的密码，我设定的比较简单
		  login_admin a=new login_admin();
		  a.dbConn=DriverManager.getConnection(dbURL,userName,userPwd);
	        System.out.println("连接数据库成功！");
	        return a.dbConn;
	}
	
	/**
	 * Launch the application.
	 */
	public static void la(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login_admin frame = new login_admin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public login_admin() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(550, 300, 455, 281);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u7BA1\u7406\u5458\u767B\u5F55");
		label.setBounds(160, 24, 137, 36);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u7BA1\u7406\u5458\u8D26\u6237");
		label_1.setBounds(70, 82, 90, 15);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("\u5BC6\u7801");
		label_2.setBounds(70, 132, 54, 15);
		contentPane.add(label_2);
		
		n_1 = new JTextField();
		n_1.setBounds(160, 79, 112, 21);
		contentPane.add(n_1);
		n_1.setColumns(10);
		
		p_1 = new JTextField();
		p_1.setBounds(160, 129, 112, 21);
		contentPane.add(p_1);
		p_1.setColumns(10);
		
		JButton button = new JButton("\u767B\u5F55");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				login_admin a=new login_admin();
				try {
					n=n_1.getText();
					p=p_1.getText();
					a.dbConn=link(n,p);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				adminmodel.am(null);
		}});
		button.setBounds(168, 190, 93, 23);
		contentPane.add(button);
		}

}
