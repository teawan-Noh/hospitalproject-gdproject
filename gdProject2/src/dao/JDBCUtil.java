package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCUtil {
	
	public static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	public static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	public static final String USER = "scott";
	public static final String PASSWORD = "tiger";
	
	public static Connection getConnection() {
		
		Connection connection = null;
		try {
			Class.forName(DRIVER);
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return connection;
	}
	
	public static void close(ResultSet resultSet, Statement statemane, Connection connection) {
		if(resultSet != null) {
			try {
				if(!resultSet.isClosed()) {
					resultSet.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				resultSet = null;
			}
		}
		
		if(statemane != null) {
			try {
				if(!statemane.isClosed()) {
					statemane.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				statemane = null;
			}
		}
		
		if(connection != null) {
			try {
				if(!connection.isClosed()) {
					connection.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				connection = null;
			}
		}
	}
}
