package hd.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ErrorFrame extends JFrame {

	private JPanel contentPane;

	public ErrorFrame() {
		setTitle("\uB3CC\uC544\uAC00");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 367, 162);
		
		setLocation((Toolkit.getDefaultToolkit().getScreenSize().width - this.getSize().width) /2, 
				(Toolkit.getDefaultToolkit().getScreenSize().height - this.getSize().height) /2);
		
		contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uD574\uB2F9 \uBD84\uAE30\uC5D0 \uC870\uD68C\uAC00\uB2A5\uD55C \uC815\uBCF4\uAC00 \uC5C6\uC2B5\uB2C8\uB2E4.");
		lblNewLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
		lblNewLabel.setBounds(14, 27, 330, 34);
		contentPane.add(lblNewLabel);
		
		Button button = new Button("\uC778\uC815");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		button.setBounds(121, 80, 103, 25);
		contentPane.add(button);
		setVisible(true);
	}
}
