<%@ page contentType="text/html;charset=utf-8" import="java.util.*,cf.member.model.MemDTO,cf.myCupbob.model.McbDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./css/basic.css">
<style type="text/css">
	
	 	
</style>
</head>
<body>
	<jsp:include page="../0_HFooter/header.jsp"></jsp:include>
	<%
		MemDTO dto = (MemDTO)session.getAttribute("loginSession");
		ArrayList<McbDTO> list = (ArrayList<McbDTO>)session.getAttribute("list");
		
		String mycupbob = null;
		String insert_cb = null;
		String my_rate = null;
		if(dto!=null){
			mycupbob="my.do?m=cb_list&id="+dto.getM_id();
			insert_cb = "my.do?m=insert_cb";
			my_rate = "my.do?m=rate_cb";
		}else{
			mycupbob = "my.do";
			insert_cb = "login.do?m=plzlogin";
			my_rate = "login.do?m=plzlogin";
		}
	%>
	<div id="container">
		<div id ="left_menu">
			<div> 내 컵밥관리 </div>
			<div> - <a href="<%=mycupbob%>">지금 나의 컵밥</a> </div>
			<div> -  <a href="<%=insert_cb%>">컵밥 등록 하기</a> </div>
			<div> -  <a href="<%=my_rate%>">나의 컵밥 통계</a> </div>
		</div>
		<div id ="contents">
			<div id = "cont_top">
				<div>	나의 컵밥 통계	</div>
			</div>

			</div>
		</div>

	<jsp:include page="../0_HFooter/footer.jsp"></jsp:include>
</body>
</html>