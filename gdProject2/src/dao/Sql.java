package dao;

public class Sql {

	//회원가입
	public static final String PATIENT_INSERT_SQL = 
			"insert into PATIENT values (pcode.nextval, ?, ?, ?,?,?, to_date(?,'yyyy-mm-dd'),?,?,?,?,?)";
	
	//회원가입-아이디중복확인
		public static final String PATIENT_SELECT_CNT_BY_ID_SQL =
		         "select count(*) as cnt from patient where id = ?";
	
	
		
	//환자 로그인
	public static final String PATIENT_LOGIN_SQL =
			"select * from patient where id =? and pw = ?";
	
	public static final String PATIENT_SELECT_BY_PCODE_SQL =
			"select * from patient where pcode = ?";
	
	//의사 로그인
	public static final String DOCTOR_LOGIN_SQL =
			"select * from doctor where id =? and pw =?";
	
	public static final String DOCTOR_SELECT_BY_DCODE_SQL =
			"select * from doctor where dcode = ?";
	
	//관리자 로그인
	public static final String MANAGER_LOGIN_SQL =
			"select * from manager where id =? and pw =?";
	
	public static final String MANAGER_SELECT_BY_MCODE_SQL =
			"select * from manager where mcode=?";
	
	
	
	//환자 개인정보수정
	public static final String PATIENT_UPDATE_SQL = 
			"update patient set pw = ?,nickname = ?,postcode = ?,address = ?,address2 = ?,tel = ?,email = ? where pcode = ?";
	
	//환자 탈퇴
	public static final String PATIENT_DELETE_SQL =
			"delete from patient where pcode = ?";
	
	
	
	
	//공지사항 전체목록
	public static final String NOTICE_SELECT_ALL_SQL =
			"select n.ncode, n.title, m.name, n.writedate, n.cnt "
			+ "from notice n inner join manager "
			+ "on n.mcode = m.mcode order by n.ncode desc";
	
	//공지사항 검색
	public static final String NOTICE_SEARCH_SQL =
			"select n.ncode, n.title, m.name, n.writedate, n.cnt "
			+ "from notice n inner join manager m on n.mcode = m.mcode "
			+ "where n.title like ? or n.content like ? order by n.ncode desc";
	
	//공지사항 조회수
	public static final String NOTICE_CNT_SQL =
			"update notice set cnt = cnt+1 where ncode=?";
	
	//공지사항 게시글 작성
	public static final String NOTICE_INSERT_SQL =
			"insert into notice values (ncode.nextval, ?, ?, ?, to_date(?,'yyyy-mm-dd'), 0)";
	
	//게시글 상세보기
	public static final String NOTICE_SELECT_BY_NCODE_SQL =
			"select n.title, m.name, n.writedate, n.cnt, n.content "
			+ "from notice n inner join manager m on n.mcode = m.mcode where ncode = ?";
	
	//공지사항 게시글 수정
	public static final String NOTICE_UPDATE_SQL =
			"update notice set title =?, content =? where ncode =?";
	
	
	//게시글 파일 수정
	public static final String NOTICE_UPDATE_FILE_SQL =
			"update files set uploaddate=sysdate, name=?, beforename=?, filesize=? where fcode=?";
	
	//공지사항 게시글 삭제
	public static final String NOTICE_DELETE_SQL =
			"delete from notice where ncode = ?";
	
	//공지사항 파일 삭제
	public static final String NOTICE_DELETE_FILE_SQL =
			"delete from files where ncode = ?";
	
	//게시글 작성 파일 업로드
		public static final String NOTICE_INSERT_FILE_SQL =
				"insert into files values(fcode.nextval,?, to_date(?, 'yyyy-mm-dd'), ?,?,?)";

	//게시글 상세보기 파일
		public static final String NOTICE_SELECT_FILE_BY_NCODE_SQL =
				"select name from files where ncode = ?";


}