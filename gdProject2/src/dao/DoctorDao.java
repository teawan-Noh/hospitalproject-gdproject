package dao;

import model.Doctor;

public interface DoctorDao {
	Doctor login(String id, String pw);
	Doctor selectByDcode(int dcode);
}
