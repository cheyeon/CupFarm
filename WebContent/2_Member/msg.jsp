<%@ page language="java" contentType="text/html; charset=utf-8"%>
<script language="javascript">
<%
	//로그인 및 로그아웃 결과
   int result = (Integer)request.getAttribute("result");

   if(result == 0){   
%>
      alert("그런 id 없어요");
      location.href="login.do";
<%
   }else if(result == 1){
%>
	  alert("pwd가 틀려요");
	location.href="login.do";
<%	   
   }else if(result == 2){
%>
	alert("로그인 성공");
	location.href="my.do";	
<%		   
   }else if(result == 3){
%>
	alert("로그아웃 성공");
	location.href="index.do";	
<%
   }else if(result == 4){
%>
	alert("회원가입 성공");
	location.href="login.do";	
<%
   }
%>
</script>