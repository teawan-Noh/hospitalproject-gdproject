package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.Manager;

public class ManagerDaoImpl implements ManagerDao {

	@Override
	public Manager login(String id, String pw) {
		Manager manager = null;
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;

		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.MANAGER_LOGIN_SQL);

			pStatement.setString(1, id);
			pStatement.setString(2, pw);

			resultSet = pStatement.executeQuery();

			if (resultSet.next()) {
				manager = new Manager();
				
				manager.setMcode(resultSet.getInt("mcode"));
				manager.setName(resultSet.getString("name"));
				manager.setId(resultSet.getString("id"));
				manager.setPw(resultSet.getString("pw"));
				
				
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(resultSet, pStatement, connection);
		}
		return manager;
	}
	

	@Override
	public Manager selectByMcode(int mcode) {
		Manager manager = null;
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;

		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.MANAGER_SELECT_BY_MCODE_SQL);

			pStatement.setInt(1, mcode);

			resultSet = pStatement.executeQuery();

			if (resultSet.next()) {
				manager = new Manager();
				
				manager.setMcode(resultSet.getInt("mcode"));
				manager.setName(resultSet.getString("name"));
				manager.setId(resultSet.getString("id"));
				manager.setPw(resultSet.getString("pw"));
				
				
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(resultSet, pStatement, connection);
		}
		return manager;
	}

}
