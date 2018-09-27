package service;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;

import DAO.AcademyDAO;

public class SearchChapterViewService {

	public int getOrder_num(String category, String lecture_level, int playlist_num) {
		AcademyDAO academyDAO = AcademyDAO.getInstance();
		Connection con = getConnection();
		academyDAO.setConnection(con);
		
		int order_num = academyDAO.getOrder_num(category,lecture_level,playlist_num);
		
		commit(con);
		close(con);
		return order_num;
	}

}
