package model;

public class Qna {
	private int qno;
	private int pcode;
	private String title;
	private String content;
	private String writedate;
	private String img;
	private int cnt;
	
	public Qna() {}
	
	public Qna(int qno, int pcode, String title, String content, String writedate, String img, int cnt) {
		super();
		this.qno = qno;
		this.pcode = pcode;
		this.title = title;
		this.content = content;
		this.writedate = writedate;
		this.img = img;
		this.cnt = cnt;
	}
	public int getQno() {
		return qno;
	}
	public void setQno(int qno) {
		this.qno = qno;
	}
	public int getPcode() {
		return pcode;
	}
	public void setPcode(int pcode) {
		this.pcode = pcode;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWritedate() {
		return writedate;
	}
	public void setWritedate(String writedate) {
		this.writedate = writedate;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	
	
}
