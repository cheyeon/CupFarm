package cf.member.model;
 
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import cf.member.model.DBConnection;

@WebServlet("/join.do") //얘가 있으면 컨트롤임
public class Joincontrol extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    
    private Connection conn;
    private Statement stmt;
    private String query;
    private String driver,url,uId,uPw,m_id,m_name,m_pwd,m_phone,m_ldate,m_mdate;
    

	public void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String m = request.getParameter("m");
		
		
		if(m != null) {
			m = m.trim();
			switch(m) {
				case "join" : join(request, response); break;
				case "logout" : logout(request, response); break;
				default : join_form(request, response); break; //진심여기어케고쳐야할지 몰겟음
			}
		}else {
			join_form(request, response);
		}		
	
	}
		
		
		
    public Joincontrol() {
        super();

    }
	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        actionDo(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        actionDo(request, response);
    }
 
    private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        m_id = request.getParameter("m_id");
        m_name = request.getParameter("m_name");
        m_pwd = request.getParameter("m_pwd");
        m_phone = request.getParameter("ph1") + "-" +request.getParameter("ph2") + "-" + request.getParameter("ph3");
        m_ldate = request.getParameter("m_ldate");
        m_mdate = request.getParameter("m_mdate");
        
        query = "insert into member values('"
                +m_name+"', '"
                +m_id+"', '"
                +m_pwd+"', '"
                +m_phone+"', '"
                +m_ldate+"', '"
                +m_mdate+"')";
 
        try{
            Class.forName(driver);
            conn = DriverManager.getConnection(url, uId, uPw);
            stmt = conn.createStatement();
            int i = stmt.executeUpdate(query);
            if(i==1){
                System.out.println("가입 성공");
                response.sendRedirect("joinok.html");
            }
            else{
                System.out.println("가입 실패");
                response.sendRedirect("joinfail.html");
            }
            
        }
        catch(Exception e){
            e.printStackTrace();
            System.out.println("가입 실패");
            response.sendRedirect("Joinfail.html");
            
        }
        finally{
            try{
                if(stmt!=null)stmt.close();
                if(conn!=null)conn.close();
            }
            catch(Exception e){
                e.printStackTrace();
                
            }
        }
    
    }
}