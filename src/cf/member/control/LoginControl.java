package cf.member.control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import cf.member.model.*;
import cf.myCupbob.model.McbDTO;
import cf.myCupbob.model.CupbobService;


@WebServlet("/login.do")
public class LoginControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String m = request.getParameter("m");
		
		if(m != null) {
			m = m.trim();
			switch(m) {
				case "login" : login(request, response); break;
				case "logout" : logout(request, response); break;
				case "plzlogin" : plzlogin(request, response); break;
				default : login_form(request, response); break;
			}
		}else {
			login_form(request, response);
		}		
	
	}
	private void login_form(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("./2_Member/login.jsp");
		rd.forward(request, response);
	}

	//로그인이 필요한 서비스입니다.
	private void plzlogin(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		int result = 5;
		request.setAttribute("result", result);
		RequestDispatcher rd = request.getRequestDispatcher("./2_Member/msg.jsp");
		rd.forward(request, response);
	}

	//로그인
	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		//DB확인
		LoginService service = LoginService.getInstance();
		Object obj[] = service.loginS(id, pwd);
		
		//컵밥세션 **
		CupbobService serviceC = CupbobService.getInstance();
		ArrayList<McbDTO> list = serviceC.cupbobListS(id);
		
		//세션유지를 위해 session객체 생성
		HttpSession session = request.getSession();
		
		//로그인 결과
		MemDTO dto = (MemDTO)obj[0];
		int result = (int)obj[1];
		if(result == 2) session.setAttribute("loginSession", dto);
		session.setAttribute("list", list);
		request.setAttribute("result", result);

		RequestDispatcher rd = request.getRequestDispatcher("./2_Member/msg.jsp");
		rd.forward(request, response);
	}

	//로그아웃
	private void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//세션끊기
		HttpSession session = request.getSession();
		session.invalidate();	
		
		int result = 3;
		request.setAttribute("result", result);
		
		RequestDispatcher rd = request.getRequestDispatcher("./2_Member/msg.jsp");
		rd.forward(request, response);
	}
	
}
