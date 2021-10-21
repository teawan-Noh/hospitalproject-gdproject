package dao;

import model.doctor;

public interface DoctorDao {
	//의사 로그인
	doctor login(String id, String pwd);
}
