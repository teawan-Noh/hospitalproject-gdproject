package dao;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import model.Doctor;
import model.Reservation;
import model.Subject;
import page.PageManager;
import page.PageRowResult;

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
	public List<Reservation> selectReservationPageAll(int requestPage) {
		// TODO 자동 생성된 메소드 스텁
		List<Reservation> rsvList = new ArrayList<>();
		
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.RESERVATION_SELECT_PAGE_SQL);
			
			PageManager pm = new PageManager(requestPage);
			PageRowResult prr = pm.getPageRowResult();
			pStatement.setInt(1, prr.getRowStartNumber());
			pStatement.setInt(2, prr.getRowEndNumber());
			
			resultSet = pStatement.executeQuery();
			
			while(resultSet.next()) {
				Reservation reservation = new Reservation();
				
				
				rsvList.add(reservation);
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


}
