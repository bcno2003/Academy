package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.ActionForward;
import bean.MemberBean;
import service.MemberAlterService;

public class Admin_MemberAlterAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int membernum = Integer.parseInt(request.getParameter("num"));
		String id = request.getParameter("id");
		
		String pass = request.getParameter("pass");
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String gender = request.getParameter("gender");
		int age = Integer.parseInt(request.getParameter("age"));
		
		MemberBean memberbean = new MemberBean();
		memberbean.setMEMBERNUM(membernum);
		memberbean.setID(id);
		memberbean.setPASS(pass);
		memberbean.setNAME(name);
		memberbean.setEMAIL(email);
		memberbean.setPHONE(phone);
		memberbean.setGENDER(gender);
		memberbean.setAGE(age);
		
		MemberAlterService memberAlterService = new MemberAlterService();
		boolean success = false;
		ActionForward forward = null;
		
		success = memberAlterService.AdminModify(memberbean);
			if(success) {
				forward = new ActionForward();
				forward.setPath("AdminInfo.se");
			}else {
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('수정실패')");
				out.println("history.back();");
				out.println("</script>");
			}
		return forward;
	}

}
