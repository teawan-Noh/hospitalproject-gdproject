package dao.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.common.JDBCUtil;
import dao.common.Sql;
import model.board.Notice;

public class NoticeDaoImpl implements NoticeDao {

	@Override
	public void insert(Notice notice) {
		Connection connection = null;
		PreparedStatement pStatement = null;
		
		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.NOTICE_INSERT_SQL);
			
			pStatement.setInt(1, notice.getMcode());
			pStatement.setString(2, notice.getTitle());
			pStatement.setString(3, notice.getContent());
			
			pStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(null, pStatement, connection);
		}
	}

	@Override
	public void update(Notice notice) {
		Connection connection = null;
		PreparedStatement pStatement = null;

		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.NOTICE_UPDATE_SQL);

			pStatement.setInt(1, notice.getMcode());
			pStatement.setString(2, notice.getTitle());
			pStatement.setString(3, notice.getContent());

			pStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(null, pStatement, connection);
		}

	}

	@Override
	public void delete(long ncode) {
		Connection connection = null;
		PreparedStatement pStatement = null;

		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.NOTICE_DELETE_SQL);

			pStatement.setLong(1,ncode);

			pStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(null, pStatement, connection);
		}

	}

	@Override
	public List<Notice> selectAll() {
		List<Notice> noticeList = new ArrayList<>();

		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;

		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.NOTICE_SELECT_ALL_SQL);
			resultSet = pStatement.executeQuery();

			while (resultSet.next()) {

				Notice notice = new Notice();

				notice.setNcode(resultSet.getInt("ncode"));
				notice.setMcode(resultSet.getInt("mcode"));
				notice.setTitle(resultSet.getString("title"));
				notice.setContent(resultSet.getString("content"));
				notice.setWritedate(resultSet.getString("to_char(writedate,'yyyy-mm-dd')"));
				notice.setCnt(resultSet.getInt("cnt"));
				

				noticeList.add(notice);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(resultSet, pStatement, connection);
		}

		return noticeList;
	}

	@Override
	public Notice selectByNcode(int ncode) {
		Notice notice = null;
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;

		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.NOTICE_SELECT_BY_NCODE_SQL);

			pStatement.setInt(1, ncode);
			
			resultSet = pStatement.executeQuery();

			if (resultSet.next()) {
				notice = new Notice();

				notice.setNcode(resultSet.getInt("ncode"));
				notice.setMcode(resultSet.getInt("mcode"));
				notice.setTitle(resultSet.getString("title"));
				notice.setContent(resultSet.getString("content"));
				notice.setWritedate(resultSet.getString("to_char(writedate,'yyyy-mm-dd')"));
				notice.setCnt(resultSet.getInt("cnt"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(resultSet, pStatement, connection);
		}
		return notice;
	}

	@Override
	public List<Notice> selectByTitleContent(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void count(int ncode) {
		// TODO Auto-generated method stub

	}

}
