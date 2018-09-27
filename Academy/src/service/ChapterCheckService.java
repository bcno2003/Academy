package service;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import bean.CompleteListBean;
import DAO.AcademyDAO;

public class ChapterCheckService {

	public boolean chapterCheck(CompleteListBean chapterCheckBean) {
		
		AcademyDAO academyDAO = AcademyDAO.getInstance();
		Connection con = getConnection();
		academyDAO.setConnection(con);
		
		boolean checkResult = false;
		
		int result = academyDAO.chapterCheck(chapterCheckBean);
		
		if(result > 0) {
			checkResult = true;
			commit(con);
			
		}else {
			checkResult = false;
			rollback(con);
			
		}
		close(con);
		return checkResult;
	}

	public ArrayList<CompleteListBean> completeList(String id) {
		AcademyDAO academyDAO = AcademyDAO.getInstance();
		Connection con = getConnection();
		academyDAO.setConnection(con);
		
		ArrayList<CompleteListBean> completeList = academyDAO.getCompleteList(id);
		
		close(con);
		return completeList;
	}

	public CompleteListBean getChapterCheck(String id, int playlist_num) {
		AcademyDAO academyDAO = AcademyDAO.getInstance();
		Connection con = getConnection();
		academyDAO.setConnection(con);
		
		CompleteListBean ChapterCheck = academyDAO.getChapterCheck(id, playlist_num);
		close(con);
		return ChapterCheck;
	}

}
