package cf.member.model;
 
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import cf.member.model.DBConnection;
import cf.member.model.JoinService;

@WebServlet("/join.do") //얘가 있으면 컨트롤임
public class Joincontrol extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    
	public void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String m = request.getParameter("m");
		if(m.equals("join")) {
			join(request, response);
			
		}else {}
	}
		
	
		
        private void join(HttpServletRequest request, HttpServletResponse response) 
    			throws ServletException, IOException {
       JoinService service = JoinService.getInstance();
   		String m_id = request.getParameter("m_id");
	    String m_name = request.getParameter("m_name");
	    String m_pwd = request.getParameter("m_pwd");
	    String m_phone = request.getParameter("ph1") + request.getParameter("ph2") + request.getParameter("ph3");
	 
	    
	    MemDTO jdto= new MemDTO(m_id, m_name, m_pwd, m_phone, null ,null);
       
       
       
       
       service.joinS(jdto);
        	
        	
        }
	
		
		
	
 
}