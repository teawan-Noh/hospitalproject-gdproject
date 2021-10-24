package dao;

import java.util.HashMap;
import java.util.List;

import model.Doctor;
import model.Subject;


public interface DoctorDao {
	Doctor login(String id, String pw);
	void insert(Doctor doctor);
	int selectCntById(String id);
	List<Doctor> selectAll();
	List<HashMap> selectByscode(int scode);
	Subject selectBycode(int scode);
	List<HashMap> selectByNameAndScode(String name, int scode);
}
