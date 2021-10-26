package dao.user;

import java.util.HashMap;
import java.util.List;

import model.user.Doctor;
import model.user.Subject;


public interface DoctorDao {
	
	void insert(Doctor doctor);
	void delete(int dcode);
	void update(Doctor doctor);
	
	Doctor login(String id, String pw);
	int selectCntById(String id);
	
	Subject selectBycode(int scode);
	
	
	List<Doctor> selectAll();
	List<HashMap> selectByscode(int scode);
	List<HashMap> selectByNameAndScode(String name, int scode);
	List<HashMap> selectBydcode(int dcode);
	
	Doctor selectByDcode(int dcode);
}
