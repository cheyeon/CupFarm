<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="../css/basic.css">
<style type="text/css">

	.cont{
		text-align:center;
	}

	.gr_menu{
	    width: 40%;
	    margin: 2% 4%;
		display: inline-block;
		height: 400px;
		background: #fcc246;
		font-size: 35px;
		font-weight: bold;
	    line-height: 400px;
		box-shadow: 2px -1px 6px #d4cec5;
		  -webkit-transition: all .3s; /* For Safari 3.1 to 6.0 */
		  transition: all .3s;
	}
	
	.gr_menu:hover{
		width: 41%;
		background: #fdd786;
		font-size: 39px;
	}
	
	.gr_menu:active{
		background: #fcc246;
	}

</style>

</head>
<body>
	<jsp:include page="../0_HFooter/header.jsp"></jsp:include>
	
	<div id="container">
		<div id ="left_menu">
			<div> 컵밥 그룹 </div>
			<div> - <a href=""> 나의 컵밥 그룹</a> </div>
			<div> -  <a href="">컵밥그룹 생성/가입</a> </div>
		</div>
		<div id ="contents">
			<div id = "cont_top">
				<div>	컵밥그룹 생성/가입	</div>
			</div>
	
			<div class ="cont">
				<div class="gr_menu"> 
					<span>그룹 생성</span>
				</div>
				<div class="gr_menu">
					<span>그룹 가입</span>
				</div>
			</div>

		</div>
	</div>
	<jsp:include page="../0_HFooter/footer.jsp"></jsp:include>
</body>
</html>