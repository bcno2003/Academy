package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.ActionForward;
import bean.playListBean;
import service.PlayListService;

public class MemberJoinFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		PlayListService playListService = new PlayListService();
		ArrayList<playListBean> categoryList = playListService.getCategoryList();
		
		request.setAttribute("categoryList", categoryList);
		
		forward = new ActionForward();
		forward.setPath("Academy/Member/MemberJoinForm.jsp");
		
		return forward;
	}

}
