package model.user;

public class Patient {
	private int pcode;
	private String id;
	private String pw;
	private String nickname;
	private String name;
	private String tel;
	private String birth;
	private String gender;
	private String email;
	private int postcode;
	private String address;
	private String address2;
	
	public Patient() {}
	
	public Patient(int pcode, String id, String pw, String nickname, String name, String tel, String birth,
			String gender, String email, int postcode, String address, String address2) {
		this.pcode = pcode;
		this.id = id;
		this.pw = pw;
		this.nickname = nickname;
		this.name = name;
		this.tel = tel;
		this.birth = birth;
		this.gender = gender;
		this.email = email;
		this.postcode = postcode;
		this.address = address;
		this.address2 = address2;
	}
	
	
	//회원가입용
	public Patient(String id, String pw, String nickname, String name, String tel, String birth, String gender,
			String email, int postcode, String address, String address2) {
		super();
		this.id = id;
		this.pw = pw;
		this.nickname = nickname;
		this.name = name;
		this.tel = tel;
		this.birth = birth;
		this.gender = gender;
		this.email = email;
		this.postcode = postcode;
		this.address = address;
		this.address2 = address2;
	}
	
	//update용
	public Patient(int pcode,String pw, String nickname, String tel, String email, int postcode, String address,
			String address2) {
		super();
		this.pcode = pcode;
		this.pw = pw;
		this.nickname = nickname;
		this.tel = tel;
		this.email = email;
		this.postcode = postcode;
		this.address = address;
		this.address2 = address2;
	}

	public int getPcode() {
		return pcode;
	}
	

	public void setPcode(int pcode) {
		this.pcode = pcode;
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
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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


	@Override
	public String toString() {
		return "Patient [pcode=" + pcode + ", id=" + id + ", pw=" + pw + ", nickname=" + nickname + ", name=" + name
				+ ", tel=" + tel + ", birth=" + birth + ", gender=" + gender + ", email=" + email + ", postcode="
				+ postcode + ", address=" + address + ", address2=" + address2 + "]";
	}

}
