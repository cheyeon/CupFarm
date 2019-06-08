<%@ page contentType="text/html;charset=utf-8" import="java.util.*,cf.member.model.MemDTO"%>
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
				$("#togglePageBack").toggle();
			});
			$("#backToggle").click(function(){
				$("#togglePageBack").toggle();
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
		<div id="togglePage">ggggg</div>
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