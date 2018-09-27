package service;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import bean.QAboardBean;
import DAO.AcademyDAO;

public class QAboardViewService {

	public ArrayList<QAboardBean> ChapterQAView(int playlist_num,int page,int limit) {
		AcademyDAO academyDAO = AcademyDAO.getInstance();
		Connection con = getConnection();
		academyDAO.setConnection(con);
		ArrayList<QAboardBean> replyList = academyDAO.ChapterQAView(playlist_num,page,limit);
		close(con);
		return replyList;
	}

	public int getQAlistCount(int playlist_num) {
		AcademyDAO academyDAO = AcademyDAO.getInstance();
		Connection con = getConnection();
		academyDAO.setConnection(con);
		
		int QAlistCount = 0;
		QAlistCount = academyDAO.getQAlistCount(playlist_num);
		close(con);
		return QAlistCount;
	}

	

}
