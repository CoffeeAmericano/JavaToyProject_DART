package hd.vo;

public class InfoVO {
	private String comCode;
	private String bs_last;
	private String is_last;
	private String cf_last;
	private String bs_now;
	private String is_now;
	private String cf_now;
	
	
	public InfoVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public InfoVO(String comCode, String bs_last, String is_last, String cf_last, String bs_now, String is_now,
			String cf_now) {
		super();
		this.comCode = comCode;
		this.bs_last = bs_last;
		this.is_last = is_last;
		this.cf_last = cf_last;
		this.bs_now = bs_now;
		this.is_now = is_now;
		this.cf_now = cf_now;
	}

	public String getComCode() {
		return comCode;
	}
	public void setComCode(String comCode) {
		this.comCode = comCode;
	}
	public String getBs_now() {
		return bs_now;
	}
	public void setBs_now(String bs_now) {
		this.bs_now = bs_now;
	}
	public String getIs_now() {
		return is_now;
	}
	public void setIs_now(String is_now) {
		this.is_now = is_now;
	}
	public String getCf_now() {
		return cf_now;
	}
	public void setCf_now(String cf_now) {
		this.cf_now = cf_now;
	}
	public String getBs_last() {
		return bs_last;
	}
	public void setBs_last(String bs_last) {
		this.bs_last = bs_last;
	}
	public String getIs_last() {
		return is_last;
	}
	public void setIs_last(String is_last) {
		this.is_last = is_last;
	}
	public String getCf_last() {
		return cf_last;
	}
	public void setCf_last(String cf_last) {
		this.cf_last = cf_last;
	}
	
}

