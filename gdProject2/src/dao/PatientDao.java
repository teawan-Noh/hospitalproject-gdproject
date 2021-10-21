package dao;

import model.patient;

public interface PatientDao {
	//회원가입
	public void insert(patient patient);
	
	//아이디 중복체크
	public int selectCntById(String id);
	
	//환자 개인정보 수정
	public void update(patient patient);
	
	//회원 탈퇴
	public void delete(long pcode);
	
	//로그인
	patient login(String id, String pwd);
}
