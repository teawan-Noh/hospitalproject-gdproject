package dao.rest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import common.JDBCUtil;
import common.Sql;
import model.ask.Rest;
import model.user.Doctor;

public class RestDaoImpl implements RestDao {

	@Override
	public void insert(Rest rest) {
		Connection connection = null;
		PreparedStatement pStatement = null;
		
		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.REST_INSERT_SQL);
			//insert into rest values(rest_seq.nextval, ?, sysdate, '대기', ?, to_date(?, 'yyyy-mm-dd'), ?)
				
			pStatement.setInt(1, rest.getDcode()); 
			pStatement.setString(2, rest.getReason());
			pStatement.setString(3, rest.getRestdate());
			pStatement.setInt(4, rest.getDay());
			
			
			pStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(null, pStatement, connection);
		}
	}

	@Override
	public List<Rest> selectRestBydcode(String state, int dcode) {
		List<Rest> restList = new ArrayList<>();

		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.REST_SELECT_BY_APPROVED);
			//select * from rest where approved = '대기' and dcode = ?
			pStatement.setString(1, state);
			pStatement.setInt(2, dcode);
			resultSet = pStatement.executeQuery();
			
			while(resultSet.next()) {
				
				Rest rest = new Rest();
				
				rest.setRcode(resultSet.getInt("rcode"));
				rest.setDcode(resultSet.getInt("dcode"));
				rest.setRequestdate(resultSet.getString("requestdate"));
				rest.setApproved(resultSet.getString("approved"));
				rest.setReason(resultSet.getString("reason"));
				rest.setRestdate(resultSet.getString("restdate"));
				rest.setDay(resultSet.getInt("day"));
				
				restList.add(rest);
			
			}
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			JDBCUtil.close(resultSet, pStatement, connection); 
		}
		return restList;
	}
}
