package common.page;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.JDBCUtil;
import common.Sql;

public class PageDaoImpl implements PageDao {

	@Override
	public int getCountPatient(int pcode) {
		// TODO 자동 생성된 메소드 스텁
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		int cnt = -1;
		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.RESERVATION_COUNT_PCODE_SQL);
			pStatement.setInt(1, pcode);
			resultSet = pStatement.executeQuery();
			
			if(resultSet.next()) {
				cnt = resultSet.getInt("cnt");
			}

			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			JDBCUtil.close(resultSet, pStatement, connection);
			
		}
		return cnt;
	}

	@Override
	public int getCountDoctor(int dcode) {
		// TODO 자동 생성된 메소드 스텁
			Connection connection = null;
			PreparedStatement pStatement = null;
			ResultSet resultSet = null;
			int cnt = -1;
			try {
				connection = JDBCUtil.getConnection();
				pStatement = connection.prepareStatement(Sql.RESERVATION_COUNT_DCODE_SQL);
				pStatement.setInt(1, dcode);
				resultSet = pStatement.executeQuery();
				
				if(resultSet.next()) {
					cnt = resultSet.getInt("cnt");
				}

				
			} catch (Exception e) {
				e.printStackTrace();
				
			} finally {
				JDBCUtil.close(resultSet, pStatement, connection);
				
			}
			return cnt;
	}

	@Override
	public int getCountDoctorRsvdate(int dcode, String rsvdate) {
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		int cnt = -1;
		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.RESERVATION_COUNT_DCODE_RSVDATE_SQL);
			pStatement.setInt(1, dcode);
			pStatement.setString(2, rsvdate);
			resultSet = pStatement.executeQuery();
			
			if(resultSet.next()) {
				cnt = resultSet.getInt("cnt");
			}

			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			JDBCUtil.close(resultSet, pStatement, connection);
			
		}
		return cnt;
	}
	
	public int getCountNotice(String sql) {
		 int cnt = 0;
	      Connection connection = null;
	      PreparedStatement pStatement = null;
	      ResultSet resultSet = null;
	      
	      try {
	         connection = JDBCUtil.getConnection();
	         pStatement = connection.prepareStatement(sql);
	         resultSet = pStatement.executeQuery();
	         
	         if(resultSet.next()) {
	            cnt = resultSet.getInt("cnt");
	         }
	      } catch (Exception e) {
	         e.printStackTrace();
	         
	      } finally {
	         JDBCUtil.close(resultSet, pStatement, connection);
	      }
	      return cnt;
	   }

	@Override
	public int getCountQnaAll(String sql) {
		int cnt = 0;
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(sql);
			resultSet = pStatement.executeQuery();
			
			if(resultSet.next()) {
				
				cnt = resultSet.getInt("cnt");
				System.out.println("전체써치"+cnt);
				
			}
		}
		catch(SQLException se) {
			se.printStackTrace();
			 	
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			JDBCUtil.close(resultSet, pStatement, connection);
		}
		
		return cnt;
	}

	@Override
	public int getCountQnaSearchNickname(String searchValue) {
		int cnt = 0;
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.QNA_COUNT_SEARCH_NICKNAME_SQL);
			pStatement.setString(1, '%'+searchValue+'%');
			resultSet = pStatement.executeQuery();
			
			if(resultSet.next()) {
				System.out.println("닉네임써치");
				cnt = resultSet.getInt("cnt");
				
			}
			
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			JDBCUtil.close(resultSet, pStatement, connection);
		}
		
		return cnt;
	}

	@Override
	public int getCountQnaSearchTitleContent(String searchValue) {
		int cnt = 0;
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.QNA_COUNT_SEARCH_TITLE_CONTENT_SQL);
			pStatement.setString(1, '%'+searchValue+'%');
			pStatement.setString(2, '%'+searchValue+'%');
			resultSet = pStatement.executeQuery();
			
			if(resultSet.next()) {
				System.out.println("타이틀컨텐츠써치");
				cnt = resultSet.getInt("cnt");
				
			}
			
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			JDBCUtil.close(resultSet, pStatement, connection);
		}
		
		return cnt;
	}
}
