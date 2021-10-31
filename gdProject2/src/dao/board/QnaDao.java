package dao.board;

import java.util.HashMap;
import java.util.List;

import model.board.Comments;
import model.board.Qna;

public interface QnaDao {
	void insert(Qna qna);
	void update(Qna qna);
	void delete(int qno);
	int insertComment(Comments comment);
	String selectByMcode(int mcode);
	
	void cntUpdate(Qna qna);
	Qna selectCntByQno(int qno);
	
	List<HashMap> selectAll(int requestPage);
	List<HashMap> selectByNickname(String nickname, int requestPage);
	List<HashMap> selectByTitleOrContent(String searchValue, int requestPage);
	HashMap selectByQno(int qno);
}
