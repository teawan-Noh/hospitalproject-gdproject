package dao.board;

import java.util.HashMap;
import java.util.List;

import model.board.Qna;

public interface QnaDao {
	void insert(Qna qna);
	void update(Qna qna);
	void delete(int qno);
	
	void cntUpdate(Qna qna);
	
	List<HashMap> selectAll();
	List<HashMap> selectByNickname(String nickname);
	List<HashMap> selectByTitleOrContent(String searchValue);
	HashMap selectByQno(int qno);
}
