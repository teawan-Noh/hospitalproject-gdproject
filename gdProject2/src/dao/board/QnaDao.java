package dao.board;

import java.util.HashMap;
import java.util.List;

import model.board.Comments;
import model.board.Qna;

public interface QnaDao {
	void insert(Qna qna);
	void update(Qna qna);
	void delete(int qno);
	void insertComment(Comments comment);
	
	void cntUpdate(Qna qna);
	Qna selectCntByQno(int qno);
	
	List<HashMap> selectAll();
	List<HashMap> selectByNickname(String nickname);
	List<HashMap> selectByTitleOrContent(String searchValue);
	HashMap selectByQno(int qno);
}
