package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.ActionForward;
import bean.boardBean;
import bean.playListBean;
import service.BoardViewService;
import service.PlayListService;

public class AlterPageAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		int me = Integer.parseInt( request.getParameter("id"));
		BoardViewService boardViewService = new BoardViewService();
		boardBean sub = boardViewService.getSubjectView(me);
		request.setAttribute("sub", sub);
		
		//강의 등록  form중 좌츨 메인 메뉴에 나타나는 목록과 form내부의 카테고리 목록 출력을 위해
				PlayListService playListService = new PlayListService();
				ArrayList<playListBean> categoryList = playListService.getCategoryList();
				
				request.setAttribute("categoryList", categoryList);
		
		forward = new ActionForward();
		forward.setPath("Academy/Board/alter_board.jsp");
		return forward;
	}

}
