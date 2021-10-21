package dao;

import java.util.List;

import model.Doctor;
import model.Subject;

public interface ReservationDao {
	List<Subject> selectSubjectAll();
	List<Doctor> selectDoctorWithSubject(String subjectName);
	Doctor selectDoctorByDcode(int dcode);
}
