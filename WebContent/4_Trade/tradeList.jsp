<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="../css/basic.css">
<style type="text/css">
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
			<form action="" method="">
				<div>
					<input type="text" placeholder="검색어 입력">
					<button class="search_button" type="submit">검색</button>
				</div>
			</form>
		</div>
	</div>
	
	<div id="container_board">
		<div id ="contents_board">
			<div class="tables">

				<table>
					<col width="10%">
					<col width="50%">
					<col width="20%">
					<col width="20%">
					
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>작성자</th>
						<th>작성일</th>
					</tr>
					
					<tr>
						<td>1</td>
						<td>웅앵웅ㅇ앵웅앵웅</td>
						<td>시발</td>
						<td>시발</td>
					</tr>

					<tr>
						<td>2</td>
						<td>시발</td>
						<td>시발</td>
						<td>시발</td>
					</tr>

					<tr>
						<td>3</td>
						<td>시발</td>
						<td>시발</td>
						<td>시발</td>
					</tr>

					<tr>
						<td>4</td>
						<td>시발</td>
						<td>시발</td>
						<td>시발</td>
					</tr>

					<tr>
						<td>5</td>
						<td>시발</td>
						<td>시발</td>
						<td>시발</td>
					</tr>

					<tr>
						<td>6</td>
						<td>시발</td>
						<td>시발</td>
						<td>시발</td>
					</tr>
				</table>
			</div>
		</div>
	</div>
	<jsp:include page="../0_HFooter/footer.jsp"></jsp:include>
</body>
</html>