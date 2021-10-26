package model.ask;

public class Approval {
	private int acode;
	private int dcode;
	private String approvedate;
	private String approved;
	private String reason;
	
	public Approval() {}
	
	public Approval(int acode, int dcode, String approvedate, String approved, String reason) {
		super();
		this.acode = acode;
		this.dcode = dcode;
		this.approvedate = approvedate;
		this.approved = approved;
		this.reason = reason;
	}

	public int getAcode() {
		return acode;
	}

	public void setAcode(int acode) {
		this.acode = acode;
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
	
	
	
}
