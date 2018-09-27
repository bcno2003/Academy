package service;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import bean.SearchBean;
import DAO.SearchDAO;

public class SearchService {

	public ArrayList<SearchBean> serch(String keyword) {
		System.out.println("서치 서비스 키워드 : " + keyword);
		//DB에 접속
		//접속성공시 connect success출력
		Connection con = getConnection();
		//Action 클래스에 대한 싱글톤 객체를 얻어옴.
		SearchDAO searchDAO = SearchDAO.getInstance();
		//DB에 인증확인된 정보를 넘겨줌
		searchDAO.setConnection(con);
		//DB에 (member)insert 쿼리문을 전송
		
		ArrayList<SearchBean> SearchList = searchDAO.selectSearchList(keyword);
		
		close(con);
		return SearchList;
	}

}
