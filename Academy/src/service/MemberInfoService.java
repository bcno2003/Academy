package service;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import DAO.MemberDAO;
import bean.MemberBean;

public class MemberInfoService {

	public  MemberBean getMemberlist(String me) {
		MemberDAO memberDAO = MemberDAO.getInstense();
		Connection con = getConnection();
		memberDAO.setConnection(con);
		
		MemberBean memberInfo = 
				memberDAO.memberSelectInfo(me);
		close(con);
		return memberInfo;
	}

}
