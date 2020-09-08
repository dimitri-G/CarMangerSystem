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

public class delete extends JFrame {

	private JPanel contentPane;
	private JTextField id;

	/**
	 * Launch the application.
	 */
	public static void de(final int i) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					delete frame = new delete(i);
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
	public delete(int i) throws SQLException {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(550, 300, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblid = new JLabel("\u5220\u9664id");
		lblid.setBounds(100, 89, 54, 15);
		contentPane.add(lblid);
		final login_admin a=new login_admin();
		try {
			a.dbConn=login_admin.link(login_admin.n,login_admin.p);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		id = new JTextField();
		id.setBounds(164, 86, 66, 21);
		contentPane.add(id);
		id.setColumns(10);
		String table=null;
		String type=null;
		switch(i){
		case 1: table="Userdetails" ; type="UserId";break;
		case 2: table="cars" ;type="CarId";break;
		case 3: table="orders" ;type="orderId";break;
		case 4: table="Suppliers" ;type="SupId";break;
		}
		
		final String sql="delete from "+table +" where "+type+ " =? ";
		
		
		
		JButton button = new JButton("\u5220\u9664");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					
					
					final PreparedStatement sql1 = a.dbConn.prepareStatement(sql);
					sql1.setInt(1, Integer.parseInt(id.getText()));
					int rs=sql1.executeUpdate();
					if(rs==1)
						JOptionPane.showMessageDialog(null, "成功删除");
					else
						JOptionPane.showMessageDialog(null, "未找到对应id");
				} catch (NumberFormatException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		button.setBounds(256, 217, 93, 23);
		contentPane.add(button);
	}
}
