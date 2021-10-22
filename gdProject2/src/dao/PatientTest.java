package dao;

import java.sql.Connection;

import dao.JDBCUtil;
import model.Patient;

public class PatientTest {
	
	public static void main(String[] args) {
		
		Connection connection = JDBCUtil.getConnection();
		JDBCUtil.close(null, null, connection);
		
		PatientDao dao = new PatientDaoImpl();
		Patient patient = new Patient();
		
		patient.setId("id1");
		patient.setPw("1111");
		patient.setNickname("환자1");
		patient.setName("이름1");
		patient.setTel("010-1111-1111");
		patient.setBirth("1998-04-14");
		patient.setGender("여");
		patient.setEmail("email1@email.com");
		patient.setPostcode(11111);
		patient.setAddress("서울");
		patient.setAddress2("강동구");
		
		dao.insert(patient);
	}

	
}
