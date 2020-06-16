package hd.view;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.CategoryDataset;

import java.util.*;

import hd.biz.SearchBIZ;
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
	private JPanel mainStatPanel;
	private CategoryDataset dataset;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_2;
	private JLabel lblRoa;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JPanel contentPane;
	private InfoVO infoVO;
	private JLabel heartPointLabel;
	private JPanel tablePanel;
	private JScrollPane scrollPane;
	
	
	public static Map<String, ArrayList<BigInteger>> parseInfo;
	static Double 유동비율, 부채비율, 자기자본비율; // 안정성비율 지표
	static Double 매출증가율, 영업이익증가율, EPS증가율; // 성장성비율 지표
	static Double 매출총이익률, ROA, ROE; // 수익성비율 지표
	static Double 총자산회전률, 총부채회전률, 총자본회전률; // 활동성 비율 지표
	static Double 영업활동현금흐름, 재무활동현금흐름, 투자활동현금흐름; // 운용성 지표
	private JTable table;
	private JPanel panel;
	private JPanel tab1_1;
	private JTabbedPane tabpane;
	private JTextArea textArea;
	private JScrollPane scrollPane_1;
	private JTable table_1;
	private JScrollPane scrollPane_2;

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
	
	public CategoryDataset getDataset() {
		return dataset;
	}

	public void setDataset(CategoryDataset dataset) {
		this.dataset = dataset;
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
		
		panel = new JPanel();
		panel.setBounds(644, 263, 408, -208);
		contentPane.add(panel);
		panel.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 398, -172);
		panel.add(scrollPane);

		sidePanel = new Panel();
		sidePanel.setBounds(0, 0, 234, 575);
		sidePanel.setBackground(Color.BLACK);
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
		
		mainStatPanel = new JPanel();
		mainStatPanel.setBounds(242, 320, 398, 251);
		mainStatPanel.setBackground(Color.BLACK);
		contentPane.add(mainStatPanel);
		mainStatPanel.setLayout(null);
		
		
		lblNewLabel = new JLabel("\uC790\uC0B0\uADDC\uBAA8");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 19));
		lblNewLabel.setBounds(23, 28, 120, 30);
		mainStatPanel.add(lblNewLabel);
		
		lblNewLabel_2 = new JLabel("\uBD80\uCC44\uBE44\uC728\uC810\uC218");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("맑은 고딕", Font.BOLD, 19));
		lblNewLabel_2.setBounds(23, 70, 120, 30);
		mainStatPanel.add(lblNewLabel_2);
		
		lblRoa = new JLabel("ROA\uC810\uC218");
		lblRoa.setForeground(Color.WHITE);
		lblRoa.setFont(new Font("맑은 고딕", Font.BOLD, 19));
		lblRoa.setBounds(23, 112, 120, 30);
		mainStatPanel.add(lblRoa);
		
		lblNewLabel_4 = new JLabel("\uC790\uAE30\uC790\uBCF8\uBE44\uC728");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("맑은 고딕", Font.BOLD, 19));
		lblNewLabel_4.setBounds(23, 154, 120, 30);
		mainStatPanel.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("\uC720\uB3D9\uBE44\uC728\uC810\uC218");
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setFont(new Font("맑은 고딕", Font.BOLD, 19));
		lblNewLabel_5.setBounds(23, 196, 120, 30);
		mainStatPanel.add(lblNewLabel_5);
		
		tabpane = new JTabbedPane();
	      tabpane.setBackground(Color.WHITE);
	      tabpane.setSize(430, 272);
	      tabpane.setLocation(644, 299);
	      contentPane.add(tabpane);

	      tab1_1 = new JPanel();
	      tab1_1.setToolTipText("");
	      tab1_1.setBackground(Color.WHITE);
	      tabpane.add("안전성", tab1_1);
	      tab1_1.setLayout(null);
	      
	      scrollPane_1 = new JScrollPane();
	      scrollPane_1.setBounds(0, 0, 420, 240);
	      tab1_1.add(scrollPane_1);
	      
	      textArea = new JTextArea();
	      textArea.setForeground(Color.WHITE);
	      textArea.setFont(new Font("돋움", Font.BOLD, 19));
	      textArea.setBackground(Color.BLACK);
	      textArea.setLineWrap(true);
	      textArea.setEditable(false);
	      scrollPane_1.setViewportView(textArea);
	      tabpane.setBackgroundAt(0, Color.WHITE);
	      
	      scrollPane_2 = new JScrollPane();
	      scrollPane_2.setBounds(644, 37, 430, 250);
	      contentPane.add(scrollPane_2);
	      
	      table_1 = new JTable();
	      scrollPane_2.setViewportView(table_1);
	      
		
		setSize(1107, 630);
		setLocationRelativeTo(null);		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
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
			EPS증가율 = null;
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
	
	public void View() {
		FiveChart f = new FiveChart();
		dataset = f.createDataset(infoVO);
		JFreeChart chart = f.createChart(dataset);
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setBackground(Color.WHITE);
		chartPanel.setBounds(240, 16, 389, 280);
        chartPanel.setPreferredSize(new java.awt.Dimension(0, 0));
        contentPane.add(chartPanel);
		chartPanel.setLayout(null);
		
		for(int i =0; i<dataset.getColumnCount(); i++) {
			int n = dataset.getValue(0, i).intValue();
			while(n > 0) {
				heartPointLabel = new JLabel("New label");
				heartPointLabel.setIcon(new ImageIcon(Page.class.getResource("/hd/view/pointHeart.png")));
				heartPointLabel.setBounds(166 + (9-n)*22, 34 + 40*i, 30, 29);
				mainStatPanel.add(heartPointLabel);
				n--;
			}
		}
		
		String[] name = { "Type", "Stat", "Value" };
		DefaultTableModel dt = new DefaultTableModel(name, 0) {
			public boolean isCellEditable(int i, int c) {
				return false;
			}
		};
		
		Object[][] data = {
			{"안정성","유동비율",String.format("%7.3f", Page.유동비율)},
			{"안정성","부채비율",Page.부채비율},
			{"안정성","자기자본비율",Page.자기자본비율},
			{"성장성","매출증가율",Page.매출증가율},
			{"성장성","영업이익증가율",Page.영업이익증가율},
			{"성장성","EPS증가율",Page.EPS증가율},
			{"수익성","매출총이익률",Page.매출총이익률},
			{"수익성","ROA",Page.ROA},
			{"수익성","ROE",Page.ROE},
			{"활동성","총자산회전률",Page.총자산회전률},
			{"활동성","총부채회전률",Page.총부채회전률},
			{"활동성","총자본회전률",Page.총자본회전률},
			{"운용성","영업활동현금흐름",Page.영업활동현금흐름},
			{"운용성","재무활동현금흐름",Page.재무활동현금흐름},
			{"운용성","투자활동현금흐름",Page.투자활동현금흐름}};
		
		for(Object[] r : data) {
			dt.addRow(r);
		}
		
		table_1 = new JTable(dt);
		scrollPane_2.setViewportView(table_1);
		
		if (dt.getRowCount() > 0)
			table_1.setRowSelectionInterval(0, 0);
		
		// 종목별 평가
		
		String stable_str = "";
		if(dataset.getValue(0, 0).intValue() == 9) {
			stable_str += "이 회사는 자산규모 5조를 상회하는 대기업으로 "; 		
		}else if(dataset.getValue(0, 0).intValue() == 6) {
			stable_str += "이 회사는 자산규모 5천억을 상회하는 중견기업으로 ";
		}else if(dataset.getValue(0, 0).intValue() == 3) {
			stable_str += "이 회사는 자산규모 5천억 미만의 중소기업으로 ";
		}else {
			stable_str += "이 회사는 ";
		}
		
		if(dataset.getValue(0, 4).intValue() == 9) {
			stable_str += "유동비율이 200%수준을 넘어 부채에 대한 지급능력이 월등히 높고 "; 		
		}else if(dataset.getValue(0, 4).intValue() == 7) {
			stable_str += "유동비율이 180%수준을 넘어 부채에 대한 지급능력이 높고 ";
		}else if(dataset.getValue(0, 4).intValue() == 6) {
			stable_str += "유동비율이 150%수준으로 부채에 대한 지급능력이 높고 ";
		}else if(dataset.getValue(0, 4).intValue() == 4) {
			stable_str += "유동비율이 130%수준으로 부채에 대한 지급능력이 평이하고 ";
		}else if(dataset.getValue(0, 4).intValue() == 3) {
			stable_str += "유동비율이 100%에 가까운 수준으로 부채에 대한 지급능력이 낮고 ";
		}else if(dataset.getValue(0, 4).intValue() == 2) {
			stable_str += "유동비율이 100%에 미치지 못하는 수준으로 부채에 대한 지급능력이 매우 낮고 ";
		}else {
			stable_str += "";
		}
		
		if(dataset.getValue(0, 1).intValue() >= 5) {
			stable_str += "부채비율이 90%미만으로 타인자본의존도가 낮고 "; 		
		}else if(dataset.getValue(0, 1).intValue() < 5) {
			stable_str += "부채비율이 90%이상으로 타인자본의존도가 높고 ";
		}else {
			stable_str += "";
		}
		
		if(dataset.getValue(0, 3).intValue() >= 7) {
			stable_str += "자기자본비율이 50%이상으로 매우 안정적인 재무구조를 보인다."; 		
		}else if(dataset.getValue(0, 4).intValue() >= 5) {
			stable_str += "자기자본비율이 30%이상으로 안정적인 재무구조를 보인다.";
		}else if(dataset.getValue(0, 4).intValue() < 3) {
			stable_str += "자기자본비율이 30%미만으로 불안정한 재무구조를 보인다.";
		}else {
			stable_str += "";
		}
		textArea.setText(stable_str);
		textArea.setBounds(644, 299 , 409, 380);
		
	}
	
	public static BigInteger strToBig(String info_str) {
		if (info_str.equals("NA"))
			return null;
		return new BigDecimal(info_str).toBigInteger();
	}
}
