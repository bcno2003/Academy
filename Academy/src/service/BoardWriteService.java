package service;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.*;
import java.sql.*;

import javax.servlet.http.HttpSession;

import DAO.BoardDAO;
import bean.boardBean;

public class BoardWriteService {
	
	public boolean BoardService(boardBean boardBean){
		BoardDAO boardDAO = BoardDAO.getInstense();
		Connection con = getConnection();
		boardDAO.setConnection(con);
		boolean boardResult = false;
		int result = boardDAO.registArticle(boardBean);
		System.out.println("서비스  ID>"+boardBean.getBOARD_NAME());
		System.out.println("board서비스부분");

		if(result > 0) { 
			boardResult = true;
			commit(con);
		}else {
			boardResult = false;
			rollback(con);
		}
	close(con);
	return boardResult;
	
}
		
	}

