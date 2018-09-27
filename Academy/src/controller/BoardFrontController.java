package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.AlterPageAction;
import action.BoardAlterAction;
import action.BoardDeleteAction;
import action.BoardListAction;
import action.BoardViewAction;
import action.Re_Comment;
import action.Re_CommentAction;
import action.boardWriteAction;

import bean.ActionForward;
import bean.boardBean;
import javax.servlet.http.HttpSession;
@WebServlet("*.bo")
public class BoardFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardFrontController() {
        super();
    }

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	//주소값을 잘라내는 과정
    	HttpSession session = request.getSession();
    	boardBean boardbean= new boardBean();
    	String RequestURI = request.getRequestURI();
    	String contextPath = request.getContextPath();
    	String command = RequestURI.substring(contextPath.length());
    	
    	
    	//세션 id 호출 

    	//처리된 결과를 전송할 주소값 지정을 위한 클래스
    	ActionForward forward = null;
    	//Controller로 부터 전달 받아 service로 전달하기 위한 클래스
    	Action action = null;
    	//command에 있는 주소값을 가지고 어떤 클래스를 호출할지를 제어
    	if(command.equals("/boardWritePro.bo")){
    		//BoardWriterAction 클래스에 대한 객체 생성
    		String id = (String)session.getAttribute("id");
    		System.out.println("컨트롤 ID"+id);
    		action = new boardWriteAction();
    		try {
    			forward = action.execute(request, response);
    		}catch(Exception e) {
    			e.printStackTrace();
    		}
    	}else if(command.equals("/boardWriteForm.bo")) {
    		String id = (String)session.getAttribute("id");
    		forward = new ActionForward();
    		forward.setPath("Academy/Board/boardWrite.jsp");
    	}
    	else if(command.equals("/boardList.bo")){
    		action = new BoardListAction();
    		try {
    			forward = action.execute(request, response);
    		}catch(Exception e) {
    			e.printStackTrace();
    		}
    	}else if(command.equals("/boardViewAction.bo")){
    		action = new BoardViewAction();
    		
    		try {
    			forward = action.execute(request, response);
    		}catch(Exception e) {
    			e.printStackTrace();
    	}}else if(command.equals("/alter_board.bo")){
        	action = new AlterPageAction();
       	try {
       		forward = action.execute(request, response);
      		}catch(Exception e) {
      			e.printStackTrace();
      	}}else if(command.equals("/boardAlterAction.bo")){
      		String id = request.getParameter("boardnum");
      		String boardname = (String)session.getAttribute("id");
      		System.out.println("id+9+++"+id);
      		System.out.println("boardname   : "+boardname);
          	action = new BoardAlterAction();
          	try {
          		forward = action.execute(request, response);
          	}catch(Exception e) {
          		e.printStackTrace();
          	}}else if(command.equals("/boardDelete.bo")){
          		String id = request.getParameter("boardnum");
          		String boardname = (String)session.getAttribute("id");
          		System.out.println("id:::"+id+"boardname"+boardname);
               	action = new BoardDeleteAction();
               	try {
                	forward = action.execute(request, response);
               	}catch(Exception e) {
                	e.printStackTrace();
                }}else if(command.equals("/re_comment.bo")){
                	action = new Re_Comment();
                   	try {
                    	forward = action.execute(request, response);
                   	}catch(Exception e) {
                    	e.printStackTrace();
                    }}else if(command.equals("/re_commentAction.bo")){
                    	int boardnum = Integer.parseInt(request.getParameter("BOARD_NUM"));
                    	System.out.println("boardnum"+boardnum);
                    	action = new Re_CommentAction();
                       	try {
                        	forward = action.execute(request, response);
                       	}catch(Exception e) {
                        	e.printStackTrace();
                        }}
    	
    	
        	if(forward != null) {
    		if(forward.isRedirect()) {
    			response.sendRedirect(forward.getPath());
    		}else {
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
