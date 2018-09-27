package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.ActionForward;
import bean.MemberBean;
import service.MemberLoginService;

public class MemberQALoginAction implements	Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		MemberBean memberBean = new MemberBean();
		ActionForward forward = null;
		
		memberBean.setID(request.getParameter("id"));
		memberBean.setPASS(request.getParameter("pass"));
		
		boolean loginResult = false;
		MemberLoginService memberLoginService = new MemberLoginService();
		loginResult = memberLoginService.loginMember(memberBean);
		
		String category=request.getParameter("category");
		int playlist_num=Integer.parseInt(request.getParameter("playlist_num"));
		String lecture_level=request.getParameter("lecture_level");
		int order_num=Integer.parseInt(request.getParameter("order_num"));
		
		
		if(loginResult) {
			HttpSession session = request.getSession();
			session.setAttribute("id", request.getParameter("id"));
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("playChapterViewAction.ac?order_num="+order_num+"&category="+category+"&playlist_num="+playlist_num+"&lecture_level="+lecture_level+"&id="+request.getParameter("id"));
		}else {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('이메일 또는 비밀번호가 일치하지 않습니다.')");
			out.println("history.back()</script>");
		}
		return forward;
	}

}
