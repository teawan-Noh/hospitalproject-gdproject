package dao;

import model.Manager;

public interface ManagerDao {
	Manager login(String id,String pw);

}
