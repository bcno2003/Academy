package service;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.rollback;

import java.sql.Connection;

import bean.QAboardBean;
import DAO.AcademyDAO;

public class QAboardWriteService {

	public boolean registQAboard(QAboardBean QABean) {
		AcademyDAO academyDAO = AcademyDAO.getInstance();
		Connection con = getConnection();
		academyDAO.setConnection(con);
		
		boolean registReplyResult= false;
		
		int result = academyDAO.registQAboard(QABean);
		
		if(result > 0) {
			registReplyResult = true;
			commit(con);
			
		}else {
			registReplyResult = false;
			rollback(con);
			
		}
		close(con);
		return registReplyResult;
	}

}
