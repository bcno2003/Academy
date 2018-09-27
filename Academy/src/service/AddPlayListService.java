package service;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.rollback;

import java.sql.Connection;

import bean.playListBean;
import DAO.AcademyDAO;

public class AddPlayListService {

	public boolean addPlayList(playListBean addPlayList) {
		AcademyDAO academyDAO = AcademyDAO.getInstance();
		Connection con = getConnection();
		academyDAO.setConnection(con);
		
		boolean addResult = false;
		
		int result = academyDAO.addPlayList(addPlayList);
		//결과를 int형태의 result로 입력 받는다.
		//result의 값에 따라 addResult값 입력
		if(result > 0) {
			addResult = true;
			commit(con);
			
		}else {
			addResult = false;
			rollback(con);
			
		}
		close(con);
		return addResult;
	}

}
