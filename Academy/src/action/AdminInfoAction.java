package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.MemberListService;
import service.PlayListService;
import bean.ActionForward;
import bean.MemberBean;
import bean.playListBean;

public class AdminInfoAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		
		MemberBean memberBean = new MemberBean();
		ActionForward forward = null;

		forward = new ActionForward();
		MemberListService memberListService = new MemberListService();
		ArrayList<MemberBean> memberList = 
				memberListService.getMemberlist();
		//request영역에 호출결과를 저장
		request.setAttribute("memberList", memberList);
		
		//메인메뉴 강의 목록을 위한 메소드
		PlayListService playListService = new PlayListService();
		ArrayList<playListBean> categoryList = playListService.getCategoryList();
		
		request.setAttribute("categoryList", categoryList);
		
		forward.setPath("Academy/Member/Admin_info.jsp");
		return forward;
		
	}

}
