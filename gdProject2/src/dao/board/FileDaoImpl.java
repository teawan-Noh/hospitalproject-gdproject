package dao.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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
			pStatement.setLong(4, files.getFilesize());
			
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
			pStatement.setLong(4, files.getFilesize());

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

	@Override
	public int returnSeq() {
		int fileSeq = 0;
		
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.FILE_NAME_SEQ_SQL);
			resultSet = pStatement.executeQuery();
			
			while(resultSet.next()) {
				fileSeq = resultSet.getInt("nextval");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(resultSet, pStatement, connection);
		}
		
		
		return fileSeq;
	}

	@Override
	public List<Files> selectAll() {
		List<Files> bbsList = new ArrayList<>();

		/*Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;

		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.BBS_SELECT_ALL_SQL);
			resultSet = pStatement.executeQuery();

			while (resultSet.next()) {

				Bbs bbs = new Bbs();

				bbs.setNo(resultSet.getLong("no"));
				bbs.setSubject(resultSet.getString("subject"));
				bbs.setContent(resultSet.getString("content"));
				bbs.setWdata(resultSet.getString("to_char(wdata,'yyyy-mm-dd')"));
				bbs.setCnt(resultSet.getInt("cnt"));
				bbs.setId(resultSet.getString("id"));

				bbsList.add(bbs);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(resultSet, pStatement, connection);
		}*/

		return bbsList;
	}

	@Override
	public List<Files> returnFiles(int ncode) {
		List<Files> fileList = new ArrayList<>();

		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;

		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.RETURN_FILE_BY_NCODE_SQL);
			
			pStatement.setLong(1,ncode);
			
			resultSet = pStatement.executeQuery();

			while (resultSet.next()) {

				Files files = new Files();

				files.setFcode(resultSet.getInt("fcode"));
				files.setNcode(resultSet.getInt("ncode"));
				files.setUploaddate(resultSet.getString("uploaddate"));
				files.setName(resultSet.getString("name"));
				files.setBeforename(resultSet.getString("beforename"));
				files.setFilesize(resultSet.getLong("filesize"));

				fileList.add(files);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(resultSet, pStatement, connection);
		}

		return fileList;
	}

}
