package dao;

import java.util.List;
import model.notice;

public interface NoticeDao {
	//공지사항 게시글 등록
	public void insert(notice notice);
	
	//공지사항 게시글 수정
	public void update(notice notice);
	
	//공지사항 게시글 삭제
	public void delete(long ncode);
	
	//공지사항 게시글 전체목록
	List <notice> selectAll();
	
	//공지사항 게시글 상세보기
	notice selectByNcode(long ncode);
	
	//공지사항 제목,내용으로 검색
	List <notice> selectByTitleContent(String name);
	
	//조회수
	public void count(long ncode);
}
