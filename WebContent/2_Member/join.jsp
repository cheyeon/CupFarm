<%@ page language="java" contentType="text/html; charset=utf-8" %>
<!doctype html>

 <head>
  <meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./css/basic.css">
  	<script language="javascript">
	   function check(){
	      if(f.m_id.value == ""){
		      alert("아이디를 입력하셔야 합니다.");
			  f.m_id.focus();
			  return false;
		  }
	      
		  if(f.m_pwd.value == ""){
		      alert("비밀번호를 입력하셔야 합니다.");
			  f.m_pwd.focus();
			  return false;
		  }
		  f.submit();
	   }
	   
	   function rewrite(){
	      f.m_id.focus();
	   }
	</script>

<style>
	#login_conts{
		text-align: center;
		background: transparent;
		font-family: 'Gothic A1', sans-serif;
	}
	
	#login_conts div{
		line-height: 60px;
	    background: transparent;
	    height: 60px;
	    margin-bottom: 30px;
	    font-size: 33px;
	    font-family: 'Righteous', cursive;
	    color: #c71d22;
	}
	
	#login_conts input{
	    display: block;
	    margin: 2% auto;
	    width: 308px;
	    height: 59px;
	    background: #ffffff8f;
	    border: none;
	    border-radius: 15px;
	    padding: 0 15px;
	}

	#login_conts input:focus {
	  outline: none;
	  background: #ffffff;
	}
		
	#login_conts div:last-child{
	    padding: 0px;
	    background: #c71d2299;
	    color: white;
	    width: 338px;
	    font-size: 20px;
	    margin: 60px auto;
	    height: 57px;
	    border-radius: 15px;
		font-family: 'Gothic A1', sans-serif;
	    box-shadow: 1px 3px 3px #3f3f3f38;
	}

	#login_conts div:last-child:hover{
	    background: #c71d22bd;
	}

	#login_conts div:last-child:active{
	    background: ##c71d22;
    	margin: 38px auto;
  		box-shadow: 0px 2px 3px #3f3f3f6e;
	}
	
	#phone{
		margin: -2% auto;
	}
	
	#phone input{
		display: inline-block;
		width: 60px;
	}
</style>
 </head>
 <body>
 <jsp:include page="../0_HFooter/header.jsp"></jsp:include>
          
 	<div id="container">
	<div id="login_conts">
	     <form name="f" action="./join.do?m=join" method="post">
	     		<div> CUPFARM JOIN </div>
				<input type="text" name="m_id" size="20" placeholder="ID">
				<input type="password" name="m_pwd" size="20" placeholder="PASSWORD">
				<input type="text" name="m_name" size="20" placeholder="NAME">
				
				<div id="phone">
					<input type="text"name="ph1" class="phone" placeholder="PHONE"> -
	                <input type="text" name="ph2" class="phone"> -
	                <input type="text" name="ph3" class="phone">				
				</div>

				
				
				<div type="button" onclick="check()">회원가입</div>
		 </form>
	</div>
	</div>
 </body>
</html>
 

  