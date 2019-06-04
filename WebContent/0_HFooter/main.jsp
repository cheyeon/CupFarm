<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
	@import url('https://fonts.googleapis.com/css?family=Gothic+A1&display=swap');
	@charset "UTF-8";
	
	#container {
	    background-color: #f3e7d4;
	    height: 100%;
	}
	
	#slider{
		width:200%;
	}
	
	#slider img {
		width:50%;
	}
	

</style>
</head>
<body>
	<jsp:include page="../0_HFooter/header.jsp"></jsp:include>
	<div id="container">

		<div id="slider">
			<img alt="main1" src="../img/컵반메인이미지1.jpg">
			<img alt="main2" src="../img/컵반메인이미지2.jpg">
		</div>


	</div>
</body>
</html>