package service;

import static db.JdbcUtil.getConnection;

import java.sql.Connection;
import static db.JdbcUtil.*;

import DAO.BoardDAO;
import bean.boardBean;

public class BoardViewService {

	public boardBean getSubjectView(int me) {
		BoardDAO boardDAO = BoardDAO.getInstense();
		Connection con = getConnection();
		boardDAO.setConnection(con);
		boardBean sub = null;
		
		//조회수올리기
		int updateCount = boardDAO.updateCount(me); 
		if(updateCount > 0) {
			commit(con);
		}else {
			rollback(con);
		}
		
		//선택된 게시글 정보 가져오기
		sub = boardDAO.BoardView(me);
		close(con);
		return sub;
	}

}
