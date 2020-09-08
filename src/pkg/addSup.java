package pkg;
import java.sql.*;
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

public class addSup extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField ad;

	/**
	 * Launch the application.
	 */
	public static void as(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addSup frame = new addSup();
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
	public addSup() throws SQLException {
		final login_admin a=new login_admin();
		try {
			a.dbConn=login_admin.link(login_admin.n,login_admin.p);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(550, 300, 466, 296);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u4F9B\u9500\u5546\u589E\u52A0");
		label.setBounds(182, 30, 99, 15);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u4F9B\u9500\u5546\u540D\u79F0");
		label_1.setBounds(86, 59, 84, 15);
		contentPane.add(label_1);
		
		name = new JTextField();
		name.setBounds(180, 56, 66, 21);
		contentPane.add(name);
		name.setColumns(10);
		
		JLabel label_2 = new JLabel("\u4F9B\u9500\u5546\u5730\u5740");
		label_2.setBounds(86, 84, 84, 15);
		contentPane.add(label_2);
		
		ad = new JTextField();
		ad.setBounds(182, 87, 66, 21);
		contentPane.add(ad);
		ad.setColumns(10);
		
		JButton add = new JButton("\u589E\u52A0");
		add.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String sql="insert into Suppliers(SupName,SupAddress) values(?,?)";
				
					try {final PreparedStatement sql1 = a.dbConn.prepareStatement(sql);
						sql1.setString(1, name.getText());
						sql1.setString(2, ad.getText());
						int rs= sql1.executeUpdate();
						if(rs==1)
							JOptionPane.showMessageDialog(null, "增加成功");
						else
							JOptionPane.showMessageDialog(null, "增加失败");
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			}
		});
		add.setBounds(289, 204, 93, 23);
		contentPane.add(add);
	}
}
