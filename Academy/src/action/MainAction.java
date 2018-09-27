package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.ActionForward;
import bean.playListBean;
import service.PlayListService;

public class MainAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		PlayListService playListService = new PlayListService();
		ArrayList<playListBean> categoryList = playListService.getCategoryList();
		
		//메인화면 강의 목록 메뉴에 출력 될 categoryList를  request 영역에 저장
		request.setAttribute("categoryList", categoryList);
		
		forward = new ActionForward();
		forward.setPath("Academy/Main.jsp");
		
		return forward;
	}

}
