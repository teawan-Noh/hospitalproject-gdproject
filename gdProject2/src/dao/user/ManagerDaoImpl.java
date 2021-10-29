package dao.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import common.JDBCUtil;
import common.Sql;
import model.ask.Rest;
import model.user.Manager;
import model.user.Patient;
import model.user.Subject;

public class ManagerDaoImpl implements ManagerDao {

	@Override
	public Manager login(String id, String pw) {
		Manager manager = null;
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;

		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.MANAGER_LOGIN_SQL);

			pStatement.setString(1, id);
			pStatement.setString(2, pw);

			resultSet = pStatement.executeQuery();

			if (resultSet.next()) {
				manager = new Manager();
				
				manager.setMcode(resultSet.getInt("mcode"));
				manager.setName(resultSet.getString("name"));
				manager.setId(resultSet.getString("id"));
				manager.setPw(resultSet.getString("pw"));
				
				
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(resultSet, pStatement, connection);
		}
		return manager;
	}
	

	@Override
	public Manager selectByMcode(int mcode) {
		Manager manager = null;
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;

		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.MANAGER_SELECT_BY_MCODE_SQL);

			pStatement.setInt(1, mcode);

			resultSet = pStatement.executeQuery();

			if (resultSet.next()) {
				manager = new Manager();
				
				manager.setMcode(resultSet.getInt("mcode"));
				manager.setName(resultSet.getString("name"));
				manager.setId(resultSet.getString("id"));
				manager.setPw(resultSet.getString("pw"));
				
				
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(resultSet, pStatement, connection);
		}
		return manager;
	}

	@Override
	public List<Subject> selectSubjectAll() {
		List<Subject> subjectList = new ArrayList<>();
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.MG_SUBJECT_SELECT_ALL_SQL);
			resultSet = pStatement.executeQuery();
			
			while(resultSet.next()) {
				
				Subject subject = new Subject();
				
				subject.setScode(resultSet.getInt("scode"));
				subject.setName(resultSet.getString("name"));
				
				subjectList.add(subject);
			}
			
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			JDBCUtil.close(resultSet, pStatement, connection);
		}
		
		return subjectList;
	}

	@Override
	public List<HashMap<String, String>> selectDoctorBySubject(int scode) {
		List<HashMap<String, String>> doctorList = new ArrayList<>();
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.MG_DOCTOR_SELECT_BY_SUBJECT_SQL);
			//select d.dcode, d.name as dname, s.name as sname, d.licenseno, d.scode from doctor d
			//inner join subject s on d.scode = s.scode where d.scode = ?
			pStatement.setInt(1, scode);
			resultSet = pStatement.executeQuery();
			
			while(resultSet.next()) {
				HashMap<String, String> hm = new HashMap<>();
				
				hm.put("dcode", Integer.toString(resultSet.getInt("dcode")));
				hm.put("dname", resultSet.getString("dname"));
				hm.put("sname", resultSet.getString("sname"));
				hm.put("licenseno", Integer.toString(resultSet.getInt("licenseno")));
				hm.put("scode",  Integer.toString(resultSet.getInt("scode")));
				
				doctorList.add(hm);
			}
			
		}
		catch(SQLException se) {
			se.printStackTrace();
		} 
		catch (Exception e) {
			e.getStackTrace();
		} finally {
			JDBCUtil.close(resultSet, pStatement, connection);
		}
		
		return doctorList;
	}


	@Override
	public void deleteDoctor(int dcode) {
		Connection connection = null;
		PreparedStatement pStatement = null;
		
		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.MG_DOCTOR_DELETE_SQL);
			//delete from doctor where dcode = ?
			pStatement.setInt(1, dcode); // ?값 셋팅 
			pStatement.executeUpdate();
			
		} catch (Exception e) {
			e.getStackTrace();
			
		} finally {
			
			JDBCUtil.close(null, pStatement, connection);
		}
		
	}

	@Override
	public List<HashMap<String, String>> selectPatientAll() {
		List<HashMap<String, String>> patientList = new ArrayList<>();
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.MG_PATIENT_SELECT_ALL_SQL);
			resultSet = pStatement.executeQuery();
			
			while(resultSet.next()) {
				
				HashMap<String, String> hm = new HashMap<>();
				
				hm.put("pcode", Integer.toString(resultSet.getInt("pcode")));
				hm.put("name", resultSet.getString("name"));
				hm.put("birth", resultSet.getString("birth"));
				hm.put("rcnt", Integer.toString(resultSet.getInt("rcnt")));
				patientList.add(hm);
			}
			
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			JDBCUtil.close(resultSet, pStatement, connection);
		}
		
		return patientList;
	}


	@Override
	public List<HashMap<String, String>> selectPatientByName(String name) {
		List<HashMap<String, String>> patientList = new ArrayList<>();
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;

		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.MG_PATIENT_SELECT_BY_NAME_SQL);

			pStatement.setString(1, '%'+name+'%');

			resultSet = pStatement.executeQuery();

			while(resultSet.next()) {
				HashMap<String, String> hm = new HashMap<>();
				
				hm.put("pcode", Integer.toString(resultSet.getInt("pcode")));
				hm.put("name", resultSet.getString("name"));
				hm.put("birth", resultSet.getString("birth"));
				hm.put("rcnt", Integer.toString(resultSet.getInt("rcnt")));
				
				patientList.add(hm);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(resultSet, pStatement, connection);
		}
		return patientList;
	}


	@Override
	public List<HashMap<String, String>> selectRestAll() {
		List<HashMap<String, String>> restList = new ArrayList<>();
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.MG_REST_SELECT_ALL_SQL);
			//select r.rcode, d.name as dname, r.requestdate, r.approved from doctor d inner join rest r
			//on d.dcode = r.dcode order by r.rcode desc;

			resultSet = pStatement.executeQuery();
			
			while(resultSet.next()) {
				HashMap<String, String> hm = new HashMap<>();
				
				hm.put("rcode", Integer.toString(resultSet.getInt("rcode")));
				hm.put("dname", resultSet.getString("dname"));
				hm.put("requestdate", resultSet.getString("requestdate"));
				hm.put("approved", resultSet.getString("approved"));
				
				restList.add(hm);
			}
			
		}
		catch(SQLException se) {
			se.printStackTrace();
		} 
		catch (Exception e) {
			e.getStackTrace();
		} finally {
			JDBCUtil.close(resultSet, pStatement, connection);
		}
		
		return restList;
	}


	@Override
	public List<HashMap<String, String>> selectRestByName(String name) {
		List<HashMap<String, String>> restList = new ArrayList<>();
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.MG_REST_SELECT_BY_NAME_SQL);
			//select r.rcode, d.name as dname, r.requestdate, r.approved from doctor d inner join rest r
			//on d.dcode = r.dcode where d.name like ? order by r.rcode desc;
			pStatement.setString(1, '%'+name+'%');
			resultSet = pStatement.executeQuery();
			
			while(resultSet.next()) {
				HashMap<String, String> hm = new HashMap<>();
				
				hm.put("rcode", Integer.toString(resultSet.getInt("rcode")));
				hm.put("dname", resultSet.getString("dname"));
				hm.put("requestdate", resultSet.getString("requestdate"));
				hm.put("approved", resultSet.getString("approved"));
				
				restList.add(hm);
			}
			
		}
		catch(SQLException se) {
			se.printStackTrace();
		} 
		catch (Exception e) {
			e.getStackTrace();
		} finally {
			JDBCUtil.close(resultSet, pStatement, connection);
		}
		
		return restList;
	}

	@Override
	public HashMap<String, String> selectRestByRcode(int rcode) {
		HashMap<String, String> restDetail = null;
		
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.MG_REST_SELECT_BY_RCODE_SQL);
			//select r.rcode, d.name as dname, r.requestdate, r.restdate, r.reason from doctor d inner join rest r 
			//on d.dcode = r.dcode where rcode = ?;
			pStatement.setInt(1, rcode);
			resultSet = pStatement.executeQuery();
			
			if(resultSet.next()) {
				
				restDetail = new HashMap<>();
				
				restDetail.put("rcode", resultSet.getString("rcode"));
				restDetail.put("dname", resultSet.getString("dname"));
				restDetail.put("requestdate", resultSet.getString("requestdate"));
				restDetail.put("restdate", resultSet.getString("restdate"));
				restDetail.put("reason", resultSet.getString("reason"));
			}
			
		}
		catch(NumberFormatException se) {
			se.printStackTrace();
		} 
		catch (Exception e) {
			e.getStackTrace();
		}
		finally {
			JDBCUtil.close(resultSet, pStatement, connection);
		}
		
		return restDetail;
	}

	@Override
	public void updateRestApprove(int rcode) {
		Connection connection = null;
		PreparedStatement pStatement = null;
		
		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.MG_REST_UPDATE_APPROVE_SQL);
			//update rest set approved = '승인' where rcode = ?
			pStatement.setInt(1, rcode); // ?값 셋팅 
			
			pStatement.executeUpdate();
			
		} catch (Exception e) {
			e.getStackTrace();
			
		} finally {
			
			JDBCUtil.close(null, pStatement, connection);
		}
		
	}


	@Override
	public void updateRestReject(int rcode) {
		Connection connection = null;
		PreparedStatement pStatement = null;
		
		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.MG_REST_UPDATE_REJECT_SQL);
			//update rest set approved = '승인' where rcode = ?
			pStatement.setInt(1, rcode); // ?값 셋팅 
			
			pStatement.executeUpdate();
			
		} catch (Exception e) {
			e.getStackTrace();
			
		} finally {
			
			JDBCUtil.close(null, pStatement, connection);
		}
		
	}



}
