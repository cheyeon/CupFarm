<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
 
    <%
    try{
        Object id = session.getAttribute("id");
        Object pw = session.getAttribute("pw");
        
        out.println(id.toString() + "님 접속을 환영합니다");%>
        <form action="Logout.jsp" method="post">
            <input type="submit" value="로그아웃">
        </form>
    <%}
    catch(NullPointerException e){
        e.printStackTrace();
        out.println("올바른 경로로 엑세스해주세요");    
    }
 
 
    %>
 
</body>
</html>
