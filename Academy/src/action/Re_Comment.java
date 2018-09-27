package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.ActionForward;
import bean.boardBean;
import service.BoardViewService;

public class Re_Comment implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		int me = Integer.parseInt( request.getParameter("id"));
		ActionForward forward = null;
		BoardViewService boardView = new BoardViewService();
		boardBean bb = boardView.getSubjectView(me);
		request.setAttribute("at", bb);
		forward = new ActionForward();
		forward.setPath("board/re_comment.jsp");
		return forward;
	}

}
