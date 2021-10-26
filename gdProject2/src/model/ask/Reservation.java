package model.ask;

public class Reservation {
	private int rcode;
	private int pcode;
	private int dcode;
	private String rsvdate;
	private String state;
	
	public Reservation() {}
		
	public Reservation(int rcode, int pcode, int dcode, String rsvdate, String state) {
		super();
		this.rcode = rcode;
		this.pcode = pcode;
		this.dcode = dcode;
		this.rsvdate = rsvdate;
		this.state = state;
	}
	public int getRcode() {
		return rcode;
	}
	public void setRcode(int rcode) {
		this.rcode = rcode;
	}
	public int getPcode() {
		return pcode;
	}
	public void setPcode(int pcode) {
		this.pcode = pcode;
	}
	public int getDcode() {
		return dcode;
	}
	public void setDcode(int dcode) {
		this.dcode = dcode;
	}
	public String getRsvdate() {
		return rsvdate;
	}
	public void setRsvdate(String rsvdate) {
		this.rsvdate = rsvdate;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	
	
}
