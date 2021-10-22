package dao;

import model.Patient;

public interface PatientDao {
	//회원가입
	public void insert(Patient patient);
	
	//아이디 중복체크
	public int selectCntById(String id);
	
	//환자 개인정보 수정
	public void update(Patient patient);
	
	//회원 탈퇴
	public void delete(int pcode);
	
	//로그인
	Patient login(String id, String pw);
}
