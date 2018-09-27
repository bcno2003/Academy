package action;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.ActionForward;
import bean.MemberBean;
import bean.SearchBean;
import bean.playListBean;
import service.PlayListService;
import service.SearchService;

public class SearchAction implements Action {

		@Override
	
		public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String keyword = request.getParameter("keyword");
		System.out.println("서치액션 키워드 : " + keyword);
		String id = request.getParameter("id");
		MemberBean memberBean = new MemberBean();
		memberBean.setID(id);
		
		SearchService searchService = new SearchService();
		ArrayList<SearchBean> searchResult = searchService.serch(keyword);
		ActionForward forward = null;
		
		PlayListService playListService = new PlayListService();
		ArrayList<playListBean> categoryList = playListService.getCategoryList();
		
		request.setAttribute("categoryList", categoryList);
		
		
		if(searchResult != null) {
			forward = new ActionForward();
			HttpSession session = request.getSession();
			session.setAttribute("keyword", searchResult);
			session.setAttribute("memberBean", memberBean);
			forward.setPath("Academy/Search/Search.jsp");
			
			
		}else {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('검색에 실패했습니다')");
			out.println("history.back()</script>");
		}
		
		return forward;
	}

}
