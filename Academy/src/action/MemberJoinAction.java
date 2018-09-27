package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.ActionForward;
import bean.MemberBean;
import service.MemberJoinService;

public class MemberJoinAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		MemberBean memberBean = new MemberBean();
		HttpSession session = request.getSession();
		String repass = request.getParameter("repass");
		String pass = request.getParameter("pass");
		
		memberBean.setNAME(request.getParameter("name"));
		memberBean.setAGE(Integer.parseInt(request.getParameter("age")));
		memberBean.setEMAIL(request.getParameter("email"));
		memberBean.setPASS(request.getParameter("pass"));
		memberBean.setID(request.getParameter("id"));
		memberBean.setPHONE(request.getParameter("phone"));
		memberBean.setGENDER(request.getParameter("gender"));
		
		System.out.println(pass);
		System.out.println(repass);
		
		boolean joinResult = false;
		MemberJoinService memberJoinService = new MemberJoinService();
		joinResult = memberJoinService.joinMember(memberBean);
						ActionForward forward = null;
						
			if(joinResult == false) {
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('회원 가입 실패')");
				out.println("history.back()</script>");
				System.out.println("회원가입실패");

			}else {
				forward = new ActionForward();
				session.setAttribute("id", memberBean.getID());
				forward.setRedirect(true);
				forward.setPath("./MainAction.ac");
				System.out.println("회원가입성공db에 저장");
			}			
		return forward;
	}
}
