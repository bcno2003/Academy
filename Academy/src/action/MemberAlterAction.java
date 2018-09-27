package action;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.sql.*;
import java.util.*;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.ActionForward;
import bean.MemberBean;
import service.MemberAlterService;


public class MemberAlterAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		System.out.println("수정id=="+id);
		String pass = request.getParameter("pass");
		System.out.println("수정pass=="+pass);
		
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
	
		MemberAlterService memberAlterService = new MemberAlterService();
		boolean success = false;
		ActionForward forward = null;
		
		success = memberAlterService.modify(id,pass,email,phone);
			if(success) {
				forward = new ActionForward();
				forward.setRedirect(true);
				forward.setPath("MemberInfo.se?id="+id);
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
