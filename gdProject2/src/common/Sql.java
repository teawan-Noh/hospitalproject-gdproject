package common;

public class Sql {

	//RESERVATION
	public static final String SUBJECT_SELECT_ALL_SQL = "select * from subject";
	public static final String DOCTOR_SELECT_BY_SUBJECT_NAME_SQL = "select d.dcode, d.scode, d.name, d.career, d.tel, d.email from doctor d join subject s on d.scode = s.scode where s.name = ?";
	public static final String DOCTOR_SELECT_BY_DCODE_SQL = "select name, tel, email, career from doctor where dcode = ?";
	public static final String SELECT_SCHEDULE_BY_DCODE_SQL = "select to_char(restdate, 'yyyy-mm-dd') restdate, day from rest where dcode = ? and approved='승인'";
	public static final String SELECT_RESERVATION_BY_DCODE_AND_RSVDATE_SQL = "select * from reservation where dcode = ? and to_char(rsvdate, 'yyyy-mm-dd') = ? and state = '예약' order by rsvdate";
	public static final String RESERVATION_INSERT_SQL = "insert into reservation values(rsv_seq.nextval, ?, ?, to_date(?, 'yyyy-mm-dd HH24:MI'), '예약')";

	
	public static final String RESERVATION_COUNT_PCODE_SQL = "select count(*) as cnt from reservation where pcode = ?";
	public static final String RESERVATION_COUNT_DCODE_SQL = "select count(*) as cnt from reservation where dcode = ?";
	public static final String RESERVATION_COUNT_DCODE_RSVDATE_SQL = "select count(*) as cnt from reservation where dcode = ? and rsvdate = ?";

	
	public static final String RESERVATION_SELECT_PAGE_SQL = "select * from (select rownum as rn, rsvs.* from (select r.rcode, r.pcode, to_char(r.rsvdate, 'yyyy-mm-dd HH24:MI') rsvdate, r.state, d.scode, s.name from reservation r inner join doctor d on r.dcode = d.dcode inner join subject s on d.scode = s.scode where r.pcode = ? order by rsvdate desc) rsvs) result where rn between ? and ?";

	public static final String RESERVATION_SELECT_PAGE_DOCTOR_SQL = "select * from (select rownum as rn, rsvs.* from (select r.rcode, to_char(r.rsvdate, 'yyyy-mm-dd HH24:MI') rsvdate, r.pcode, p.name from reservation r inner join patient p on r.pcode = p.pcode where r.dcode = ? order by rsvdate desc) rsvs) result where rn between ? and ?";
	public static final String RESERVATION_SELECT_PAGE_DOCTOR_RSVDATE_SQL = "select * from (select rownum as rn, rsvs.* from (select r.rcode, to_char(r.rsvdate, 'yyyy-mm-dd HH24:MI') rsvdate, r.pcode, p.name from reservation r inner join patient p on r.pcode = p.pcode where r.dcode = ? and to_char(rsvdate, 'yyyy-mm-dd') = ? order by rsvdate desc) rsvs) result where rn between ? and ?";

	public static final String RESERVATION_DELETE_SQL = "delete from reservation where rcode = ?";
	
	//CUSTOMER
	public static final String CUSTOMER_INSERT_SQL = "insert into CUSTOMER values(customerseq.nextval, ?, ?, ?, ?, ?, ?, ?, ?)";
	public static final String CUSTOMER_SELECT_BY_CODE_SQL = "select * from customer where customerseq = ?";
	public static final String CUSTOMER_UPDATE_SQL = "update customer set id = ?, name = ?,"
			+ " password = ?, postcode = ?, address = ?, address2 = ?, phone = ?, email = ? where customerseq = ?";
	public static final String CUSTOMER_DELETE_SQL = "delete from CUSTOMER where customerseq = ?";
	public static final String CUSTOMER_SELECT_CNT_BY_ID_SQL = "select count(*) as cnt from customer where id=?";
	public static final String CUSTOMER_LOGIN_SQL = "select * from customer where id = ? and password = ?";
	
	//jsh
	public static final String RESERVATION_LIST_SELECT_SQL = "select rcode, to_char(rsvdate, 'yyyy-mm-dd HH24:MI') rsvdate, ds.name, state from (select d.dcode, d.scode, s.name from doctor d join subject on d.scode = s.scode) ds join reservation on r.dcode = ds.dcode where pcode = ? order by rcode desc";
	// 환자 코드 대신 예약 코드로 조회(edited by jp)
	public static final String RESERVATION_DETAIL_SELECT_SQL = "SELECT p.name pname, p.pcode pcode, d.dcode dcode, p.tel, to_char(r.rsvdate, 'yyyy-mm-dd HH24:MI') rsvdate, r.state, r.rcode, d.name dname, s.name sname FROM patient p INNER JOIN reservation r ON p.pcode = r.pcode INNER JOIN doctor d ON r.dcode = d.dcode INNER JOIN subject s ON d.scode = s.scode WHERE r.rcode = ?";
	public static final String DOCTOR_LIST_SELECT_SQL = "select d.name, s.name from doctor d join subject s on d.scode = s.scode order by s.name asc, d.name asc";
	public static final String DOCTOR_DETAIL_SELECT_SQL = "select d.name, s.name, d.career from doctor d join subject s on d.scode = s.scode where d.dcode = ?";
	public static final String DOCTOR_UPDATE_SQL = "update doctor set pw = ?, postcode = ?, address = ?, address2 = ?, career = ?, tel = ?, email = ? where dcode = ?";
	public static final String APPROVAL_SELECT_SQL = "select * from approval natural join rest where approved = '승인' and dcode = ?";
	public static final String APPROVAL_NOT_SELECT_SQL = "select * from approval natural join rest where approved != '승인' and dcode = ?";
	public static final String APPROVAL_INSERT_SQL = "insert into approval values (approval_seq.nextval, ?, ?, ?, ?)"; 
	public static final String DOCTOR_RESERVATION_SELECT_SQL = "SELECT b.rcode, b.rsvdate, a.name FROM patient a INNER JOIN reservation b ON a.pcode = b.pcode INNER JOIN doctor c ON b.dcode = c.dcode WHERE c.dcode = ? and to_char(b.rsvdate, 'yyyy-mm-dd') = to_date(?, 'yyyy-mm-dd') order by b.rsvdate asc";
	public static final String DOCTOR_INSERT_SQL = "insert into doctor values(doctor_seq.nextval, ?, ?, ?, ?, to_date(?,'yyyy-mm-dd'), ?, ?, ?, ?, ?, ?, ?)";
	public static final String DOCTOR_SELECT_CNT_BY_ID_SQL = "select count(*) as cnt from doctor where id = ?";
	public static final String DOCTOR_SELECT_ALL_SQL = "select * from doctor";
	public static final String DOCTOR_SELECT_BY_SCODE_SQL = "select d.dcode, d.scode, d.name as dname, d.career, d.tel, d.email, s.name as sname from doctor d join subject s on d.scode = s.scode where s.scode = ?";
	public static final String SUBJECT_SELECT_BY_SCODE_SQL = "select * from subject where scode = ?";
	public static final String DOCTOR_SELECT_BY_NAME_AND_SCODE_SQL = "select d.dcode, d.scode, d.name as dname, d.career, d.tel, d.email, s.name as sname from doctor d join subject s on d.scode = s.scode where d.name like ? and  s.scode = ?";
	public static final String DOCTOR_DELETE_SQL = "delete from doctor where dcode = ?";
	public static final String DOCTOR_SELECT_BY_DCODE = "select d.dcode, d.scode, d.name as dname, d.career, d.tel, d.licenseno, d.id, d.pw, d.email, to_char(d.birth,'yyyy-mm-dd') as birth, d.postcode, d.address, d.address2, s.name as sname from doctor d join subject s on d.scode = s.scode where d.dcode = ?";
	//odw
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
			"insert into notice values (ncode.nextval, ?, ?, ?, sysdate, 0)";
	
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
		//ntw
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
		= "select * from qna where subject like ? order by no desc";

	public static final String QNA_SELECT_BY_QNO_SQL 
		= "select q.qno, q.title, p.nickname, q.writedate, q.cnt, q.img, q.content, c.content as ccontent, c.writedate as cwritedate, m.id" 
			+ " from qna q" 
			+ " inner join patient p on q.pcode = p.pcode" 
			+ " inner join comments c on q.qno = c.qno" 
			+ " inner join manager m on c.mcode = m.mcode" 
			+ " where q.qno = ?";

	public static final String QNA_INSERT_SQL 
		= "insert into qna values (qna_seq.nextval, ?, ?, ?, sysdate, ?, 0)";

	public static final String QNA_UPDATE_SQL 
		= "update qna set subject = ?, content = ? where no = ?";

	public static final String QNA_DELETE_SQL 
		= "delete from qna where no = ?";

	public static final String QNA_CNT_UPDATE_SQL 
		= "update qna set cnt = ? where no = ?";
	//매니저
	public static final String MG_DOCTOR_SELECT_BY_SUBJECT_SQL 
		= "select d.dcode, d.name as dname, s.name as sname, d.licenseno, d.scode" 
				+ " from doctor d" 
				+ " inner join subject s on d.scode = s.scode" 
				+ " where d.scode = ?";
	
	public static final String MG_SUBJECT_SELECT_ALL_SQL
		= "select scode, name from subject";
	
	public static final String MG_DOCTOR_DELETE_SQL =
			"delete from doctor where dcode = ?";
}
