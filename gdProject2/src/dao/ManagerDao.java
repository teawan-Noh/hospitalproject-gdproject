package dao;

import model.manager;

public interface ManagerDao {
	//관리자 로그인
	manager login(String id, String pwd);
}
