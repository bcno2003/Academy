package service;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.rollback;

import java.sql.Connection;
import DAO.MemberDAO;

public class MemberDeleteService {

	public boolean deleteMember(String delId) {
		MemberDAO memberDAO = MemberDAO.getInstense();
		Connection con = getConnection();
		memberDAO.setConnection(con);
		
		boolean deleteResult = false;
		
		int deleteCount = memberDAO.deleteMember(delId);
		
		if(deleteCount > 0) {
			commit(con);
			deleteResult = true;
		}else {
			rollback(con);
			deleteResult = false;
		}
		close(con);
		return deleteResult;
	}

	public boolean getPwResult(String delId, String pw) {
		MemberDAO memberDAO = MemberDAO.getInstense();
		Connection con = getConnection();
		memberDAO.setConnection(con);
		
		boolean password = memberDAO.MemberInsert(delId, pw);
		close(con);
		return password;
	}
	
	
	
	
}
