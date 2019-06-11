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
		
		#togglePage div:first-child{
			text-align: center;
		    padding-bottom: 16px;
		    margin-bottom: 9px;
		    font-size: 19px;
		    border-bottom: 1px solid #fcc246;
		}
		
		#togglePage div:last-child{
		    text-align: center;
		    bottom: 31px;
		    right: 34px;
		    position: absolute;
		    background: transparent;
		}
		
		#togglePage div:last-child button{
		    width: 115px;
		    height: 50px;
		    background: #c71d22;
		    color: white;
		    border: none;
		    border-radius: 13px;
		    font-weight: bold;
		    font-size: 19px;
		    box-shadow: 0px 1px 1px 1px darkgrey;
		}

		#togglePage div:last-child button:active{
	  		outline: none;
		    width: 114px;
		    height: 49px;
		    box-shadow: 0px 1px 1px 1px darkgrey;
		    background: #ab191d;
		}
		
		#togglePage div:last-child button:focus{
	  		outline: none;
		}
		
		#backToggle{
		    background-color: transparent;
		    width:100%;
		    height:100%;
		}
		
		#select_cb{
			width: 100%;
		    height: 38px;
		    line-height: 38px;
		    border-radius: 14px;
		    margin: 10px 0;
		    padding: 0px 10px;
		}
		
		#select_cb:focus {
	  		outline: none;
	  	}
		
	</style>
	
    <script type="text/javascript" src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
	<script>
		$( document ).ready( function() {
			$('#eatbt').click(function(){
	    		if($("select[name=idx]").val() == ''){
	    			alert('컵밥을 선택해주세요');
	    		}else{
	    			alert('컵밥을 먹었습니다!');
	    			f.submit();
	    		}				
			});
			
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
			<div> 컵밥을 먹어요 </div>
			<form name="f" method="post" action="my.do">
				<input type="hidden" name="m" value="eat"/>
				<input type="hidden" name="id" value="<%=f.getM_id()%>"/>
				<div>
					<select name="idx" id="select_cb">
						<%
							ArrayList<McbDTO> l = (ArrayList<McbDTO>)request.getAttribute("list");
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
											<option value="<%=m.getC_idx()%>">[개인컵밥] <%=m.getC_name()%> (<%=m.getC_cdate()%>)</option>
						<%
											}else{
						%>
											<option value="<%=m.getC_idx()%>">[<%=m.getG_name()%>] <%=m.getC_name()%> (<%=m.getC_cdate()%>)</option>											
						<%
										}
									}
								}
							}
						%>
					</select>	
				</div>			
				
				<div>
					<button type="button" id="eatbt""> 먹기 </button>
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