package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import action.AdminInfoAction;
import action.AdminMemberDeleteAction;
import action.AdminMemberInfoAction;
import action.AdminSearchAction;
import action.Admin_MemberAlterAction;
import action.Admin_MemberAlterFormAction;
import action.MemberAlterAction;
import action.MemberAlterFormAction;
import action.MemberDeleteAction;
import action.MemberInfoAction;
import action.MemberJoinAction;
import action.MemberJoinFormAction;
import action.MemberLoginAction;
import action.MemberLoginFormAction;
import action.SearchAction;
import bean.ActionForward;

@WebServlet("*.se")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public MemberController() {
        super();
    }
    
    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	String RequestURI=request.getRequestURI();
    	String contextPath=request.getContextPath();
    	String command=RequestURI.substring(contextPath.length());
    	ActionForward forward=null;
    	Action action=null;
    	
    	if(command.equals("/MemberJoinAction.se")) {
    		action = new MemberJoinAction();
    		try {
    			forward = action.execute(request, response);
    		}catch(Exception e) {
    			e.printStackTrace();
    		}
    	}else if(command.equals("/MemberLoginAction.se")) {
    		action = new MemberLoginAction();
    		try {
    			forward = action.execute(request, response);
    		}catch(Exception e) {
    			e.printStackTrace();
    		}
    }else if(command.equals("/MemberLogout.se")) {
    	request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out =response.getWriter();
		HttpSession session = request.getSession();
		session.invalidate();
		forward = new ActionForward();
		forward.setRedirect(true);
		forward.setPath("./MainAction.ac");
    }
    else if(command.equals("/MemberInfo.se")) {
		action = new MemberInfoAction();
		System.out.println("인포컨트롤러"+request.getParameter("id"));
		try {
			System.out.println("인포 컨트롤러1");
			forward = action.execute(request, response);
		}catch(Exception e) {
			e.printStackTrace();
		}
    }
    else if(command.equals("/MemberAlter.se")) {
		action = new MemberAlterAction();
		System.out.println("얼터컨트롤러"+request.getParameter("id"));
		try {
			System.out.println("회원정보수정 컨트롤러");
			forward = action.execute(request, response);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
    else if(command.equals("/Admin_MemberAlter.se")) {
		action = new Admin_MemberAlterAction();
		System.out.println("관리자얼터컨트롤러"+request.getParameter("id"));
		try {
			System.out.println("관리자회원정보수정 컨트롤러");
			forward = action.execute(request, response);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
    else if(command.equals("/MemberDelete.se")) {
			action = new MemberDeleteAction();
			try {
				System.out.println("회원탈퇴 컨트롤러");
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
			}else if(command.equals("/AdminInfo.se")) {
				action = new AdminInfoAction();
				try {
					System.out.println("관리자인포 컨트롤러");
					forward = action.execute(request, response);
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
			else if(command.equals("/AdminMemberInfo.se")) {
				action = new AdminMemberInfoAction();
				try {
					System.out.println("관리자회원인포 컨트롤러");
					forward = action.execute(request, response);
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
			else if(command.equals("/AdminMemberDelete.se")) {
				action = new AdminMemberDeleteAction();
				try {
					System.out.println("관리자인포 컨트롤러");
					forward = action.execute(request, response);
				}catch(Exception e) {
					e.printStackTrace();
				}
			}else if(command.equals("/SearchAction.se")) {
				action = new SearchAction();
				try {
					forward = action.execute(request, response);
				} catch(Exception e) {
					e.printStackTrace();
				}
			}else if(command.equals("/AdminSearchAction.se")) {
					action = new AdminSearchAction();
					try {
						forward = action.execute(request, response);
					} catch(Exception e) {
						e.printStackTrace();
					}
				
			}else if(command.equals("/Search.se")) {
				forward = new ActionForward();
				forward.setRedirect(true);
				forward.setPath("./Search.jsp");
			}else if(command.equals("/index.se")) {
				forward = new ActionForward();
				forward.setRedirect(true);
				forward.setPath("./loginMain.jsp");
			}else if(command.equals("/administator.se")) {
				forward = new ActionForward();
				forward.setRedirect(true);
				forward.setPath("./Administator.jsp");
			}else if(command.equals("/member_info.se")) {
				forward = new ActionForward();
				forward.setRedirect(true);
				forward.setPath("./member_info.jsp");
			}else if(command.equals("/admin_info.se")) {
				forward = new ActionForward();
				forward.setRedirect(true);
				forward.setPath("./Admin_info.jsp");
			}else if(command.equals("/AdminSearch.se")) {
				forward = new ActionForward();
				forward.setRedirect(true);
				forward.setPath("./Admin_Search.jsp");
			}else if(command.equals("/MemberJoinForm.se")) {
				action = new MemberJoinFormAction();
				try {
					forward = action.execute(request, response);
				} catch(Exception e) {
					e.printStackTrace();
				}
				
			}else if(command.equals("/MemberLoginForm.se")) {
				action = new MemberLoginFormAction();
				try {
					forward = action.execute(request, response);
				} catch(Exception e) {
					e.printStackTrace();
				}
				
			}else if(command.equals("/MemberAlterForm.se")) {
				action = new MemberAlterFormAction();
				try {
					forward = action.execute(request, response);
				} catch(Exception e) {
					e.printStackTrace();
				}
				
			}
			else if(command.equals("/Admin_MemberAlterForm.se")) {
				action = new Admin_MemberAlterFormAction();
				try {
					forward = action.execute(request, response);
				} catch(Exception e) {
					e.printStackTrace();
				}
				
			}
    	
    	if(forward != null) {
    		if(forward.isRedirect()) {
    			response.sendRedirect(forward.getPath());
    		}else {
    			RequestDispatcher dispatcher = 
    					request.getRequestDispatcher(forward.getPath());
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
