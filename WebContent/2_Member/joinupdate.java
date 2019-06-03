package cf.member.model.MemDTO;
 
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
 

@WebServlet("/joinup")
public class Joinupdate extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    
    private Connection conn;
    private Statement stmt;
    private String query;
    private String driver,url,uId,uPw,name,id,pwd,phone,joindate;
    
//    String driver = "oracle.jdbc.driver.OracleDriver";
//    String url = "jdbc:oracle:thin:@localhost:1521:xe";
//    String uId ="";		서버계정의 ID와 
//    String uPw ="";		비번
 
    public joinupdate() {
        super();

    }
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        actionDo(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        actionDo(request, response);
    }
 
    private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        request.setCharacterEncoding("UTF-8");
        driver = "oracle.jdbc.driver.OracleDriver";
        url = "jdbc:oracle:thin:@localhost:1521:xe";
       // uId ="";  서버계정(?)의 아이디와
      //  uPw ="";	비번
        
        name = request.getParameter("name");
        id = request.getParameter("id");
        pwd = request.getParameter("pwd");
        phone = request.getParameter("ph1") + "-" +request.getParameter("ph2") + "-" + request.getParameter("ph3");
        joindate = request.getParameter("SYSDATE");
        
        query = "insert into member values('"
                +name+"', '"
                +id+"', '"
                +pwd+"', '"
                +phone+"', '"
                +joindate+"')";
 
        try{
            Class.forName(driver);
            conn = DriverManager.getConnection(url, uId, uPw);
            stmt = conn.createStatement();
            int i = stmt.executeUpdate(query);
            if(i==1){
                System.out.println("insert success");
                response.sendRedirect("joinok.html");
            }
            else{
                System.out.println("insert fail");
                response.sendRedirect("joinFail.html");
            }
            
        }
        catch(Exception e){
            e.printStackTrace();
            System.out.println("insert fail");
            response.sendRedirect("JoinFail.html");
            
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