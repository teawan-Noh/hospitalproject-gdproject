package dao.user;

import java.util.HashMap;
import java.util.List;

import model.user.Manager;
import model.user.Subject;

public interface ManagerDao {
	Manager login(String id,String pw);
	Manager selectByMcode(int mcode);
	
	List<Subject> selectAll();
	List<HashMap> selectDoctorBySubject(int scode);
	void deleteDoctor(int dcode);

}
