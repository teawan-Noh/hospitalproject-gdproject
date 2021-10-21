package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCUtil {
	//디비 연결하기 위해 필요한 정보
	public static final String driver = "oracle.jdbc.driver.OracleDriver"; //자바로 디비 사용하기 위해 연결해주는 드라이버
	public static final String url = "jdbc:oracle:thin:@localhost:1521:xe";//해당하는 주소의 db로 감
	public static final String user = "scott"; //로그인 유저 아이디
	public static final String password = "tiger"; //로그인 유저 패스워드
	
	public static Connection getConnection() {
		
		Connection connection = null;
		
		try {
			Class.forName(driver);//오라클 드라이버 연결 
			connection = DriverManager.getConnection(url, user, password); //디비설치주소, 로그인 정보 드라이버 매니저 통해 보내면 디비와 연결하는 객체가 옴
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return connection;
	}
	public static void close(ResultSet resultSet, Statement statement, Connection connection) { 
		//네트워크 사용 후 닫을 때 리소스 처리해야 함
		//리소스 처리를 잘 안하면 서버, DB 속도나 성능에 문제가 생길 수 있음
		if(resultSet != null) { 
			try {
				if(!resultSet.isClosed()) { //resultSet이 닫혀있지 않으면 닫기
					resultSet.close();
				}
			} catch(Exception e) {
				System.out.println("resultSet close 오류");
			} finally {
				
				resultSet = null;
			}
		}
		
		if(statement != null) { 
			try {
				if(!statement.isClosed()) { //statement이 닫혀있지 않으면 닫기
					statement.close();
				}
			} catch(Exception e) {
				System.out.println("statement close 오류");
			} finally {
				
				statement = null;
			}
		}
		
		if(connection != null) { 
			try {
				if(!connection.isClosed()) { //connection이 닫혀있지 않으면 닫기
					connection.close();
				}
			} catch(Exception e) {
				System.out.println("connection close 오류");
			} finally {
				
				connection = null;
			}
		}
	}
}
