package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.Doctor;

public class DoctorDaoImpl implements DoctorDao {

	@Override
	public Doctor login(String id, String pw) {
		Doctor doctor = null;
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;

		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.DOCTOR_LOGIN_SQL);

			pStatement.setString(1, id);
			pStatement.setString(2, pw);

			resultSet = pStatement.executeQuery();

			if (resultSet.next()) {
				doctor = new Doctor();
				
				doctor.setDcode(resultSet.getInt("dcode"));
				doctor.setScode(resultSet.getInt("scode"));
				doctor.setId(resultSet.getString("id"));
				doctor.setPw(resultSet.getString("pw"));
				doctor.setName(resultSet.getString("name"));
				doctor.setBirth(resultSet.getString("birth"));
				doctor.setLicenseno(resultSet.getInt("licenseno"));
				doctor.setPostcode(resultSet.getInt("postcode"));
				doctor.setAddress(resultSet.getString("address"));
				doctor.setAddress2(resultSet.getString("address2"));
				doctor.setAddress(resultSet.getString("address2"));
				doctor.setCareer(resultSet.getString("career"));
				doctor.setTel(resultSet.getString("tel"));
				doctor.setEmail(resultSet.getString("email"));
				
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(resultSet, pStatement, connection);
		}
		return doctor;
	}
	

	@Override
	public Doctor selectByDcode(int dcode) {
		Doctor doctor = null;
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;

		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.DOCTOR_SELECT_BY_DCODE_SQL);

			pStatement.setLong(1, dcode);

			resultSet = pStatement.executeQuery();

			if (resultSet.next()) {
doctor = new Doctor();
				
				doctor.setDcode(resultSet.getInt("dcode"));
				doctor.setScode(resultSet.getInt("scode"));
				doctor.setId(resultSet.getString("id"));
				doctor.setPw(resultSet.getString("pw"));
				doctor.setName(resultSet.getString("name"));
				doctor.setBirth(resultSet.getString("birth"));
				doctor.setLicenseno(resultSet.getInt("licenseno"));
				doctor.setPostcode(resultSet.getInt("postcode"));
				doctor.setAddress(resultSet.getString("address"));
				doctor.setAddress2(resultSet.getString("address2"));
				doctor.setAddress(resultSet.getString("address2"));
				doctor.setCareer(resultSet.getString("career"));
				doctor.setTel(resultSet.getString("tel"));
				doctor.setEmail(resultSet.getString("email"));

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(resultSet, pStatement, connection);
		}
		return doctor;
	}
	

}
