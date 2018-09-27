package action;

import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import bean.ActionForward;
import bean.playListBean;
import service.AddPlayListService;

public class AddPlayListAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//강의 등록시 업로드 되는 폴더명
		String realPath = "";
		String savePath = "./imageUpload";
		
		int size = 5*1024*1024;
		
		ServletContext context = request.getServletContext();
		realPath = context.getRealPath(savePath);
		
		MultipartRequest multi = new MultipartRequest(
									  request,
									  realPath,
									  size,
									  "UTF-8",
									  new DefaultFileRenamePolicy()
									  );
		
		playListBean addPlayList = new playListBean();
		//전달 받은 정보를 playListBean형태의 addPlayList의 객체에 저장
		addPlayList.setCategory(multi.getParameter("category"));
		addPlayList.setLecture_level(multi.getParameter("lecture_level"));
		addPlayList.setLecture_image(multi.getOriginalFileName((String)multi.getFileNames().nextElement()));
		addPlayList.setChapter_subject(multi.getParameter("chapter_subject"));
		addPlayList.setChapter_url(multi.getParameter("chapter_url"));
		addPlayList.setChapter_objectives(multi.getParameter("chapter_objectives"));
		
		AddPlayListService addPlayListService = new AddPlayListService();
		
		//AddPlayListService의 addPlayList()메소드에 addPlayList객체를 전달
		boolean addResult = addPlayListService.addPlayList(addPlayList);
		//그 결과를 boolean형태의 addResult로 입력 받는다.
		ActionForward forward = null;
		//addResult 값에 따라 forward 저장
		if(addResult) {
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("./playList.ac");
			
		}else {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('강의등록에 실패 하셨습니다.')");
			out.println("history.back()</script>");
		}
		return forward;
	}

}
