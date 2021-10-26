package dao.user;

import model.user.Patient;

public interface PatientDao {
	//회원가입
	void insert(Patient patient);
	
	//아이디 중복체크
	int selectCntById(String id);
	
	//환자 개인정보 수정
	void update(Patient patient);
	
	//회원 탈퇴
	void delete(int pcode);
	
	//로그인
	Patient login(String id, String pw);
	Patient selectByPcode(int pcode);
}
