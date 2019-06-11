<%@ page contentType="text/html;charset=utf-8" import="java.util.*,cf.member.model.MemDTO,cf.myCupbob.model.McbDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./css/basic.css">
<link rel="stylesheet" type="text/css" href="./css/mycupbob.css">
</head>
<body>
	<jsp:include page="../0_HFooter/header.jsp"></jsp:include>
	<%
		MemDTO dto = (MemDTO)session.getAttribute("loginSession");
		ArrayList<McbDTO> list = (ArrayList<McbDTO>)request.getAttribute("list");
		int count = (Integer)request.getAttribute("countD");
		
		String mycupbob = null;
		String insert_cb = null;
		String my_rate = null;
		if(dto!=null){
			mycupbob="my.do?m=cb_list&id="+dto.getM_id();
			insert_cb = "my.do?m=insert_cb";
			my_rate = "my.do?m=rate_cb&id="+dto.getM_id();
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
				
		<%
			String name;	
			if(dto != null){
				name = dto.getM_name()+"님이 드신 컵밥은 "+ count +"개 입니다.";
			}else{
				name = "로그인을 해주세요";
			}
		%>			
			<div id ="cont_header">
				<h1 class ="bounceIn"> <%=name%> </h1>
			</div>

		<%
		if(dto != null){
		%>			
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
					
		<%
			if(list.size()==0){
		%>
				<tr>
					<td colspan="4"> 현재 가지고있는 컵밥이 없습니다 </td>
				</tr>
		<%			
			}
		
			for(McbDTO cbdto : list){
				if(cbdto.getC_state()==0){
		%>
					<tr>
						<td><%=cbdto.getC_idx()%></td>
						<td><%=cbdto.getC_name()%></td>
		<%
						if(cbdto.getG_name().equals("그룹없음")){
		%>
						<td id="ps_td"><%=dto.getM_name()%>님의 개인컵밥</td>
		<% 					
						}else{
		%>
						<td id="gr_td"><%=cbdto.getG_name()%></td>
		<% 					
						}
		%>
						<td><%=cbdto.getC_cdate()%></td>
					</tr>
		<%
				}
			}				
		%>
				</table>
		<%
		}else{}
		%>

			</div>
		</div>
</body>
</html>