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

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class search extends JFrame {

	private JPanel contentPane;
	private final JScrollPane scrollPane = new JScrollPane();
	private JTable table;
	private JTextField way;
	private JTextField key;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					search frame = new search();
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
	public search() throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		scrollPane.setBounds(0, 80, 434, 181);
		contentPane.add(scrollPane);
		
		final Main a=new Main();
		a.dbConn=Main.link();
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"userid", "username", "sex", "age", "phone", "driverType"
			}
		));
		scrollPane.setViewportView(table);
		
		JLabel label = new JLabel("\u67E5\u627E\u65B9\u5F0F");
		label.setBounds(10, 10, 54, 15);
		contentPane.add(label);
		
		way = new JTextField();
		way.setBounds(69, 7, 66, 21);
		contentPane.add(way);
		way.setColumns(10);
		
		JLabel label_1 = new JLabel("\u5173\u952E\u5B57");
		label_1.setBounds(10, 46, 54, 15);
		contentPane.add(label_1);
		
		key = new JTextField();
		key.setBounds(69, 49, 66, 21);
		contentPane.add(key);
		key.setColumns(10);
		
		JButton find = new JButton("\u67E5\u627E");
		find.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					String IdType=way.getText();
					String sql="select * from Userdetails where "+IdType+" =? ";
					final PreparedStatement sql1 = a.dbConn.prepareStatement(sql);
					if(way.getText().equals("id"))
						sql1.setInt(1, Integer.parseInt(key.getText()));
					else
						sql1.setString(1, key.getText());
					ResultSet rs=sql1.executeQuery();
					//for()
						
				} catch (NumberFormatException | SQLException e1) {
				}
			}
		});
		find.setBounds(331, 47, 93, 23);
		contentPane.add(find);
	}
}
