package common.page;

public class PageManager2 {
private int requestPage; //1
	
	public PageManager2() {}
	
	public PageManager2(int requestPage) {
		
		this.requestPage = requestPage;
	}
	
	public PageRowResult getPageRowResult() {
		PageRowResult pageRowResult = new PageRowResult();
		//변수값 계산해서 넣기
		//private int rowStartNumber; //화면에 보여줄 시작 줄번호
		//private int rowEndNumber;  //화면에 보여줄 끝 줄번호
		pageRowResult.setRowStartNumber((PageInfo.ROW_COUNT_PAGE*requestPage) - (PageInfo.ROW_COUNT_PAGE - 1)); //1
//		pageRowResult.setRowStartNumber((requestPage-1)*PageInfo.ROW_COUNT_PER_PAGE+1); //1
		pageRowResult.setRowEndNumber((PageInfo.ROW_COUNT_PAGE*requestPage)); //5
		
		return pageRowResult;
		
	}
	
	public PageGroupResult getPageGroupResult(int cnt) {
		//변수값 계산해서 넣기
		//3개씩 보여줄거다
		//[1,2,3]다음
		//이전[4,5,6]다음
		//이전[7,8,9]다음
		//이전[10,11]
		//private int groupStartNumber; //링크 시작번호
		//private int groupEndNumber; //링크 끝번호
		PageGroupResult pgr = new PageGroupResult();
		int reqPageGroupNumber =  (int)Math.ceil((double)requestPage/PageInfo.SHOW_PAGE_COUNT); 
		pgr.setGroupStartNumber((reqPageGroupNumber * PageInfo.SHOW_PAGE_COUNT) - (PageInfo.SHOW_PAGE_COUNT-1));
		pgr.setGroupEndNumber(reqPageGroupNumber * PageInfo.SHOW_PAGE_COUNT);
		
		//ex)22줄 2줄씩 =>링크:11개 링크그룹 3개씩 
		int totalPageNumber = (int)Math.ceil((double)cnt/PageInfo.ROW_COUNT_PAGE);
		System.out.println(cnt + "확인여기");
		System.out.println(totalPageNumber + "확인여기2");
		if(pgr.getGroupEndNumber() > totalPageNumber) {
			pgr.setGroupEndNumber(totalPageNumber);
		}
		
		//private boolean beforePage = true; //이전 링크
		if(pgr.getGroupStartNumber() == 1) {
			pgr.setBeforePage(false);
		}
		//private boolean afterPage = true; //다음 링크
		if(pgr.getGroupEndNumber() == totalPageNumber) {
			pgr.setAfterPage(false);
		}
		//private int selectPageNumber;  //현재 페이지
		pgr.setSelectPageNumber(requestPage);
		
		return pgr;
	}
	
}
