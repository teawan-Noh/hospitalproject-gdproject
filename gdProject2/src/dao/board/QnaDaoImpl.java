package dao.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import common.JDBCUtil;
import common.Sql;
import model.board.Qna;

public class QnaDaoImpl implements QnaDao{

	@Override
	public void insert(Qna qna) {
	      Connection connection = null;
	      PreparedStatement pStatement = null;
	      
	      try {
	         connection = JDBCUtil.getConnection();
	         pStatement = connection.prepareStatement(Sql.QNA_INSERT_SQL);
	         //insert into memo values (seqMemo.nextval, ?, ?)
	         //***셋팅 수정
	         pStatement.setString(1, qna.getTitle());
	         pStatement.setInt(2, qna.getQno());
	         
	         pStatement.executeUpdate(); 
	         
	      } catch (Exception e) {
	         e.printStackTrace();
	      } finally {
	         JDBCUtil.close(null, pStatement, connection); 
	      }
	   }

	@Override
	public void update(Qna qna) {
		
		Connection connection = null;
		PreparedStatement pStatement = null;
		
		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.QNA_UPDATE_SQL);
			//update memo set name = ?, age = ? where memoid = ?
			pStatement.setString(1, qna.getContent()); // ?값 셋팅 
			//insert, delete, update에 사용
			pStatement.executeUpdate();
			
		} catch (Exception e) {
			e.getStackTrace();
			
		} finally {
			
			JDBCUtil.close(null, pStatement, connection);
		}
		
	}

	@Override
	public void delete(int qno) {
		Connection connection = null;
		PreparedStatement pStatement = null;
		
		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.QNA_DELETE_SQL);
			//delete from memo where memoid = ?
			pStatement.setInt(1, qno); // ?값 셋팅 
			//insert, delete, update에 사용
			pStatement.executeUpdate();
			
		} catch (Exception e) {
			e.getStackTrace();
			
		} finally {
			
			JDBCUtil.close(null, pStatement, connection);
		}
		
	}

	@Override
	public List<HashMap> selectAll() {
		List<HashMap> qnaList = new ArrayList<>();
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.QNA_SELECT_ALL_SQL);
			//select q.qno, q.title, p.nickname, q.writedate, q.cnt 
			//from qna q inner join patient p 
			//on q.pcode = p.pcode order by q.qno desc;
			resultSet = pStatement.executeQuery();
			
			while(resultSet.next()) {
				HashMap<String, String> hm = new HashMap<>();
				
				hm.put("qno", Integer.toString(resultSet.getInt("qno")));
				hm.put("title", resultSet.getString("title"));
				hm.put("nickname", resultSet.getString("nickname"));
				hm.put("writedate", resultSet.getString("writedate"));
				hm.put("cnt",  Integer.toString(resultSet.getInt("cnt")));
				qnaList.add(hm);
			}
			
		}
		catch(SQLException se) {
			se.printStackTrace();
		} 
		catch (Exception e) {
			e.getStackTrace();
		} finally {
			JDBCUtil.close(resultSet, pStatement, connection);
		}
		
		return qnaList;
	}

	@Override
	public List<HashMap> selectByNickname(String nickname) {
		List<HashMap> qnaList = new ArrayList<>();
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.QNA_SELECT_BY_NICKNAME_SQL);
			//select q.qno, q.title, p.nickname, q.writedate, q.cnt 
			//from qna q inner join patient p on q.pcode = p.pcode 
			//where p.nickname = ? order by q.qno desc;
			pStatement.setString(1, nickname);
			resultSet = pStatement.executeQuery();
			
			while(resultSet.next()) {
				HashMap<String, String> hm = new HashMap<>();
				
				hm.put("qno", Integer.toString(resultSet.getInt("qno")));
				hm.put("title", resultSet.getString("title"));
				hm.put("nickname", resultSet.getString("nickname"));
				hm.put("writedate", resultSet.getString("writedate"));
				hm.put("cnt",  Integer.toString(resultSet.getInt("cnt")));
				qnaList.add(hm);
			}
			
		}
		catch(SQLException se) {
			se.printStackTrace();
		} 
		catch (Exception e) {
			e.getStackTrace();
		} finally {
			JDBCUtil.close(resultSet, pStatement, connection);
		}
		
		return qnaList;
	}
	@Override
	public HashMap selectByQno(int qno) {
		HashMap<String, String> qnaDetail = null;
		
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.QNA_SELECT_BY_QNO_SQL);
			
			//select memoid, name, age from memo where memoid=?
			pStatement.setInt(1, qno);
			resultSet = pStatement.executeQuery();
			
			if(resultSet.next()) {
				
				qnaDetail = new HashMap<>();
				
				qnaDetail.put("qno", Integer.toString(resultSet.getInt("qno")));
				qnaDetail.put("title", resultSet.getString("title"));
				qnaDetail.put("nickname", resultSet.getString("nickname"));
				qnaDetail.put("writedate", resultSet.getString("writedate"));
				qnaDetail.put("cnt", Integer.toString(resultSet.getInt("cnt")));
				qnaDetail.put("img", resultSet.getString("img"));
				qnaDetail.put("content", resultSet.getString("content"));
				qnaDetail.put("ccontent", resultSet.getString("ccontent"));
				qnaDetail.put("cwritedate", resultSet.getString("cwritedate"));
				qnaDetail.put("id", resultSet.getString("id"));
				
			}
			
		}
		catch(NumberFormatException se) {
			se.printStackTrace();
		} 
		catch (Exception e) {
			e.getStackTrace();
		}
		finally {
			JDBCUtil.close(resultSet, pStatement, connection);
		}
		
		return qnaDetail;
	}
	
	@Override
	public void cntUpdate(Qna qna) {
		Connection connection = null;
		PreparedStatement pStatement = null;
		
		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.QNA_CNT_UPDATE_SQL);
			//update bbs set cnt = ? where no = ?
			pStatement.setInt(1, qna.getCnt()); // ?값 셋팅  
			pStatement.setInt(2, qna.getQno()); // ?값 셋팅  
			
			pStatement.executeUpdate();
			
		} catch (Exception e) {
			e.getStackTrace();
			
		} finally {
			
			JDBCUtil.close(null, pStatement, connection);
		}
		
	}

	
}
