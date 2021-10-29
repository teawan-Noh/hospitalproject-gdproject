package model.board;

public class Comments {
	private int qno;
	private int mcode;
	private String writedate;
	private String content;
	
	public Comments() {}
	
	public Comments(int qno, int mcode, String content) {
		super();
		this.qno = qno;
		this.mcode = mcode;
		this.content = content;
	}

	public Comments(int qno, int mcode, String writedate, String content) {
		super();
		this.qno = qno;
		this.mcode = mcode;
		this.writedate = writedate;
		this.content = content;
	}
	public int getQno() {
		return qno;
	}
	public void setQno(int qno) {
		this.qno = qno;
	}
	public int getMcode() {
		return mcode;
	}
	public void setMcode(int mcode) {
		this.mcode = mcode;
	}
	public String getWritedate() {
		return writedate;
	}
	public void setWritedate(String writedate) {
		this.writedate = writedate;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
}
