package action;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import static db.JdbcUtil.*;
import bean.ActionForward;
import bean.boardBean;
import bean.playListBean;
import service.BoardWriteService;
import service.PlayListService;
import bean.boardBean;

public class boardWriteAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//boardWrite에서 입력받은 내용을 boardBean 객체에 저장
		boardBean boardBean = new boardBean();
	
		HttpSession session = request.getSession();
		boardBean.setBOARD_NAME((String)session.getAttribute("id"));
		boardBean.setBOARD_SUBJECT(request.getParameter("BOARD_SUBJECT"));
		boardBean.setBOARD_CONTENT(request.getParameter("BOARD_CONTENT"));
		boolean boardResult = false;
		BoardWriteService boardWriteService = new BoardWriteService();
		boardResult = boardWriteService.BoardService(boardBean);
		System.out.println("board액션부분");
		
		//강의 등록  form중 좌츨 메인 메뉴에 나타나는 목록과 form내부의 카테고리 목록 출력을 위해
		PlayListService playListService = new PlayListService();
		ArrayList<playListBean> categoryList = playListService.getCategoryList();
		
		request.setAttribute("categoryList", categoryList);
		

		ActionForward forward = null;
		if(boardResult == false) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('뭔가 실패')");
			out.println("history.back();");
			out.println("</ script>");
		}else {
			forward = new ActionForward();
			forward.setPath("boardList.bo");
		}
		return forward;
	}
}
