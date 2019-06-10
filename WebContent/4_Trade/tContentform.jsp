<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8" import="java.util.*,cf.board.model.CFBoardDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
	@import url('https://fonts.googleapis.com/css?family=Gothic+A1&display=swap');
	@charset "UTF-8";
	
	html, body { 
		margin:0px;
		height:100%;
	}

	#container {
	    padding: 1%;
	    height: 100%;
        text-align: center;
	}
	
	#left_menu div{
		margin-right: 14%;
		background-color: transparent;
		font-family: 'Gothic A1', sans-serif;
		margin-bottom: 6px;
		font-size: 15px;
	}
	
	#left_menu div:first-child{    
		font-size: 18px;
    	font-weight: bold;
		margin-bottom: 10px;
	}

	#contents{
		vertical-align: top;
		width: 80%;
		background-color: white;
		display: inline-block;
		font-family: 'Gothic A1', sans-serif;
		min-height: 80%;
	}
		
	.tables table{
		border-collapse: collapse;
		width: 90%;
		border-right:none;
		border-left:none;
		border-top:none;
		border-bottom:none;
		text-align: center;
		margin: auto;
	}
	
	.tables th{
		padding: 10px;
		color: #2d2d2d;
	    border-top: 3px solid #cacaca;
	    background-color: #f3e7d4;
	}
	
	.tables td {
	  color: #669;
	  padding: 10px;
	  border-bottom: 1px solid #ddd;
	}
	
	.tables tr:hover td {
	  background-color: #f2f2f2;
	}
	
	.top_search{
	    height: 20%;
	    background-color: #f9f4eca6;
	    text-align: center;
	    padding-top: 2%;
	    margin-bottom: 40px;
	}
	
	.search_title{
		font-family: 'Gothic A1', sans-serif;
		background-color: transparent;
		font-size: 25px;
	}
	
	.search{
		background-color: transparent;
		margin-top: 2.8%;
	}
		
	.search div{
		height: 40px;
		width: 400px;
		border: 1px solid #c71d22;
		background: #ffffff;
	}
	
	.search input{
		font-size: 16px;
		width: 325px;
		padding: 10px;
		border: 0px;
		outline: none;
		float: left;
	}
	
	.search input:-ms-input-placeholder {color:#a8a8a8; } 
	.search input::-webkit-input-placeholder {color:#a8a8a8;} 
	.search input::-moz-placeholder {color:#a8a8a8;} 
	
	.search_button{
		width: 50px;
		height: 100%;
		border: 0px;
		background: #c71d22;
		outline: none;
		float: right;
		color: #ffffff
	}
	
	.search_button:active{
		background: #b5171b;
		font-weight: bold';
	}
	
	form{
		display: inline-block;
	}

	
</style>
</head>
<body>
	<jsp:include page="../0_HFooter/header.jsp"></jsp:include>

<% 
	CFBoardDTO tcon = (CFBoardDTO) request.getAttribute("tcon");
%>
	
<center>
<hr width='600' size='2' noshade>
<h2> CFCFCFCFCF</h2>
&nbsp;&nbsp;&nbsp;
<hr width='600' size='2' noshade>
<table border='1' width='600' align='center' cellpadding='3'>
<tr>
<td width='100' align='center'>글번호</td>
<td><%=tcon.getB_idx() %></td>
</tr>
<tr>
<td align='center'>글쓴이</td>
<td><%=tcon.getM_id() %></td>
</tr>
<tr>
<td align='center'>글제목</td>
<td><%=tcon.getB_title() %></td>
</tr>
<tr>
<td align='center'>글내용</td>
<td><%=tcon.getB_content() %></td>
</tr>
</table>
<hr width='600' size='2' noshade>
<b>

<a href='./board.do?m=tradelist&cp=10&ps=1'>목록</a>
</b>
<hr width='600' size='2' noshade>

	
	
	
	
	<form name="rinform" action="./board.do?m=replyin" method="post">
			<!-------------------------------------------------------------->
			<!-- <input type="hidden"  name="method" value="writeOk"> -->
			<table align="center" width="600" cellspacing="1" cellpadding="3"
				border="1">
		
				<tr>
					<td align="center" width="20%">내용</td>
					<td align="center" width="80%"><textarea name="content"
							rows="1" cols="60"></textarea></td>
				</tr>
				<tr>
					<td align="center" colspan="2"><input type="button"
						value="댓입력" onclick="submit()"> <input type="reset"
						value="다시쓰기" ></td>
				</tr>
				<input type="hidden" value="<%= tcon.getB_idx()%>" name="b_idx">
				
</center>	
	
	
	
	
	
	<jsp:include page="../0_HFooter/footer.jsp"></jsp:include>
</body>
</html>