package service;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.rollback;

import java.sql.Connection;

import DAO.BoardDAO;
import bean.boardBean;

public class BoardCommentService {

	public boolean comment(boardBean boardBean) {
		BoardDAO boardDAO = BoardDAO.getInstense();
		Connection con = getConnection();
		boardDAO.setConnection(con);
		boolean comResult = false;
		System.out.println("코맨트 서비스");
		int comCount = boardDAO.comment(boardBean);
		
		if(comCount > 0) {
			commit(con);
			comResult = true;
		}else {
			rollback(con);
			comResult = false;
		}
		close(con);
		return comResult;
	}

}
