package dao;

public class Sql {

	//RESERVATION
	public static final String SUBJECT_SELECT_ALL_SQL = "select * from subject";
	public static final String DOCTOR_SELECT_BY_SUBJECT_NAME_SQL = "select d.dcode, d.scode, d.name, d.career, d.tel, d.email from doctor d join subject s on d.scode = s.scode where s.name = ?";
	public static final String DOCTOR_SELECT_BY_DCODE_SQL = "select name, tel, email, career from doctor where dcode = ?";
	public static final String SELECT_SCHEDULE_BY_DCODE_SQL = "select restdate, day from rest r join approval a on r.acode = a.acode where a.dcode = ? and approved='½ÂÀÎ'";
	
	//CUSTOMER
	public static final String CUSTOMER_INSERT_SQL = "insert into CUSTOMER values(customerseq.nextval, ?, ?, ?, ?, ?, ?, ?, ?)";
	public static final String CUSTOMER_SELECT_BY_CODE_SQL = "select * from customer where customerseq = ?";
	public static final String CUSTOMER_UPDATE_SQL = "update customer set id = ?, name = ?,"
			+ " password = ?, postcode = ?, address = ?, address2 = ?, phone = ?, email = ? where customerseq = ?";
	public static final String CUSTOMER_DELETE_SQL = "delete from CUSTOMER where customerseq = ?";
	public static final String CUSTOMER_SELECT_CNT_BY_ID_SQL = "select count(*) as cnt from customer where id=?";
	public static final String CUSTOMER_LOGIN_SQL = "select * from customer where id = ? and password = ?";
	
	//jsh
	public static final String RESERVATION_LIST_SELECT_SQL = "select rcode, rsvdate, ds.name, state from (select d.dcode, d.scode, s.name from doctor d join subject on d.scode = s.scode) ds join reservation on r.dcode = ds.dcode where pcode = ? order by rcode desc";
	public static final String RESERVATION_DETAIL_SELECT_SQL = "SELECT a.name, a.tel, b.rsvdate, c.name, d.name FROM patient a INNER JOIN reservation b ON a.pcode = b.pcode INNER JOIN doctor c ON b.dcode = c.dcode INNER JOIN subject d ON c.scode = d.scode WHERE a.pcode = ?";
	public static final String DOCTOR_LIST_SELECT_SQL = "select d.name, s.name from doctor d join subject s on d.scode = s.scode order by s.name asc, d.name asc";
	public static final String DOCTOR_DETAIL_SELECT_SQL = "select d.name, s.name, d.career from doctor d join subject s on d.scode = s.scode where d.dcode = ?";
	public static final String DOCTOR_UPDATE_SQL = "update doctor set pw = ?, postcode = ?, address = ?, address2 = ?, career = ?, tel = ?, email = ? where dcode = ?";
	public static final String APPROVAL_SELECT_SQL = "select * from approval natural join rest where approved = '½ÂÀÎ' and dcode = ?";
	public static final String APPROVAL_NOT_SELECT_SQL = "select * from approval natural join rest where approved != '½ÂÀÎ' and dcode = ?";
	public static final String APPROVAL_INSERT_SQL = "insert into approval values (?, ?, sysdate, ?, ?)"; 
	public static final String DOCTOR_RESERVATION_SELECT_SQL = "SELECT b.rcode, b.rsvdate, a.name FROM patient a INNER JOIN reservation b ON a.pcode = b.pcode INNER JOIN doctor c ON b.dcode = c.dcode WHERE c.dcode = ? and to_char(b.rsvdate, 'yyyy-mm-dd') = to_date(?, 'yyyy-mm-dd') order by b.rsvdate asc";
}
