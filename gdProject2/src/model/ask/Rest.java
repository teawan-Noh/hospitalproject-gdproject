package model.ask;

public class Rest {
	private int rcode;
	private int acode;
	private String restdate;
	private String day;
	
	public Rest() {}
	
	public Rest(int rcode, int acode, String restdate, String day) {
		super();
		this.rcode = rcode;
		this.acode = acode;
		this.restdate = restdate;
		this.day = day;
	}
	public int getRcode() {
		return rcode;
	}
	public void setRcode(int rcode) {
		this.rcode = rcode;
	}
	public int getAcode() {
		return acode;
	}
	public void setAcode(int acode) {
		this.acode = acode;
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
