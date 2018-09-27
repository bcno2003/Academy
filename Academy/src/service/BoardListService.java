package service;

import bean.boardBean;

import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.*;

import java.sql.Connection;
import java.util.ArrayList;

import DAO.BoardDAO;


public class BoardListService {
	
	public int getListCount() {
		BoardDAO boardDAO = BoardDAO.getInstense();
		Connection con = getConnection();
		boardDAO.setConnection(con);
		
		int listCount = 0;
		listCount = boardDAO.getListCount();
		close(con);
		return listCount;
	}

	

	public ArrayList<boardBean> getBoardList(int page, int limit) {
		BoardDAO boardDAO = BoardDAO.getInstense();
		Connection con = getConnection();
		boardDAO.setConnection(con);
		
		ArrayList<boardBean> boardList = 
				boardDAO.getBoardList(page, limit);
		close(con);
		
		return boardList;
	}

	

}










