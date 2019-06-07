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
 

@WebServlet("/join.do")
public class Joinupdate extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    
    private Connection conn;
    private Statement stmt;
    private String query;
    private String driver,url,uId,uPw,name,id,pwd,phone,ldate,mdate;
    
    driver = "oracle.jdbc.driver.OracleDriver";
    url = "jdbc:oracle:thin:@203.236.209.195:1521/JAVA";
    String uId ="cupbob";
    String uPw ="JAVA";
 
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
        url = "jdbc:oracle:thin:@203.236.209.195:1521/JAVA";
        String uId ="cupbob";
        String uPw ="JAVA";
        
        name = request.getParameter("name");
        id = request.getParameter("id");
        pwd = request.getParameter("pwd");
        phone = request.getParameter("ph1") + "-" +request.getParameter("ph2") + "-" + request.getParameter("ph3");
        ldate = request.getParameter("SYSDATE");
        mdate = request.getParameter("SYSDATE");		// 여기 수정해야함 ㅜ
        
        query = "insert into member values('"
                +name+"', '"
                +id+"', '"
                +pwd+"', '"
                +phone+"', '"
                 +ldate+"', '"
                +mdate+"')";
 
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