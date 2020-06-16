package hd.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ErrorFrame extends JFrame {

	private JPanel contentPane;

	public ErrorFrame() {
		setTitle("\uB3CC\uC544\uAC00");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 358, 162);
		contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uC870\uD68C\uAC00\uB2A5\uD55C \uC815\uBCF4\uAC00 \uC5C6\uC2B5\uB2C8\uB2E4.");
		lblNewLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
		lblNewLabel.setBounds(57, 27, 233, 34);
		contentPane.add(lblNewLabel);
		
		Button button = new Button("\uC778\uC815");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		button.setBounds(119, 67, 103, 25);
		contentPane.add(button);
		setVisible(true);
	}
}
