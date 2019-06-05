package cf.group.control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/group.do")
public class groupControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String m = request.getParameter("m");
		
		if(m != null){
			m = m.trim();
			switch(m) {
			 case "gr_menu" : groupMenu(request, response); break;
			 case "gr_list" : groupList(request, response); break;
			 default : myGroup(request, response);
			}
		}else {
			myGroup(request, response);
		}
	}
	
	protected void myGroup(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("3_Group/myGroup.jsp");
		rd.forward(request, response);		
	}

	protected void groupList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("3_Group/group_list.jsp");
		rd.forward(request, response);	
	}

	protected void groupMenu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("3_Group/group_menu.jsp");
		rd.forward(request, response);	
	}
}
