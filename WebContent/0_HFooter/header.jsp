<%@ page contentType="text/html;charset=utf-8" import="java.util.*,cf.member.model.MemDTO"%>
<!DOCTYPE html>
<html>
<head>
<title>CUPFARM</title>
<meta charset="UTF-8">
	<style type="text/css">
		@import url('https://fonts.googleapis.com/css?family=Gothic+A1&display=swap');
		body{
			margin: 0px;
		}
		
		a{
			text-decoration: none;
			font-family: 'Gothic A1', sans-serif;
			color: #2d2d2d;
		}
		
		div{
			background-color: white;
		}
	
		#header{
			width: 100%;
		}

		#top{
			width: 100%;
			height: 29px;
			background-color:#c71d22;
			line-height: 29px;
		}
				
		#top a{
			margin-left : 10px;
			text-decoration: none;
			font-size: 14px;
			color: white;
		}
		
		#top a:hover{
			color: #f3e7d4;
		}
		
		#mid{
		    text-align: center;
		    padding: 25px 0;
		    border-bottom: .5px solid #d0d0d0;
		}
		
		#cf_logo{
			width: 111px;
		}
		
		#bottom{
			height: 55px;
			width: 100%;
			line-height: 55px;
		    display: flex;
		    justify-content: center;
		    box-shadow: -5px 2px 1px -1px rgba(0, 0, 0, 0.15);
		}
		
		#bottom ul{
			list-style: none;
			margin: 0;
			padding: 0;
		}
		
		#bottom ul li{
			float : left;
			margin: 0px 30px;
		}
		
		#bottom ul li:hover{
			font-weight: bold;
			color: #939393;
		}
		
		#bottom ul li:active{
			font-size: 15px;
			line-height: 56px;
		}
		
		.fixed{
			position: fixed;
			top: 0px;
			background-color: #ffffffd6;
		}
		
		#top span{
			background-color: transparent;
			font-family: 'Gothic A1', sans-serif;
			font-size: 14px;
			color: white;		
		}
		
		#user{
			background-color: transparent;
			font-family: 'Gothic A1', sans-serif;
			font-size: 14px;
			color: white;
			float: right;
    		margin-right: 1%;
		}
	</style>
	
    <script src="//code.jquery.com/jquery-3.4.1.min.js"></script>
    <script>
      $( document ).ready( function() {
      	//브라우저 높이알아내기
      	$.contH = function(){
      		var bwheight = $(window).height();
      		var hdheight = $('#header').height();
      		var contheight = bwheight-hdheight;
      		$('#container').css("min-height",contheight);   		
      	}
      	
    	//메뉴위치 파악
        var botOffset = $(  '#bottom' ).offset();
    	
    	$.contH();
    	
    	//브라우저바뀔때마다
    	$(window).resize(function(){
        	$.contH();
    	});
    	  
        $( window ).scroll( function() {
        	//스크롤바가 메뉴보다 아래면 고정하라
          if ( $( document ).scrollTop() > botOffset.top ) {
            $( '#bottom' ).addClass( 'fixed' );
          }else {
            $(  '#bottom' ).removeClass( 'fixed' );
          }
        });
      } );
    </script>
</head>
<body>
	<div id ="header">
		<div id = "top">
		<%
			MemDTO mdto = (MemDTO)session.getAttribute("loginSession");
			String mycupbob = null;
			if(mdto != null){
				mycupbob="my.do?m=cb_list&id="+mdto.getM_id();
		%>
				<span><a href="./login.do?m=logout">로그아웃</a></span>
				<span id="user"> <a href="">접속자 : <%=mdto.getM_name()%></a> </span>
		<%
			}else{
				mycupbob = "my.do";
		%>
				<span> <a href="./login.do"> 로그인 </a></span>
				<span> <a href="./join.do"> 회원가입 </a> </span>
		<%
			}
		%>
		</div>
		
		<div id = "mid">
			<a href="./index.do"> <img alt="cupfarmlogo" src="./img/컵팜로고.png" id="cf_logo"> </a>
		</div>
		
		<div id = "bottom">
			<ul>
				<li> <a href=""> 컵팜  </a> </li>
				<li> <a href="<%=mycupbob%>"> 내 컵밥관리  </a> </li>
				<li> <a href="./group.do"> 컵밥 그룹  </a> </li>
				<li> <a href="./board.do?m=tradelist&cp=10&ps=1"> 컵밥 교환  </a> </li>
				<li> <a href=""> 컵밥 판매  </a> </li>

			</ul>
		</div>
		
	</div>
</body>
</html>