package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.ActionForward;
import bean.playListBean;
import service.PlayListService;

public class PlayListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		
		PlayListService playListService = new PlayListService();
		
		//category를 알기위한 변수
		String category = "%";
		System.out.println("category=="+category);
		//category파라메터 값 검사
		if(request.getParameter("category")!=null) {
			category= request.getParameter("category");
			System.out.println(category);
		}
		//메뉴에서 category 이동을 위한 category 목록 가져오기
		ArrayList<playListBean> categoryList = playListService.getCategoryList();
		
		//category에 해당하는 강의만 가져오는 방법
		ArrayList<playListBean> LectureList = playListService.getLectureList(category);
		
		request.setAttribute("LectureList", LectureList);
		request.setAttribute("categoryList", categoryList);
		
		forward = new ActionForward();
		forward.setPath("Academy/Lecture/LectureList.jsp");
		
		return forward;
	}

}
