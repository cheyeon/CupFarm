package cf.member.control;
 
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import cf.member.model.JoinService;
import cf.member.model.MemDTO;

@WebServlet("/join.do") 
public class Joincontrol extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    
	public void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String m = request.getParameter("m");
		
		if(m != null) {
			m = m.trim();
			switch(m) {
				case "join" : join(request, response); break;
				default : join_form(request, response); break;
			}
		}else {
			join_form(request, response);
		}		
	}
		
        private void join(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	       JoinService service = JoinService.getInstance();
	   		String m_id = request.getParameter("m_id");
		    String m_name = request.getParameter("m_name");
		    String m_pwd = request.getParameter("m_pwd");
		    String m_phone = request.getParameter("ph1") + request.getParameter("ph2") + request.getParameter("ph3");
		 
		    MemDTO jdto= new MemDTO(m_id, m_name, m_pwd, m_phone, null ,null);
	        service.joinS(jdto);
	       
			int result = 4;
			request.setAttribute("result", result);
    		RequestDispatcher rd = request.getRequestDispatcher("./2_Member/msg.jsp");
    		rd.forward(request, response);
        }
	
    	private void join_form(HttpServletRequest request, HttpServletResponse response) 
    			throws ServletException, IOException {
    		RequestDispatcher rd = request.getRequestDispatcher("./2_Member/join.jsp");
    		rd.forward(request, response);
    	}
		
	
 
}