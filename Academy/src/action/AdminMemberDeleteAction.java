package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.ActionForward;
import service.MemberDeleteService;

public class AdminMemberDeleteAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		
		String delId = request.getParameter("id");
		MemberDeleteService memberDeleteService = 
				new MemberDeleteService();
		boolean deleteResult = 
				memberDeleteService.deleteMember(delId);
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		System.out.println("관리자의 회원 삭제 액션");
		forward = new ActionForward();
		forward.setPath("AdminInfo.se");
		return forward;
	}

}
