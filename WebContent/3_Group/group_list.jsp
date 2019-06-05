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