package action;

import java.io.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.ActionForward;
import bean.QAboardBean;
import service.QAboardWriteService;

public class QAboardWriteAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		QAboardBean QABean = new QAboardBean();
		
		QABean.setPlaylist_num(Integer.parseInt(request.getParameter("playlist_num")));
		
		System.out.println("qa==="+request.getParameter("playlist_num"));
		QABean.setLecture_level(request.getParameter("lecture_level"));
		//댓글 작성자 이름
		QABean.setQaboard_name(request.getParameter("qaboard_name"));
		//작성한 댓글 내용
		QABean.setQaboard_content(request.getParameter("qaboard_content"));
		
		//댓글 등록을 위한 서비스 클래스 
		QAboardWriteService QAWriteService = new QAboardWriteService();
		
		boolean QAWriteResult = QAWriteService.registQAboard(QABean);
		
		String Lecture_level = request.getParameter("lecture_level");
		System.out.println("Lecture_level=="+Lecture_level);
		int order_num=Integer.parseInt(request.getParameter("order_num"));
		System.out.println("order_num=="+order_num);
		ActionForward forward = null;
		if(QAWriteResult) {
			response.setContentType("text/html; charset=UTF-8");
			System.out.println("./QABoardViewAction.ac?playlist_num="+request.getParameter("playlist_num")+"&category="+request.getParameter("category")+"&lecture_level="+Lecture_level+"&order_num="+request.getParameter("order_num"));
			forward = new ActionForward();
			forward.setPath("playChapterViewAction.ac?playlist_num="+request.getParameter("playlist_num")+"&category="+request.getParameter("category")+"&lecture_level="+Lecture_level+"&order_num="+order_num+"&id="+request.getParameter("qaboard_name"));
			
		}else {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('댓글쓰기에 실패 하셨습니다.')");
			out.println("history.back()</script>");
		}
		return forward;
	}

}
