package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.ActionForward;
import bean.CompleteListBean;
import bean.QAPageInfo;
import bean.QAboardBean;
import bean.playListBean;
import service.ChapterCheckService;
import service.PlayChapterListService;
import service.PlayChapterViewService;
import service.PlayListService;
import service.QAboardViewService;

public class playChapterViewAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//강의 영상 페이지 불러오는 부분
		
		String category = request.getParameter("category");
		int order_num = Integer.parseInt(request.getParameter("order_num"));
		String lecture_level = request.getParameter("lecture_level");
		
		System.out.println("lecture_level == "+lecture_level);
		
		System.out.println("order_num == " + order_num);
		PlayChapterViewService playChapterViewService = new PlayChapterViewService();
		
		playListBean playChapter = playChapterViewService.playChapter(order_num,category,lecture_level);
		
		request.setAttribute("playChapter", playChapter);
		
		int playlist_num = playChapter.getPlaylist_num();
		
		//카테고리에 해당하는 가장 큰 ORDER_NUM 찾기
		int maxOrder_num = playChapterViewService.getMaxOrder_num(category,lecture_level);
		System.out.println(request.getParameter("id"));
		request.setAttribute("maxOrder_num", maxOrder_num);
		
		//수강확인 
		//로그인한 id를 전달 받은 경우에만 확인
		if(request.getParameter("id")!=null) {
			String id = request.getParameter("id");
			if(request.getParameter("playlist_num")!=null) {
				playlist_num = Integer.parseInt(request.getParameter("playlist_num"));
				System.out.println("request플레이번호는=="+playlist_num);
			}else {
				playlist_num=playChapter.getPlaylist_num();
				System.out.println("getPlaylist_num()=="+playlist_num);
			}
			
			ChapterCheckService chapterCheckService = new ChapterCheckService();
			
			CompleteListBean chapterCheck = chapterCheckService.getChapterCheck(id,playlist_num);
			request.setAttribute("chapterCheck", chapterCheck);
			
			ArrayList<CompleteListBean> completeList = chapterCheckService.completeList(id);
			request.setAttribute("completeList", completeList);
		}
		
		
		//메뉴에서 category 이동을 위한 category 목록 가져오기
		PlayListService playListService = new PlayListService();
		ArrayList<playListBean> categoryList = playListService.getCategoryList();
		request.setAttribute("categoryList", categoryList);		
		
		//View 페이지 내부의 팝업 목록을 가져오기 위한 메소드
		PlayChapterListService playChapterListService = new PlayChapterListService();
		
		ArrayList<playListBean> playChapterList = playChapterListService.playChapterList(lecture_level,category);
		
		request.setAttribute("playChapterList", playChapterList);
		
		//댓글 불러오는 부분
				QAboardViewService QAViewService = new QAboardViewService();
				//페이지 번호를 알기위해 사용하는 변
				int page = 1;
				//한 페이지에 보여줄 글 갯수를 정하기 위해 사용하는 변수
				int limit = 5 ;
				//page 파라메터값 검사
				if(request.getParameter("page")!=null) {
					page= Integer.parseInt(request.getParameter("page"));
				}	
				
				int QAlistCount = QAViewService.getQAlistCount(playlist_num);
					
				//limit 값을 걸어놓은 만큼 범위에 해당하는 글만 가져오는 방법		
				ArrayList<QAboardBean> chapterQAView = (ArrayList<QAboardBean>)QAViewService.ChapterQAView(playlist_num,page,limit);
						
				request.setAttribute("chapterQAView", chapterQAView);
				
				//페이지 계산을 위한 부분
				//최대로 필요한 페이지 갯수 계산
				int maxQAPage=(int)((double)QAlistCount/limit +1);
				//현재 페이지에 보여줄 시작 페이지 번호
				int startQAPage = (((int)((double)page/10 + 0.9))-1)*10+1;
				
				int endQAPage = startQAPage + 10 - 1 ;
				
				if(endQAPage>maxQAPage){
					endQAPage = maxQAPage;
				}
				QAPageInfo QApageInfo = new QAPageInfo();
				QApageInfo.setQApage(page);
				QApageInfo.setStartQAPage(startQAPage);
				QApageInfo.setEndQAPage(endQAPage);
				QApageInfo.setMaxQAPage(maxQAPage);
				QApageInfo.setQAlistCount(QAlistCount);
				
				request.setAttribute("QApageInfo", QApageInfo);
		
		ActionForward forward = null;
		forward = new ActionForward();
		forward.setPath("Academy/Lecture/ChapterView.jsp");
		return forward;
	}

}
