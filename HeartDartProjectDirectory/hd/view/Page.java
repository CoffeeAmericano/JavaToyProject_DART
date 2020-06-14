package hd.view;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import hd.dao.SearchDAO;
import hd.vo.InfoVO;

import java.awt.event.ActionListener;
import java.math.BigDecimal; // 추가
import java.math.BigInteger; // 추가
import java.util.*; // 추가
import java.awt.event.ActionEvent;

public class Page extends JFrame {

	private JPanel contentPane;
	private InfoVO infoVO;
	private static Map<String, ArrayList<BigInteger>> parseInfoVO;
	
	static Double 유동비율;
	static Double 부채비율, 자기자본비율; // 안정성비율 지표	
	static Double 매출증가율, 영업이익증가율, EPS증가율; // 성장성비율 지표
	static Double 매출총이익률, ROA, ROE; // 수익성비율 지표
	static Double 총자산회전률, 총부채회전률, 총자본회전률, 순운전자본회전율; // 활동성 비율 지표
	static Double 영업활동현금흐름, 재무활동현금흐름, 투자활동현금흐름; // 운용성 지표

	public InfoVO getInfoVO() {
		return infoVO;
	}

	public void setInfoVO(InfoVO infoVO) {
		this.infoVO = infoVO;
	}
	
	// parseInfoVO : 계정항목(key)과 숫자 리스트(value)가 Map으로 이루어진 객체
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
	
	// parseInfoVO 메서드는 String 형태의 InfoVO를 숫자로 변환해주는 메서드
	public void parseInfoVO(InfoVO infoVO) {
		Scanner sc = null;
		Map<String, ArrayList<BigInteger>> ret = new HashMap<>(3, 1);
		ArrayList<BigInteger> bs_last = new ArrayList<>();
		ArrayList<BigInteger> is_last = new ArrayList<>();
		ArrayList<BigInteger> cf_last = new ArrayList<>();
		ArrayList<BigInteger> bs_now = new ArrayList<>();
		ArrayList<BigInteger> is_now = new ArrayList<>();
		ArrayList<BigInteger> cf_now = new ArrayList<>();

		sc = new Scanner(infoVO.getBs_last()).useDelimiter("_");
		while (sc.hasNext()) {
			bs_last.add(strToBig(sc.next()));
		}

		sc = new Scanner(infoVO.getIs_last()).useDelimiter("_");
		while (sc.hasNext()) {
			is_last.add(strToBig(sc.next()));
		}

		sc = new Scanner(infoVO.getCf_last()).useDelimiter("_");
		while (sc.hasNext()) {
			cf_last.add(strToBig(sc.next()));
		}

		sc = new Scanner(infoVO.getBs_now()).useDelimiter("_");
		while (sc.hasNext()) {
			bs_now.add(strToBig(sc.next()));
		}

		sc = new Scanner(infoVO.getIs_now()).useDelimiter("_");
		while (sc.hasNext()) {
			is_now.add(strToBig(sc.next()));
		}

		sc = new Scanner(infoVO.getCf_now()).useDelimiter("_");
		while (sc.hasNext()) {
			cf_now.add(strToBig(sc.next()));
		}

		sc.close();
		ret.put("bs_last", bs_last);
		ret.put("is_last", is_last);
		ret.put("cf_last", cf_last);
		ret.put("bs_now", bs_now);
		ret.put("is_now", is_now);
		ret.put("cf_now", cf_now);

		this.setParseInfoVO(ret);

	}
	
	
	public static void calculateInfoVO() {
		
		try {
			유동비율 = (parseInfoVO.get("bs_now").get(3)).doubleValue()
					/ (parseInfoVO.get("bs_now").get(6)).doubleValue()
					* 100;
		}catch(NullPointerException ne) {
			유동비율 = null;
		}catch(Exception e) {
			System.out.println(e + " => 유동비율 에러");
		}
		
		try {
			부채비율 = (parseInfoVO.get("bs_now").get(2)).doubleValue()
					/ (parseInfoVO.get("bs_now").get(1)).doubleValue()
					* 100;
		}catch(NullPointerException ne) {
			부채비율 = null;
		}catch(Exception e) {
			System.out.println(e + " => 부채비율 에러");
		}
		
		try {
			자기자본비율 = (parseInfoVO.get("bs_now").get(1)).doubleValue()
					/ (parseInfoVO.get("bs_now").get(0)).doubleValue()
					* 100;
		}catch(NullPointerException ne) {
			자기자본비율 = null;
		}catch(Exception e) {
			System.out.println(e + " => 자기자본비율 에러");
		}
		
		try {
			매출증가율 = ((parseInfoVO.get("is_now").get(0)).doubleValue()
					/ (parseInfoVO.get("is_last").get(0)).doubleValue()
					- 1)
					* 100;
		}catch(NullPointerException ne) {
			매출증가율 = null;
		}catch(Exception e) {
			System.out.println(e + " => 매출증가율 에러");
		}
		
		try {
			영업이익증가율 = ((parseInfoVO.get("is_now").get(2)).doubleValue()
					/ (parseInfoVO.get("is_last").get(2)).doubleValue()
					- 1)
					* 100;
		}catch(NullPointerException ne) {
			영업이익증가율 = null;
		}catch(Exception e) {
			System.out.println(e + " => 영업이익증가율 에러");
		}
		
		try {
			EPS증가율 = ((parseInfoVO.get("is_now").get(7)).doubleValue()
					/ (parseInfoVO.get("is_last").get(7)).doubleValue()
					- 1)
					* 100;
		}catch(NullPointerException ne) {
			EPS증가율 = null;
		}catch(Exception e) {
			System.out.println(e + " => EPS증가율 에러");
		}
		
		try {
			매출총이익률 = (parseInfoVO.get("is_now").get(2)).doubleValue()
					/ (parseInfoVO.get("is_now").get(3)).doubleValue()
					* 100;
		}catch(NullPointerException ne) {
			매출총이익률 = null;
		}catch(Exception e) {
			System.out.println(e + " => 매출총이익률 에러");
		}
		
		try {
			ROA = (parseInfoVO.get("is_now").get(5)).doubleValue()
					/ (parseInfoVO.get("bs_now").get(0)).doubleValue()
					* 100;
		}catch(NullPointerException ne) {
			ROA = null;
		}catch(Exception e) {
			System.out.println(e + " => ROA 에러");
		}
		
		try {
			ROE = (parseInfoVO.get("is_now").get(5)).doubleValue()
					/ (parseInfoVO.get("bs_now").get(1)).doubleValue()
					* 100;
		}catch(NullPointerException ne) {
			ROE = null;
		}catch(Exception e) {
			System.out.println(e + " => ROE 에러");
		}
		
		try {
			총자산회전률 = (parseInfoVO.get("is_now").get(0)).doubleValue()
					/ (parseInfoVO.get("bs_now").get(0)).doubleValue()
					* 100;
		}catch(NullPointerException ne) {
			총자산회전률 = null;
		}catch(Exception e) {
			System.out.println(e + " => 총자산회전률 에러");
		}
		
		try {
			총부채회전률 = (parseInfoVO.get("is_now").get(0)).doubleValue()
					/ (parseInfoVO.get("bs_now").get(2)).doubleValue()
					* 100;
		}catch(NullPointerException ne) {
			총부채회전률 = null;
		}catch(Exception e) {
			System.out.println(e + " => 총부채회전률 에러");
		}
		
		try {
			총자본회전률 = (parseInfoVO.get("is_now").get(0)).doubleValue()
					/ (parseInfoVO.get("bs_now").get(1)).doubleValue()
					* 100;
		}catch(NullPointerException ne) {
			총자본회전률 = null;
		}catch(Exception e) {
			System.out.println(e + " => 총자본회전률 에러");
		}
		
		try {
			영업활동현금흐름 = parseInfoVO.get("cf_now").get(0).doubleValue();
		}catch(NullPointerException ne) {
			영업활동현금흐름 = null;
		}catch(Exception e) {
			System.out.println(e + " => 영업활동현금흐름 에러");
		}
		
		try {
			투자활동현금흐름 = parseInfoVO.get("cf_now").get(1).doubleValue();
		}catch(NullPointerException ne) {
			투자활동현금흐름 = null;
		}catch(Exception e) {
			System.out.println(e + " => 투자활동현금흐름 에러");
		}
		
		try {
			재무활동현금흐름 = parseInfoVO.get("cf_now").get(2).doubleValue();
		}catch(NullPointerException ne) {
			재무활동현금흐름 = null;
		}catch(Exception e) {
			System.out.println(e + " => 재무활동현금흐름 에러");
		}	

	}

	public static BigInteger strToBig(String info_str) {
		if (info_str.equals("NA"))
			return null;
		return new BigDecimal(info_str).toBigInteger();
	}
}
