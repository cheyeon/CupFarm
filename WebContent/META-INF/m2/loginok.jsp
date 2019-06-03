<%@ page language="java" contentType="text/html; charset=utf-8" import="java.util.*,jung.m2.model.BoardDTO"%>
<meta charset="utf-8">

<%
	request.setCharacterEncoding("utf-8");
	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");
	
	if(id != null && id.equals(pwd)){
	session.setAttribute("id", id);
	}
	response.sendRedirect("list.jsp");
	%>'