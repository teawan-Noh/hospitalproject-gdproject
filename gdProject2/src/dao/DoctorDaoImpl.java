package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import model.Doctor;
import model.Subject;


public class DoctorDaoImpl implements DoctorDao {

	@Override
	public List<Subject> selectSubjectAll() {
	
		return null;
	}


	@Override
	public Doctor login(String id, String pw) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void insert(Doctor doctor) {
		Connection connection = null;
		PreparedStatement pStatement = null;
		
		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.DOCTOR_INSERT_SQL); 
				
			pStatement.setInt(1, doctor.getScode()); 
			pStatement.setString(2, doctor.getId());
			pStatement.setString(3, doctor.getPw());
			pStatement.setString(4, doctor.getName());
			pStatement.setString(5, doctor.getBirth());
			pStatement.setInt(6, doctor.getLicenseno());
			pStatement.setInt(7, doctor.getPostcode());
			pStatement.setString(8, doctor.getAddress());
			pStatement.setString(9, doctor.getAddress2());
			pStatement.setString(10, doctor.getCareer());
			pStatement.setString(11, doctor.getTel());
			pStatement.setString(12, doctor.getEmail());
			
			
			pStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(null, pStatement, connection);
		}
		
	}


	@Override
	public int selectCntById(String id) {
int cnt = 1;
		
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;

		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.DOCTOR_SELECT_CNT_BY_ID_SQL);

			pStatement.setString(1, id);

			resultSet = pStatement.executeQuery();

			if (resultSet.next()) {
				cnt=resultSet.getInt("cnt");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(resultSet, pStatement, connection);
		}
		return cnt;
	}
}
