package pkg;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPopupMenu;
import javax.swing.UIManager;
import javax.swing.WindowConstants;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

import java.awt.BorderLayout;

import javax.swing.JTextField;

import org.jvnet.substance.*;
import org.jvnet.substance.SubstanceLookAndFeel;
import org.jvnet.substance.theme.SubstanceSteelBlueTheme;

import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;

import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class test {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {


    
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
			        UIManager.setLookAndFeel(new SubstanceLookAndFeel());
			        JFrame.setDefaultLookAndFeelDecorated(true);//设置窗口
			        JDialog.setDefaultLookAndFeelDecorated(true);//设置对话框
			        SubstanceLookAndFeel.setCurrentTheme(new SubstanceSteelBlueTheme());//设置主题
			 
			    } catch (Exception e) {
			        System.err.println("Something went wrong!");}
				try {
					
					test window = new test();
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
	public test() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(350, 100, 1166, 759);
		frame.getContentPane().setLayout(null);
		
		JButton button = new JButton("\u7BA1\u7406\u5458\u6A21\u5F0F");
		button.setFont(new Font("宋体", Font.PLAIN, 20));
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				login_admin.la(null);
			}
		});
		button.setBounds(455, 442, 162, 58);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("\u6211\u662F\u7528\u6237");
		button_1.setFont(new Font("宋体", Font.PLAIN, 20));
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				login_user.login_u(null);
			}
		});
		button_1.setBounds(455, 202, 162, 51);
		frame.getContentPane().add(button_1);
		
		JButton button_2 = new JButton("\u67E5\u8BE2\u6A21\u5F0F");
		button_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				searchmodel.sm(null);
			}
		});
		button_2.setFont(new Font("宋体", Font.PLAIN, 20));
		button_2.setBounds(455, 330, 162, 56);
		frame.getContentPane().add(button_2);
		
		JLabel label = new JLabel("\u6B22\u8FCE\u4F7F\u7528\u6C7D\u8F66\u79DF\u8D41\u7CFB\u7EDF");
		label.setFont(new Font("微软雅黑", Font.PLAIN, 34));
		label.setBounds(373, 107, 346, 68);
		frame.getContentPane().add(label);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\hasee\\Desktop\\35352da30436343cee7a37b7ad4b7d0e.jpg"));
		lblNewLabel.setBounds(0, 0, 1150, 720);
		frame.getContentPane().add(lblNewLabel);
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
	}
}
