package DAO;

import static db.JdbcUtil.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import bean.SearchBean;

public class SearchDAO {
	private Connection con;
	private static SearchDAO searchDAO;
	PreparedStatement pstmt;
	private ResultSet rs;

	public void setConnection(Connection con) {
		this.con  = con;
		
	}
	
	public static SearchDAO getInstance() {
		if(searchDAO == null) {
			searchDAO = new SearchDAO();
		}
		return searchDAO;
	}

	
	  public ArrayList<SearchBean> selectSearchList(String keyword) {
		String sql = "SELECT * FROM PLAYLIST WHERE UPPER(LECTURE_LEVEL) LIKE UPPER(?) OR UPPER(CHAPTER_SUBJECT) LIKE UPPER(?) OR UPPER(CATEGORY) LIKE UPPER(?) ORDER BY PLAYLIST_NUM";
		ArrayList<SearchBean> searchList = new ArrayList<SearchBean>();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, '%'+keyword+'%');
			pstmt.setString(2, '%'+keyword+'%');
			pstmt.setString(3, '%'+keyword+'%');
			rs = pstmt.executeQuery();
			System.out.println("서치디에이오 키워드 : " + keyword);
			while(rs.next()) {
				SearchBean searchInfo = new SearchBean();
				searchInfo.setCategory(rs.getString("CATEGORY"));
				searchInfo.setLecture(rs.getString("LECTURE_LEVEL"));
				searchInfo.setImage(rs.getString("LECTURE_IMAGE"));
				searchInfo.setNum(rs.getInt("PLAYLIST_NUM"));
				searchInfo.setUrl(rs.getString("CHAPTER_URL"));
				searchInfo.setChapter(rs.getString("CHAPTER_SUBJECT"));
				searchList.add(searchInfo);
			}
		} catch (Exception e) {
			System.out.println("searchInfo 오류!! : "+e);
		} finally {
			close(rs);
			close(pstmt);
		}
		return searchList;
	}
}
