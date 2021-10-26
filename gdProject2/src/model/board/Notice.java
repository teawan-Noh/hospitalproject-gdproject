package model.board;

public class Notice {
	private int ncode;
	private int mcode;
	private String title;
	private String content;
	private String writedate;
	private int cnt;
	
	public Notice() {}
	
	public Notice(int ncode, int mcode, String title, String content, String writedate, int cnt) {
		super();
		this.ncode = ncode;
		this.mcode = mcode;
		this.title = title;
		this.content = content;
		this.writedate = writedate;
		this.cnt = cnt;
	}
	public int getNcode() {
		return ncode;
	}
	public void setNcode(int ncode) {
		this.ncode = ncode;
	}
	public int getMcode() {
		return mcode;
	}
	public void setMcode(int mcode) {
		this.mcode = mcode;
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
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	
	
	
}
