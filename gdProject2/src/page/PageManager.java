package page;

public class PageManager {
	private int requestPage;

	public PageManager() {}

	public PageManager(int requestPage) {
		this.requestPage = requestPage;
	}
	
	public PageRowResult getPageRowResult() {
		// 변수 값 계산해서 넣기
		//private int rowStartNumber; // 화면에 보여줄 시작 줄 번호
		//private int rowEndNumber; // 화면에 보여줄 마지막 줄 번호
		
		PageRowResult prr = new PageRowResult();
		
		prr.setRowStartNumber((requestPage - 1) * PageInfo.ROW_COUNT_PAGE + 1);
		prr.setRowEndNumber(requestPage * PageInfo.ROW_COUNT_PAGE);
		
		return prr;
	}
	
	public PageGroupResult getPageGroupResult(int cnt) {


		PageGroupResult pgr = new PageGroupResult();
		
		int reqPageGroupNumber = (requestPage - 1) / PageInfo.SHOW_PAGE_COUNT + 1;
		
		pgr.setSelectPageNumber(this.requestPage);
		pgr.setGroupStartNumber((reqPageGroupNumber - 1) * PageInfo.SHOW_PAGE_COUNT + 1);
		pgr.setGroupEndNumber(reqPageGroupNumber * PageInfo.SHOW_PAGE_COUNT);
		
		
		
		if(pgr.getGroupStartNumber() == 1) {
			pgr.setBeforePage(false);
		}
		
		int totalPageNumber = (cnt - 1) / PageInfo.ROW_COUNT_PAGE + 1;

		if(pgr.getGroupEndNumber() > totalPageNumber) {
			pgr.setGroupEndNumber(totalPageNumber);
		}
		if(pgr.getGroupEndNumber() == totalPageNumber) {
			pgr.setAfterPage(false);
		}
		
		
		return pgr;
	}
	
	public static void main(String[] args) {
		//System.out.println((12 - 1) / 3 + 1);
		PageManager pm = new PageManager(3);
		PageRowResult prr = pm.getPageRowResult();
		System.out.println(prr.getRowStartNumber());
		System.out.println(prr.getRowEndNumber());
		
		PageGroupResult pgr = pm.getPageGroupResult(12);
		System.out.println(pgr.getGroupStartNumber());
		System.out.println(pgr.getGroupEndNumber());
	}
	
}
