package service;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import DAO.MemberDAO;
import bean.MemberBean;

public class MemberListService {

	public ArrayList<MemberBean> getMemberlist() {
		MemberDAO memberDAO = MemberDAO.getInstense();
		Connection con = getConnection();
		memberDAO.setConnection(con);
		
		ArrayList<MemberBean> memberList = memberDAO.selectMemberList();
		close(con);
		
		return memberList;
	}

}
