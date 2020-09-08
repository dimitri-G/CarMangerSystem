package pkg;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class update extends JFrame {

	private JPanel contentPane;
	private JTextField id;
	private JTextField col;
	private JTextField value;
	 String table = null;
	 String IdType=null;
	/**
	 * Launch the application.
	 */
	public static void ud(final int i) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					update frame = new update(i);
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
	public update(int i) throws SQLException {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(550, 300, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblid = new JLabel("\u66F4\u65B0id");
		lblid.setBounds(110, 47, 54, 15);
		contentPane.add(lblid);
		
		JLabel label = new JLabel("\u66F4\u65B0\u5217\u540D");
		label.setBounds(110, 83, 54, 15);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u66F4\u65B0\u4E3A");
		label_1.setBounds(110, 121, 54, 15);
		contentPane.add(label_1);
		
		
		switch(i){
		case 1: table="Userdetails" ; IdType="UserId"; break;
		case 2: table="orders" ;IdType="orderId";break;
		case 3: table="cars" ;IdType="CarId";break;
		case 4: table="Suppliers" ;IdType="SupId";break;
		}
		
		final login_admin a=new login_admin();
		try {
			a.dbConn=login_admin.link(login_admin.n,login_admin.p);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
		id = new JTextField();
		id.setBounds(214, 44, 66, 21);
		contentPane.add(id);
		id.setColumns(10);
		
		col = new JTextField();
		col.setBounds(214, 80, 66, 21);
		contentPane.add(col);
		col.setColumns(10);
		
		value = new JTextField();
		value.setBounds(214, 118, 66, 21);
		contentPane.add(value);
		value.setColumns(10);
		
		JButton update = new JButton("\u66F4\u65B0");
		update.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				try {
					System.out.println("233");
					String sql="update "+table +" set "+ col.getText()+" = "+"'"+value.getText()+"'"+ "   where "+ IdType +" =? ";
					System.out.println(sql);
					final PreparedStatement sql1 = a.dbConn.prepareStatement(sql);
					sql1.setInt(1, Integer.parseInt(id.getText()));
					int rs=sql1.executeUpdate();
					System.out.print(rs);
					if(rs==1)
						JOptionPane.showMessageDialog(null, "成功更新");
					else
						JOptionPane.showMessageDialog(null, "未找到对应id");
				} catch (NumberFormatException | SQLException e1) {
				}
				}
		});
		update.setBounds(304, 209, 93, 23);
		contentPane.add(update);
	}

}
