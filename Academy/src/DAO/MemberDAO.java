package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import static db.JdbcUtil.*;
import javax.servlet.http.HttpServletRequest;

import bean.MemberBean;

public class MemberDAO {
	
	private static MemberDAO MemberDAO;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	public static MemberDAO getInstense() {
		if(MemberDAO == null) {
			MemberDAO = new MemberDAO();
		}
		return MemberDAO;
	}
	public void setConnection(Connection con) {
		this.con = con;
	}
	
	public boolean confirmId(String id) {
		boolean result = false;
		System.out.println("DAO");
		try {
			con = getConnection();
			System.out.println("DAO트라이안");
			String sql = "SELECT ID FROM MEMBER WHERE ID = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = true;
				System.out.println("DAO안에 if문");
			}
		}catch(Exception e) {
			System.out.println("아이디 중복확인 DAO : "+e);
		}
		return result;
	}

	public int insertMember(MemberBean memberBean) {
		int num = 0;
		String sql1 = "SELECT MAX(MEMBERNUM) FROM MEMBER";
		String sql = "INSERT INTO MEMBER VALUES (?,?,?,?,?,?,?,?)";
		int insertResult = 0;
		try {
			pstmt = con.prepareStatement(sql1);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				num = rs.getInt(1)+1;
			}else {
				num=1;
			}

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setString(2, memberBean.getNAME());
			pstmt.setInt(3, memberBean.getAGE());
			pstmt.setString(4, memberBean.getEMAIL());
			pstmt.setString(5, memberBean.getID());
			pstmt.setString(6, memberBean.getPASS());
			pstmt.setString(7, memberBean.getPHONE());
			pstmt.setString(8, memberBean.getGENDER());
			insertResult = pstmt.executeUpdate();
		}catch(Exception e){
			System.out.println("joinMember 오류 !! : "+e);
		}finally {
			close(pstmt);
		}
		return insertResult;
	}
	public String loginMember(MemberBean memberBean) {
		String loginId=null;
		String sql = "SELECT * FROM MEMBER WHERE ID=? AND PASS=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, memberBean.getID());
			pstmt.setString(2, memberBean.getPASS());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				loginId = rs.getString("ID");
			}
		}catch(Exception e) {
			System.out.println("loginMember 오류");
		}finally {
			close(pstmt);
			}
		return loginId;
	}
	public MemberBean memberSelectInfo(String me) {
		String sql = "SELECT * FROM MEMBER WHERE ID=?";
		MemberBean memberInfo=null;
		System.out.println("인포DAO페이지");
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, me);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				memberInfo = new MemberBean();
				memberInfo.setMEMBERNUM(rs.getInt("MEMBERNUM"));
				memberInfo.setNAME(rs.getString("NAME"));
				memberInfo.setAGE(rs.getInt("AGE"));
				memberInfo.setEMAIL(rs.getString("EMAIL"));
				memberInfo.setID(rs.getString("ID"));
				memberInfo.setPASS(rs.getString("PASS"));
				memberInfo.setPHONE(rs.getString("PHONE"));
				memberInfo.setGENDER(rs.getString("GENDER"));
			}
		}catch(Exception e) {
			System.out.println("info 메소드 오류 "+e);
		}finally {
			close(rs);
			close(pstmt);
			}
		return memberInfo;
	}
	
	
	public int modify(String id, String pass, String email, String phone) {
		System.out.println("modifyDAO");
		int upDateCount = 0;
		String sql = "UPDATE MEMBER SET EMAIL=?, PHONE=?, PASS=? WHERE ID=?";
		try {
			System.out.println("modifyDAO안의 try");
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, email);
			pstmt.setString(2, phone);
			pstmt.setString(3, pass);
			pstmt.setString(4, id);
			upDateCount = pstmt.executeUpdate();
		}catch(Exception e) {
			System.out.println("수정부분에러"+e);
		}finally {
			close(pstmt);
		}
		return upDateCount;
	}
	public int deleteMember(String delId) {
		
		String sql = "DELETE MEMBER WHERE ID=?";
		String sql1 = "DELETE COMPLETELIST WHERE ID=?";
		int deleteResult = 0;
		try {
			pstmt = con.prepareStatement(sql1);
			pstmt.setString(1, delId);
			pstmt.executeUpdate();
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, delId);
			deleteResult = pstmt.executeUpdate();
		}catch(Exception e) {
			System.out.println("deleteMember 오류"+e);
		}finally {
			close(pstmt);
		}
		return deleteResult;
	}
	public boolean MemberInsert(String delId, String pw) {
		String sql = "SELECT * FROM MEMBER WHERE ID=?";
		boolean password = false;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, delId);
			rs = pstmt.executeQuery();
			while(rs.next()){
			if(pw.equals(rs.getString("PASS"))) {
				password = true;
			}else {
				System.out.println("패스워드 DAO false값나옴");
			}}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rs);
		}
		
		return password;
	}
	public ArrayList<MemberBean> selectMemberList() {
		String sql = "SELECT * FROM MEMBER";
		ArrayList<MemberBean> memberList = new ArrayList<MemberBean>();
		MemberBean memberBean=null;
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				do {			    
					memberBean = new MemberBean();
					memberBean.setMEMBERNUM(rs.getInt("MEMBERNUM"));
					memberBean.setNAME(rs.getString("NAME"));
					memberBean.setAGE(rs.getInt("AGE"));
					memberBean.setID(rs.getString("ID"));
					memberBean.setEMAIL(rs.getString("EMAIL"));
					memberBean.setPASS(rs.getString("PASS"));
					memberBean.setPHONE(rs.getString("PHONE"));
					memberBean.setGENDER(rs.getString("GENDER"));
					memberList.add(memberBean);
				}while(rs.next());
			}
		}catch(Exception e) {
			System.out.println("list 메소드 오류 "+e);
		}finally {
			close(rs);
			close(pstmt);
			}
	return memberList;
	}
	
	public String id_search2(String name, String email) {
		 con=getConnection();
		  String user_id=null ; //찾을아이디
		  
		  String sql="SELECT ID from MEMBER WHERE NAME=? AND EMAIL=?";
		  
		  try{
		   pstmt=con.prepareStatement(sql);
		   pstmt.setString(1, name); 
		   pstmt.setString(2, email); 
		   
		   rs=pstmt.executeQuery(); 
		   while(rs.next()){  
		    user_id=rs.getString("ID"); //cnt를 디비에서 가져온 cnt에 저장  
		   }
		  }catch(Exception e){
		   System.out.println(e);
		  }finally {
			  close(con);
			  close(pstmt);
			  close(rs);
		  }
		  return user_id;	
	}
	public int AdminModify(MemberBean memberbean) {
		System.out.println("modifyDAO");
		int upDateCount = 0;
		String sql = "UPDATE MEMBER SET NAME=?, AGE=?, ID=?, EMAIL=?, PHONE=?, PASS=?,GENDER=? WHERE MEMBERNUM=?";
		try {
			System.out.println("modifyDAO안의 try");
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, memberbean.getNAME());
			pstmt.setInt(2, memberbean.getAGE());
			pstmt.setString(3, memberbean.getID());
			pstmt.setString(4, memberbean.getEMAIL());
			pstmt.setString(5, memberbean.getPHONE());
			pstmt.setString(6, memberbean.getPASS());
			pstmt.setString(7, memberbean.getGENDER());
			pstmt.setInt(8, memberbean.getMEMBERNUM());
			upDateCount = pstmt.executeUpdate();
		}catch(Exception e) {
			System.out.println("수정부분에러"+e);
		}finally {
			close(pstmt);
		}
		return upDateCount;
	}
}
