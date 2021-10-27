package dao.user;

import java.util.HashMap;
import java.util.List;

import model.user.Manager;
import model.user.Patient;
import model.user.Subject;

public interface ManagerDao {
	Manager login(String id,String pw);
	Manager selectByMcode(int mcode);
	
	List<Subject> selectSubjectAll();
	List<HashMap> selectDoctorBySubject(int scode);
	void deleteDoctor(int dcode);
	
	List<Patient> selectPatientAll();
	List<Patient> selectPatientByName(String name);
	
	List<HashMap> selectApprovalAll();
	List<HashMap> selectApprovalByName(String name);
	HashMap selectApprovalByAcode(int acode);
}
