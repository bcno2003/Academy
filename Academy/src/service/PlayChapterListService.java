package service;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import bean.playListBean;
import DAO.AcademyDAO;

public class PlayChapterListService {

	public ArrayList<playListBean> playChapterList(String lecture_level,String category) {
		AcademyDAO academyDAO = AcademyDAO.getInstance();
		Connection con = getConnection();
		academyDAO.setConnection(con);
		
		ArrayList<playListBean> playLectureList = academyDAO.playChapterList(lecture_level,category);
		
		commit(con);
		close(con);
		return playLectureList;
	}

}
