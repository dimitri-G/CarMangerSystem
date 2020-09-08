package pkg;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Font;

import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

public class searchmodel extends JFrame {
	JLabel lblNewLabel;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void sm(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					searchmodel frame = new searchmodel();
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
	public searchmodel() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(350, 100, 1166, 759);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u67E5\u8BE2\u6A21\u5F0F");
		label.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 37));
		label.setBounds(490, 49, 162, 92);
		contentPane.add(label);
		
		JButton button = new JButton("\u8F66\u8F86\u79DF\u501F\u6570\u91CF");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					TEST1.t1();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		button.setFont(new Font("ËÎÌå", Font.PLAIN, 20));
		button.setBounds(490, 173, 153, 54);
		contentPane.add(button);
		
		JButton btnNewButton = new JButton("\u8F66\u8F86\u79DF\u501F\u5206\u5E03");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					TEST2.t2();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("ËÎÌå", Font.PLAIN, 20));
		btnNewButton.setBounds(490, 280, 153, 45);
		contentPane.add(btnNewButton);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\hasee\\Desktop\\35352da30436343cee7a37b7ad4b7d0e.jpg"));
		lblNewLabel.setBounds(5, 5, 1140, 710);
		getContentPane().add(lblNewLabel);
	}
}
