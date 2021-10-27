package dao.ask;

import java.sql.Connection;



import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import common.JDBCUtil;
import common.Sql;
import model.ask.Reservation;
import model.user.Doctor;
import model.user.Subject;
import common.page.PageManager;
import common.page.PageRowResult;

public class ReservationDaoImpl implements ReservationDao {

	@Override
	public List<Subject> selectSubjectAll() {
		List<Subject> subjectList = new ArrayList<Subject>();
		
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.SUBJECT_SELECT_ALL_SQL);
			resultSet = pStatement.executeQuery();
			
			while(resultSet.next()) {
				Subject subject = new Subject(resultSet.getInt("scode"),
						resultSet.getString("name"),
						resultSet.getString("description"),
						resultSet.getString("tel"));

			
				subjectList.add(subject);
			}

			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			JDBCUtil.close(resultSet, pStatement, connection);
			
		}
		return subjectList;
	}

	@Override
	public List<Doctor> selectDoctorWithSubject(String subjectName) {
		List<Doctor> doctorList = new ArrayList<Doctor>();
		
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.DOCTOR_SELECT_BY_SUBJECT_NAME_SQL);
			pStatement.setString(1, subjectName);
			resultSet = pStatement.executeQuery();
			
			while(resultSet.next()) {
				Doctor doctor = new Doctor(
						resultSet.getInt("dcode"),
						resultSet.getInt("scode"),
						null,
						null,
						resultSet.getString("name"),
						null,
						0,
						0,
						null,
						null,
						null,
						null,
						null
						);

			
				doctorList.add(doctor);
			}

			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			JDBCUtil.close(resultSet, pStatement, connection);
			
		}
		return doctorList;
	}

	@Override
	public Doctor selectDoctorByDcode(int dcode) {
		Doctor doctor = null;
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.DOCTOR_SELECT_BY_DCODE_SQL);
			pStatement.setInt(1, dcode);
			resultSet = pStatement.executeQuery();
			
			if(resultSet.next()) {
				doctor = new Doctor(
						resultSet.getInt("dcode"),
						resultSet.getInt("scode"),
						null,
						null,
						resultSet.getString("name"),
						null,
						0,
						0,
						null,
						null,
						resultSet.getString("career"),
						resultSet.getString("tel"),
						resultSet.getString("email")
						);

			}

			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			JDBCUtil.close(resultSet, pStatement, connection);
			
		}
		return doctor;
	}

	@Override
	public List<Map<String, String>> selectScheduleByDcode(int dcode) {
		List<Map<String, String>> result = new ArrayList<Map<String, String>>();
		
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		
		
		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.SELECT_SCHEDULE_BY_DCODE_SQL);
			pStatement.setInt(1, dcode);
			resultSet = pStatement.executeQuery();
			
			while(resultSet.next()) {
				Map<String, String> map = new HashMap<String, String>();
				String restdate = resultSet.getString("restdate");
				String day = resultSet.getString("day");
				if(restdate != null) {
					map.put("restdate", resultSet.getString("restdate"));
				}
				if(day != null) {
					map.put("day", convertDay(resultSet.getString("day")));
				}
				result.add(map);
				
			}

		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			JDBCUtil.close(resultSet, pStatement, connection);
			
		}
		return result;
	}
	


	@Override
	public List<Reservation> selectReservationByDcodeAndRsvDate(int dcode, String rsvdate) {
		List<Reservation> rsvList = new ArrayList<Reservation>();
		
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		
		
		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.SELECT_RESERVATION_BY_DCODE_AND_RSVDATE_SQL);
			pStatement.setInt(1, dcode);
			pStatement.setString(2, rsvdate);
			resultSet = pStatement.executeQuery();
			
			while(resultSet.next()) {
				Reservation reservation = new Reservation(
						resultSet.getInt("rcode"),
						resultSet.getInt("pcode"),
						resultSet.getInt("dcode"),
						resultSet.getString("rsvdate"),
						resultSet.getString("state")
						);
				rsvList.add(reservation);
				
			}

		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			JDBCUtil.close(resultSet, pStatement, connection);
			
		}
		return rsvList;
	}
	
	@Override
	public int insertReservation(int pcode, int dcode, String rsvdate) {
			int cnt = 0;
			Connection connection = null;
			PreparedStatement pStatement = null;
			
			
			try {
				connection = JDBCUtil.getConnection();
				pStatement = connection.prepareStatement(Sql.RESERVATION_INSERT_SQL);
				pStatement.setInt(1, pcode);
				pStatement.setInt(2, dcode);
				pStatement.setString(3, rsvdate);
				cnt = pStatement.executeUpdate();
				
			} catch (Exception e) {
				e.printStackTrace();
				
			} finally {
				JDBCUtil.close(null, pStatement, connection);
				
			}
			return cnt;
		
	}
	
	@Override
	public List<Map<String, String>> selectReservationPage(int pcode, int requestPage) {
		// TODO 자동 생성된 메소드 스텁
		List<Map<String, String>> rsvList = new ArrayList<>();
		
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.RESERVATION_SELECT_PAGE_SQL);
			
			PageManager pm = new PageManager(requestPage);
			PageRowResult prr = pm.getPageRowResult();
			pStatement.setInt(1, pcode);
			pStatement.setInt(2, prr.getRowStartNumber());
			pStatement.setInt(3, prr.getRowEndNumber());
			
			resultSet = pStatement.executeQuery();
			
			while(resultSet.next()) {
				Map<String, String> result = new HashMap<>();
				String[] rsvDate = resultSet.getString("rsvdate").split(" ");
				result.put("rn", resultSet.getString("rn"));
				result.put("rcode", resultSet.getString("rcode"));
				result.put("pcode", resultSet.getString("pcode"));
				result.put("rsvdate", rsvDate[0]);
				result.put("rsvtime", rsvDate[1]);
				result.put("scode", resultSet.getString("scode"));
				result.put("name", resultSet.getString("name"));
				result.put("state", resultSet.getString("state"));
				rsvList.add(result);
			}

			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			JDBCUtil.close(resultSet, pStatement, connection);
			
		}
		
		return rsvList;
	}
	
	@Override
	public List<Map<String, String>> selectReservationByDcodePage(int dcode, int requestPage) {
		List<Map<String, String>> rsvList = new ArrayList<>();
		
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.RESERVATION_SELECT_PAGE_DOCTOR_SQL);
			
			PageManager pm = new PageManager(requestPage);
			PageRowResult prr = pm.getPageRowResult();
			pStatement.setInt(1, dcode);
			pStatement.setInt(2, prr.getRowStartNumber());
			pStatement.setInt(3, prr.getRowEndNumber());
			
			resultSet = pStatement.executeQuery();
			
			while(resultSet.next()) {
				Map<String, String> result = new HashMap<>();
				String[] rsvDate = resultSet.getString("rsvdate").split(" ");
				result.put("rn", resultSet.getString("rn"));
				result.put("rcode", resultSet.getString("rcode"));
				result.put("pcode", resultSet.getString("pcode"));
				result.put("rsvdate", rsvDate[0]);
				result.put("rsvtime", rsvDate[1]);
				result.put("name", resultSet.getString("name"));
				rsvList.add(result);
			}

			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			JDBCUtil.close(resultSet, pStatement, connection);
			
		}
		
		return rsvList;
	}
	
	@Override
	public List<Map<String, String>> selectReservationByDcodeRsvdatePage(int dcode, int requestPage, String rsvdate) {
		List<Map<String, String>> rsvList = new ArrayList<>();
		
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.RESERVATION_SELECT_PAGE_DOCTOR_RSVDATE_SQL);
			
			PageManager pm = new PageManager(requestPage);
			PageRowResult prr = pm.getPageRowResult();
			pStatement.setInt(1, dcode);
			pStatement.setString(2, rsvdate);
			pStatement.setInt(3, prr.getRowStartNumber());
			pStatement.setInt(4, prr.getRowEndNumber());
			
			resultSet = pStatement.executeQuery();
			
			while(resultSet.next()) {
				Map<String, String> result = new HashMap<>();
				String[] rsvDate = resultSet.getString("rsvdate").split(" ");
				result.put("rn", resultSet.getString("rn"));
				result.put("rcode", resultSet.getString("rcode"));
				result.put("pcode", resultSet.getString("pcode"));
				result.put("rsvdate", rsvDate[0]);
				result.put("rsvtime", rsvDate[1]);
				result.put("name", resultSet.getString("name"));
				rsvList.add(result);
			}

			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			JDBCUtil.close(resultSet, pStatement, connection);
			
		}
		
		return rsvList;
	}
		
	public String convertDay(String dayString) {
		String result = null;
		String[] days = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
		
		for(int i = 0; i < days.length; i++) {
			if(dayString.equals(days[i])) {
				return String.valueOf(i);
			}
		}
		
		return result;
	}

	@Override
	public Map<String, String> selectReservationByRcode(int rcode) {
		// TODO 자동 생성된 메소드 스텁
		
		Map<String, String> result = new HashMap<>();
		
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.RESERVATION_DETAIL_SELECT_SQL);
			
			pStatement.setInt(1, rcode);
			resultSet = pStatement.executeQuery();
			
			if(resultSet.next()) {
				String[] rsvDate = resultSet.getString("rsvdate").split(" ");
				result.put("pcode", resultSet.getString("pcode"));
				result.put("pname", resultSet.getString("pname"));
				result.put("dcode", resultSet.getString("dcode"));
				result.put("tel", resultSet.getString("tel"));
				result.put("rcode", resultSet.getString("rcode"));
				result.put("rsvdate", rsvDate[0]);
				result.put("rsvtime", rsvDate[1]);
				result.put("sname", resultSet.getString("sname"));
				result.put("dname", resultSet.getString("dname"));
				result.put("state", resultSet.getString("state"));
			}

			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			JDBCUtil.close(resultSet, pStatement, connection);
			
		}
		
		return result;
	}

	@Override
	public void deleteReservation(int rcode) {
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.RESERVATION_DELETE_SQL);
			
			pStatement.setInt(1, rcode);
			pStatement.executeUpdate();

			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			JDBCUtil.close(resultSet, pStatement, connection);
			
		}
		
	}
	



}
