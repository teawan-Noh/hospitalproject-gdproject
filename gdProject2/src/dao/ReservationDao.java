package dao;

import java.util.List;
import java.util.Map;

import model.Doctor;
import model.Subject;

public interface ReservationDao {
	List<Subject> selectSubjectAll();
	List<Doctor> selectDoctorWithSubject(String subjectName);
	Doctor selectDoctorByDcode(int dcode);
	List<Map<String, String>> selectScheduleByDcode(int dcode);
}
