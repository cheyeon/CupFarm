<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
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
		
	</style>
	
    <script src="//code.jquery.com/jquery-1.12.4.min.js"></script>
    <script>
      $( document ).ready( function() {
    	  //메뉴위치 파악
        var botOffset = $(  '#bottom' ).offset();
    	  
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
			<span> <a href="../login.do"> 로그인 </a></span>
			<span> <a href="./2_Member/join.jsp"> 회원가입 </a> </span>
		</div>
		
		<div id = "mid">
			<a href=""> <img alt="cupfarmlogo" src="../img/컵팜로고.png" id="cf_logo"> </a>
		</div>
		
		<div id = "bottom">
			<ul>
				<li> <a href=""> 컵팜  </a> </li>
				<li> <a href=""> 내 컵밥관리  </a> </li>
				<li> <a href=""> 컵밥 그룹  </a> </li>
				<li> <a href=""> 컵밥 교환  </a> </li>
				<li> <a href=""> 컵밥 판매  </a> </li>
			</ul>
		</div>
		
	</div>
</body>
</html>