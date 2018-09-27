package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.ActionForward;
import bean.boardBean;
import service.BoardAlterService;
import service.BoardCommentService;

public class Re_CommentAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		boardBean boardBean = new boardBean();
		ActionForward forward = null;
		int me = Integer.parseInt( request.getParameter("BOARD_NUM"));
		BoardCommentService boardCommentService = new BoardCommentService(); 
		System.out.println("코맨트 액션");
		boolean success = false;
		
		boardBean.setBOARD_NUM(Integer.parseInt(request.getParameter("BOARD_NUM")));
		boardBean.setBOARD_NAME(request.getParameter("name"));
		boardBean.setBOARD_PASS(request.getParameter("pass"));
		boardBean.setBOARD_SUBJECT(request.getParameter("subject"));
		boardBean.setBOARD_CONTENT(request.getParameter("content"));
		boardBean.setBOARD_RE_LEV(Integer.parseInt(request.getParameter("BOARD_RE_LEV")));
		boardBean.setBOARD_RE_SEQ(Integer.parseInt(request.getParameter("BOARD_RE_SEQ")));
		boardBean.setBOARD_RE_REF(Integer.parseInt(request.getParameter("BOARD_RE_REF")));
		
		success = boardCommentService.comment(boardBean);
			if(success) {
				forward = new ActionForward();
				forward.setRedirect(true);
				forward.setPath("boardList.bo");
			}else {
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('답글달기')");
				out.println("history.back();");
				out.println("</script>");
			}
		
		return forward;
	}
}
