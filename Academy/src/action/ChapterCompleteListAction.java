package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.ActionForward;
import bean.CompleteListBean;
import bean.playListBean;
import service.CompleteListService;
import service.PlayChapterListService;
import service.PlayListService;

public class ChapterCompleteListAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String id = request.getParameter("id");
		
		CompleteListService completeListService = new CompleteListService();
		//전달 받은 id에 해당하는 수강완료목록을 DB에서 받아온다.
		ArrayList<CompleteListBean> CompleteList = completeListService.getCompleteList(id);
		
		//수강완료 목록을 request영역에 저장
		request.setAttribute("CompleteList", CompleteList);
		
		PlayListService playListService = new PlayListService();
		ArrayList<playListBean> categoryList = playListService.getCategoryList();
		//카테고리 목록을 request영역에 저장
		request.setAttribute("categoryList", categoryList);
		
		
		ActionForward forward = null;
		forward = new ActionForward();
		forward.setPath("Academy/Lecture/ChapterCompleteList.jsp");
		return forward;
	}

}
