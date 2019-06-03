<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
	@import url('https://fonts.googleapis.com/css?family=Gothic+A1&display=swap');
	
	html, body { 
		margin:0px;
		height:100%;
		overflow:hidden 
	}

	#container {
	    padding: 1%;
	    padding-top: 45px;
	    background-color: #f3e7d4;
	    height: 100%;
	    width: 100%;
	}
	
	#left_menu{
		width: 19%;
		vertical-align: top;
		display: inline-block;
		text-align: right;
		background-color: transparent;
	}

	#left_menu div{
		margin-right: 14%;
		background-color: transparent;
		font-family: 'Gothic A1', sans-serif;
		margin-bottom: 6px;
	}
	
	#left_menu div:first-child{
		font-size: 20px;
		margin-bottom: 10px;
	}

	#contents{
		vertical-align: top;
		width: 55%;
		background-color: white;
		display: inline-block;
		font-family: 'Gothic A1', sans-serif;
		min-height: 80%;
		padding: 3%;
		box-shadow: 3px 4px 5px -5px;
	}	
	
	
</style>
</head>
<body>
	<jsp:include page="../0_HFooter/header.jsp"></jsp:include>
	
	<div id="container">
		<div id ="left_menu">
			<div> 내 컵밥관리 </div>
			<div> - <a href="">지금 나의 컵밥</a> </div>
			<div> -  <a href="">나의 컵밥 통계</a> </div>
		</div>
		<div id ="contents">
			<div id =""> @@님의 컵밥 @@개 </div>
		</div>
	</div>
</body>
</html>