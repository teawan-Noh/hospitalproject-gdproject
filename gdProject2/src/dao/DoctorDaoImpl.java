package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import model.Doctor;
import model.Subject;


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


	@Override
	public List<Doctor> selectAll() {
		List<Doctor> doctorList = new ArrayList<>();

		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.DOCTOR_SELECT_ALL_SQL);
			resultSet = pStatement.executeQuery();
			
			while(resultSet.next()) {
				
				Doctor doctor = new Doctor();
				
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
				doctor.setCareer(resultSet.getString("career"));
				doctor.setTel(resultSet.getString("tel"));
				doctor.setEmail(resultSet.getString("email"));
				
				
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
	public List<HashMap> selectByscode(int scode) {
		List<HashMap> doctorList = new ArrayList<>();

		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.DOCTOR_SELECT_BY_SCODE_SQL);
			pStatement.setInt(1, scode);
			resultSet = pStatement.executeQuery();
			//select d.dcode, d.scode, d.name, d.career, d.tel, d.email from doctor d join subject s on d.scode = s.scode where s.scode = ?
			while(resultSet.next()) {
				
				HashMap<String, Comparable> doctorMap = new HashMap<>();
				
				doctorMap.put("dcode", resultSet.getInt("dcode"));
				doctorMap.put("scode", resultSet.getInt("scode"));
				doctorMap.put("name", resultSet.getString("dname"));
				doctorMap.put("career", resultSet.getString("career"));
				doctorMap.put("tel", resultSet.getString("tel"));
				doctorMap.put("email", resultSet.getString("email"));
				doctorMap.put("sname", resultSet.getString("sname"));
				
				doctorList.add(doctorMap);
			}
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			JDBCUtil.close(resultSet, pStatement, connection); 
		}
		return doctorList;
	}


	@Override
	public Subject selectBycode(int scode) {
		Subject subject = null;
		
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		
		try {	
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.SUBJECT_SELECT_BY_SCODE_SQL);
			pStatement.setInt(1, scode);
			resultSet = pStatement.executeQuery();
			
			if(resultSet.next()) {	
				
				subject = new Subject();
				
				subject.setScode(resultSet.getInt("scode"));
				subject.setName(resultSet.getString("name"));
				subject.setDescription(resultSet.getString("description"));
				subject.setTel(resultSet.getString("tel"));
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(resultSet, pStatement, connection);
		}
		return subject;
	}


	@Override
	public List<HashMap> selectByNameAndScode(String name, int scode) {
		List<HashMap> doctorList = new ArrayList<>();

		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.DOCTOR_SELECT_BY_NAME_AND_SCODE_SQL);
			pStatement.setString(1, '%'+name+'%');
			pStatement.setInt(2, scode);
			resultSet = pStatement.executeQuery();
			//select d.dcode, d.scode, d.name, d.career, d.tel, d.email from doctor d join subject s on d.scode = s.scode where s.scode = ?
			while(resultSet.next()) {
				
				HashMap<String, Comparable> doctorMap = new HashMap<>();
				
				doctorMap.put("dcode", resultSet.getInt("dcode"));
				doctorMap.put("scode", resultSet.getInt("scode"));
				doctorMap.put("name", resultSet.getString("dname"));
				doctorMap.put("career", resultSet.getString("career"));
				doctorMap.put("tel", resultSet.getString("tel"));
				doctorMap.put("email", resultSet.getString("email"));
				doctorMap.put("sname", resultSet.getString("sname"));
				
				doctorList.add(doctorMap);
			}
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			JDBCUtil.close(resultSet, pStatement, connection); 
		}
		return doctorList;
	}


	@Override
	public void delete(int dcode) {
		Connection connection = null;
		PreparedStatement pStatement = null;
		
		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.DOCTOR_DELETE_SQL);
			
			pStatement.setInt(1, dcode);
			
			pStatement.executeUpdate(); //쿼리 작성 후 실행되게 함
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(null, pStatement, connection);
		}
		
	}


	@Override
	public void update(Doctor doctor) {
		Connection connection = null;
		PreparedStatement pStatement = null;

		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.DOCTOR_UPDATE_SQL);
			
			pStatement.setString(1, doctor.getPw());
			pStatement.setInt(2, doctor.getPostcode());
			pStatement.setString(3, doctor.getAddress());
			pStatement.setString(4, doctor.getAddress2());
			pStatement.setString(5, doctor.getCareer());
			pStatement.setString(6, doctor.getTel());
			pStatement.setString(7, doctor.getEmail());
			pStatement.setInt(8, doctor.getDcode());
			
			pStatement.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(null, pStatement, connection);
		}
		
	}


	@Override
	public List<HashMap> selectBydcode(int dcode) {
		List<HashMap> doctorList = new ArrayList<>();

		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		
		try {	
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.DOCTOR_SELECT_BY_DCODE);
			pStatement.setInt(1, dcode);
			resultSet = pStatement.executeQuery();
			
			while(resultSet.next()) {
				
				HashMap<String, Comparable> doctorMap = new HashMap<>();
				
				doctorMap.put("dcode", resultSet.getInt("dcode"));
				doctorMap.put("scode", resultSet.getInt("scode"));
				doctorMap.put("sname", resultSet.getString("sname"));
				doctorMap.put("id", resultSet.getString("id"));
				doctorMap.put("pw", resultSet.getString("pw"));
				doctorMap.put("name", resultSet.getString("dname"));
				doctorMap.put("birth", resultSet.getString("birth"));
				doctorMap.put("licenseno", resultSet.getInt("licenseno"));
				doctorMap.put("postcode", resultSet.getInt("postcode"));
				doctorMap.put("address", resultSet.getString("address"));
				doctorMap.put("address2", resultSet.getString("address2"));
				doctorMap.put("career", resultSet.getString("career"));
				doctorMap.put("tel", resultSet.getString("tel"));
				doctorMap.put("email", resultSet.getString("email"));
				
				doctorList.add(doctorMap);
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(resultSet, pStatement, connection);
		}
		return doctorList;
	}
}
