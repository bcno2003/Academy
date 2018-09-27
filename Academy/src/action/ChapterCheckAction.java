package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.ActionForward;
import bean.CompleteListBean;
import service.ChapterCheckService;

public class ChapterCheckAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//전달받은 id 저장
		String id = request.getParameter("id");
		//전달받은 playlist_num 저장
		int playlist_num = Integer.parseInt(request.getParameter("playlist_num"));
		
		System.out.println("playlist_num=="+playlist_num);
		//전달받은 order_num 저장
		int order_num=Integer.parseInt(request.getParameter("order_num"));
		//전달받은 값들 저장
		String category = request.getParameter("category");
		String lecture_level = request.getParameter("lecture_level");
		String lecture_image = request.getParameter("lecture_image");
		String chapter_subject = request.getParameter("chapter_subject");
		
		CompleteListBean chapterCheckBean = new CompleteListBean();
		chapterCheckBean.setId(id);
		chapterCheckBean.setPlaylist_num(playlist_num);
		chapterCheckBean.setCategory(category);
		chapterCheckBean.setLecture_level(lecture_level);
		chapterCheckBean.setLecture_image(lecture_image);
		chapterCheckBean.setChapter_subject(chapter_subject);
		
		ChapterCheckService chapterCheckService = new ChapterCheckService();
		//chapterCheckBean에 저장한 데이터를 전달하여 DB에 저장후 그 결과를
		//boolean chapterCheckResult로 입력 받는다
		boolean chapterCheckResult = chapterCheckService.chapterCheck(chapterCheckBean);
		ActionForward forward = null;
		if(chapterCheckResult) {
			response.setContentType("text/html; charset=UTF-8");
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("./playChapterViewAction.ac?id="+id+"&order_num="+order_num+"&playlist_num="+playlist_num+"&lecture_level="+lecture_level+"&category="+category);
		}else {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('수강체크에 실패 하셨습니다.')");
			out.println("history.back()</script>");
			
		}
		return forward;
		
		
	}

}
