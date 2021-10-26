package page;

public class PageGroupResult {
	private int groupStartNumber; // 링크 시작 번호
	private int groupEndNumber; // 링크 끝 번호
	
	private boolean beforePage = true; // 이전 링크 존재 여부
	private boolean afterPage = true; // 다음 링크 존재 여부
	
	private int selectPageNumber; // 현재 페이지
	
	public int getGroupStartNumber() {
		return groupStartNumber;
	}
	public void setGroupStartNumber(int groupStartNumber) {
		this.groupStartNumber = groupStartNumber;
	}
	public int getGroupEndNumber() {
		return groupEndNumber;
	}
	public void setGroupEndNumber(int groupEndNumber) {
		this.groupEndNumber = groupEndNumber;
	}
	public boolean isBeforePage() {
		return beforePage;
	}
	public void setBeforePage(boolean beforePage) {
		this.beforePage = beforePage;
	}
	public boolean isAfterPage() {
		return afterPage;
	}
	public void setAfterPage(boolean afterPage) {
		this.afterPage = afterPage;
	}
	public int getSelectPageNumber() {
		return selectPageNumber;
	}
	public void setSelectPageNumber(int selectPageNumber) {
		this.selectPageNumber = selectPageNumber;
	}
	
	
	
}
