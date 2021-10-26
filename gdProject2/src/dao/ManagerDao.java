package dao;

import java.util.HashMap;
import java.util.List;

import model.Manager;
import model.Subject;

public interface ManagerDao {
	Manager login(String id,String pw);
	Manager selectByMcode(int mcode);
	
	List<Subject> selectAll();
	List<HashMap> selectDoctorBySubject(int scode);
	void deleteDoctor(int dcode);

}
