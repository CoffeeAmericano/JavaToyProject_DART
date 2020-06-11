package hd.view;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Page extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Page frame = new Page();
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
	public Page() {
		setForeground(Color.WHITE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Page.class.getResource("/SecPage/HeartDart.png")));
		setTitle("\u2665Heart Dart\u2665");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1075, 622);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Panel panel = new Panel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 234, 575);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Page.class.getResource("/Page_1/heartTest2.png")));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 30));
		lblNewLabel.setBounds(-62, 35, 282, 145);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("Are you");
		lblNewLabel_2.setFont(new Font("굴림", Font.BOLD, 29));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(14, 204, 206, 46);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("New");
		lblNewLabel_2_1.setFont(new Font("굴림", Font.BOLD, 30));
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_1.setBounds(14, 262, 206, 46);
		panel.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("to finance?");
		lblNewLabel_2_2.setFont(new Font("굴림", Font.BOLD, 30));
		lblNewLabel_2_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_2.setForeground(Color.WHITE);
		lblNewLabel_2_2.setBounds(14, 320, 206, 46);
		panel.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setIcon(new ImageIcon(Page.class.getResource("/SecPage/chart3.png")));
		lblNewLabel_3.setBounds(14, 370, 206, 193);
		panel.add(lblNewLabel_3);
		
		Panel panel_1 = new Panel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(255, 28, 383, 327);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon(Page.class.getResource("/Page_1/logo.png")));
		lblNewLabel_1.setBounds(26, 0, 331, 327);
		panel_1.add(lblNewLabel_1);
		
		Panel panel_1_1 = new Panel();
		panel_1_1.setBackground(new Color(192, 192, 192));
		panel_1_1.setBounds(664, 28, 372, 327);
		contentPane.add(panel_1_1);
		panel_1_1.setLayout(null);
		
		Panel panel_1_2_1 = new Panel();
		panel_1_2_1.setBackground(new Color(192, 192, 192));
		panel_1_2_1.setBounds(255, 375, 383, 176);
		contentPane.add(panel_1_2_1);
		panel_1_2_1.setLayout(null);
		
		Button button_1 = new Button("\uC8FC\uC11D");
		button_1.setBounds(261, 108, 112, 58);
		panel_1_2_1.add(button_1);
		button_1.setFont(new Font("Georgia", Font.BOLD, 20));
		button_1.setForeground(new Color(255, 255, 255));
		button_1.setBackground(new Color(255, 99, 71));
		
		Panel panel_2 = new Panel();
		panel_2.setBackground(new Color(192, 192, 192));
		panel_2.setBounds(664, 378, 372, 173);
		contentPane.add(panel_2);
	}
}
