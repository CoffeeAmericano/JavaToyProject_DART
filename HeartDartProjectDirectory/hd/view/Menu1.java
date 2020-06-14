package hd.view;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import hd.biz.InfoBIZ;
import hd.biz.SearchBIZ;
import hd.vo.InfoVO;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Map;

public class Menu1 extends JFrame implements MouseListener {

	private JPanel contentPane;
	private JPanel main;
	private JPanel periodBar;

	private Label quarterLabel;
	private Label yearLabel;
	private Label tipLabel;

	private Choice quarterChoice;
	private Choice yearChoice;

	private JTextField searchTextField;
	private JTable table;
	private DefaultTableModel dt;
	@SuppressWarnings("rawtypes")
	private JComboBox searchCombo;
	private JButton searchButton;
	private JScrollPane scrollPane;
	
	private Map<String, ArrayList<String>> info_str;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Menu1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Menu1.class.getResource("/hd/view/HeartDart.png")));
		setTitle("\u2665Heart Dart\u2665 - Search");
		setBounds(100, 100, 481, 319);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		main = new JPanel();
		main.setBounds(0, 235, 463, 37);
		main.setBackground(new Color(205, 92, 92));
		contentPane.add(main);

		searchCombo = new JComboBox(new Object[] {});
		searchCombo.setBackground(Color.WHITE);
		searchCombo.setFont(new Font("경기천년바탕 Regular", Font.BOLD, 17));
		searchCombo.setModel(new DefaultComboBoxModel(
				new String[] { "  \uC804\uCCB4", "  \uD68C\uC0AC\uBA85 ", "  \uCF54\uB4DC", "  \uC5C5\uC885" }));
		main.add(searchCombo);

		searchTextField = new JTextField(20);
		main.add(searchTextField);

		periodBar = new JPanel();
		periodBar.setBackground(Color.DARK_GRAY);
		periodBar.setBounds(0, 0, 463, 30);
		contentPane.add(periodBar);
		periodBar.setLayout(null);

		quarterLabel = new Label("\uBD84\uAE30 :");
		quarterLabel.setAlignment(Label.CENTER);
		quarterLabel.setForeground(new Color(255, 255, 255));
		quarterLabel.setFont(new Font("Dialog", Font.BOLD, 15));
		quarterLabel.setBounds(243, 3, 52, 25);
		periodBar.add(quarterLabel);

		yearLabel = new Label("\uB144\uB3C4 :");
		yearLabel.setForeground(Color.WHITE);
		yearLabel.setFont(new Font("Dialog", Font.BOLD, 15));
		yearLabel.setAlignment(Label.CENTER);
		yearLabel.setBounds(104, 3, 53, 25);
		periodBar.add(yearLabel);

		quarterChoice = new Choice();
		quarterChoice.setBounds(299, 3, 52, 24);
		quarterChoice.add("1");
		quarterChoice.add("2");
		quarterChoice.add("3");
		quarterChoice.add("4");
		periodBar.add(quarterChoice);

		yearChoice = new Choice();
		yearChoice.setBounds(163, 3, 74, 24);
		yearChoice.add("2015");
		yearChoice.add("2016");
		yearChoice.add("2017");
		yearChoice.add("2018");
		yearChoice.add("2019");
		yearChoice.add("2020");
		periodBar.add(yearChoice);

		tipLabel = new Label("*\uAE30\uAC04\uC120\uD0DD*");
		tipLabel.setFont(new Font("Dialog", Font.BOLD, 15));
		tipLabel.setForeground(new Color(255, 255, 255));
		tipLabel.setAlignment(Label.CENTER);
		tipLabel.setBounds(18, 4, 92, 25);
		periodBar.add(tipLabel);

		scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(0, 31, 463, 206);
		contentPane.add(scrollPane);

		searchButton = new JButton("\uAC80\uC0C9");
		main.add(searchButton);
		
		getComTable();
		
		searchButton.addMouseListener(this);
		table.addMouseListener(this);
		
	}

	private void getComTable() {
		
		String[] name = { "회사명", "업종명", "종목코드" };
		dt = new DefaultTableModel(name, 0) {
			public boolean isCellEditable(int i, int c) {
				return false;
			}
		};
		table = new JTable(dt);
		scrollPane.setViewportView(table);

		SearchBIZ.userSelectAll(dt);

		if (dt.getRowCount() > 0)
			table.setRowSelectionInterval(0, 0);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == searchButton) {
			switch (searchCombo.getSelectedItem().toString().trim()) {
			case "전체":
				new SearchBIZ().userSearchAll(dt, searchTextField.getText());
				break;
			case "회사명":
				new SearchBIZ().userSearch(dt, "com_name", searchTextField.getText());
				break;
			case "코드":
				new SearchBIZ().userSearch(dt, "com_code", searchTextField.getText());
				break;
			case "업종":
				new SearchBIZ().userSearch(dt, "industry_name", searchTextField.getText());
				break;
			}
		} else if (e.getSource() == table) {
			JTable jt = (JTable) e.getSource();
			Point point = e.getPoint();
			int row = jt.rowAtPoint(point);
			if (e.getClickCount() == 2 && jt.getSelectedRow() != -1) {
				String clickCode = (String) jt.getValueAt(row, 2);
				String period = yearChoice.getSelectedItem().substring(2, 4) 
						+ "_" + quarterChoice.getSelectedItem();
				
				InfoVO infoVO = new InfoBIZ().infoSelect(clickCode, period);

				Page page = new Page();
				page.setInfoVO(infoVO);
				page.parseInfoVO(infoVO);
			}
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}
}
