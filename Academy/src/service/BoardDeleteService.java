package service;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.rollback;

import java.sql.Connection;

import DAO.BoardDAO;

public class BoardDeleteService {

	public boolean deleteBoard(String boardname,int num) {
		BoardDAO boardDAO = BoardDAO.getInstense();
		Connection con = getConnection();
		boardDAO.setConnection(con);
		
		boolean deleteResult = false;
		
		int deleteCount = boardDAO.deleteBoard(boardname,num);
		
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

}
