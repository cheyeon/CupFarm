package cf.member.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Hashtable;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cf.member.model.LoginService;
import cf.member.model.MemDTO;

@WebServlet("/login.do")
public class LoginControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String m = request.getParameter("m");
		if(m != null) {
			m = m.trim();
			if(m.equals("form")) {	
				form(request, response);
			}else if(m.equals("check")) {
			    check(request, response);
			}else {
				out(request, response);
			}
		}else { 
			form(request, response);
		}
	}
	private void form(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.sendRedirect("2_Member/login.jsp");
	}
	private void check(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		System.out.println("id: " + id + ", pwd: " + pwd);
		
		HttpSession session = request.getSession();
		
		LoginService service = LoginService.getInstance();
		Object obj[] = service.checkS(id, pwd);
		MemDTO dto = (MemDTO)obj[0];
		int result = (int)obj[1];
		if(result == 2) {
			session.setAttribute("loginok", dto);
		}
		
		request.setAttribute("result", result);
		RequestDispatcher rd = request.getRequestDispatcher("login/msg.jsp");
		rd.forward(request, response);
	}
	private void out(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.invalidate();
		//session.removeAttribute("loginOkUser");
		
		response.sendRedirect("index.do");
	}
}
