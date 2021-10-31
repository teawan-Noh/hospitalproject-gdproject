package model.board;

public class Files {
	private int fcode;
	private int ncode;
	private String uploaddate;
	private String name;
	private String beforename;
	private long filesize;
	
	public Files() {}
	
	public Files(int fcode, int ncode, String uploaddate, String name, String beforename, long filesize) {
		super();
		this.fcode = fcode;
		this.ncode = ncode;
		this.uploaddate = uploaddate;
		this.name = name;
		this.beforename = beforename;
		this.filesize = filesize;
	}
	
	
	public Files(int ncode,String name, String beforename, long filesize) {
		super();
		this.ncode = ncode;
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
	public long getFilesize() {
		return filesize;
	}
	public void setFilesize(long l) {
		this.filesize = l;
	}
	
	
	
}
