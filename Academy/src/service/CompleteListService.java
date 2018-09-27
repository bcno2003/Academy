package service;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import bean.CompleteListBean;
import bean.playListBean;
import DAO.AcademyDAO;

public class CompleteListService {

	public ArrayList<CompleteListBean> getCompleteList(String id) {
		AcademyDAO academyDAO = AcademyDAO.getInstance();
		Connection con = getConnection();
		academyDAO.setConnection(con);
		
		ArrayList<CompleteListBean> CompleteList = academyDAO.getCompleteList(id);
		commit(con);
		close(con);
		return CompleteList;
	}

	
}
