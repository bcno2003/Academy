package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.ActionForward;
import bean.MemberBean;
import bean.playListBean;
import service.MemberInfoService;
import service.PlayListService;

public class MemberAlterFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		
		MemberBean memberBean = new MemberBean();
		ActionForward forward = null;
		
		PlayListService playListService = new PlayListService();
		ArrayList<playListBean> categoryList = playListService.getCategoryList();
		
		request.setAttribute("categoryList", categoryList);
		
		String me = (String) request.getParameter("id");
		System.out.println("인포에서 아이디"+me);
		System.out.println("새션에서받은 아이디"+id);
		System.out.println("인포액션");
		forward = new ActionForward();
		MemberInfoService memberInfoService = new MemberInfoService();
		MemberBean memberInfo = 
					memberInfoService.getMemberlist(me);
		request.setAttribute("memberInfo", memberInfo);
		session.setAttribute("memberInfo", memberInfo);
		response.setContentType("text/html;charset=UTF-8");
		forward.setPath("Academy/Member/MemberAlterForm.jsp");
		
		return forward;
	}

}
