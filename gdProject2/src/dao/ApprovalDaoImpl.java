package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import model.Approval;

public class ApprovalDaoImpl implements ApprovalDao {

	@Override
	public void insert(Approval approval) {
		Connection connection = null;
		PreparedStatement pStatement = null;
		
		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.APPROVAL_INSERT_SQL); 
				
			pStatement.setInt(1, approval.getDcode()); 
			pStatement.setString(2, approval.getApprovedate());
			pStatement.setString(3, approval.getApproved());
			pStatement.setString(4, approval.getReason());
			
			pStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(null, pStatement, connection);
		}
	}

}
