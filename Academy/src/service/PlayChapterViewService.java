package service;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;

import bean.playListBean;
import DAO.AcademyDAO;

public class PlayChapterViewService {

	public playListBean playChapter(int order_num,String category,String lecture_level) {
		// TODO Auto-generated method stub
		AcademyDAO academyDAO = AcademyDAO.getInstance();
		Connection con = getConnection();
		academyDAO.setConnection(con);
		
		playListBean playChapter = academyDAO.getPlayChapter(order_num,category,lecture_level);
		
		commit(con);
		close(con);
		return playChapter;
	}

	public int getMaxOrder_num(String category,String lecture_level) {
		AcademyDAO academyDAO = AcademyDAO.getInstance();
		Connection con = getConnection();
		academyDAO.setConnection(con);
		
		int maxOrder_num = academyDAO.getMaxOrder_num(category,lecture_level);
		close(con);
		return maxOrder_num;
	}


}
