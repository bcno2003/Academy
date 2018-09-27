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
import service.ModifyPlayListService;

public class ModifyPlayListAction implements Action{

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
				
		playListBean ModifyPlayList = new playListBean();
		
		//전달 받은 정보를 playListBean형태의 ModifyPlayList의 객체에 저장
		ModifyPlayList.setPlaylist_num(Integer.parseInt(multi.getParameter("playlist_num")));
		ModifyPlayList.setCategory(multi.getParameter("category"));
		ModifyPlayList.setLecture_level(multi.getParameter("lecture_level"));
		ModifyPlayList.setLecture_image(multi.getOriginalFileName((String)multi.getFileNames().nextElement()));
		ModifyPlayList.setChapter_subject(multi.getParameter("chapter_subject"));
		ModifyPlayList.setChapter_url(multi.getParameter("chapter_url"));
		ModifyPlayList.setChapter_objectives(multi.getParameter("chapter_objectives"));
		
		ModifyPlayListService ModifyPlayListService = new ModifyPlayListService();
		
		//AddPlayListService의 ModifyPlayList()메소드에 ModifyPlayList객체를 전달
		boolean ModifyResult = ModifyPlayListService.ModifyPlayList(ModifyPlayList);
		//그 결과를 boolean형태의 addResult로 입력 받는다.
		ActionForward forward = null;
		//addResult 값에 따라 forward 저장
		if(ModifyResult) {
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
