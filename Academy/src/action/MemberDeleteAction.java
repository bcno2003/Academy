package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.MemberDeleteService;
import bean.ActionForward;

public class MemberDeleteAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String delId = request.getParameter("id");
		String pw = request.getParameter("pass");
		ActionForward forward = null;
		MemberDeleteService memberDeleteService = 
				new MemberDeleteService();
		boolean deleteResult = false; 
		
		boolean Result = memberDeleteService.getPwResult(delId, pw);
		
		if(Result) {
			deleteResult = memberDeleteService.deleteMember(delId);
		if(deleteResult) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			System.out.println("탈퇴완료 액션");
			out.println("<script>");
			out.println("alert('회원탈퇴가 완료되었습니다.')");
			out.println("</script>");
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("./index.se");
		}else {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('못나감.')");
			out.println("location.href='./MemberIofoAction.se'</script>");
		}
	}else{
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<script>");
		out.println("alert('비밀번호가 일치하지 않습니다.')");
		out.println("location.href='index.jsp'");
		out.println("</script>");
		}
		return forward;
	}
}
