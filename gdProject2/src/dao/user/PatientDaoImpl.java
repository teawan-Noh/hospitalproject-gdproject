package dao.user;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import common.JDBCUtil;
import common.Sql;
import model.user.Patient;

public class PatientDaoImpl implements PatientDao{

	@Override
	public void insert(Patient patient) {
		Connection connection = null;
		PreparedStatement pStatement = null;

		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.PATIENT_INSERT_SQL);

			pStatement.setString(1, patient.getId());
			pStatement.setString(2, patient.getPw());
			pStatement.setString(3, patient.getNickname());
			pStatement.setString(4, patient.getName());
			pStatement.setString(5, patient.getTel());
			pStatement.setString(6, patient.getBirth());
			pStatement.setString(7, patient.getGender());
			pStatement.setString(8, patient.getEmail());
			pStatement.setInt(9, patient.getPostcode());
			pStatement.setString(10, patient.getAddress());
			pStatement.setString(11, patient.getAddress2());

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
			pStatement = connection.prepareStatement(Sql.PATIENT_SELECT_CNT_BY_ID_SQL);

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

	@Override
	public void update(Patient patient) {
		Connection connection = null;
		PreparedStatement pStatement = null;

		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.PATIENT_UPDATE_SQL);
			//pw = ?,nickname = ?,postcode = ?,address = ?,address2 = ?,tel = ?,email = ? where pcode = ?
			
			pStatement.setString(1, patient.getPw());
			pStatement.setString(2, patient.getNickname());
			pStatement.setInt(3, patient.getPostcode());
			pStatement.setString(4, patient.getAddress());
			pStatement.setString(5, patient.getAddress2());
			pStatement.setString(6, patient.getTel());
			pStatement.setString(7, patient.getEmail());
			pStatement.setInt(8, patient.getPcode());

			pStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(null, pStatement, connection);
		}
		
	}

	@Override
	public void delete(int pcode) {
		Connection connection = null;
		PreparedStatement pStatement = null;

		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.PATIENT_DELETE_SQL);

			pStatement.setLong(1, pcode);
			pStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(null, pStatement, connection);
		}
		
	}

	@Override
	public Patient login(String id, String pw) {
		Patient patient = null;
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;

		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.PATIENT_LOGIN_SQL);

			pStatement.setString(1, id);
			pStatement.setString(2, pw);

			resultSet = pStatement.executeQuery();

			if (resultSet.next()) {
				patient = new Patient();
				
				patient.setPcode(resultSet.getInt("pcode"));
				patient.setId(resultSet.getString("id"));
				patient.setPw(resultSet.getString("pw"));
				patient.setNickname(resultSet.getString("nickName"));
				patient.setName(resultSet.getString("name"));
				patient.setTel(resultSet.getString("tel"));
				patient.setBirth(resultSet.getString("birth"));
				patient.setGender(resultSet.getString("gender"));
				patient.setEmail(resultSet.getString("email"));
				patient.setPostcode(resultSet.getInt("postcode"));
				patient.setAddress(resultSet.getString("address"));
				patient.setAddress2(resultSet.getString("address2"));
				
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(resultSet, pStatement, connection);
		}
		return patient;
	}

	@Override
	public Patient selectByPcode(int pcode) {
		Patient patient = null;
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;

		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.PATIENT_SELECT_BY_PCODE_SQL);

			pStatement.setLong(1, pcode);

			resultSet = pStatement.executeQuery();

			if (resultSet.next()) {
				patient = new Patient();

				patient.setPcode(resultSet.getInt("pcode"));
				patient.setId(resultSet.getString("id"));
				patient.setPw(resultSet.getString("pw"));
				patient.setNickname(resultSet.getString("nickName"));
				patient.setName(resultSet.getString("name"));
				patient.setTel(resultSet.getString("tel"));
				patient.setBirth(resultSet.getString("birth"));
				patient.setGender(resultSet.getString("gender"));
				patient.setEmail(resultSet.getString("email"));
				patient.setPostcode(resultSet.getInt("postcode"));
				patient.setAddress(resultSet.getString("address"));
				patient.setAddress2(resultSet.getString("address2"));

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(resultSet, pStatement, connection);
		}
		return patient;
	}

}
