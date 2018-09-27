package service;

import static db.JdbcUtil.*;

import java.sql.Connection;
import java.util.ArrayList;

import bean.playListBean;
import DAO.AcademyDAO;

public class PlayListService {

	public ArrayList<playListBean> getLectureList(String category) {

		AcademyDAO academyDAO = AcademyDAO.getInstance();
		Connection con = getConnection();
		academyDAO.setConnection(con);
		
		ArrayList<playListBean> playList = academyDAO.getLectureList(category);
		
		close(con);
		
		return playList;
	}

	public ArrayList<playListBean> getCategoryList() {
		AcademyDAO academyDAO = AcademyDAO.getInstance();
		Connection con = getConnection();
		academyDAO.setConnection(con);
		
		ArrayList<playListBean> categoryList = academyDAO.getCategoryList();
		
		close(con);
		
		return categoryList;
	}

	public playListBean getPlayList_num_Info(int playlist_num) {
		AcademyDAO academyDAO = AcademyDAO.getInstance();
		Connection con = getConnection();
		academyDAO.setConnection(con);
		
		playListBean PlayList_num_Info = academyDAO.getPlayList_num_Info(playlist_num);
		
		close(con);
		
		return PlayList_num_Info;
	}

}
