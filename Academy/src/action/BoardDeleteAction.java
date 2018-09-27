package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.ActionForward;
import service.BoardDeleteService;

public class BoardDeleteAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		int num = Integer.parseInt(request.getParameter("boardnum"));
		String boardname = (String)session.getAttribute("id"); //작성자 이름
		System.out.println("id+++++"+num);
		System.out.println("boadname"+boardname);
		ActionForward forward = null;
       BoardDeleteService boardDeleteService = new BoardDeleteService();
		boolean deleteResult = 
				boardDeleteService.deleteBoard(boardname,num);
		
		if(deleteResult) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('삭제완료.')");
			out.println("</script>");
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("./boardList.bo");
		}else {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('삭제실패.')");
			out.println("location.href='./boardList.bo'</script>");
		}
		return forward;
	}

}
