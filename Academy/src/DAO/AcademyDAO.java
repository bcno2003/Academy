package DAO;

import static db.JdbcUtil.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.CompleteListBean;
import bean.QAboardBean;
import bean.playListBean;

public class AcademyDAO {
	private static AcademyDAO academyDAO;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public AcademyDAO() {
		
	}
	
	public static AcademyDAO getInstance() {
		if(academyDAO == null) {
			academyDAO = new AcademyDAO();
		}
		return academyDAO;
	}
	
	public void setConnection(Connection con) {
		this.con=con;
		
	}

	public ArrayList<playListBean> getLectureList(String category) {
		
		String sql = "SELECT DISTINCT LECTURE_LEVEL, CATEGORY, LECTURE_IMAGE FROM PLAYLIST WHERE CATEGORY LIKE ? ORDER BY LECTURE_LEVEL DESC";
		//중복되는 LECTURE_LEVEL을 제거하고 CATEGORY, LECTURE_IMAGE를 LECTURE_LEVEL DESC순으로 출력
		System.out.println("sql == "+sql);
		ArrayList<playListBean> playList = new ArrayList<playListBean>();
		
		playListBean list = new playListBean();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, category);
			rs = pstmt.executeQuery();
			//DB에서 출력되는 값들을 playListBean형태의 list객체에 저장
			if(rs.next()) {
				do {
					list = new playListBean();
					list.setCategory(rs.getString("CATEGORY"));
					list.setLecture_level(rs.getString("LECTURE_LEVEL"));
					list.setLecture_image(rs.getString("LECTURE_IMAGE"));
					
					playList.add(list);
					
				}while(rs.next());
			}
		}catch (Exception e) {
			System.out.println("playList 오류!!:"+e);
			e.printStackTrace();
		}finally{
			close(pstmt);
			close(rs);
		}
		
		return playList;
	}

	public ArrayList<playListBean> playChapterList(String lecture_level,String category) {

		String sql = "SELECT * FROM (SELECT ROWNUM ORDER_NUM, V1. * FROM " + "(SELECT * FROM PLAYLIST " + " WHERE LECTURE_LEVEL LIKE ? AND CATEGORY LIKE ?) V1) V2";
		
		ArrayList<playListBean> playChapterList = new ArrayList<playListBean>();
		
		playListBean ChapterList = new playListBean();
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, lecture_level);
			pstmt.setString(2, category);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				do {
					ChapterList = new playListBean();	
					ChapterList.setOrder_num(rs.getInt("ORDER_NUM"));
					ChapterList.setPlaylist_num(rs.getInt("PLAYLIST_NUM"));
					ChapterList.setCategory(rs.getString("CATEGORY"));
					ChapterList.setLecture_image(rs.getString("LECTURE_IMAGE"));
					ChapterList.setLecture_level(rs.getString("LECTURE_LEVEL"));
					ChapterList.setChapter_subject(rs.getString("CHAPTER_SUBJECT"));
					ChapterList.setChapter_url(rs.getString("CHAPTER_URL"));
				
					playChapterList.add(ChapterList);
				
				}while(rs.next());
			}
				
			
		}catch (Exception e) {
			System.out.println("playView 오류!!:"+e);
			e.printStackTrace();
		}finally{
			close(pstmt);
			close(rs);
		}
		return playChapterList;
	}

	public playListBean getPlayChapter(int order_num,String category,String lecture_level) {
		String sql="SELECT * FROM (SELECT ROWNUM ORDER_NUM, V1. * FROM " + "(SELECT * FROM PLAYLIST " + " WHERE CATEGORY LIKE ? AND LECTURE_LEVEL LIKE ?) V1) V2 WHERE ORDER_NUM=?";

		
		playListBean playChapter = new playListBean();
		
		try {
			System.out.println("DAOlecture_level=="+lecture_level);
			pstmt = con.prepareStatement(sql);
			//?부분 컬럼값 넣기
			pstmt.setString(1, category);
			pstmt.setString(2, lecture_level);
			pstmt.setInt(3, order_num);
			//쿼리문 실행
			rs = pstmt.executeQuery();
			if(rs.next()) {
				playChapter.setOrder_num(rs.getInt("ORDER_NUM"));
				playChapter.setPlaylist_num(rs.getInt("PLAYLIST_NUM"));
				playChapter.setCategory(rs.getString("CATEGORY"));
				playChapter.setLecture_level(rs.getString("LECTURE_LEVEL"));
				playChapter.setLecture_image(rs.getString("LECTURE_IMAGE"));
				playChapter.setChapter_subject(rs.getString("CHAPTER_SUBJECT"));
				playChapter.setChapter_url(rs.getString("CHAPTER_URL"));
				playChapter.setChapter_objectives(rs.getString("CHAPTER_OBJECTIVES"));
			}
		}catch (Exception e) {
				System.out.println("getPlayChapter 오류!!:"+e);
				e.printStackTrace();
			}finally{
				close(pstmt);
				close(rs);
			}
			return playChapter;
	
	}

	public int registQAboard(QAboardBean QABean) {
		String sql = "INSERT INTO QABOARD VALUES(?,?,?,?,?,SYSDATE)";
		//댓글 등록 번호 1증가 시키기 위한 sql
		String sql1 = "SELECT MAX(QABOARD_NUM) FROM QABOARD";
		
		int writeResult=0;
		int qaboard_num=0;
		
		try {
			//댓글번호 1증가 시키기 위한 부분
			pstmt = con.prepareStatement(sql1);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				qaboard_num=(rs.getInt("MAX(QABOARD_NUM)")+1);
			}else {
				qaboard_num=1;
			}
			
		//작성한 댓글 DB에 저장
		pstmt = con.prepareStatement(sql);
		//?부분 컬럼값 작성
		
		pstmt.setInt(1, qaboard_num);
		pstmt.setInt(2, QABean.getPlaylist_num());
		pstmt.setString(3, QABean.getLecture_level());
		pstmt.setString(4, QABean.getQaboard_name());
		pstmt.setString(5, QABean.getQaboard_content());
		
		writeResult=pstmt.executeUpdate();
		
		}catch (Exception e) {
			System.out.println("registReply 오류!!:"+e);
			e.printStackTrace();
		}finally{
			close(pstmt);
			close(rs);
		}
		return writeResult;
	}

	public ArrayList<QAboardBean> ChapterQAView(int playlist_num,int page, int limit) {
		String sql = "SELECT * FROM (SELECT ROWNUM RN2, V1. * FROM " +
				 "(SELECT * FROM QABOARD WHERE PLAYLIST_NUM=? ORDER BY QABOARD_NUM DESC) V1) V2 " + "WHERE V2.RN2 BETWEEN ? AND ?";
		
		int startrow = (page-1)*limit+1;
		int endrow = page*limit;
		ArrayList<QAboardBean> QAList = new ArrayList<QAboardBean>();
		
		QAboardBean list = new QAboardBean();
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,playlist_num);
			pstmt.setInt(2, startrow);
			pstmt.setInt(3, endrow);
			System.out.println("playlist_num == "+playlist_num);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				do {
					list = new QAboardBean();
					list.setQaboard_num(rs.getInt("QABOARD_NUM"));
					System.out.println("QABOARD_NUM == "+rs.getInt("QABOARD_NUM"));
					list.setPlaylist_num(rs.getInt("PLAYLIST_NUM"));
					list.setLecture_level(rs.getString("LECTURE_LEVEL"));
					list.setQaboard_name(rs.getString("QABOARD_NAME"));
					list.setQaboard_content(rs.getString("QABOARD_CONTENT"));
					list.setQaboard_date(rs.getDate("QABOARD_DATE"));
					
					QAList.add(list);
					
				}while(rs.next());
			}
		}catch (Exception e) {
			System.out.println("ChapterReplyList 오류!!:"+e);
			e.printStackTrace();
		}finally{
			close(pstmt);
			close(rs);
		}
		
		return QAList;
	}

	public int addPlayList(playListBean addPlayList) {
		//PLAYLIST 테이블에 값 입력을 위한 sql
		String sql="INSERT INTO PLAYLIST VALUES(?,?,?,?,?,?,?)";
				
		//댓글 등록 번호 1증가 시키기 위한 sql
		String sql1 = "SELECT MAX(PLAYLIST_NUM) FROM PLAYLIST";
		
		int addPlayResult=0;
		int playlist_num=0;
		
		try {
			//PLAYLIST_NUM 1증가 시키기 위한 부분
			pstmt = con.prepareStatement(sql1);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				playlist_num=(rs.getInt("MAX(PLAYLIST_NUM)")+1);
			}else {
				playlist_num=1;
			}
			
		//작성한 PLAYLIST DB에 저장
		pstmt = con.prepareStatement(sql);
		//?부분 컬럼값 작성
		
		pstmt.setInt(1, playlist_num);	
		pstmt.setString(2,addPlayList.getCategory());
		pstmt.setString(3,addPlayList.getLecture_level());
		pstmt.setString(4,addPlayList.getLecture_image());
		pstmt.setString(5,addPlayList.getChapter_subject());
		pstmt.setString(6,addPlayList.getChapter_url());
		pstmt.setString(7,"<pre>"+addPlayList.getChapter_objectives()+"</pre>");
		
		addPlayResult=pstmt.executeUpdate();
		
		}catch (Exception e) {
			System.out.println("addPlayList 오류!!:"+e);
			e.printStackTrace();
		}finally{
			close(pstmt);
			close(rs);
		}
		return addPlayResult;
	}

	public int getMaxOrder_num(String category,String lecture_level) {
		String sql="SELECT MAX(ORDER_NUM) FROM (SELECT ROWNUM ORDER_NUM, V1. * FROM " + "(SELECT * FROM PLAYLIST " + " WHERE CATEGORY LIKE ? AND LECTURE_LEVEL LIKE ?) V1) V2 ";
		
		int maxOrder_num = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, category);
			pstmt.setString(2, lecture_level);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				do {
					maxOrder_num = rs.getInt("MAX(ORDER_NUM)");
				}while(rs.next());
			}	
			
		}catch (Exception e) {
			System.out.println("getMaxOrder_num 오류!!:"+e);
			e.printStackTrace();
		}finally{
			close(pstmt);
			close(rs);
		}
		return maxOrder_num;
	}


	public int chapterCheck(CompleteListBean chapterCheckBean) {
		String sql = "INSERT INTO COMPLETELIST VALUES(?,?,?,?,?,?,SYSDATE)";
		//COMPLETELIST에 데이터 저장
		int checkResult = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, chapterCheckBean.getId());
			pstmt.setInt(2, chapterCheckBean.getPlaylist_num());
			pstmt.setString(3, chapterCheckBean.getCategory());
			pstmt.setString(4, chapterCheckBean.getLecture_level());
			pstmt.setString(5, chapterCheckBean.getLecture_image());
			pstmt.setString(6, chapterCheckBean.getChapter_subject());
			
			checkResult=pstmt.executeUpdate();
			
		}catch(Exception e) {
			System.out.println("chapterCheck 오류"+e);
		}finally{
			close(pstmt);
			close(rs);
		}
		return checkResult;
	}

	public ArrayList<CompleteListBean> getCompleteList(String id) {
		String sql = "SELECT * FROM COMPLETELIST WHERE ID=? ORDER BY PLAYLIST_NUM";
		System.out.println("ID==="+id);
		//id에 해당하는 COMPLETELIST의 모든 컬럼 출력
		ArrayList<CompleteListBean> CompleteList = new ArrayList<CompleteListBean>();
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,id);
			rs = pstmt.executeQuery();
			CompleteListBean list = new CompleteListBean();
			if(rs.next()) {
				do {
					list = new CompleteListBean();
					list.setId(rs.getString("ID"));
					list.setPlaylist_num(rs.getInt("PLAYLIST_NUM"));
					list.setCategory(rs.getString("CATEGORY"));
					list.setLecture_level(rs.getString("LECTURE_LEVEL"));
					list.setLecture_image(rs.getString("LECTURE_IMAGE"));
					list.setChapter_subject(rs.getString("CHAPTER_SUBJECT"));
					list.setComplete_date(rs.getDate("COMPLETE_DATE"));
					CompleteList.add(list);
					
				}while(rs.next());
			}
		}catch (Exception e) {
			System.out.println("getCompleteList 오류!!:"+e);
			e.printStackTrace();
		}finally{
			close(pstmt);
			close(rs);
		}
		
		return CompleteList;
	}

	public CompleteListBean getChapterCheck(String id, int playlist_num) {
		String sql = "SELECT * FROM COMPLETELIST WHERE ID=? AND PLAYLIST_NUM=?";
		CompleteListBean ChapterCheck = new CompleteListBean();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,id);
			pstmt.setInt(2, playlist_num);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				
				ChapterCheck.setId(rs.getString("ID"));
				ChapterCheck.setPlaylist_num(rs.getInt("PLAYLIST_NUM"));
				
			}
		}catch (Exception e) {
			System.out.println("getChapterCheck 오류!!:"+e);
			e.printStackTrace();
		}finally{
			close(pstmt);
			close(rs);
		}
		return ChapterCheck;
	}

	public ArrayList<playListBean> getCategoryList() {
		String sql = "SELECT DISTINCT CATEGORY FROM PLAYLIST";
		ArrayList<playListBean> categoryList = new ArrayList<playListBean>();
		
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			playListBean list = new playListBean();
			if(rs.next()) {
				do {
					list = new playListBean();
					list.setCategory(rs.getString("CATEGORY"));
					categoryList.add(list);
					
				}while(rs.next());
			}
		}catch (Exception e) {
			System.out.println("getCategoryList 오류!!:"+e);
			e.printStackTrace();
		}finally{
			close(pstmt);
			close(rs);
		}
		
		return categoryList;
	}
	
	//해당 챕터 영상 번호의 QA글 개수 가져오기 메소드
	public int getQAlistCount(int playlist_num) {
		int QAlistCount = 0;
		
		String sql = "SELECT COUNT(*) FROM QABOARD WHERE PLAYLIST_NUM=?";
		try {
			pstmt =con.prepareStatement(sql);
			pstmt.setInt(1, playlist_num);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				QAlistCount = rs.getInt(1);
			}
		}catch(Exception e) {
			System.out.println("글 갯수 오류 : "+e);
		}finally {
			close(rs);
			close(pstmt);
		}
		return QAlistCount;
	}

	public int getOrder_num(String category, String lecture_level, int playlist_num) {
		String sql="SELECT * FROM (SELECT ROWNUM ORDER_NUM, V1. * FROM " + "(SELECT * FROM PLAYLIST " + " WHERE CATEGORY LIKE ? AND LECTURE_LEVEL LIKE ?) V1) V2 WHERE PLAYLIST_NUM=?";

		int order_num=0;
		try {
			
			pstmt = con.prepareStatement(sql);
			//?부분 컬럼값 넣기
			pstmt.setString(1, category);
			pstmt.setString(2, lecture_level);
			pstmt.setInt(3, playlist_num);
			//쿼리문 실행
			rs = pstmt.executeQuery();
			if(rs.next()) {
				order_num=rs.getInt("ORDER_NUM");
			}
		}catch (Exception e) {
				System.out.println("getOrder_num 오류!!:"+e);
				e.printStackTrace();
			}finally{
				close(pstmt);
				close(rs);
			}
			return order_num;
	}

	public playListBean getPlayList_num_Info(int playlist_num) {
		String sql = "SELECT * FROM PLAYLIST WHERE PLAYLIST_NUM=?";
		
		playListBean playList_num_Info = new playListBean();
		
		try {
			
			pstmt = con.prepareStatement(sql);
			//?부분 컬럼값 넣기
			pstmt.setInt(1, playlist_num);
			//쿼리문 실행
			rs = pstmt.executeQuery();
			if(rs.next()) {
				playList_num_Info.setPlaylist_num(rs.getInt("PLAYLIST_NUM"));
				playList_num_Info.setCategory(rs.getString("CATEGORY"));
				playList_num_Info.setLecture_level(rs.getString("LECTURE_LEVEL"));
				playList_num_Info.setLecture_image(rs.getString("LECTURE_IMAGE"));
				playList_num_Info.setChapter_subject(rs.getString("CHAPTER_SUBJECT"));
				playList_num_Info.setChapter_url(rs.getString("CHAPTER_URL"));
				playList_num_Info.setChapter_objectives(rs.getString("CHAPTER_OBJECTIVES"));
			}
		}catch (Exception e) {
				System.out.println("getPlayList_num_Info 오류!!:"+e);
				e.printStackTrace();
			}finally{
				close(pstmt);
				close(rs);
			}
			return playList_num_Info;
	}

	public int ModifyPlayList(playListBean modifyPlayList) {
		//PLAYLIST 테이블에 값 입력을 위한 sql
		String sql="UPDATE PLAYLIST SET CATEGORY=?, LECTURE_LEVEL=?, LECTURE_IMAGE=?,CHAPTER_SUBJECT=?,CHAPTER_URL=?,CHAPTER_OBJECTIVES=? WHERE PLAYLIST_NUM=?";
		int ModifyResult = 0;				
		try {
		//작성한 PLAYLIST DB에 저장
		pstmt = con.prepareStatement(sql);
		//?부분 컬럼값 작성
		
		pstmt.setString(1,modifyPlayList.getCategory());
		pstmt.setString(2,modifyPlayList.getLecture_level());
		pstmt.setString(3,modifyPlayList.getLecture_image());
		pstmt.setString(4,modifyPlayList.getChapter_subject());
		pstmt.setString(5,modifyPlayList.getChapter_url());
		pstmt.setString(6,modifyPlayList.getChapter_objectives());
		pstmt.setInt(7, modifyPlayList.getPlaylist_num());	
				
		ModifyResult=pstmt.executeUpdate();
				
		}catch (Exception e) {
			System.out.println("ModifyResult 오류!!:"+e);
			e.printStackTrace();
		}finally{
			close(pstmt);
			close(rs);
		}
		return ModifyResult;
	}

	
}
