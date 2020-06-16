package hd.view;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Map;

import javax.swing.JFrame;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardCategoryToolTipGenerator;
import org.jfree.chart.plot.SpiderWebPlot;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import hd.vo.InfoVO;

public class FiveChart {
	
	private String company;	    
	// 1자산규모, 2부채등급, 3ROA등급, 4자기자본비율, 5유동비율등급
	private static String category[] = {"자산규모", "부채점수","ROA","자기자본비율", "유동비율"};
    private int[] category_value;

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public int[] getCategory_value() {
		return category_value;
	}

	public void setCategory_value(int[] category_value) {
		this.category_value = category_value;
	}

	public CategoryDataset createDataset(InfoVO infoVO) {
		
		FiveChart f = new FiveChart();
		int[] v = new int[5];
		f.setCategory_value(new int[5]);
		f.setCompany(infoVO.getComName());
	   
	    Page p = new Page();
	    p.parseInfo(infoVO);
	    
	    try {
	    Long 총자산 = p.getParseInfo().get("bs_now").get(0).longValue();
	    if(총자산 >= 5000000000000L) f.getCategory_value()[0] = 9;
	    else if(총자산 >= 500000000000L) f.getCategory_value()[0]= 6;
	    else f.getCategory_value()[0] = 3;
	    } catch (Exception e) {
	    	f.getCategory_value()[0] = 0;
	    }
	    
	    
	    try {
	    Double 부채비율 = Page.부채비율;
	    if(부채비율 < 50) f.getCategory_value()[1] = 9;
	    else if( 50 <= 부채비율 && 부채비율 < 90) f.getCategory_value()[1] = 7;
	    else if( 90 <= 부채비율 && 부채비율 < 110) f.getCategory_value()[1] = 5;
	    else if( 110 <= 부채비율 && 부채비율 < 150) f.getCategory_value()[1] = 3;
	    else f.getCategory_value()[1] = 1;
	    } catch (Exception e) {
	    	f.getCategory_value()[1] = 0;
	    }
	    
	   
	    try {
	    	 Double ROA = Page.ROA;	    	
	    if (ROA < 70) f.getCategory_value()[2] = 9;
	    else if (ROA < 50) f.getCategory_value()[2] = 8;
	    else if (ROA < 20) f.getCategory_value()[2] = 7;
	    else if (ROA < 0) f.getCategory_value()[2] = 5;
	    else if (ROA < -20) f.getCategory_value()[2] = 4;
	    else if (ROA < -50) f.getCategory_value()[2] = 3;
	    else if (ROA < -70) f.getCategory_value()[2] = 2;
	    else f.getCategory_value()[2] = 1;
	    } catch (Exception e) {
	    	f.getCategory_value()[2] = 0;
	    }
	    
	        
	    try {
	    	Double 자기자본 = Page.자기자본비율;	
	    if (자기자본 > 70) f.getCategory_value()[3] = 9;
	    else if (자기자본 > 50) f.getCategory_value()[3] = 7;
	    else if (자기자본 > 30) f.getCategory_value()[3] = 5;
	    else if (자기자본 > 10) f.getCategory_value()[3] = 3;
	    else f.getCategory_value()[3] = 2;
	    } catch (Exception e) {
	    	f.getCategory_value()[3] = 0;
	    }
	    
	    	    
	    try {
	    	Double 유동비율 = Page.유동비율;
	    if (유동비율 > 200) f.getCategory_value()[4] = 9;
	    else if (유동비율 > 180) f.getCategory_value()[4] = 7;
	    else if (유동비율 > 150) f.getCategory_value()[4] = 6;
	    else if (유동비율 > 130) f.getCategory_value()[4] = 4;
	    else if (유동비율 > 100) f.getCategory_value()[4] = 3;
	    else f.getCategory_value()[4] = 2;
	    } catch(Exception e) {
	    	f.getCategory_value()[4] = 0;
	    }
	    
	    //데이터 집합을 만듦
	    DefaultCategoryDataset dataset = new DefaultCategoryDataset();
	    
	    for(int i = 0; i<f.getCategory_value().length; i++) {
	    	if(f.getCategory_value()[i] != 0) {
	    		dataset.addValue(f.getCategory_value()[i], f.getCompany(), category[i]);
	    	}
	    }
	    return dataset;
	}
	
	public JFreeChart createChart(CategoryDataset dataset) {
	    SpiderWebPlot plot = new SpiderWebPlot(dataset);
	    plot.setStartAngle(90);
	    plot.setInteriorGap(0.40);
	    plot.setToolTipGenerator(new StandardCategoryToolTipGenerator());
	    JFreeChart chart = new JFreeChart("주요 지표",
	    TextTitle.DEFAULT_FONT, plot, false);
	    LegendTitle legend = new LegendTitle(plot);
	    chart.addSubtitle(legend);  
	    return chart;  
	}
	
}
