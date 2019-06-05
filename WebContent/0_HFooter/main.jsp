<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>

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
	    background-color: #f3e7d4;
	}
	
	@keyframes slidy {
	    0% { left: 0px; }
	    20% { left: 0px; }
	    30% { left: -100%; }
	    50% { left: -100%; }
	    60% { left: -200%; }
	    80% { left: -200%; }
	    100% { left: 0px; }
	}
	
	#main_slide {width: 100%;}
	#main_slide > div.wrap > div#slider {overflow: hidden; position: relative;}
	div#slider > div > img {width: 33.333333333333333333333333%; float: left;}
	div#slider > div { 
	    position: relative;
	    width: 300%;
	    margin: 0;
	    top:0;
	    left: 0;
	    text-align: left;
	    font-size: 0;
	    -webkit-animation: 20s slidy ease-in-out infinite;
	    animation: 20s slidy ease-in-out infinite;
	}

</style>
</head>
<body>
	<jsp:include page="../0_HFooter/header.jsp"></jsp:include>
	<div id="container">

	<div id="main_slide">
	    <div class="wrap">
	        <div id="slider">
	            <div>
				<img alt="main1" src="../img/컵반메인이미지3.jpg">
				<img alt="main2" src="../img/컵반메인이미지1.jpg">
				<img alt="main2" src="../img/컵반메인이미지2.jpg">
	            </div>
	        </div>
	    </div>
	</div>

	</div>
</body>
</html>