package model.ask;

public class Rest {
	private int rcode;
	private int dcode;
	private String approvedate;
	private String approved;
	private String reason;
	private String restdate;
	private String day;
	
	public Rest() {}
	
	public Rest(int rcode, int dcode, String approvedate, String approved, String reason) {
		super();
		this.rcode = rcode;
		this.dcode = dcode;
		this.approvedate = approvedate;
		this.approved = approved;
		this.reason = reason;
	}

	public int getRcode() {
		return rcode;
	}

	public void setRcode(int rcode) {
		this.rcode = rcode;
	}

	public int getDcode() {
		return dcode;
	}

	public void setDcode(int dcode) {
		this.dcode = dcode;
	}

	public String getApprovedate() {
		return approvedate;
	}

	public void setApprovedate(String approvedate) {
		this.approvedate = approvedate;
	}

	public String getApproved() {
		return approved;
	}

	public void setApproved(String approved) {
		this.approved = approved;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getRestdate() {
		return restdate;
	}

	public void setRestdate(String restdate) {
		this.restdate = restdate;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}
	
	
	
}
