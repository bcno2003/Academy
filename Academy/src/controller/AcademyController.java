package controller;

import java.io.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.*;
import bean.ActionForward;


@WebServlet("*.ac")
public class AcademyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AcademyController() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	
    	//주소값을 잘라내는 과정	
    	String RequestURI=request.getRequestURI();
    	
		String contextPath=request.getContextPath();
	
		String command=RequestURI.substring(contextPath.length());
		//RequestURI 를 contextPath의 길이만큼 잘라내라
		System.out.println("contextPath = "+contextPath);
		System.out.println("command = "+command);
		//ActionForward 클래스 : 처리된 결과를 전송할 주소값 지정을 위한 클래스
		ActionForward forward=null;
		//Action 클래스 : Controller로 부터 전달 받아 Service로 전달하기 위한 클래스
		Action action=null;//action 변수 선언
		
		// 카테고리 목록 보기
		if(command.equals("/playList.ac")) {
			action = new PlayListAction(); 
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/MainAction.ac")) {
			action = new MainAction(); 
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		//강의 리스트 보기
		else if(command.equals("/playChapterListAction.ac")) {
			action = new playChapterListAction(); 
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		//강의 상세보기
		else if(command.equals("/playChapterViewAction.ac")) {
			action = new playChapterViewAction(); 
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		//댓글 작성
		else if(command.equals("/QAboardWrite.ac")) {
			action = new QAboardWriteAction(); 
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		//강의 등록 폼 이동
		else if(command.equals("/AddPlayListForm.ac")) {
			action = new AddPlayListFormAction(); 
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		//강의 등록 하기
		else if(command.equals("/AddPlayList.ac")) {
			action = new AddPlayListAction(); 
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/MemberLoginAction.ac")) {
			action = new MemberLoginAction(); 
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/MemberQALoginAction.ac")) {
			action = new MemberQALoginAction(); 
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/MemberLogoutAction.ac")) {
			HttpSession session = request.getSession();
			session.invalidate();
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("index.jsp");
			
		}else if(command.equals("/ChapterCheckAction.ac")) {
			action = new ChapterCheckAction(); 
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/SearchChapterViewAction.ac")) {
			action = new SearchChapterViewAction(); 
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/ChapterCompleteListAction.ac")) {
			action = new ChapterCompleteListAction(); 
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/PlayListModifyFormAction.ac")) {
			action = new PlayListModifyFormAction(); 
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/ModifyPlayList.ac")) {
			action = new ModifyPlayListAction(); 
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
    
		if(forward != null) {
			//isRedirect 필드값을 가져오기 위한 getter 호출
			if(forward.isRedirect()) {
				//redirect 필드값이 true로 셋팅되어 있다면
				//redirect 메소드를 호출
				
				response.sendRedirect(forward.getPath());
				
			}else {
				System.out.println("forward.getPath()=="+forward.getPath());
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}
		}
		
    }
	
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doProcess(request, response);
	}

}
