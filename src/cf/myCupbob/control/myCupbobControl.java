package cf.myCupbob.control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/my.do")
public class myCupbobControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String m = request.getParameter("m");
		
		if(m != null){
			m = m.trim();
			switch(m) {
			 case "gr_menu" : ; break;
			 default : myCupBob(request, response);
			}
		}else {
			myCupBob(request, response);
		}
	}
	
	protected void myCupBob(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("2_Member/myCupbob.jsp");
		rd.forward(request, response);
	}

}