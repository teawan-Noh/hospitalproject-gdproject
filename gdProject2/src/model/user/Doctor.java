package model.user;

public class Doctor {
	private int dcode;
	private int scode;
	private String id;
	private String pw;
	private String name;
	private String birth;
	private int licenseno;
	private int postcode;
	private String address;
	private String address2;
	private String career;
	private String tel;
	private String email;
	
	public Doctor() {}
	
	public Doctor(int dcode, int scode, String id, String pw, String name, String birth, int licenseno, int postcode,
			String address, String address2, String career, String tel, String email) {
		super();
		this.dcode = dcode;
		this.scode = scode;
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.birth = birth;
		this.licenseno = licenseno;
		this.postcode = postcode;
		this.address = address;
		this.address2 = address2;
		this.career = career;
		this.tel = tel;
		this.email = email;
	}
	
	
	public Doctor(int scode, String id, String pw, String name, String birth, int licenseno, int postcode,
			String address, String address2, String career, String tel, String email) {
		super();
		this.scode = scode;
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.birth = birth;
		this.licenseno = licenseno;
		this.postcode = postcode;
		this.address = address;
		this.address2 = address2;
		this.career = career;
		this.tel = tel;
		this.email = email;
	}
	
	

	public Doctor(int dcode, String pw, int postcode, String address, String address2, String career, String tel,
			String email) {
		super();
		this.dcode = dcode;
		this.pw = pw;
		this.postcode = postcode;
		this.address = address;
		this.address2 = address2;
		this.career = career;
		this.tel = tel;
		this.email = email;
	}

	public int getDcode() {
		return dcode;
	}
	public void setDcode(int dcode) {
		this.dcode = dcode;
	}
	public int getScode() {
		return scode;
	}
	public void setScode(int scode) {
		this.scode = scode;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public int getLicenseno() {
		return licenseno;
	}
	public void setLicenseno(int licenseno) {
		this.licenseno = licenseno;
	}
	public int getPostcode() {
		return postcode;
	}
	public void setPostcode(int postcode) {
		this.postcode = postcode;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getCareer() {
		return career;
	}
	public void setCareer(String career) {
		this.career = career;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Doctor [dcode=" + dcode + ", scode=" + scode + ", id=" + id + ", pw=" + pw + ", name=" + name
				+ ", birth=" + birth + ", licenseno=" + licenseno + ", postcode=" + postcode + ", address=" + address
				+ ", address2=" + address2 + ", career=" + career + ", tel=" + tel + ", email=" + email + "]";
	}
	
	
}
