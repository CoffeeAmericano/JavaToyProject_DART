package hd.view;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import hd.dao.SearchDAO;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;

public class Page extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_1;
	private BufferedReader input;
	private String line;
	private JFileChooser fc;
	
	public void ReadFileExample() {
		line  = new String();
		fc = new JFileChooser();
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) throws IOException {
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
	public Page() throws IOException {
		setForeground(Color.WHITE);
		setTitle("\u2665Heart Dart\u2665");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1075, 622);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		Panel panel = new Panel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, 234, 575);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("Are you");
		lblNewLabel_2.setFont(new Font("굴림", Font.BOLD, 29));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(14, 219, 206, 46);
		panel.add(lblNewLabel_2);

		JLabel lblNewLabel_2_1 = new JLabel("New");
		lblNewLabel_2_1.setFont(new Font("굴림", Font.BOLD, 30));
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_1.setBounds(14, 270, 206, 46);
		panel.add(lblNewLabel_2_1);

		JLabel lblNewLabel_2_2 = new JLabel("to finance?");
		lblNewLabel_2_2.setFont(new Font("굴림", Font.BOLD, 30));
		lblNewLabel_2_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_2.setForeground(Color.WHITE);
		lblNewLabel_2_2.setBounds(14, 320, 206, 46);
		panel.add(lblNewLabel_2_2);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(14, 368, 206, 195);
		panel.add(lblNewLabel);

		Panel panel_1 = new Panel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(251, 19, 383, 333);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon(Page.class.getResource("/hd/view/logo.png")));
		lblNewLabel_1.setBounds(26, 0, 331, 327);
		panel_1.add(lblNewLabel_1);

		JTabbedPane tabpane = new JTabbedPane();
		tabpane.setBackground(Color.WHITE);
		tabpane.setSize(444, 543);
		tabpane.setLocation(644, 16);

		JPanel tab1 = new JPanel();
		tab1.setToolTipText("");
		tab1.setBackground(Color.WHITE);
		tabpane.add("안전성", tab1);
		tabpane.setBackgroundAt(0, Color.WHITE);
		JButton btn1_1 = new JButton("수식");
		btn1_1.setBounds(47, 5, 113, 57);
		btn1_1.setIcon(new ImageIcon(Page.class.getResource("/hd/view/HTicon1.png")));
		btn1_1.setForeground(new Color(205, 92, 92));
		btn1_1.setFont(new Font("경기천년제목 Bold", Font.BOLD, 18));
		btn1_1.setBackground(Color.WHITE);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(14, 107, 411, 392);
		tab1.add(scrollPane_1);

		JTextArea textArea = new JTextArea();;
		textArea.setEditable(false);
		scrollPane_1.setViewportView(textArea);
		
		btn1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				File file = new File("src/hd/view/Test.txt");
                try
                {
                    input = new BufferedReader(
                            new InputStreamReader(
                            new FileInputStream(
                            file)));
                    textArea.read(input, "READING FILE :-)");      
                }
                catch(Exception e)
                {       
                    e.printStackTrace();
                }
			}
		});
		
		
		JButton btn1_2 = new JButton("설명");
		btn1_2.setBounds(165, 5, 113, 57);
		btn1_2.setBackground(Color.WHITE);
		btn1_2.setForeground(new Color(205, 92, 92));
		btn1_2.setFont(new Font("경기천년제목 Bold", Font.PLAIN, 18));
		btn1_2.setIcon(new ImageIcon(Page.class.getResource("/hd/view/HTicon2.png")));
		btn1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				File file = new File("src/hd/view/Test1");
                try
                {
                    input = new BufferedReader(
                            new InputStreamReader(
                            new FileInputStream(
                            file)));
                    textArea.read(input, "READING FILE :-)");      
                }
                catch(Exception e)
                {       
                    e.printStackTrace();
                }
			}
		});
		
		JButton btn1_3 = new JButton("Tip");
		btn1_3.setBounds(282, 5, 109, 57);
		btn1_3.setBackground(Color.WHITE);
		btn1_3.setForeground(new Color(205, 92, 92));
		btn1_3.setFont(new Font("경기천년제목 Bold", Font.BOLD, 18));
		btn1_3.setIcon(new ImageIcon(Page.class.getResource("/hd/view/HTicon3.png")));
		btn1_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				File file = new File("src/hd/view/Test1");
                try
                {
                    input = new BufferedReader(
                            new InputStreamReader(
                            new FileInputStream(
                            file)));
                    textArea.read(input, "READING FILE :-)");      
                }
                catch(Exception e)
                {       
                    e.printStackTrace();
                }
			}
		});
		
		JTextField txt_1 = new JTextField("단어를 입력해보세요", 25);
		txt_1.setBounds(78, 71, 281, 24);
		tab1.setLayout(null);
		tab1.add(btn1_1);
		tab1.add(btn1_2);
		tab1.add(btn1_3);
		tab1.add(txt_1);
		

		

		JPanel tab2 = new JPanel();
		tab2.setToolTipText("");
		tab2.setBackground(Color.WHITE);
		tabpane.add("성장성", tab2);
		tabpane.setBackgroundAt(0, Color.WHITE);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(14, 109, 409, 390);
		tab2.add(scrollPane_2);

		JTextArea textArea_1 = new JTextArea();
		textArea_1.setEditable(false);
		scrollPane_2.setViewportView(textArea_1);
		
		JButton btn2_1 = new JButton("수식");
		btn2_1.setBounds(47, 5, 113, 57);
		btn2_1.setIcon(new ImageIcon(Page.class.getResource("/hd/view/HTicon1.png")));
		btn2_1.setForeground(new Color(205, 92, 92));
		btn2_1.setFont(new Font("경기천년제목 Bold", Font.BOLD, 18));
		btn2_1.setBackground(Color.WHITE);
		btn2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				File file = new File("src/hd/view/Test1");
                try
                {
                    input = new BufferedReader(
                            new InputStreamReader(
                            new FileInputStream(
                            file)));
                    textArea_1.read(input, "READING FILE :-)");      
                }
                catch(Exception e)
                {       
                    e.printStackTrace();
                }
			}
		});
		
		JButton btn2_2 = new JButton("설명");
		btn2_2.setBounds(165, 5, 113, 57);
		btn2_2.setBackground(Color.WHITE);
		btn2_2.setForeground(new Color(205, 92, 92));
		btn2_2.setFont(new Font("경기천년제목 Bold", Font.PLAIN, 18));
		btn2_2.setIcon(new ImageIcon(Page.class.getResource("/hd/view/HTicon2.png")));
		btn2_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				File file = new File("src/hd/view/Test1");
                try
                {
                    input = new BufferedReader(
                            new InputStreamReader(
                            new FileInputStream(
                            file)));
                    textArea_1.read(input, "READING FILE :-)");      
                }
                catch(Exception e)
                {       
                    e.printStackTrace();
                }
			}
		});
		
		
		JButton btn2_3 = new JButton("Tip");
		btn2_3.setBounds(282, 5, 109, 57);
		btn2_3.setBackground(Color.WHITE);
		btn2_3.setForeground(new Color(205, 92, 92));
		btn2_3.setFont(new Font("경기천년제목 Bold", Font.BOLD, 18));
		btn2_3.setIcon(new ImageIcon(Page.class.getResource("/hd/view/HTicon3.png")));
		btn2_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				File file = new File("src/hd/view/Test1");
                try
                {
                    input = new BufferedReader(
                            new InputStreamReader(
                            new FileInputStream(
                            file)));
                    textArea_1.read(input, "READING FILE :-)");      
                }
                catch(Exception e)
                {       
                    e.printStackTrace();
                }
			}
		});
		
		
		JTextField txt_2 = new JTextField("단어를 입력해보세요", 25);
		txt_2.setBounds(78, 71, 281, 24);
		tab2.setLayout(null);
		tab2.add(btn2_1);
		tab2.add(btn2_2);
		tab2.add(btn2_3);
		tab2.add(txt_2);

		

		JPanel tab3 = new JPanel();
		tab3.setBackground(Color.WHITE);
		tab3.setToolTipText("");
		tab3.setBackground(Color.WHITE);
		tabpane.add("수익성", tab3);
		tabpane.setBackgroundAt(2, Color.WHITE);
		tab3.setLayout(null);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(14, 109, 409, 390);
		tab3.add(scrollPane_3);

		JTextArea textArea_3 = new JTextArea();
		textArea_3.setEditable(false);
		scrollPane_3.setViewportView(textArea_3);
		tabpane.setBackgroundAt(0, Color.WHITE);

		JButton btn3_1 = new JButton("\uC218\uC2DD");
		btn3_1.setBounds(47, 5, 113, 57);
		btn3_1.setIcon(new ImageIcon(Page.class.getResource("/hd/view/HTicon1.png")));
		btn3_1.setForeground(new Color(205, 92, 92));
		btn3_1.setFont(new Font("경기천년제목 Bold", Font.BOLD, 18));
		btn3_1.setBackground(Color.WHITE);
		tab3.add(btn3_1);
		btn3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				File file = new File("src/hd/view/Test1");
                try
                {
                    input = new BufferedReader(
                            new InputStreamReader(
                            new FileInputStream(
                            file)));
                    textArea_3.read(input, "READING FILE :-)");      
                }
                catch(Exception e)
                {       
                    e.printStackTrace();
                }
			}
		});

		JButton btn3_2 = new JButton("\uC124\uBA85");
		btn3_2.setBounds(165, 5, 113, 57);
		btn3_2.setIcon(new ImageIcon(Page.class.getResource("/hd/view/HTicon2.png")));
		btn3_2.setForeground(new Color(205, 92, 92));
		btn3_2.setFont(new Font("경기천년제목 Bold", Font.PLAIN, 18));
		btn3_2.setBackground(Color.WHITE);
		tab3.add(btn3_2);
		btn3_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				File file = new File("src/hd/view/Test1");
                try
                {
                    input = new BufferedReader(
                            new InputStreamReader(
                            new FileInputStream(
                            file)));
                    textArea_3.read(input, "READING FILE :-)");      
                }
                catch(Exception e)
                {       
                    e.printStackTrace();
                }
			}
		});

		JButton btn3_3 = new JButton("Tip");
		btn3_3.setBounds(282, 5, 109, 57);
		btn3_3.setIcon(new ImageIcon(Page.class.getResource("/hd/view/HTicon3.png")));
		btn3_3.setForeground(new Color(205, 92, 92));
		btn3_3.setFont(new Font("경기천년제목 Bold", Font.BOLD, 18));
		btn3_3.setBackground(Color.WHITE);
		tab3.add(btn3_3);
		btn3_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				File file = new File("src/hd/view/Test1");
                try
                {
                    input = new BufferedReader(
                            new InputStreamReader(
                            new FileInputStream(
                            file)));
                    textArea_3.read(input, "READING FILE :-)");      
                }
                catch(Exception e)
                {       
                    e.printStackTrace();
                }
			}
		});

		textField = new JTextField("\uB2E8\uC5B4\uB97C \uC785\uB825\uD574\uBCF4\uC138\uC694", 25);
		textField.setBounds(78, 71, 281, 24);
		tab3.add(textField);

		

		JPanel tab4 = new JPanel();
		tab4.setBackground(Color.WHITE);
		tab4.setToolTipText("");
		tab4.setBackground(Color.WHITE);
		tabpane.add("활동성", tab4);
		tabpane.setBackgroundAt(2, Color.WHITE);
		tab4.setLayout(null);
		
		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(14, 109, 407, 388);
		tab4.add(scrollPane_4);
		
		JTextArea textArea_4 = new JTextArea();
		textArea_4.setEditable(false);
		textArea_4.setEditable(false);
		scrollPane_4.setViewportView(textArea_4);

		JButton btn4_1 = new JButton("\uC218\uC2DD");
	
		btn4_1.setBounds(47, 5, 113, 57);
		btn4_1.setIcon(new ImageIcon(Page.class.getResource("/hd/view/HTicon1.png")));
		btn4_1.setForeground(new Color(205, 92, 92));
		btn4_1.setFont(new Font("경기천년제목 Bold", Font.BOLD, 18));
		btn4_1.setBackground(Color.WHITE);
		tab4.add(btn4_1);
		btn4_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				File file = new File("src/hd/view/Test1");
                try
                {
                    input = new BufferedReader(
                            new InputStreamReader(
                            new FileInputStream(
                            file)));
                    textArea_4.read(input, "READING FILE :-)");      
                }
                catch(Exception e)
                {       
                    e.printStackTrace();
                }
			}
		});

		JButton btn4_2 = new JButton("\uC124\uBA85");
		btn4_2.setBounds(165, 5, 113, 57);
		btn4_2.setIcon(new ImageIcon(Page.class.getResource("/hd/view/HTicon2.png")));
		btn4_2.setForeground(new Color(205, 92, 92));
		btn4_2.setFont(new Font("경기천년제목 Bold", Font.PLAIN, 18));
		btn4_2.setBackground(Color.WHITE);
		tab4.add(btn4_2);
		btn4_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				File file = new File("src/hd/view/Test1");
                try
                {
                    input = new BufferedReader(
                            new InputStreamReader(
                            new FileInputStream(
                            file)));
                    textArea_4.read(input, "READING FILE :-)");      
                }
                catch(Exception e)
                {       
                    e.printStackTrace();
                }
			}
		});

		JButton btn4_3 = new JButton("Tip");
		btn4_3.setBounds(282, 5, 109, 57);
		btn4_3.setIcon(new ImageIcon(Page.class.getResource("/hd/view/HTicon3.png")));
		btn4_3.setForeground(new Color(205, 92, 92));
		btn4_3.setFont(new Font("경기천년제목 Bold", Font.BOLD, 18));
		btn4_3.setBackground(Color.WHITE);
		tab4.add(btn4_3);
		btn4_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				File file = new File("src/hd/view/Test1");
                try
                {
                    input = new BufferedReader(
                            new InputStreamReader(
                            new FileInputStream(
                            file)));
                    textArea_4.read(input, "READING FILE :-)");      
                }
                catch(Exception e)
                {       
                    e.printStackTrace();
                }
			}
		});

		textField_1 = new JTextField("\uB2E8\uC5B4\uB97C \uC785\uB825\uD574\uBCF4\uC138\uC694", 25);
		textField_1.setBounds(78, 71, 281, 24);
		tab4.add(textField_1);
		tabpane.setBackgroundAt(0, Color.WHITE);

		JPanel tab5 = new JPanel();
		tab5.setBackground(Color.WHITE);
		tab5.setToolTipText("");
		tab5.setBackground(Color.WHITE);
		tabpane.add("순이익성", tab5);
		tabpane.setBackgroundAt(2, Color.WHITE);
		tab5.setLayout(null);
		
		JScrollPane scrollPane_5 = new JScrollPane();
		scrollPane_5.setBounds(14, 107, 409, 390);
		tab5.add(scrollPane_5);

		JTextArea textArea_5 = new JTextArea();
		textArea_5.setEditable(false);
		scrollPane_5.setViewportView(textArea_5);
		tabpane.setBackgroundAt(0, Color.WHITE);

		JButton btn5_1 = new JButton("\uC218\uC2DD");
		btn5_1.setBounds(47, 5, 113, 57);
		btn5_1.setIcon(new ImageIcon(Page.class.getResource("/hd/view/HTicon1.png")));
		btn5_1.setForeground(new Color(205, 92, 92));
		btn5_1.setFont(new Font("경기천년제목 Bold", Font.BOLD, 18));
		btn5_1.setBackground(Color.WHITE);
		tab5.add(btn5_1);
		btn5_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				File file = new File("src/hd/view/Test1");
                try
                {
                    input = new BufferedReader(
                            new InputStreamReader(
                            new FileInputStream(
                            file)));
                    textArea_5.read(input, "READING FILE :-)");      
                }
                catch(Exception e)
                {       
                    e.printStackTrace();
                }
			}
		});

		JButton btn5_2 = new JButton("\uC124\uBA85");
		btn5_2.setBounds(165, 5, 113, 57);
		btn5_2.setIcon(new ImageIcon(Page.class.getResource("/hd/view/HTicon2.png")));
		btn5_2.setForeground(new Color(205, 92, 92));
		btn5_2.setFont(new Font("경기천년제목 Bold", Font.PLAIN, 18));
		btn5_2.setBackground(Color.WHITE);
		tab5.add(btn5_2);
		btn5_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				File file = new File("src/hd/view/Test1");
                try
                {
                    input = new BufferedReader(
                            new InputStreamReader(
                            new FileInputStream(
                            file)));
                    textArea_5.read(input, "READING FILE :-)");      
                }
                catch(Exception e)
                {       
                    e.printStackTrace();
                }
			}
		});

		JButton btn5_3 = new JButton("Tip");
		btn5_3.setBounds(282, 5, 109, 57);
		btn5_3.setIcon(new ImageIcon(Page.class.getResource("/hd/view/HTicon3.png")));
		btn5_3.setForeground(new Color(205, 92, 92));
		btn5_3.setFont(new Font("경기천년제목 Bold", Font.BOLD, 18));
		btn5_3.setBackground(Color.WHITE);
		tab5.add(btn5_3);
		btn5_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				File file = new File("src/hd/view/Test1");
                try
                {
                    input = new BufferedReader(
                            new InputStreamReader(
                            new FileInputStream(
                            file)));
                    textArea_5.read(input, "READING FILE :-)");      
                }
                catch(Exception e)
                {       
                    e.printStackTrace();
                }
			}
		});

		textField_2 = new JTextField("\uB2E8\uC5B4\uB97C \uC785\uB825\uD574\uBCF4\uC138\uC694", 25);
		textField_2.setBounds(78, 71, 281, 24);
		tab5.add(textField_2);

		


		getContentPane().add(tabpane);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(251, 359, 383, 200);
		contentPane.add(scrollPane);
		setSize(1120, 630);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
