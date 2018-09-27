package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.ActionForward;
import bean.PageInfo;
import bean.boardBean;
import bean.playListBean;
import service.BoardListService;
import service.PlayListService;

public class BoardListAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		BoardListService boardListService = new BoardListService();
		boardBean bb = new boardBean();
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		bb.setBOARD_NAME(id);
		
		//페이징 처리
		//페이지 번호를 알기위해 사용하는 변수
		int page = 1;
		//한 페이지에 뵤여줄 글 갯수를 정하기 위해 사용하는 변수
		int limit = 10;
		//page파라미터값 검사
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		
		//전체 글 갯수를 가져오기위한 listservice 클래스의 메소드 호출
		int listCount = boardListService.getListCount();
		
		/*ArrayList<boardBean> boardList = boardListService.getBoardList();*/
		//limit 값을 걸어놓은 만큼 범위에서 해당하는 글만 가져오는 방법
		ArrayList<boardBean> boardList = boardListService.getBoardList(page, limit);
		
		//페이지 게산을 위한 부분
		int maxPage = (int)((double)listCount/limit + 1);
		//현제 페이지에서 보여줄 시작페이지 번호
		//1,2,3,4,5,6,7,8,9,10[다음]
		//[이전]11,12,13 ...[다음]
		int startPage = (((int)((double)page/10 + 0.9))-1)*10+1;
		
		int endPage = startPage +10 -1 ;
		if(endPage>maxPage) {
			endPage = maxPage;
		}
		
		PageInfo pageInfo = new PageInfo();
		pageInfo.setPage(page);
		pageInfo.setStartPage(startPage);
		pageInfo.setEndPage(endPage);
		pageInfo.setMaxPage(maxPage);
		pageInfo.setListCount(listCount);
		
		//강의 등록  form중 좌츨 메인 메뉴에 나타나는 목록과 form내부의 카테고리 목록 출력을 위해
				PlayListService playListService = new PlayListService();
				ArrayList<playListBean> categoryList = playListService.getCategoryList();
				
				request.setAttribute("categoryList", categoryList);
		request.setAttribute("boardList", boardList);
		request.setAttribute("pageInfo", pageInfo);
		session.setAttribute("mamberBean", bb);
		forward = new ActionForward();
		forward.setPath("Academy/Board/board_list.jsp");
		return forward;
	}

}
