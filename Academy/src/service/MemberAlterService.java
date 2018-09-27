package service;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.rollback;

import java.sql.Connection;

import DAO.MemberDAO;
import bean.MemberBean;

public class MemberAlterService {

	public boolean modify(String id, String pass, String email, String phone) {
		System.out.println("정보수정 서비스");
		MemberDAO memberDAO = MemberDAO.getInstense();
		Connection con = getConnection();
		memberDAO.setConnection(con);
		boolean sc = false;
		int modify = memberDAO.modify(id,pass,email,phone);
		
		if(modify >0) {
			sc = true;
			System.out.println("수정성공 서비스");
			commit(con);
		}else {
			sc = false;
			System.out.println("수정실패 서비스");
			rollback(con);
		}
		close(con);
		return sc;
	}

	public boolean AdminModify(MemberBean memberbean) {
		System.out.println("정보수정 서비스");
		MemberDAO memberDAO = MemberDAO.getInstense();
		Connection con = getConnection();
		memberDAO.setConnection(con);
		boolean sc = false;
		int modify = memberDAO.AdminModify(memberbean);
		
		if(modify >0) {
			sc = true;
			System.out.println("수정성공 서비스");
			commit(con);
		}else {
			sc = false;
			System.out.println("수정실패 서비스");
			rollback(con);
		}
		return sc;
	}

}
