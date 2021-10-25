package dao;

public class Sql {
	//RESERVATION
	public static final String SUBJECT_SELECT_ALL_SQL = "select * from subject";
	public static final String DOCTOR_SELECT_BY_SUBJECT_NAME_SQL = "select d.dcode, d.scode, d.name, d.career, d.tel, d.email from doctor d join subject s on d.scode = s.scode where s.name = ?";
	public static final String DOCTOR_SELECT_BY_DCODE_SQL = "select name, tel, email, career from doctor where dcode = ?";
	public static final String SELECT_SCHEDULE_BY_DCODE_SQL = "select to_char(restdate, 'yyyy-mm-dd') restdate, day from rest r join approval a on r.acode = a.acode where a.dcode = ? and approved='승인'";
	public static final String SELECT_RESERVATION_BY_DCODE_AND_RSVDATE_SQL = "select * from reservation where dcode = ? and to_char(rsvdate, 'yyyy-mm-dd') = ? and state = '예약' order by rsvdate";
	public static final String RESERVATION_INSERT_SQL = "insert into reservation values(rsv_seq.nextval, ?, ?, to_date(?, 'yyyy-mm-dd HH24:MI'), '예약')";

	
	public static final String MEMO_COUNT_SQL = "select count(*) as cnt from memo";

	
	public static final String RESERVATION_SELECT_PAGE_SQL = "select * from (select rownum as rn , rsvs.* from (select r.rcode, r.pcode, r.rsvdate, d.scode, s.name from reservation r inner join doctor d on r.dcode = d.dcode inner join subject s on d.scode = s.scode where r.pcode = ? order by rcode desc) rsvs) result where rn between ? and ?";
	

}
