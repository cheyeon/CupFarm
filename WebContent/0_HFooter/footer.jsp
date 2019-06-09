<%@ page contentType="text/html;charset=utf-8" import="java.util.*,cf.member.model.MemDTO,cf.myCupbob.model.McbDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<style type="text/css">
		#footer{
		    position: absolute;
		    bottom: 0;
		    right: 0;
		    background-color: transparent;
		    margin: 3%;
		    width: 91px;
		    height: 91px;
		}
		
		#eat{
		    background-color: #c71d22;
		    border-radius: 50%;
		    width: 90px;
		    height: 90px;
		    box-shadow: 1px 2px 3px 0px #949494;
		}
		
		#eat:hover{
		    background-color: #e42c31;
		}
		
		#eat:active{
		    background-color: #c71d22;
		    margin: 1px;
		    width: 89px;
		    height: 89px;
		    box-shadow: -1px 1px 3px 0px #949494;
		}
		
		#eatimg{
		    width: 70px;
		    display: block;
		    position: absolute;
    		margin: 11px;
		    line-height:90px;
		}
		
		#togglePageBack{
		    background: #00000094;
		    position: fixed;
		    width: 100%;
		    height: 100%;
		    z-index: 1;
		    top: 0;
		    display:none;
		}
		
		#togglePage{
			background: white;
		    width: 300px;
		    height: 55%;
		    border-radius: 26px;
		    padding: 4%;
		    box-shadow: -1px 3px 10px #383838;
		    position: absolute;
		    top:50%;
		    left:50%;
		    transform:translate(-50%, -50%);
		}
		
		#backToggle{
		    background-color: transparent;
		    width:100%;
		    height:100%;
		}
	</style>
	
	<script>
		$(document).ready(function() {
			//버튼눌렀을때
			$('#footer').click(function(){
				$("#togglePageBack").fadeToggle("fast");
			});
			$("#backToggle").click(function(){
				$("#togglePageBack").fadeToggle("fast");
			});
			
	      	//브라우저 높이알아내기
	      	$.contentHeight = function(){
	      		var bwheight = window.innerHeight;
	      		$('#togglePageBack').css("height",bwheight);   		
	      	}
	    	$.contentHeight();
	    	
	    	//브라우저바뀔때마다
	    	$(window).resize(function(){
	    		$.contentHeight();
	    	});
	
			// 기존 css에서 플로팅 배너 위치(top)값을 가져와 저장한다.
			var floatPosition = parseInt($("#footer").css('top'));
			// 250px 이런식으로 가져오므로 여기서 숫자만 가져온다. parseInt( 값 );
					
			$(window).scroll(function() {
				// 현재 스크롤 위치를 가져온다.
				var scrollTop = $(window).scrollTop();
				var newPosition = scrollTop + floatPosition + "px";
	
				$("#footer").stop().animate({
					"top" : newPosition
				}, 500);
			}).scroll();
	
		});
	</script>
</head>
<body>
		<%
			MemDTO f = (MemDTO)session.getAttribute("loginSession");
			if(f != null){
		%>
	<div id="togglePageBack">
		<div id="backToggle"></div>
		<div id="togglePage">
			<div> 내가 가지고 있는 컵밥들 </div>
			<form method="post" action="my.do?m=eat">
				<div>
					<select name="idx">
						<%
							ArrayList<McbDTO> l = (ArrayList<McbDTO>)session.getAttribute("list");
								if(l.size()==0){
						%>
										<option value=""> 현재 가지고있는 컵밥이 없습니다 </option>									
						<%
								}else{
						%>
										<option value="">먹을 컵밥을 선택해주세요</option>
						<%
									for(McbDTO m : l){
										if(m.getC_state()==1){
											if(m.getG_name().equals("그룹없음")){
						%>
											<option value="<%=m.getC_idx()%>">[<%=f.getM_name()%>님의 개인컵밥] <%=m.getC_name()%></option>
						<%
											}else{
						%>
											<option value="<%=m.getC_idx()%>">[<%=m.getG_name()%>] <%=m.getC_name()%></option>											
						<%
										}
									}
								}
							}
						%>
					</select>	
				</div>			
				
				<div>
					<button type="submit"> 먹기 </button>
				</div>	
			</form>
		</div>
	</div>	
	
	<div id ="footer">
			<div id = "eat">
				<img alt="cupfarmlogo" src="./img/컵팜로고3.png" id="eatimg">
			</div>
	</div>
		<%
			}else{}
		%>
</body>
</html>