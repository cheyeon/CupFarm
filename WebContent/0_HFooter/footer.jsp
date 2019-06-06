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
	</style>
	
	<script>
		$(document).ready(function() {
	
			// 기존 css에서 플로팅 배너 위치(top)값을 가져와 저장한다.
			var floatPosition = parseInt($("#footer").css('top'));
			// 250px 이런식으로 가져오므로 여기서 숫자만 가져온다. parseInt( 값 );
	
			$(window).scroll(function() {
				// 현재 스크롤 위치를 가져온다.
				var scrollTop = $(window).scrollTop();
				var newPosition = scrollTop + floatPosition + "px";
	
				/* 애니메이션 없이 바로 따라감
				 $("#floatMenu").css('top', newPosition);
				 */
	
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
	<div id ="footer">
		<a href="">
			<div id = "eat">
				<img alt="cupfarmlogo" src="./img/컵팜로고3.png" id="eatimg">
			</div>
		</a>
	</div>
		<%
			}else{}
		%>
</body>
</html>