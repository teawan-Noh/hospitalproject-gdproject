package dao.board;

import model.board.Files;

public interface FileDao {
	//게시글 파일 등록
	void insert(Files files);
	
	//게시글 파일 수정
	void update(Files files);
	
	//게시글 파일 삭제
	void delete(int ncode);
}
