package cf.member.control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import cf.member.model.*;


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

	//�α���
	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		//DBȮ��
		LoginService service = LoginService.getInstance();
		Object obj[] = service.loginS(id, pwd);
		
		//���������� ���� session��ü ����
		HttpSession session = request.getSession();
		
		//�α��� ���
		MemDTO dto = (MemDTO)obj[0];
		int result = (int)obj[1];
		if(result == 2) session.setAttribute("loginSession", dto);
		request.setAttribute("result", result);

		RequestDispatcher rd = request.getRequestDispatcher("./2_Member/msg.jsp");
		rd.forward(request, response);
	}

	//�α׾ƿ�
	private void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//���ǲ���
		HttpSession session = request.getSession();
		session.invalidate();	
		
		int result = 3;
		request.setAttribute("result", result);
		
		RequestDispatcher rd = request.getRequestDispatcher("./2_Member/msg.jsp");
		rd.forward(request, response);
	}
	
}
