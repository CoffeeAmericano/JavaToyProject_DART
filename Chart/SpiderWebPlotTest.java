import javax.swing.JFrame;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardCategoryToolTipGenerator;
import org.jfree.chart.plot.SpiderWebPlot;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.RefineryUtilities;

public class Test extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static void main(String[] args) {
	    Test demo = new Test("sibal");
	    demo.pack();
	    RefineryUtilities.centerFrameOnScreen(demo);
	    demo.setVisible(true);
	}
	
	public Test(String title) {
		CategoryDataset dataset = createDataset();
		JFreeChart chart = createChart(dataset);
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
        setContentPane(chartPanel);
}

	private static CategoryDataset createDataset() {
		//계열
	    String company = "엔코아";
	    String company2 = "엔코아2";
	    //항목
	    String category1 = "안정성";
	    String category2 = "성장성";
	    String category3 = "수익성";
	    String category4 = "활동성";
	    String category5 = "배기성";
	 
	    //데이터 집합을 만듦
	    DefaultCategoryDataset dataset = new DefaultCategoryDataset();
	 
	    dataset.addValue(9.0, company, category1);
	    dataset.addValue(9.0, company, category2);
	    dataset.addValue(9.0, company, category3);
	    dataset.addValue(9.0, company, category4);
	    dataset.addValue(9.0, company, category5);
	    
	    dataset.addValue(3.0, company2, category1);
	    dataset.addValue(2.0, company2, category2);
	    dataset.addValue(6.0, company2, category3);
	    dataset.addValue(3.0, company2, category4);
	    dataset.addValue(7.0, company2, category5);
	    
	    return dataset;
	}
	private static JFreeChart createChart(CategoryDataset dataset) {
	    SpiderWebPlot plot = new SpiderWebPlot(dataset);
	    plot.setStartAngle(90);
	    plot.setInteriorGap(0.40);
	    plot.setToolTipGenerator(new StandardCategoryToolTipGenerator());
	    JFreeChart chart = new JFreeChart("개같은 오망성",
	    TextTitle.DEFAULT_FONT, plot, false);
	    LegendTitle legend = new LegendTitle(plot);
	    chart.addSubtitle(legend);  
	    return chart;  
	}
}
