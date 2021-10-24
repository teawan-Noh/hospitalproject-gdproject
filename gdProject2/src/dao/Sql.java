package dao;

public class Sql {
	//RESERVATION
	public static final String SUBJECT_SELECT_ALL_SQL = "select * from subject";
	public static final String DOCTOR_SELECT_BY_SUBJECT_NAME_SQL = "select d.dcode, d.scode, d.name, d.career, d.tel, d.email from doctor d join subject s on d.scode = s.scode where s.name = ?";
	public static final String DOCTOR_SELECT_BY_DCODE_SQL = "select name, tel, email, career from doctor where dcode = ?";
	public static final String SELECT_SCHEDULE_BY_DCODE_SQL = "select to_char(restdate, 'yyyy-mm-dd') restdate, day from rest r join approval a on r.acode = a.acode where a.dcode = ? and approved='승인'";
	public static final String SELECT_RESERVATION_BY_DCODE_AND_RSVDATE_SQL = "select * from reservation where dcode = ? and to_char(rsvdate, 'yyyy-mm-dd') = ? and state = '예약' order by rsvdate";
	public static final String RESERVATION_INSERT_SQL = "insert into reservation values(rsv_seq.nextval, ?, ?, to_date(?, 'yyyy-mm-dd HH24:MI'), '예약')";
	
	//CUSTOMER
	public static final String CUSTOMER_INSERT_SQL = "insert into CUSTOMER values(customerseq.nextval, ?, ?, ?, ?, ?, ?, ?, ?)";
	public static final String CUSTOMER_SELECT_BY_CODE_SQL = "select * from customer where customerseq = ?";
	public static final String CUSTOMER_UPDATE_SQL = "update customer set id = ?, name = ?,"
			+ " password = ?, postcode = ?, address = ?, address2 = ?, phone = ?, email = ? where customerseq = ?";
	public static final String CUSTOMER_DELETE_SQL = "delete from CUSTOMER where customerseq = ?";
	
	public static final String CUSTOMER_SELECT_CNT_BY_ID_SQL = "select count(*) as cnt from customer where id=?";
	
	public static final String CUSTOMER_LOGIN_SQL = "select * from customer where id = ? and password = ?";
	
	//BBS 테이블
	public static final String BBS_INSERT_SQL = "insert into bbs values(bbsseq.nextval, ?, ?, sysdate, 0, ?)";
	
	public static final String BBS_SELECT_BY_NO_SQL = "select * from bbs where \"no\" = ?";
	
	public static final String BBS_SEARCH_BY_SUBJECT_SQL = "select * from bbs where subject like '%' || ? || '%'";

	public static final String BBS_SELECT_ALL_SQL = "select * from bbs";

	public static final String BBS_UPDATE_SQL = "update bbs set subject = ?, content = ? where \"no\" = ?";

	public static final String BBS_INCREASE_CNT_SQL = "update bbs set cnt = cnt + 1 where \"no\" = ?";

	public static final String BBS_DELETE_SQL = "delete from bbs where \"no\" = ?";

}
