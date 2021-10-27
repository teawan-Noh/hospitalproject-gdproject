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
	public List<HashMap> selectDoctorBySubject(int scode) {
		List<HashMap> doctorList = new ArrayList<>();
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
			pStatement.setInt(1, dcode); // ?°ª ¼ÂÆÃ 
			pStatement.executeUpdate();
			
		} catch (Exception e) {
			e.getStackTrace();
			
		} finally {
			
			JDBCUtil.close(null, pStatement, connection);
		}
		
	}

	@Override
	public List<Patient> selectPatientAll() {
		List<Patient> patientList = new ArrayList<>();
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.MG_PATIENT_SELECT_ALL_SQL);
			resultSet = pStatement.executeQuery();
			
			while(resultSet.next()) {
				
				Patient patient = new Patient();
				
				patient.setPcode(resultSet.getInt("pcode"));
				patient.setName(resultSet.getString("name"));
				patient.setBirth(resultSet.getString("birth"));
				
				patientList.add(patient);
			}
			
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			JDBCUtil.close(resultSet, pStatement, connection);
		}
		
		return patientList;
	}


	@Override
	public List<Patient> selectPatientByName(String name) {
		List<Patient> patientList = new ArrayList<>();
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;

		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.MG_PATIENT_SELECT_BY_NAME_SQL);

			pStatement.setString(1, '%'+name+'%');

			resultSet = pStatement.executeQuery();

			while(resultSet.next()) {
				Patient patient = new Patient();
				
				patient.setPcode(resultSet.getInt("pcode"));
				patient.setName(resultSet.getString("name"));
				patient.setBirth(resultSet.getString("birth"));
				
				patientList.add(patient);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(resultSet, pStatement, connection);
		}
		return patientList;
	}


	@Override
	public List<HashMap> selectApprovalAll() {
		List<HashMap> approvalList = new ArrayList<>();
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.MG_APPROVAL_SELECT_ALL_SQL);
//			select a.acode, d.name as dname, a.approvedate, a.approved from doctor d inner join approval a
//			on d.dcode = a.dcode order by a.acode desc;
			resultSet = pStatement.executeQuery();
			
			while(resultSet.next()) {
				HashMap<String, String> hm = new HashMap<>();
				
				hm.put("acode", Integer.toString(resultSet.getInt("acode")));
				hm.put("dname", resultSet.getString("dname"));
				hm.put("approvedate", resultSet.getString("approvedate"));
				hm.put("approved", resultSet.getString("approved"));
				
				approvalList.add(hm);
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
		
		return approvalList;
	}


	@Override
	public List<HashMap> selectApprovalByName(String name) {
		List<HashMap> approvalList = new ArrayList<>();
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.MG_APPROVAL_SELECT_BY_NAME_SQL);
//			select a.acode, d.name as dname, a.approvedate, a.approved from doctor d inner join approval a
//			where d.name like ? on d.dcode = a.dcode order by a.acode desc;
			pStatement.setString(1, '%'+name+'%');
			resultSet = pStatement.executeQuery();
			
			while(resultSet.next()) {
				HashMap<String, String> hm = new HashMap<>();
				
				hm.put("acode", Integer.toString(resultSet.getInt("acode")));
				hm.put("dname", resultSet.getString("dname"));
				hm.put("approvedate", resultSet.getString("approvedate"));
				hm.put("approved", resultSet.getString("approved"));
				
				approvalList.add(hm);
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
		
		return approvalList;
	}

}
