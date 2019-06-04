<%@ page language="java" contentType="text/html; charset=utf-8" import="java.util.*,cf.member.model.MemDTO"%>
<meta charset="utf-8">

<%
	request.setCharacterEncoding("utf-8");
	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");
	
	if(id != null && id.equals(pwd)){
	session.setAttribute("id", id);
	}
	response.sendRedirect("../0_HFooter/header.jsp");
	%>'