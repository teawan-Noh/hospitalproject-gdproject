package dao;

import java.util.List;
import model.Doctor;
import model.Subject;


public interface DoctorDao {
	List<Subject> selectSubjectAll();
	Doctor login(String id, String pw);
	void insert(Doctor doctor);

}
