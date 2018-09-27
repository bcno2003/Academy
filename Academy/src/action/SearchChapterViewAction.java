package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.ActionForward;
import service.SearchChapterViewService;

public class SearchChapterViewAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int playlist_num=Integer.parseInt(request.getParameter("playlist_num"));
		String category=request.getParameter("category");
		String lecture_level=request.getParameter("lecture_level");
		String id = request.getParameter("id");
		
		SearchChapterViewService scvService = new SearchChapterViewService();
		
		int order_num = scvService.getOrder_num(category,lecture_level,playlist_num);
		
		ActionForward forward = null;
		forward = new ActionForward();
		forward.setRedirect(true);
		forward.setPath("playChapterViewAction.ac?playlist_num="+playlist_num+"&category="+category+"&lecture_level="+lecture_level+"&order_num="+order_num+"&id="+id);
		
		return forward;
	}

}
