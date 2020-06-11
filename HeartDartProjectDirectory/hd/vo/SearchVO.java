package hd.vo;

public class SearchVO {
	private int comCode;
	private String comName;
	private String industryName;
	private int year;
	private int quarter;

	public SearchVO() {
		super();
	}

	public SearchVO(int comCode, String comName, String industryName, int year, int quarter) {
		super();
		this.comCode = comCode;
		this.comName = comName;
		this.industryName = industryName;
		this.year = year;
		this.quarter = quarter;
	}

	public int getComCode() {
		return comCode;
	}

	public void setComCode(int comCode) {
		this.comCode = comCode;
	}

	public String getComName() {
		return comName;
	}

	public void setComName(String comName) {
		this.comName = comName;
	}

	public String getIndustryName() {
		return industryName;
	}

	public void setIndustryName(String industryName) {
		this.industryName = industryName;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getQuarter() {
		return quarter;
	}

	public void setQuarter(int quarter) {
		this.quarter = quarter;
	}

}
