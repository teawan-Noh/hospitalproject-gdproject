package model;

public class files {
	private int fcode;
	private int ncode;
	private String uploaddate;
	private String name;
	private String beforename;
	private int filesize;
	
	public files() {}
	
	public files(int fcode, int ncode, String uploaddate, String name, String beforename, int filesize) {
		super();
		this.fcode = fcode;
		this.ncode = ncode;
		this.uploaddate = uploaddate;
		this.name = name;
		this.beforename = beforename;
		this.filesize = filesize;
	}
	public int getFcode() {
		return fcode;
	}
	public void setFcode(int fcode) {
		this.fcode = fcode;
	}
	public int getNcode() {
		return ncode;
	}
	public void setNcode(int ncode) {
		this.ncode = ncode;
	}
	public String getUploaddate() {
		return uploaddate;
	}
	public void setUploaddate(String uploaddate) {
		this.uploaddate = uploaddate;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBeforename() {
		return beforename;
	}
	public void setBeforename(String beforename) {
		this.beforename = beforename;
	}
	public int getFilesize() {
		return filesize;
	}
	public void setFilesize(int filesize) {
		this.filesize = filesize;
	}
	
	
	
}
