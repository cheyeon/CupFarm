package cf.board.control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/board.do")
public class CFBoardControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String m = request.getParameter("m");
		if(m !=null) {
			m.trim();
			
			
			
			
			
		}else {
			nulllist(request, response);
		}
		
	}
	private void nulllist(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
			
			
		} 
		
	
	
	
	
	

}
