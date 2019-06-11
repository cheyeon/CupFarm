<%@page import="cf.myCupbob.model.CupbobDTO"%>
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

	<div class ="top_search">
		<div class="search_title">컵밥 교환 게시판</div>
		<div class="search">
			<form action="./board.do?m=tlistseach" method="post">
				<div>
					<input name=tseachval type="text" placeholder="검색어 입력">
					<button class="search_button" type="submit">검색</button>
				</div>
			</form>
		</div>	
	</div>
	
	<div id="container">
		<div id ="contents">
			<div class="tables">

				<table>
					<col width="10%">
					<col width="50%">
					<col width="20%">
					<col width="20%">
					
					
					
					<tr>
						<th>번호</th>
						<th>교환밥</th>
						<th>제목</th>
						<th>작성자</th>
						<th>작성일</th>
					</tr>
<%
	ArrayList<CFBoardDTO> list = (ArrayList<CFBoardDTO>)request.getAttribute("list");
	for(CFBoardDTO dto : list){
%>
					<tr>
						<td><%=dto.getB_idx()%></td>
			
			
<%
	ArrayList<CupbobDTO> clist = (ArrayList<CupbobDTO>)request.getAttribute("clist");
	

		for(CupbobDTO cdto : clist){
		
		if(dto.getC_idx()==cdto.getC_idx()){
			%>
			<td><%=cdto.getC_name()%></td>
			<%
			}else{
				
			}
	}

%>			
	
			
			
			
						<td>
						<a href="./board.do?m=con&idx=<%=dto.getB_idx()%>">
						<%=dto.getB_title() %></td></a>
						<td><%=dto.getM_id() %></td>
						<td><%=dto.getB_wdate() %></td>
					</tr>

<%
	}
%>











<%
	
	int pagesu = (int)request.getAttribute("pagesu");
	int strs[] = new int[pagesu];
			for(int i=0;i<(pagesu);i++){
				strs[i]=i;
			}
%>
		  <td colspan="5">
		    <hr width="600" color="Maroon" size="2" noshade>
		  </td>
		</tr>
		<tr>
		  <td colspan="3" align="center">

           |
<%
	for(int i=0;i<pagesu;i++){
%>
             <a href="./board.do?m=tradelist&cp=10&ps=<%=strs[i]+1%>">
<b><%=strs[i]+1 %></b>

             </a> 

		   |
<%
	}
%>



<form action="./board.do?m=tinputform" method="post">
				<div>
					
					<button class="search_button" type="submit">입력</button>
				</div>
			</form>



				</table>
			</div>
		</div>
	</div>
</body>
</html>