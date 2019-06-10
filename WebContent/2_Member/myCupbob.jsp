<%@ page contentType="text/html;charset=utf-8" import="java.util.*,cf.member.model.MemDTO,cf.myCupbob.model.McbDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./css/basic.css">
<style type="text/css">
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
	 	margin-top: 9%;
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
	
	#in_cb{
		width: 90%;
	}
	
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
				<div>	지금 나의 컵밥	</div>
			</div>

		<%
			String name;			
			if(dto != null){
				name = dto.getM_name()+"님이 가지고 계신 컵밥은 "+"웅앵웅"+"개 입니다.";
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
				if(cbdto.getC_state()==1){
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
	</div>

	<jsp:include page="../0_HFooter/footer.jsp"></jsp:include>
</body>
</html>