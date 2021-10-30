package dao.board;

import java.util.List;
import model.board.Files;

public interface FileDao {
	//게시글 파일 등록
	void insert(Files files);
	
	//게시글 파일 수정
	void update(Files files);
	
	//게시글 파일 삭제
	void delete(int ncode);
	
	//바뀐파일이름을 위한 시퀀스 리턴메소드
	int returnSeq();
	
	List <Files> selectAll();
	
	//ncode를 받아서 파일이 있으면 파일객체를 리턴해주는 메소드
	List <Files> returnFiles(int ncode);
}
