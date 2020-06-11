package hd.vo;

public class InfoVO {
	private int comCode;
	private int[] bs;
	private int[] is;
	private int[] cf;
	
	public InfoVO() {
		super();
	}
	
	public InfoVO(int comCode, int[] bs, int[] is, int[] cf) {
		super();
		this.comCode = comCode;
		this.bs = bs;
		this.is = is;
		this.cf = cf;
	}
	public int getComCode() {
		return comCode;
	}
	public void setComCode(int comCode) {
		this.comCode = comCode;
	}
	public int[] getBs() {
		return bs;
	}
	public void setBs(int[] bs) {
		this.bs = bs;
	}
	public int[] getIs() {
		return is;
	}
	public void setIs(int[] is) {
		this.is = is;
	}
	public int[] getCf() {
		return cf;
	}
	public void setCf(int[] cf) {
		this.cf = cf;
	}	
}
