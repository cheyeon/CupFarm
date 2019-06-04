<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %>
 
<%!
    Connection conn;
    Statement stmt;
    ResultSet rSet;
    
    String driver = "oracle.jdbc.driver.OracleDriver";
    String url = "jdbc:oracle:thin:@203.236.209.195:1521/JAVA";
    String uId ="cupbob";
    String uPw ="JAVA";
    String id,pwd,query,result;
%>
 
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
    
    <!-- Driver load -->
    <%
    
   //     request.setCharacterEncoding("uft-8");
        driver = "oracle.jdbc.driver.OracleDriver";
        url = "jdbc:oracle:thin:@203.236.209.195:1521/JAVA";
        String uId ="cupbob";
        String uPw ="JAVA";
        
        id = request.getParameter("id");
        pwd = request.getParameter("pwd");
        
        query = "select pwd from member where id='" + id + "'";
        System.out.println(query);
        
        try{
            Class.forName(driver);
            conn = DriverManager.getConnection(url, uId, uPw);
            stmt = conn.createStatement();
            rSet = stmt.executeQuery(query);
            
            while(rSet.next()){
                result = rSet.getString("pw");
            }
            
            if(result == null){
                System.out.println("로그인 실패!");
                response.sendRedirect("loginfail.html");
            }
            else{
                System.out.println("pw : "+pwd);
                System.out.println("result : "+result);
                if(result.equals(pwd)){
                    session.setAttribute("id", id);
                    session.setAttribute("pw", pwd);
                    System.out.println("로그인 성공!");
                    response.sendRedirect("loginok.jsp");
                }
                else{
                    System.out.println("비밀번호가 틀립니다 ");
                    response.sendRedirect("loginfail.html");
                }
            }
    
            
        }
        catch(Exception e){
            e.printStackTrace();
            System.out.println("로그인 실패!");
            response.sendRedirect("loginfail.html");
            
        }
        finally{
            try{
                if(rSet!=null){rSet.close();}
                if(stmt!=null){stmt.close();}
                if(conn!=null){conn.close();}
            }
            catch(Exception e){
                e.printStackTrace();
                
            }
        }
        
        
    
    
    
    
    %>
 
</body>
</html>
