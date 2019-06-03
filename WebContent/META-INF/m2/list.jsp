<%@ page language="java" contentType="text/html; charset=utf-8" import="java.util.*,jung.m2.model.BoardDTO"%>
<meta charset="utf-8">

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<center>
<hr width='600' size='2' noshade>
<h2>미니플젝 게시판 글목록♥</h2>
&nbsp;&nbsp;&nbsp;
<a href='m2.do?m=in_form'>글쓰기</a>
&nbsp;&nbsp;&nbsp;
<a href='./'>인덱스</a>
<hr width='600' size='2' noshade>

<table border='1' width='600' align='center' cellpadding='2'>
	<tr>
	<th align='center' width='10%'>번호</th>
	<th align='center' width='30%'>제목</th>
	<th align='center' width='15%'>이름</th>
	<th align='center' width='15%'>날짜</th>
	<th align='center' width='15%'>삭제</th>	   
	</tr>
		<%
		ArrayList<BoardDTO> list = (ArrayList<BoardDTO>)request.getAttribute("list");
		for(BoardDTO dto : list){
		%>
	<tr>
	<td align='center'><%=dto.getIdx() %></td>
	<td align='center'><a href='board.do?m=b_contents&no=<%=dto.getIdx()%>'><%=dto.getSubject()%></a></td>
	<td align='center'><%=dto.getWriter()%></td>
	<td align='center'><%=dto.getIdx()%></td>
	<td align='center'><a href='board.do?m=del&no=<%=dto.getIdx()%>'>삭제</a></td>
	
	</tr>
<%
		}
%>
</table>

</center>
</body>
</html>
