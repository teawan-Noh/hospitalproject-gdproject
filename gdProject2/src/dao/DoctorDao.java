package dao;

import model.Doctor;


public interface DoctorDao {
	Doctor login(String id, String pw);
	void insert(Doctor doctor);
	int selectCntById(String id);
}
