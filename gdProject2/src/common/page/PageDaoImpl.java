package common.page;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

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


}
