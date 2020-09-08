package pkg;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*
;public class addcar extends JFrame {

	private JPanel contentPane;
	private JTextField Sno;
	private JTextField price;
	private JTextField type;
	private JTextField color;
	private JTextField brand;
	private JTextField wrent;
	private JTextField drent;
	private JTextField state;
	private JTextField cN;

	/**
	 * Launch the application.
	 */
	public static void ac(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addcar frame = new addcar();
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
	public addcar() throws SQLException {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		final login_admin a=new login_admin();
		try {
			a.dbConn=login_admin.link(login_admin.n,login_admin.p);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		setBounds(550, 300, 454, 319);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u6C7D\u8F66\u65B0\u589E");
		label.setBounds(166, 10, 54, 15);
		contentPane.add(label);
		
		JLabel lblNewLabel = new JLabel("\u4F9B\u9500\u5546\u7F16\u53F7");
		lblNewLabel.setBounds(75, 41, 79, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u5355\u8F66\u4EF7\u683C");
		lblNewLabel_1.setBounds(75, 66, 54, 15);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u8F66\u578B");
		lblNewLabel_2.setBounds(75, 91, 54, 15);
		contentPane.add(lblNewLabel_2);
		
		JLabel label_1 = new JLabel("\u8F66\u8272");
		label_1.setBounds(75, 116, 54, 15);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("\u54C1\u724C");
		label_2.setBounds(75, 141, 54, 15);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("\u5468\u79DF\u91D1");
		label_3.setBounds(75, 166, 54, 15);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("\u65E5\u79DF\u91D1");
		label_4.setBounds(75, 191, 54, 15);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("\u72B6\u6001");
		label_5.setBounds(75, 216, 54, 15);
		contentPane.add(label_5);
		
		Sno = new JTextField();
		Sno.setBounds(153, 35, 89, 21);
		contentPane.add(Sno);
		Sno.setColumns(10);
		
		price = new JTextField();
		price.setColumns(10);
		price.setBounds(153, 63, 89, 21);
		contentPane.add(price);
		
		type = new JTextField();
		type.setColumns(10);
		type.setBounds(153, 88, 89, 21);
		contentPane.add(type);
		
		color = new JTextField();
		color.setBounds(153, 113, 66, 21);
		contentPane.add(color);
		color.setColumns(10);
		
		brand = new JTextField();
		brand.setBounds(153, 138, 66, 21);
		contentPane.add(brand);
		brand.setColumns(10);
		
		wrent = new JTextField();
		wrent.setBounds(153, 163, 66, 21);
		contentPane.add(wrent);
		wrent.setColumns(10);
		
		drent = new JTextField();
		drent.setBounds(154, 188, 66, 21);
		contentPane.add(drent);
		drent.setColumns(10);
		cN = new JTextField();
		cN.setBounds(326, 35, 66, 21);
		contentPane.add(cN);
		cN.setColumns(10);
		state = new JTextField();
		state.setBounds(153, 216, 66, 21);
		contentPane.add(state);
		state.setColumns(10);
		
		JButton add = new JButton("\u65B0\u589E");
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sql="insert into cars(carNum,CarType,color,brand,week_rental,day_rental,state) values(?,?,?,?,?,?,?)";
				
				try {final PreparedStatement sql1 = a.dbConn.prepareStatement(sql);
				
					sql1.setString(1, cN.getText());
					sql1.setString(2, type.getText());
					sql1.setString(3, color.getText());
					sql1.setString(4, brand.getText());
					sql1.setString(5, wrent.getText());
					sql1.setString(6, drent.getText());
					sql1.setString(7, state.getText());
					int rs= sql1.executeUpdate();
					final PreparedStatement sql2 = a.dbConn.prepareStatement("select CarId from cars where carNum=?");
					sql2.setString(1, cN.getText());
					ResultSet rs2=sql2.executeQuery();
					int carid=0;
					if(rs2.next())
						carid=rs2.getInt("CarId");
					
					final PreparedStatement sql3 = a.dbConn.prepareStatement("insert into SuppliesPrice(SupId,CarId,price)values(?,?,?)");
					sql3.setInt(1, Integer.parseInt(Sno.getText()));
					sql3.setInt(2, carid);
					sql3.setFloat(3, Float.parseFloat(price.getText()));
					int rs3=sql3.executeUpdate();
					JOptionPane.showMessageDialog(null, "增加成功");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		add.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
			}
		});
		add.setBounds(311, 212, 93, 23);
		contentPane.add(add);
		
		JLabel label_6 = new JLabel("\u8F66\u724C\u53F7");
		label_6.setBounds(262, 38, 54, 15);
		contentPane.add(label_6);
		
		
	}

}
