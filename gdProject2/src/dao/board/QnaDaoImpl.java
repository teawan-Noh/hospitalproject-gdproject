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
import common.page.PageManager;
import common.page.PageRowResult;
import model.board.Comments;
import model.board.Qna;

public class QnaDaoImpl implements QnaDao{

	@Override
	public void insert(Qna qna) {
	      Connection connection = null;
	      PreparedStatement pStatement = null;
	      
	      try {
	         connection = JDBCUtil.getConnection();
	         pStatement = connection.prepareStatement(Sql.QNA_INSERT_SQL);
	         //insert into qna values (qna_seq.nextval, ?, ?, ?, sysdate, ?, 0)
	         //***셋팅 수정
	         pStatement.setInt(1, qna.getPcode());
	         pStatement.setString(2, qna.getTitle());
	         pStatement.setString(3, qna.getContent());
	         pStatement.setString(4, qna.getImg());
	         
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
			//update qna set title = ?, content = ? whereq qno = ?
			pStatement.setString(1, qna.getTitle()); // ?값 셋팅 
			pStatement.setString(2, qna.getContent()); // ?값 셋팅 
			pStatement.setString(3, qna.getImg()); // ?값 셋팅 
			pStatement.setInt(4, qna.getQno()); // ?값 셋팅 
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
	public List<HashMap> selectAll(int requestPage) {
		List<HashMap> qnaList = new ArrayList<>();
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.QNA_SELECT_ALL_SQL);
			System.out.println("전체");
			PageManager pm = new PageManager(requestPage);
			PageRowResult prr = pm.getPageRowResult();
			
			pStatement.setInt(1, prr.getRowStartNumber());
			pStatement.setInt(2, prr.getRowEndNumber());
			
			resultSet = pStatement.executeQuery();
			
			while(resultSet.next()) {
				HashMap<String, String> hm = new HashMap<>();
				
				hm.put("rn", Integer.toString(resultSet.getInt("rn")));
				hm.put("qno", Integer.toString(resultSet.getInt("qno")));
				hm.put("title", resultSet.getString("title"));
				hm.put("pcode", Integer.toString(resultSet.getInt("pcode")));
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
	public List<HashMap> selectByNickname(String nickname, int requestPage) {
		List<HashMap> qnaList = new ArrayList<>();
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.QNA_SELECT_BY_NICKNAME_SQL);
			System.out.println("닉네임");
			PageManager pm = new PageManager(requestPage);
			PageRowResult prr = pm.getPageRowResult();
			
			pStatement.setString(1, '%'+nickname+'%');
			pStatement.setInt(2, prr.getRowStartNumber());
			pStatement.setInt(3, prr.getRowEndNumber());
			resultSet = pStatement.executeQuery();
			
			while(resultSet.next()) {
				HashMap<String, String> hm = new HashMap<>();
				
				hm.put("qno", Integer.toString(resultSet.getInt("qno")));
				hm.put("title", resultSet.getString("title"));
				hm.put("pcode", Integer.toString(resultSet.getInt("pcode")));
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
	public List<HashMap> selectByTitleOrContent(String searchValue, int requestPage) {
		List<HashMap> qnaList = new ArrayList<>();
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.QNA_SELECT_BY_TITLE_OR_CONTENT_SQL);
			System.out.println("제목내용");
			PageManager pm = new PageManager(requestPage);
			PageRowResult prr = pm.getPageRowResult();
			
			pStatement.setString(1, '%'+searchValue+'%');
			pStatement.setString(2, '%'+searchValue+'%');
			pStatement.setInt(3, prr.getRowStartNumber());
			pStatement.setInt(4, prr.getRowEndNumber());
			resultSet = pStatement.executeQuery();
			
			while(resultSet.next()) {
				HashMap<String, String> hm = new HashMap<>();
				
				hm.put("rn", Integer.toString(resultSet.getInt("rn")));
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
			
			pStatement.setInt(1, qno);
			resultSet = pStatement.executeQuery();
			
			if(resultSet.next()) {
				
				qnaDetail = new HashMap<>();
				
				qnaDetail.put("qno", Integer.toString(resultSet.getInt("qno")));
				qnaDetail.put("title", resultSet.getString("title"));
				qnaDetail.put("pcode", Integer.toString(resultSet.getInt("pcode")));
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
			//update qna set cnt = ? where no = ?
			pStatement.setInt(1, qna.getCnt()); // ?값 셋팅  
			pStatement.setInt(2, qna.getQno()); // ?값 셋팅  
			
			pStatement.executeUpdate();
			
		} catch (Exception e) {
			e.getStackTrace();
			
		} finally {
			
			JDBCUtil.close(null, pStatement, connection);
		}
		
	}



	@Override
	public int insertComment(Comments comment) {
		Connection connection = null;
	    PreparedStatement pStatement = null;
	    int value = 0;
	    
	    try {
	    	connection = JDBCUtil.getConnection();
	        pStatement = connection.prepareStatement(Sql.COMMNETS_INSERT_SQL);
	        //insert into comments values (?, ?, sysdate, ?)
	         
	        pStatement.setInt(1, comment.getQno());
	        pStatement.setInt(2, comment.getMcode());
	        pStatement.setString(3, comment.getContent());
	         
	        value = pStatement.executeUpdate(); 
	         
	    } catch (Exception e) {
	    	e.printStackTrace();
	    } finally {
	    	JDBCUtil.close(null, pStatement, connection); 
	    }
		return value;
	}

	@Override
	public Qna selectCntByQno(int qno) {
		Qna qna = null;
		
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.QNA_CNT_SELECT_BY_QNO_SQL);
			
			pStatement.setInt(1, qno);
			resultSet = pStatement.executeQuery();
			
			if(resultSet.next()) {
				
				qna = new Qna();
				
				qna.setCnt(resultSet.getInt("cnt"));
				
			}
			
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			JDBCUtil.close(resultSet, pStatement, connection);
		}
		
		return qna;
	}

}
