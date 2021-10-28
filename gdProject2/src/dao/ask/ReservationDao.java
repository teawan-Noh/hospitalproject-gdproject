package dao.ask;

import java.util.List;
import java.util.Map;

import model.ask.Reservation;
import model.user.Doctor;
import model.user.Subject;

public interface ReservationDao {
	List<Subject> selectSubjectAll();
	List<Doctor> selectDoctorWithSubject(String subjectName);
	Doctor selectDoctorByDcode(int dcode);
	List<Map<String, String>> selectScheduleByDcode(int dcode);
	
	List<Reservation> selectReservationByDcodeAndRsvDate(int dcode, String rsvdate);
	
	int insertReservation(int pcode, int dcode, String rsvdate);
	
	List<Map<String, String>> selectReservationPage(int pcode, int requestPage);
	List<Map<String, String>> selectReservationByDcodePage(int dcode, int requestPage);
	List<Map<String, String>> selectReservationByDcodeRsvdatePage(int dcode, int requestPage, String rsvdate);

	Map<String, String> selectReservationByRcode(int rcode);
	
	void deleteReservation(int rcode);
	
	void updateReservation(int rcode, int pcode, int dcode, String rsvdate);
	
	
}
