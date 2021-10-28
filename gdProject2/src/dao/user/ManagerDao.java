package dao.user;

import java.util.HashMap;
import java.util.List;

import model.ask.Rest;
import model.user.Manager;
import model.user.Patient;
import model.user.Subject;

public interface ManagerDao {
	//로그인
	Manager login(String id,String pw);
	Manager selectByMcode(int mcode);
	//의사조회
	List<Subject> selectSubjectAll();
	List<HashMap<String, String>> selectDoctorBySubject(int scode);
	void deleteDoctor(int dcode);
	//환자조회
	List<HashMap<String, String>> selectPatientAll();
	List<Patient> selectPatientByName(String name);
	//승인관리
	List<HashMap<String, String>> selectRestAll();
	List<HashMap<String, String>> selectRestByName(String name);
	HashMap<String, String> selectRestByRcode(int rcode);
	void updateRestApprove(int rcode);
	void updateRestReject(int rcode);
}
