package hd.view;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import hd.dao.SearchDAO;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Page extends JFrame {

	private JPanel contentPane;
	private InfoVO infoVO;
	private Map<String, ArrayList<BigInteger>> parseInfoVO;

	public InfoVO getInfoVO() {
		return infoVO;
	}

	public void setInfoVO(InfoVO infoVO) {
		this.infoVO = infoVO;
	}
	
	public Map<String, ArrayList<BigInteger>> getParseInfoVO() {
		return parseInfoVO;
	}

	public void setParseInfoVO(Map<String, ArrayList<BigInteger>> parseInfoVO) {
		this.parseInfoVO = parseInfoVO;
	}

	
	public Page() {
		setForeground(Color.WHITE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Page.class.getResource("/SecPage/HeartDart.png")));
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

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Page.class.getResource("/hd/view/heartTest2.png")));
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
		lblNewLabel_3.setIcon(new ImageIcon(Page.class.getResource("/hd/view/chart3.png")));
		lblNewLabel_3.setBounds(14, 370, 206, 193);
		panel.add(lblNewLabel_3);

		Panel panel_1 = new Panel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(255, 28, 383, 333);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon(Page.class.getResource("/hd/view/logo.png")));
		lblNewLabel_1.setBounds(26, 0, 331, 327);
		panel_1.add(lblNewLabel_1);
		
		JTabbedPane tabpane = new JTabbedPane();
		tabpane.setBackground(Color.WHITE);
		tabpane.setTabPlacement(JTabbedPane.RIGHT);
		tabpane.setSize(444, 543);
		tabpane.setLocation(644, 28);
		
		JPanel tab1 = new JPanel();
		tab1.setToolTipText("");
		tab1.setBackground(Color.WHITE);
		tabpane.add("안전성", tab1);
		tabpane.setBackgroundAt(0, Color.WHITE);
		JButton btn1_1 = new JButton("수식");
		btn1_1.setIcon(new ImageIcon(Page.class.getResource("/hd/view/HTicon1.png")));
		btn1_1.setForeground(new Color(205, 92, 92));
		btn1_1.setFont(new Font("경기천년제목 Bold", Font.BOLD, 20));
		btn1_1.setBackground(Color.WHITE);
		btn1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		JButton btn1_2 = new JButton("설명");
		btn1_2.setForeground(new Color(205, 92, 92));
		btn1_2.setFont(new Font("경기천년제목 Bold", Font.PLAIN, 20));
		btn1_2.setIcon(new ImageIcon(Page.class.getResource("/hd/view/HTicon2.png")));
		JButton btn1_3 = new JButton("Tip");
		btn1_3.setForeground(new Color(205, 92, 92));
		btn1_3.setFont(new Font("경기천년제목 Bold", Font.BOLD, 20));
		btn1_3.setIcon(new ImageIcon(Page.class.getResource("/hd/view/HTicon3.png")));
		JTextField txt_1 = new JTextField("단어를 입력해보세요", 25);
		tab1.add(btn1_1);
		tab1.add(btn1_2);
		tab1.add(btn1_3);
		tab1.add(txt_1);
		
		JPanel tab2 = new JPanel();
		tabpane.add("성장성", tab2);
		tabpane.setBackgroundAt(1, Color.PINK);
		JButton btn2_1 = new JButton("수식");
		JButton btn2_2 = new JButton("설명");
		JButton btn2_3 = new JButton("Tip");
		JTextField txt_2 = new JTextField("단어를 입력해보세요", 25);
		tab2.add(btn2_1);
		tab2.add(btn2_2);
		tab2.add(btn2_3);
		tab2.add(txt_2);
		
		JPanel tab3 = new JPanel();
		tabpane.add("수익성", tab3);
		JButton btn3_1 = new JButton("수식");
		JButton btn3_2 = new JButton("설명");
		JButton btn3_3 = new JButton("Tip");
		JTextField txt_3 = new JTextField("단어를 입력해보세요", 25);
		tab3.add(btn3_1);
		tab3.add(btn3_2);
		tab3.add(btn3_3);
		tab3.add(txt_3);
		
		JPanel tab4 = new JPanel();
		tabpane.add("활동성", tab4);
		JButton btn4_1 = new JButton("수식");
		JButton btn4_2 = new JButton("설명");
		JButton btn4_3 = new JButton("Tip");
		JTextField txt_4 = new JTextField("단어를 입력해보세요", 25);
		tab3.add(btn4_1);
		tab3.add(btn4_2);
		tab3.add(btn4_3);
		tab3.add(txt_4);
		
		JPanel tab5 = new JPanel();
		tabpane.add("활동성", tab5);
		JButton btn5_1 = new JButton("수식");
		JButton btn5_2 = new JButton("설명");
		JButton btn5_3 = new JButton("Tip");
		JTextField txt_5 = new JTextField("단어를 입력해보세요", 25);
		tab3.add(btn5_1);
		tab3.add(btn5_2);
		tab3.add(btn5_3);
		tab3.add(txt_5);
		
		
		getContentPane().add(tabpane);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(255, 371, 377, 200);
		contentPane.add(scrollPane);
		setSize(1120, 630);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void parseInfoVO(InfoVO infoVO) {

		Map<String, ArrayList<BigInteger>> ret = new HashMap<>(3, 1);
		ArrayList<BigInteger> bsList = new ArrayList<>();
		ArrayList<BigInteger> isList = new ArrayList<>();
		ArrayList<BigInteger> cfList = new ArrayList<>();

		Scanner sc = new Scanner(infoVO.getBs()).useDelimiter("_");

		while (sc.hasNext()) {
			bsList.add(strToBig(sc.next()));
		}
		for (int i = 0; i < bsList.size(); i++) {
			System.out.println(bsList.get(i));
		}

		sc = new Scanner(infoVO.getIs()).useDelimiter("_");
		while (sc.hasNext()) {
			isList.add(strToBig(sc.next()));
		}

		sc = new Scanner(infoVO.getCf()).useDelimiter("_");
		while (sc.hasNext()) {
			cfList.add(strToBig(sc.next()));
		}
		ret.put("재무상태표", bsList);
		ret.put("손익계산서", isList);
		ret.put("현금흐름표", cfList);

		this.setParseInfoVO(ret);

	}

	private static BigInteger strToBig(String info_str) {
		if (info_str == "NA")
			return null;
		return new BigDecimal(info_str).toBigInteger();
	}
}
