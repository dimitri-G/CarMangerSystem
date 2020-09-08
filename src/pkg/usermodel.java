package pkg;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JComboBox;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JLabel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;

public class usermodel {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void um(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					usermodel window = new usermodel();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public usermodel() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(350, 100, 1166, 759);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton button = new JButton("\u6211\u8981\u79DF\u8F66");
		button.setFont(new Font("ËÎÌå", Font.PLAIN, 20));
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				rent.rent(null);
			}
		});
		button.setBounds(509, 185, 135, 39);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("\u6211\u8981\u8FD8\u8F66");
		button_1.setFont(new Font("ËÎÌå", Font.PLAIN, 20));
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				user_choice.rt(null);
			}
		});
		button_1.setBounds(509, 308, 135, 45);
		frame.getContentPane().add(button_1);
		
		JButton button_2 = new JButton("\u6211\u8981\u770B\u8F66");
		button_2.setFont(new Font("ËÎÌå", Font.PLAIN, 20));
		button_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				srhcar.sc(null);
			}
		});
		button_2.setBounds(509, 428, 135, 45);
		frame.getContentPane().add(button_2);
		
		JLabel label = new JLabel("\u7528\u6237\u9009\u9879");
		label.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 38));
		label.setBounds(490, 60, 173, 57);
		frame.getContentPane().add(label);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\hasee\\Desktop\\35352da30436343cee7a37b7ad4b7d0e.jpg"));
		lblNewLabel.setBounds(0, 0, 1150, 720);
		frame.getContentPane().add(lblNewLabel);
	}
}
