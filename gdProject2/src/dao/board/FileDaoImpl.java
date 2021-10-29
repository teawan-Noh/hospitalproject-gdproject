package dao.board;

import java.sql.Connection;
import java.sql.PreparedStatement;

import common.JDBCUtil;
import common.Sql;
import model.board.Files;

public class FileDaoImpl implements FileDao {

	@Override
	public void insert(Files files) {
		Connection connection = null;
		PreparedStatement pStatement = null;
		
		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.NOTICE_INSERT_FILE_SQL);
			
			pStatement.setInt(1, files.getNcode());
			pStatement.setString(2, files.getName());
			pStatement.setString(3, files.getBeforename());
			pStatement.setInt(4, files.getFilesize());
			
			pStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(null, pStatement, connection);
		}

	}

	@Override
	public void update(Files files) {
		Connection connection = null;
		PreparedStatement pStatement = null;

		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.NOTICE_UPDATE_FILE_SQL);

			pStatement.setInt(1, files.getNcode());
			pStatement.setString(2, files.getName());
			pStatement.setString(3, files.getBeforename());
			pStatement.setInt(4, files.getFilesize());

			pStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(null, pStatement, connection);
		}

	}

	@Override
	public void delete(int ncode) {
		Connection connection = null;
		PreparedStatement pStatement = null;

		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.NOTICE_DELETE_FILE_SQL);

			pStatement.setLong(1,ncode);

			pStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(null, pStatement, connection);
		}

	}

}
