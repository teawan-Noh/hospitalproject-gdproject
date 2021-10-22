package dao;

import java.util.List;
import model.Subject;
import model.Doctor;


public interface DoctorDao {
	List<Subject> selectSubjectAll();
	Doctor login(String id, String pw);

}
