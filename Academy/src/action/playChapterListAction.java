package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.ActionForward;
import bean.CompleteListBean;
import bean.playListBean;
import service.ChapterCheckService;
import service.PlayChapterListService;
import service.PlayListService;

public class playChapterListAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String lecture_level = request.getParameter("lecture_level");
		System.out.println("playChapterListAction lecture_level == "+lecture_level);
		String category = request.getParameter("category");
		System.out.println("playChapterListAction category=="+category);
		String id = request.getParameter("id");
		
		PlayChapterListService playChapterListService = new PlayChapterListService();
		
		ArrayList<playListBean> playChapterList = playChapterListService.playChapterList(lecture_level,category);
		//전달받은 lecture_level,category에 해당하는 챕터 목록 을 request 영역에 저장
		request.setAttribute("playChapterList", playChapterList);
		
		ChapterCheckService chapterCheckService = new ChapterCheckService();
		
		ArrayList<CompleteListBean> completeList = chapterCheckService.completeList(id);
		//id에 해당하는 수강완료 목록 저장
		request.setAttribute("completeList", completeList);
		request.setAttribute("lecture_level", lecture_level);
		
		//메뉴에서 category 이동을 위한 category 목록 가져오기
		PlayListService playListService = new PlayListService();
		ArrayList<playListBean> categoryList = playListService.getCategoryList();
		request.setAttribute("categoryList", categoryList);		
		
		ActionForward forward = null;
		forward = new ActionForward();
		forward.setPath("Academy/Lecture/ChapterList.jsp");
		return forward;
	}

}
