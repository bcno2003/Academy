package service;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.rollback;

import java.sql.Connection;

import DAO.AcademyDAO;
import bean.playListBean;

public class ModifyPlayListService {

	public boolean ModifyPlayList(playListBean modifyPlayList) {
		AcademyDAO academyDAO = AcademyDAO.getInstance();
		Connection con = getConnection();
		academyDAO.setConnection(con);
		
		boolean ModifyResult = false;
		
		int result = academyDAO.ModifyPlayList(modifyPlayList);
		//결과를 int형태의 result로 입력 받는다.
		//result의 값에 따라 ModifyResult값 입력
		if(result > 0) {
			ModifyResult = true;
			commit(con);
			
		}else {
			ModifyResult = false;
			rollback(con);
			
		}
		close(con);
		return ModifyResult;
	}

}
