package dao;

import model.files;

public interface FileDao {
	//게시글 파일 등록
	public void insert(files files);
	
	//게시글 파일 수정
	public void update(files files);
	
	//게시글 파일 삭제
	public void delete(long ncode);
}
