package hd.view;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.CategoryDataset;

import java.util.*;

import hd.vo.InfoVO;

import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.awt.event.ActionEvent;

public class Page extends JFrame {

	private Panel sidePanel;
	private JLabel wordLabel1;
	private JLabel wordLabel2;
	private JLabel wordLabel3;
	private JLabel ImageLabel;
	private JLabel HeartDartLabel;
	private Panel chartPanel;
	private JPanel tab1;
	private CategoryDataset dataset;
	private BufferedReader input;
	private String line;
	private JFileChooser fc;
	
	private JPanel contentPane;
	private InfoVO infoVO;
	
	public static Map<String, ArrayList<BigInteger>> parseInfo;
	static Double 유동비율, 부채비율, 자기자본비율; // 안정성비율 지표
	static Double 매출증가율, 영업이익증가율, EPS증가율; // 성장성비율 지표
	static Double 매출총이익률, ROA, ROE; // 수익성비율 지표
	static Double 총자산회전률, 총부채회전률, 총자본회전률, 순운전자본회전율; // 활동성 비율 지표
	static Double 영업활동현금흐름, 재무활동현금흐름, 투자활동현금흐름; // 운용성 지표
	
	
	private JTable table;
	
	public InfoVO getInfoVO() {
		return infoVO;
	}

	public void setInfoVO(InfoVO infoVO) {
		this.infoVO = infoVO;
	}

	public Map<String, ArrayList<BigInteger>> getParseInfo() {
		return parseInfo;
	}

	public void setParseInfo(Map<String, ArrayList<BigInteger>> parseInfo) {
		this.parseInfo = parseInfo;
	}

	public Page() {
		setForeground(Color.WHITE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Page.class.getResource("/hd/view/HeartDart.png")));
		setTitle("\u2665Heart Dart\u2665");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1075, 622);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		sidePanel = new Panel();
		sidePanel.setBackground(Color.BLACK);
		sidePanel.setBounds(0, 0, 234, 575);
		contentPane.add(sidePanel);
		sidePanel.setLayout(null);

		wordLabel1 = new JLabel("Are you");
		wordLabel1.setFont(new Font("굴림", Font.BOLD, 29));
		wordLabel1.setHorizontalAlignment(SwingConstants.CENTER);
		wordLabel1.setForeground(Color.WHITE);
		wordLabel1.setBounds(14, 204, 206, 46);
		sidePanel.add(wordLabel1);

		wordLabel2 = new JLabel("New");
		wordLabel2.setFont(new Font("굴림", Font.BOLD, 30));
		wordLabel2.setHorizontalAlignment(SwingConstants.CENTER);
		wordLabel2.setForeground(Color.WHITE);
		wordLabel2.setBounds(14, 262, 206, 46);
		sidePanel.add(wordLabel2);

		wordLabel3 = new JLabel("to finance?");
		wordLabel3.setFont(new Font("굴림", Font.BOLD, 30));
		wordLabel3.setHorizontalAlignment(SwingConstants.CENTER);
		wordLabel3.setForeground(Color.WHITE);
		wordLabel3.setBounds(14, 320, 206, 46);
		sidePanel.add(wordLabel3);

		ImageLabel = new JLabel("");
		ImageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		ImageLabel.setIcon(new ImageIcon(Page.class.getResource("/hd/view/chart3.png")));
		ImageLabel.setBounds(14, 370, 206, 193);
		sidePanel.add(ImageLabel);
		
		HeartDartLabel = new JLabel("");
		HeartDartLabel.setBounds(-62, 36, 282, 145);
		sidePanel.add(HeartDartLabel);
		HeartDartLabel.setIcon(new ImageIcon(Page.class.getResource("/hd/view/heartTest2.png")));
		HeartDartLabel.setForeground(new Color(255, 255, 255));
		HeartDartLabel.setFont(new Font("굴림", Font.BOLD, 30));
		
		JPanel mainStatPanel = new JPanel();
		mainStatPanel.setBackground(Color.BLACK);
		mainStatPanel.setBounds(242, 320, 398, 251);
		contentPane.add(mainStatPanel);
		mainStatPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uC790\uC0B0\uADDC\uBAA8");
		lblNewLabel.setForeground(Color.ORANGE);
		lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 19));
		lblNewLabel.setBounds(23, 28, 120, 30);
		mainStatPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("\uBD80\uCC44\uBE44\uC728\uC810\uC218");
		lblNewLabel_2.setForeground(Color.ORANGE);
		lblNewLabel_2.setFont(new Font("맑은 고딕", Font.BOLD, 19));
		lblNewLabel_2.setBounds(23, 70, 120, 30);
		mainStatPanel.add(lblNewLabel_2);
		
		JLabel lblRoa = new JLabel("ROA\uC810\uC218");
		lblRoa.setForeground(Color.ORANGE);
		lblRoa.setFont(new Font("맑은 고딕", Font.BOLD, 19));
		lblRoa.setBounds(23, 112, 120, 30);
		mainStatPanel.add(lblRoa);
		
		JLabel lblNewLabel_4 = new JLabel("\uC720\uB3D9\uBE44\uC728\uC810\uC218");
		lblNewLabel_4.setForeground(Color.ORANGE);
		lblNewLabel_4.setFont(new Font("맑은 고딕", Font.BOLD, 19));
		lblNewLabel_4.setBounds(23, 154, 120, 30);
		mainStatPanel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("\uC720\uB3D9\uBE44\uC728\uC810\uC218");
		lblNewLabel_5.setForeground(Color.ORANGE);
		lblNewLabel_5.setFont(new Font("맑은 고딕", Font.BOLD, 19));
		lblNewLabel_5.setBounds(23, 196, 120, 30);
		mainStatPanel.add(lblNewLabel_5);
		
		JPanel pointPanel1_1 = new JPanel();
		pointPanel1_1.setBackground(Color.ORANGE);
		pointPanel1_1.setBounds(157, 35, 18, 23);
		mainStatPanel.add(pointPanel1_1);
		
		JPanel pointPanel1_2 = new JPanel();
		pointPanel1_2.setBackground(Color.ORANGE);
		pointPanel1_2.setBounds(179, 35, 18, 23);
		mainStatPanel.add(pointPanel1_2);
		
		JPanel pointPanel1_3 = new JPanel();
		pointPanel1_3.setBackground(Color.ORANGE);
		pointPanel1_3.setBounds(201, 35, 18, 23);
		mainStatPanel.add(pointPanel1_3);
		
		JPanel pointPanel1_4 = new JPanel();
		pointPanel1_4.setBackground(Color.ORANGE);
		pointPanel1_4.setBounds(223, 35, 18, 23);
		mainStatPanel.add(pointPanel1_4);
		
		JPanel pointPanel1_5 = new JPanel();
		pointPanel1_5.setBackground(Color.ORANGE);
		pointPanel1_5.setBounds(245, 35, 18, 23);
		mainStatPanel.add(pointPanel1_5);
		
		JPanel pointPanel1_6 = new JPanel();
		pointPanel1_6.setBackground(Color.ORANGE);
		pointPanel1_6.setBounds(267, 35, 18, 23);
		mainStatPanel.add(pointPanel1_6);
		
		JPanel pointPanel1_7 = new JPanel();
		pointPanel1_7.setBackground(Color.ORANGE);
		pointPanel1_7.setBounds(289, 35, 18, 23);
		mainStatPanel.add(pointPanel1_7);
		
		JPanel pointPanel1_8 = new JPanel();
		pointPanel1_8.setBackground(Color.ORANGE);
		pointPanel1_8.setBounds(311, 35, 18, 23);
		mainStatPanel.add(pointPanel1_8);
		
		JPanel pointPanel1_9 = new JPanel();
		pointPanel1_9.setBackground(Color.ORANGE);
		pointPanel1_9.setBounds(333, 35, 18, 23);
		mainStatPanel.add(pointPanel1_9);
		
		JPanel pointPanel2_1 = new JPanel();
		pointPanel2_1.setBackground(Color.ORANGE);
		pointPanel2_1.setBounds(157, 77, 18, 23);
		mainStatPanel.add(pointPanel2_1);
		
		JPanel pointPanel2_2 = new JPanel();
		pointPanel2_2.setBackground(Color.ORANGE);
		pointPanel2_2.setBounds(179, 77, 18, 23);
		mainStatPanel.add(pointPanel2_2);
		
		JPanel pointPanel2_3 = new JPanel();
		pointPanel2_3.setBackground(Color.ORANGE);
		pointPanel2_3.setBounds(201, 77, 18, 23);
		mainStatPanel.add(pointPanel2_3);
		
		JPanel pointPanel2_4 = new JPanel();
		pointPanel2_4.setBackground(Color.ORANGE);
		pointPanel2_4.setBounds(223, 77, 18, 23);
		mainStatPanel.add(pointPanel2_4);
		
		JPanel pointPanel2_5 = new JPanel();
		pointPanel2_5.setBackground(Color.ORANGE);
		pointPanel2_5.setBounds(245, 77, 18, 23);
		mainStatPanel.add(pointPanel2_5);
		
		JPanel pointPanel2_6 = new JPanel();
		pointPanel2_6.setBackground(Color.ORANGE);
		pointPanel2_6.setBounds(267, 77, 18, 23);
		mainStatPanel.add(pointPanel2_6);
		
		JPanel pointPanel2_7 = new JPanel();
		pointPanel2_7.setBackground(Color.ORANGE);
		pointPanel2_7.setBounds(289, 77, 18, 23);
		mainStatPanel.add(pointPanel2_7);
		
		JPanel pointPanel2_8 = new JPanel();
		pointPanel2_8.setBackground(Color.ORANGE);
		pointPanel2_8.setBounds(311, 77, 18, 23);
		mainStatPanel.add(pointPanel2_8);
		
		JPanel pointPanel2_9 = new JPanel();
		pointPanel2_9.setBackground(Color.ORANGE);
		pointPanel2_9.setBounds(333, 77, 18, 23);
		mainStatPanel.add(pointPanel2_9);
		
		JPanel pointPanel3_1 = new JPanel();
		pointPanel3_1.setBackground(Color.ORANGE);
		pointPanel3_1.setBounds(157, 119, 18, 23);
		mainStatPanel.add(pointPanel3_1);
		
		JPanel pointPanel3_2 = new JPanel();
		pointPanel3_2.setBackground(Color.ORANGE);
		pointPanel3_2.setBounds(179, 119, 18, 23);
		mainStatPanel.add(pointPanel3_2);
		
		JPanel pointPanel3_3 = new JPanel();
		pointPanel3_3.setBackground(Color.ORANGE);
		pointPanel3_3.setBounds(201, 119, 18, 23);
		mainStatPanel.add(pointPanel3_3);
		
		JPanel pointPanel3_4 = new JPanel();
		pointPanel3_4.setBackground(Color.ORANGE);
		pointPanel3_4.setBounds(223, 119, 18, 23);
		mainStatPanel.add(pointPanel3_4);
		
		JPanel pointPanel3_5 = new JPanel();
		pointPanel3_5.setBackground(Color.ORANGE);
		pointPanel3_5.setBounds(245, 119, 18, 23);
		mainStatPanel.add(pointPanel3_5);
		
		JPanel pointPanel3_6 = new JPanel();
		pointPanel3_6.setBackground(Color.ORANGE);
		pointPanel3_6.setBounds(267, 119, 18, 23);
		mainStatPanel.add(pointPanel3_6);
		
		JPanel pointPanel3_7 = new JPanel();
		pointPanel3_7.setBackground(Color.ORANGE);
		pointPanel3_7.setBounds(289, 119, 18, 23);
		mainStatPanel.add(pointPanel3_7);
		
		JPanel pointPanel3_8 = new JPanel();
		pointPanel3_8.setBackground(Color.ORANGE);
		pointPanel3_8.setBounds(311, 119, 18, 23);
		mainStatPanel.add(pointPanel3_8);
		
		JPanel pointPanel3_9 = new JPanel();
		pointPanel3_9.setBackground(Color.ORANGE);
		pointPanel3_9.setBounds(333, 119, 18, 23);
		mainStatPanel.add(pointPanel3_9);
		
		JPanel pointPanel4_1 = new JPanel();
		pointPanel4_1.setBackground(Color.ORANGE);
		pointPanel4_1.setBounds(157, 161, 18, 23);
		mainStatPanel.add(pointPanel4_1);
		
		JPanel pointPanel4_2 = new JPanel();
		pointPanel4_2.setBackground(Color.ORANGE);
		pointPanel4_2.setBounds(179, 161, 18, 23);
		mainStatPanel.add(pointPanel4_2);
		
		JPanel pointPanel4_3 = new JPanel();
		pointPanel4_3.setBackground(Color.ORANGE);
		pointPanel4_3.setBounds(201, 161, 18, 23);
		mainStatPanel.add(pointPanel4_3);
		
		JPanel pointPanel4_4 = new JPanel();
		pointPanel4_4.setBackground(Color.ORANGE);
		pointPanel4_4.setBounds(223, 161, 18, 23);
		mainStatPanel.add(pointPanel4_4);
		
		JPanel pointPanel4_5 = new JPanel();
		pointPanel4_5.setBackground(Color.ORANGE);
		pointPanel4_5.setBounds(245, 161, 18, 23);
		mainStatPanel.add(pointPanel4_5);
		
		JPanel pointPanel4_6 = new JPanel();
		pointPanel4_6.setBackground(Color.ORANGE);
		pointPanel4_6.setBounds(267, 161, 18, 23);
		mainStatPanel.add(pointPanel4_6);
		
		JPanel pointPanel4_7 = new JPanel();
		pointPanel4_7.setBackground(Color.ORANGE);
		pointPanel4_7.setBounds(289, 161, 18, 23);
		mainStatPanel.add(pointPanel4_7);
		
		JPanel pointPanel4_8 = new JPanel();
		pointPanel4_8.setBackground(Color.ORANGE);
		pointPanel4_8.setBounds(311, 161, 18, 23);
		mainStatPanel.add(pointPanel4_8);
		
		JPanel pointPanel4_9 = new JPanel();
		pointPanel4_9.setBackground(Color.ORANGE);
		pointPanel4_9.setBounds(333, 161, 18, 23);
		mainStatPanel.add(pointPanel4_9);
		
		JPanel pointPanel5_1 = new JPanel();
		pointPanel5_1.setBackground(Color.ORANGE);
		pointPanel5_1.setBounds(157, 203, 18, 23);
		mainStatPanel.add(pointPanel5_1);
		
		JPanel pointPanel5_2 = new JPanel();
		pointPanel5_2.setBackground(Color.ORANGE);
		pointPanel5_2.setBounds(179, 203, 18, 23);
		mainStatPanel.add(pointPanel5_2);
		
		JPanel pointPanel5_3 = new JPanel();
		pointPanel5_3.setBackground(Color.ORANGE);
		pointPanel5_3.setBounds(201, 203, 18, 23);
		mainStatPanel.add(pointPanel5_3);
		
		JPanel pointPanel5_4 = new JPanel();
		pointPanel5_4.setBackground(Color.ORANGE);
		pointPanel5_4.setBounds(223, 203, 18, 23);
		mainStatPanel.add(pointPanel5_4);
		
		JPanel pointPanel5_5 = new JPanel();
		pointPanel5_5.setBackground(Color.ORANGE);
		pointPanel5_5.setBounds(245, 203, 18, 23);
		mainStatPanel.add(pointPanel5_5);
		
		JPanel pointPanel5_6 = new JPanel();
		pointPanel5_6.setBackground(Color.ORANGE);
		pointPanel5_6.setBounds(267, 203, 18, 23);
		mainStatPanel.add(pointPanel5_6);
		
		JPanel pointPanel5_7 = new JPanel();
		pointPanel5_7.setBackground(Color.ORANGE);
		pointPanel5_7.setBounds(289, 203, 18, 23);
		mainStatPanel.add(pointPanel5_7);
		
		JPanel pointPanel5_8 = new JPanel();
		pointPanel5_8.setBackground(Color.ORANGE);
		pointPanel5_8.setBounds(311, 203, 18, 23);
		mainStatPanel.add(pointPanel5_8);
		
		JPanel pointPanel5_9 = new JPanel();
		pointPanel5_9.setBackground(Color.ORANGE);
		pointPanel5_9.setBounds(333, 203, 18, 23);
		mainStatPanel.add(pointPanel5_9);
		setSize(1107, 630);
		setLocationRelativeTo(null);		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);;
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(659, 31, 416, 277);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
	}

	public Map<String, ArrayList<BigInteger>> parseInfo(InfoVO infoVO) {
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

		return ret;

	}

	public void calculateInfo() {

		try {
			유동비율 = (parseInfo.get("bs_now").get(3)).doubleValue() 
					/ (parseInfo.get("bs_now").get(6)).doubleValue()
					* 100;
		} catch (NullPointerException ne) {
			유동비율 = null;
		} catch (Exception e) {
			System.out.println(e + " => 유동비율 에러");
		}

		try {
			부채비율 = (parseInfo.get("bs_now").get(2)).doubleValue() 
					/ (parseInfo.get("bs_now").get(1)).doubleValue()
					* 100;
		} catch (NullPointerException ne) {
			부채비율 = null;
		} catch (Exception e) {
			System.out.println(e + " => 부채비율 에러");
		}

		try {
			자기자본비율 = (parseInfo.get("bs_now").get(1)).doubleValue() 
					/ (parseInfo.get("bs_now").get(0)).doubleValue()
					* 100;
		} catch (NullPointerException ne) {
			자기자본비율 = null;
		} catch (Exception e) {
			System.out.println(e + " => 자기자본비율 에러");
		}

		try {
			매출증가율 = ((parseInfo.get("is_now").get(0)).doubleValue()
					/ (parseInfo.get("is_last").get(0)).doubleValue() - 1) * 100;
		} catch (NullPointerException ne) {
			매출증가율 = null;
		} catch (Exception e) {
			System.out.println(e + " => 매출증가율 에러");
		}

		try {
			영업이익증가율 = ((parseInfo.get("is_now").get(2)).doubleValue()
					/ (parseInfo.get("is_last").get(2)).doubleValue() - 1) * 100;
		} catch (NullPointerException ne) {
			영업이익증가율 = null;
		} catch (Exception e) {
			System.out.println(e + " => 영업이익증가율 에러");
		}

		try {
			EPS증가율 = ((parseInfo.get("is_now").get(7)).doubleValue()
					/ (parseInfo.get("is_last").get(7)).doubleValue() - 1) * 100;
		} catch (NullPointerException ne) {
			EPS증가율 = null;
		} catch (Exception e) {
			System.out.println(e + " => EPS증가율 에러");
		}

		try {
			매출총이익률 = (parseInfo.get("is_now").get(2)).doubleValue() 
					/ (parseInfo.get("is_now").get(3)).doubleValue()
					* 100;
		} catch (NullPointerException ne) {
			매출총이익률 = null;
		} catch (Exception e) {
			System.out.println(e + " => 매출총이익률 에러");
		}

		try {
			ROA = (parseInfo.get("is_now").get(5)).doubleValue() 
					/ (parseInfo.get("bs_now").get(0)).doubleValue()
					* 100;
		} catch (NullPointerException ne) {
			ROA = null;
		} catch (Exception e) {
			System.out.println(e + " => ROA 에러");
		}

		try {
			ROE = (parseInfo.get("is_now").get(5)).doubleValue() 
					/ (parseInfo.get("bs_now").get(1)).doubleValue()
					* 100;
		} catch (NullPointerException ne) {
			ROE = null;
		} catch (Exception e) {
			System.out.println(e + " => ROE 에러");
		}

		try {
			총자산회전률 = (parseInfo.get("is_now").get(0)).doubleValue() 
					/ (parseInfo.get("bs_now").get(0)).doubleValue()
					* 100;
		} catch (NullPointerException ne) {
			총자산회전률 = null;
		} catch (Exception e) {
			System.out.println(e + " => 총자산회전률 에러");
		}

		try {
			총부채회전률 = (parseInfo.get("is_now").get(0)).doubleValue() 
					/ (parseInfo.get("bs_now").get(2)).doubleValue()
					* 100;
		} catch (NullPointerException ne) {
			총부채회전률 = null;
		} catch (Exception e) {
			System.out.println(e + " => 총부채회전률 에러");
		}

		try {
			총자본회전률 = (parseInfo.get("is_now").get(0)).doubleValue() 
					/ (parseInfo.get("bs_now").get(1)).doubleValue()
					* 100;
		} catch (NullPointerException ne) {
			총자본회전률 = null;
		} catch (Exception e) {
			System.out.println(e + " => 총자본회전률 에러");
		}

		try {
			영업활동현금흐름 = parseInfo.get("cf_now").get(0).doubleValue();
		} catch (NullPointerException ne) {
			영업활동현금흐름 = null;
		} catch (Exception e) {
			System.out.println(e + " => 영업활동현금흐름 에러");
		}

		try {
			투자활동현금흐름 = parseInfo.get("cf_now").get(1).doubleValue();
		} catch (NullPointerException ne) {
			투자활동현금흐름 = null;
		} catch (Exception e) {
			System.out.println(e + " => 투자활동현금흐름 에러");
		}

		try {
			재무활동현금흐름 = parseInfo.get("cf_now").get(2).doubleValue();
		} catch (NullPointerException ne) {
			재무활동현금흐름 = null;
		} catch (Exception e) {
			System.out.println(e + " => 재무활동현금흐름 에러");
		}

	}
	
	public void chartView() {
		dataset = FiveChart.createDataset(infoVO);
		JFreeChart chart = FiveChart.createChart(dataset);
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setBackground(Color.WHITE);
		chartPanel.setBounds(240, 16, 389, 280);
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 500));
        contentPane.add(chartPanel);
		chartPanel.setLayout(null);
	}

	public static BigInteger strToBig(String info_str) {
		if (info_str.equals("NA"))
			return null;
		return new BigDecimal(info_str).toBigInteger();
	}
}
