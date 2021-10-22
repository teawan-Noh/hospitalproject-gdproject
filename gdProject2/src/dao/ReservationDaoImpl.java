package dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Doctor;
import model.Subject;

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
	public Map<String, String> selectScheduleByDcode(int dcode) {
		Map<String, String> result = new HashMap<String, String>();
		
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		
		
		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.DOCTOR_SELECT_BY_DCODE_SQL);
			pStatement.setInt(1, dcode);
			resultSet = pStatement.executeQuery();
			
			while(resultSet.next()) {
				

			}

			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			JDBCUtil.close(resultSet, pStatement, connection);
			
		}
		return null;
	}
	
	public String convertDay(String dayString) {
		return null;
	}
	
}
