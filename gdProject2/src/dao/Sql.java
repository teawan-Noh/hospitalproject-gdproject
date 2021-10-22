package dao;

public class Sql {

	//qna 테이블
	public static final String QNA_SELECT_ALL_SQL 
		= "select q.qno, q.title, p.nickname, q.writedate, q.cnt"
			+ " from qna q inner join patient p"
			+ " on q.pcode = p.pcode"
			+ " order by q.qno desc";
	
	public static final String QNA_SELECT_BY_NICKNAME_SQL 
		= "select q.qno, q.title, p.nickname, q.writedate, q.cnt"
			+ " from qna q inner join patient p"
			+ " on q.pcode = p.pcode"
			+ " where p.nickname = ?"
			+ " order by q.qno desc";
	
	public static final String QNA_SELECT_BY_SUBJECT_SQL 
		= "select * from bbs where subject like ? order by no desc";

	public static final String QNA_SELECT_BY_NO_SQL 
		= "select * from bbs where no = ?";

	public static final String QNA_INSERT_SQL 
		= "insert into qna values (qnaseq.nextval, 1, '질문19', '질문일번입니다', sysdate, 'image경로1', 0)";

	public static final String QNA_UPDATE_SQL 
		= "update bbs set subject = ?, content = ? where no = ?";

	public static final String QNA_DELETE_SQL 
		= "delete from bbs where no = ?";

	public static final String QNA_CNT_UPDATE_SQL 
		= "update bbs set cnt = ? where no = ?";
}
