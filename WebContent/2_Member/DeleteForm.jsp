<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="cf.member.model.MemDAO" %>
<% //로그인이 되었이어야  보여지도록 검증
   if(session.getAttribute("memId")==null){
       response.sendRedirect("main.jsp");
    }else{
%> 
<%
   String m_id =request.getParameter("m_id");
   String m_pwd = request.getParameter("m_pwd");
    
   MemDAO manager = MemDAO.getInstance();
   int check= manager.userCheck(m_id, m_pwd);
    
   if(check==1){
       manager.deleteMember(m_id);
       session.invalidate();       
%>     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원 탈퇴</title>
</head>
<body>
<h4>회원 정보 삭제</h4>
<div align="center">
회원정보가 삭제되었습니다.<br/>
<input type= "button" value="확인" onClick="location.href='main.jsp'">
</div>
</body>
</html>
<%}else{%>
    <!-- 무엇이 틀렸는지 안알려준다  보안! -->
   <script>
       alert("id 또는 비밀번호가 맞지 않습니다.");
      history.go(-1);
   </script>
<%}}%>


