package hd.vo;

public class InfoVO {
	private String comCode;
	private String bs;
	private String is;
	private String cf;
	
	public InfoVO() {
		super();
	}
	public InfoVO(String comCode, String bs, String is, String cf) {
		super();
		this.comCode = comCode;
		this.bs = bs;
		this.is = is;
		this.cf = cf;
	}
	public String getComCode() {
		return comCode;
	}
	public void setComCode(String comCode) {
		this.comCode = comCode;
	}
	public String getBs() {
		return bs;
	}
	public void setBs(String bs) {
		this.bs = bs;
	}
	public String getIs() {
		return is;
	}
	public void setIs(String is) {
		this.is = is;
	}
	public String getCf() {
		return cf;
	}
	public void setCf(String cf) {
		this.cf = cf;
	}
}
