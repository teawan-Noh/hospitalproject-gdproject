package dao;

import java.util.List;
import model.Notice;

public interface NoticeDao {
	//공지사항 게시글 등록
	void insert(Notice notice);
	
	//공지사항 게시글 수정
	void update(Notice notice);
	
	//공지사항 게시글 삭제
	void delete(long ncode);
	
	//공지사항 게시글 전체목록
	List <Notice> selectAll();
	
	//공지사항 게시글 상세보기
	Notice selectByNcode(long ncode);
	
	//공지사항 제목,내용으로 검색
	List <Notice> selectByTitleContent(String name);
	
	//조회수
	void count(long ncode);
}
