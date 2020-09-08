package pkg;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class find extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField kw;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					find frame = new find();
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
	public find() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 634, 452);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 60, 618, 353);
		contentPane.add(scrollPane);
		
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
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"\u8F66\u8F86\u53F7", "\u8F66\u724C\u53F7", "\u54C1\u724C", "\u8F66\u578B", "\u65E5\u79DF", "\u6708\u79DF"
			}
		));
		scrollPane.setViewportView(table);
		
		JRadioButton brd = new JRadioButton("\u6309\u54C1\u724C\u67E5\u627E");
		brd.setBounds(464, 6, 121, 23);
		contentPane.add(brd);
		
		JRadioButton radioButton_1 = new JRadioButton("\u6309\u8F66\u578B\u67E5\u627E");
		radioButton_1.setBounds(464, 31, 121, 23);
		contentPane.add(radioButton_1);
		
		JLabel label = new JLabel("\u8BF7\u8F93\u5165\u5173\u952E\u8BCD\u67E5\u627E");
		label.setFont(new Font("ËÎÌו", Font.PLAIN, 20));
		label.setBounds(10, 10, 173, 40);
		contentPane.add(label);
		
		kw = new JTextField();
		kw.setBounds(183, 20, 121, 23);
		contentPane.add(kw);
		kw.setColumns(10);
		
		JButton button = new JButton("\u67E5\u627E");
		button.setBounds(331, 21, 72, 23);
		contentPane.add(button);
	}
}
