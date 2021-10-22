package dao;

import model.Files;

public interface FileDao {
	//게시글 파일 등록
	public void insert(Files files);
	
	//게시글 파일 수정
	public void update(Files files);
	
	//게시글 파일 삭제
	public void delete(long ncode);
}
