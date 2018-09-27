package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.ActionForward;
import bean.playListBean;
import service.PlayListService;

public class PlayListModifyFormAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int playlist_num=Integer.parseInt(request.getParameter("playlist_num"));
		
		PlayListService playListService = new PlayListService();
		
		playListBean playList_num_Info = playListService.getPlayList_num_Info(playlist_num);
		
		request.setAttribute("playList_num_Info", playList_num_Info);
		
		//강의 등록  form중 좌츨 메인 메뉴에 나타나는 목록과 form내부의 카테고리 목록 출력을 위해
		
		ArrayList<playListBean> categoryList = playListService.getCategoryList();
				
		request.setAttribute("categoryList", categoryList);
		
		//모든 카테고리의 강의 등급 불러오기
		String category = "%";
		ArrayList<playListBean> LectureList = playListService.getLectureList(category);
		request.setAttribute("LectureList", LectureList);
		
		ActionForward forward = null;
		forward = new ActionForward();
		forward.setPath("Academy/Lecture/ModifyPlayList.jsp");
		
		return forward;
	}

}
