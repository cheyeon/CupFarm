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
	    padding: 1%;
	    padding-top: 45px;
	    background-color: #f3e7d4;
	    height: 100%;
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
		font-size: 15px;
	}
	
	#left_menu div:first-child{
		font-size: 18px;
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
	
	#cont_top{
		border-bottom: 1px solid #fcc246;
	}
	
	#cont_top div{
		margin-bottom: 8px;
	}
	
	@-webkit-keyframes bounceIn {
	  from,
	  20%,
	  40%,
	  60%,
	  80%,
	  to {
	    -webkit-animation-timing-function: cubic-bezier(0.215, 0.61, 0.355, 1);
	    animation-timing-function: cubic-bezier(0.215, 0.61, 0.355, 1);
	  }
	
	  0% {
	    opacity: 0;
	    -webkit-transform: scale3d(0.3, 0.3, 0.3);
	    transform: scale3d(0.3, 0.3, 0.3);
	  }
	
	  20% {
	    -webkit-transform: scale3d(1.1, 1.1, 1.1);
	    transform: scale3d(1.1, 1.1, 1.1);
	  }
	
	  40% {
	    -webkit-transform: scale3d(0.9, 0.9, 0.9);
	    transform: scale3d(0.9, 0.9, 0.9);
	  }
	
	  60% {
	    opacity: 1;
	    -webkit-transform: scale3d(1.03, 1.03, 1.03);
	    transform: scale3d(1.03, 1.03, 1.03);
	  }
	
	  80% {
	    -webkit-transform: scale3d(0.97, 0.97, 0.97);
	    transform: scale3d(0.97, 0.97, 0.97);
	  }
	
	  to {
	    opacity: 1;
	    -webkit-transform: scale3d(1, 1, 1);
	    transform: scale3d(1, 1, 1);
	  }
	}
	
	@keyframes bounceIn {
	  from,
	  20%,
	  40%,
	  60%,
	  80%,
	  to {
	    -webkit-animation-timing-function: cubic-bezier(0.215, 0.61, 0.355, 1);
	    animation-timing-function: cubic-bezier(0.215, 0.61, 0.355, 1);
	  }
	
	  0% {
	    opacity: 0;
	    -webkit-transform: scale3d(0.3, 0.3, 0.3);
	    transform: scale3d(0.3, 0.3, 0.3);
	  }
	
	  20% {
	    -webkit-transform: scale3d(1.1, 1.1, 1.1);
	    transform: scale3d(1.1, 1.1, 1.1);
	  }
	
	  40% {
	    -webkit-transform: scale3d(0.9, 0.9, 0.9);
	    transform: scale3d(0.9, 0.9, 0.9);
	  }
	
	  60% {
	    opacity: 1;
	    -webkit-transform: scale3d(1.03, 1.03, 1.03);
	    transform: scale3d(1.03, 1.03, 1.03);
	  }
	
	  80% {
	    -webkit-transform: scale3d(0.97, 0.97, 0.97);
	    transform: scale3d(0.97, 0.97, 0.97);
	  }
	
	  to {
	    opacity: 1;
	    -webkit-transform: scale3d(1, 1, 1);
	    transform: scale3d(1, 1, 1);
	  }
	}
	
	.bounceIn {
	  	-webkit-animation-duration: 0.75s;
	  	animation-duration: 0.75s;
	  	-webkit-animation-name: bounceIn;
	  	animation-name: bounceIn;
	 	text-align: center;
	 	margin-top: 50px;
	 }
	 
	 .tables{
	 	margin-top: 11%;
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
		border-bottom: 3px solid #2d2d2d;
	}
	
	.tables td {
	  color: #669;
	  padding: 10px;
	  border-bottom: 1px solid #ddd;
	}
	
	.tables tr:hover td {
	  background-color: #f2f2f2;
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
			<div id = "cont_top">
				<div>	지금 나의 컵밥	</div>
			</div>
			
			<div id ="cont_header">
				<h1 class ="bounceIn"> @@님이 가지고 있는 컵밥은 @@개 입니다. </h1>
			</div>
			
			<div class="tables">

				<table>
					<col width="13%">
					<col width="35%">
					<col width="35%">
					<col width="20%">
					
					<tr>
						<th>번호</th>
						<th>컵밥이름</th>
						<th>컵밥그룹</th>
						<th>구매날짜</th>
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