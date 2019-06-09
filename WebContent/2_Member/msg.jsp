<%@ page contentType="text/html;charset=utf-8" import="cf.member.model.MemDTO"%>
<script language="javascript">
<%
	//로그인 및 로그아웃 결과
   int result = (Integer)request.getAttribute("result");

	MemDTO mdto = (MemDTO)session.getAttribute("loginSession");
	String my = "my.do";
	if(mdto!=null){
		my="my.do?m=cb_list&id="+mdto.getM_id();
	}
	
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
	location.href="<%=my%>";	
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