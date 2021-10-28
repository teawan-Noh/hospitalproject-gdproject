package dao.rest;

import java.util.List;

import model.ask.Rest;

public interface RestDao {
	
	void insert(Rest rest);
	
	List<Rest> selectRestBydcode(String state, int dcode);
}
