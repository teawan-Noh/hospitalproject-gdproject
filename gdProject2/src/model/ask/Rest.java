package model.ask;

public class Rest {
	private int rcode;
	private int dcode;
	private String requestdate;
	private String approved;
	private String reason;
	private String restdate;
	private int day;
	
	public Rest() {}

	public Rest(int dcode, String reason, String restdate, int day) {

		super();
		this.restdate = restdate;
		this.day = day;
		this.dcode = dcode;
		this.reason = reason;
	}
	
	

	public Rest(int dcode, String reason, String restdate) {
		super();
		this.dcode = dcode;
		this.reason = reason;
		this.restdate = restdate;
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

	public String getRequestdate() {
		return requestdate;
	}

	public void setRequestdate(String requestdate) {
		this.requestdate = requestdate;
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

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	@Override
	public String toString() {
		return "Rest [rcode=" + rcode + ", dcode=" + dcode + ", requestdate=" + requestdate + ", approved=" + approved
				+ ", reason=" + reason + ", restdate=" + restdate + ", day=" + day + "]";
	}
	
	
	
}
