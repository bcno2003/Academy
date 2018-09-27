package service;

import static db.JdbcUtil.*;

import java.sql.Connection;

import javax.servlet.http.HttpSession;

import DAO.BoardDAO;
import bean.boardBean;

public class BoardAlterService {

	//아이디 일치여부를 위한 메소드
	public boolean getAlterBoard(String boardname,int num) {
		BoardDAO boardDAO = BoardDAO.getInstense();
		Connection con = getConnection();
		boardDAO.setConnection(con);
		
		boolean bb = boardDAO.BoardInsert(boardname,num);
		close(con);
		return bb;
	}

	public boolean modify(boardBean bb) {
		BoardDAO boardDAO = BoardDAO.getInstense();
		Connection con = getConnection();
		boardDAO.setConnection(con);// db연결
		
		boolean sc = false; //false 설정 
		int modify = boardDAO.modify(bb);
		
		if(modify >0) {
			sc = true;
			commit(con);
		}else {
			sc = false;
			rollback(con);
		}
		close(con);
		return sc;
	}
}
