package action;

import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import bean.ActionForward;
import bean.boardBean;
import service.BoardAlterService;
import service.BoardWriteService;

public class BoardAlterAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		String boardname = (String)session.getAttribute("id"); //작성자 이름
		int num = Integer.parseInt(request.getParameter("boardnum")); //글 번호 
		System.out.println("boardname"+boardname);
		System.out.println("num"+num);
		boardBean bb = new boardBean();//보드빈 선언
		BoardAlterService boardAlterService = new BoardAlterService(); //서비스 선언
		boolean success = false;// false 기본 설정

		//ID 와 글번호 비교
		boolean alter = boardAlterService.getAlterBoard(boardname,num);
		System.out.println("alter"+alter);
		ActionForward forward = null;
		
			if(alter) {
			bb.setBOARD_SUBJECT(request.getParameter("BOARD_SUBJECT"));
			bb.setBOARD_CONTENT(request.getParameter("BOARD_CONTENT"));
			bb.setBOARD_NUM(num);
			success = boardAlterService.modify(bb);
			if(success) {
				forward = new ActionForward();
				forward.setRedirect(true);
				forward.setPath("boardViewAction.bo?id="+bb.getBOARD_NUM());
			}else {
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('수정실패')");
				out.println("history.back();");
				out.println("</script>");
			}
		}else {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('작성자가 아닙니다.')");
			out.println("history.back();");
			out.println("</script>");
		}
		return forward;
	}
}
