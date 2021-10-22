package model;

public class Subject {
	private int scode;
	private String name;
	private String description;
	private String tel;
	
	public Subject() {}
	
	public Subject(int scode, String name, String description, String tel) {
		super();
		this.scode = scode;
		this.name = name;
		this.description = description;
		this.tel = tel;
	}

	public int getScode() {
		return scode;
	}

	public void setScode(int scode) {
		this.scode = scode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
	
	
}
