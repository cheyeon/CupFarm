<%@ page contentType="text/html;charset=utf-8" import="java.util.*,cf.member.model.MemDTO,cf.myCupbob.model.McbDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./css/basic.css">
<style type="text/css">
		#cupbob_form div:first-child{
			font-size: 23px;
    		font-weight: bold;
		}

	 	.checks {
			display: none;
		}

		.checks + label {
			display: inline-block;
		    width: 12px;
		    height: 12px;
		    border: 1px solid #c71d22;
		    cursor: pointer;
		    position: relative;
		    border-radius: 12px;
		    top: 26%;
		    transform: translateY(-50%);
		    margin-right: 6px;
		}
		
		.checks + label:active{
		    width: 11.5px;
		    height: 11.5px;
		    background-color: 	#c71d22
		}

		.checks:checked + label {
			background-color: #c71d22;
		}
		
		.checks input[type="text"]{
			width: 50px;
		}
				
		.cupbobs{
		    width: 100%;
		    height: 33px;
		    line-height: 33px;
		}
		
		#subtext{
			font-size: 13px;
		    margin: 4px;
		    width: 89%;
		}
		
		#subtext span{
		    background: #fff2dd;
		}

		#checkboxs{
		    margin: 10px;
		    padding: 10px;
		}
		
		#insert_bt{
			width: 122px;
		    background: #c8383c;
		    height: 50px;
		    line-height: 50px;
		    color: white;
		    text-align: center;
		    float: right;
		    border-radius: 9px;
		    font-size: 19px;
		    font-weight: bold;
		    box-shadow: 1px 1px 2px 1px #8080808f;
		    cursor: pointer;
		}
		
		#insert_bt:active{
			margin-top: 2px;
			height: 48px;
		    box-shadow: 1px 1px 1px 1px #8080808f;
		}
		
		input[type=text]{
			width: 23px;
		    height: 10px;
		    padding: 5px;
		}
</style>

<script src="//code.jquery.com/jquery-3.4.1.min.js"></script>
<script>
		$(document).ready(function() {
			//초기값 확인
			chTchbx();
			
			//변경값 확인
			$("input:checkbox[name='cupbobs']").change(function () {
			    if ($(this).prop("checked")) {
			    	chTchbx();
			    }else{
			    	chTchbx();
			    }
			});
		});
		
		function chTchbx(){
			if($("input:checkbox[name='cupbobs']").is(":checked")==true){
				$("#insert_bt").css("background","#c8383c");
			}else{
				$("#insert_bt").css("background","gray");
			}
		}
		
		function checkThecheckbox(){
			if($("input:checkbox[name='cupbobs']").is(":checked")==true){
				alert('컵밥 등록 성공!');
				f.submit();
			}else{
				alert('컵밥을 체크해주세요');
			}			
		}
</script>
</head>
<body>
	<jsp:include page="../0_HFooter/header.jsp"></jsp:include>
	<%
		MemDTO dto = (MemDTO)session.getAttribute("loginSession");
		ArrayList<McbDTO> list = (ArrayList<McbDTO>)session.getAttribute("list");
		
		String mycupbob = null;
		String insert_cb = null;
		String my_rate = null;
		String my_id = null;
		
		if(dto!=null){
			mycupbob="my.do?m=cb_list&id="+dto.getM_id();
			insert_cb = "my.do?m=insert_cb";
			my_rate = "my.do?m=rate_cb&id="+dto.getM_id();
			my_id = dto.getM_id();
		}else{
			mycupbob = "my.do";
			insert_cb = "login.do?m=plzlogin";
			my_rate = "login.do?m=plzlogin";
			my_id = null;
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
				<div>	컵밥 등록 하기	</div>
			</div>

			<form name="f" action="./my.do?m=insert" method="post">
			<div id="cupbob_form">
				<div> 구매하신 컵밥을 등록해주세요 </div>
				<div id="subtext"><span>** 컵밥등록 기본값은 1개입니다. 2개이상의 컵밥을 등록하려면 수량을 입력해주세요.</span></div>

				<div id="checkboxs">
				<input type="checkbox" name="cupbobs" value="1" class="checks" id="ck"/>
				<input type="hidden" name="id" value="<%=my_id%>"/>
				<div class="cupbobs"> <input type="checkbox" name="cupbobs" value="1" class="checks" id="ck1"/><label for="ck1"></label> 볶은김치덮밥 - <input type="text" name="1num" maxlength="3" size="3" placeholder="1개"> </div>
				<div class="cupbobs"> <input type="checkbox" name="cupbobs" value="2" class="checks" id="ck2"/><label for="ck2"></label> 오징어덮밥 - <input type="text" name="2num" maxlength="3" size="3" placeholder="1개"> </div>
				<div class="cupbobs"> <input type="checkbox" name="cupbobs" value="3" class="checks" id="ck3"/><label for="ck3"></label> 불닭덮밥 - <input type="text" name="3num" maxlength="3" size="3" placeholder="1개"> </div>
				<div class="cupbobs"> <input type="checkbox" name="cupbobs" value="4" class="checks" id="ck4"/><label for="ck4"></label> 고추장제육덮밥 - <input type="text" name="4num" maxlength="3" size="3" placeholder="1개"></div>
				<div class="cupbobs"> <input type="checkbox" name="cupbobs" value="5" class="checks" id="ck5"/><label for="ck5"></label> 육개장국밥 - <input type="text" name="5num" maxlength="3" size="3" placeholder="1개"></div>
				<div class="cupbobs"> <input type="checkbox" name="cupbobs" value="6" class="checks" id="ck6"/><label for="ck6"></label> 불고기덮밥 - <input type="text" name="6num" maxlength="3" size="3" placeholder="1개"></div>
				<div class="cupbobs"> <input type="checkbox" name="cupbobs" value="7" class="checks" id="ck7"/><label for="ck7"></label> 부대찌개국밥 - <input type="text" name="7num" maxlength="3" size="3" placeholder="1개"> </div>
				<div class="cupbobs"> <input type="checkbox" name="cupbobs" value="8" class="checks" id="ck8"/><label for="ck8"></label> 콩나물국밥 - <input type="text" name="8num" maxlength="3" size="3" placeholder="1개"> </div>
				<div class="cupbobs"> <input type="checkbox" name="cupbobs" value="9" class="checks" id="ck9"/><label for="ck9"></label> 옐로우크림커리덮밥 - <input type="text" name="9num" maxlength="3" size="3" placeholder="1개"> </div>
				<div class="cupbobs"> <input type="checkbox" name="cupbobs" value="10" class="checks" id="ck10"/><label for="ck10"></label> 레드스파이시커리덮밥 - <input type="text" name="10num" maxlength="3" size="3" placeholder="1개"> </div>
				<div class="cupbobs"> <input type="checkbox" name="cupbobs" value="11" class="checks" id="ck11"/><label for="ck11"></label> 직화볶음짜장덮밥 - <input type="text" name="11num" maxlength="3" size="3" placeholder="1개"> </div>
				<div class="cupbobs"> <input type="checkbox" name="cupbobs" value="12" class="checks" id="ck12"/><label for="ck12"></label> 고추장나물비빔밥 - <input type="text" name="12num" maxlength="3" size="3" placeholder="1개"></div>
				<div class="cupbobs"> <input type="checkbox" name="cupbobs" value="13" class="checks" id="ck13"/><label for="ck13"></label> 강된장보리비빔밥 - <input type="text" name="13num" maxlength="3" size="3" placeholder="1개"> </div>
				<div class="cupbobs"> <input type="checkbox" name="cupbobs" value="14" class="checks" id="ck14"/><label for="ck14"></label> 중화마파두부덮밥 - <input type="text" name="14num" maxlength="3" size="3" placeholder="1개"> </div>
				<div class="cupbobs"> <input type="checkbox" name="cupbobs" value="15" class="checks" id="ck15"/><label for="ck15"></label> 황태국밥 - <input type="text" name="15num"  maxlength="3" size="3" placeholder="1개"></div>
				<div class="cupbobs"> <input type="checkbox" name="cupbobs" value="16" class="checks" id="ck16"/><label for="ck16"></label> 순두부찌개국밥 - <input type="text" name="16num"  maxlength="3" size="3" placeholder="1개"></div>
				<div class="cupbobs"> <input type="checkbox" name="cupbobs" value="17" class="checks" id="ck17"/><label for="ck17"></label> 사골곰탕국밥 - <input type="text" name="17num" maxlength="3" size="3" placeholder="1개"></div>
				<div class="cupbobs"> <input type="checkbox" name="cupbobs" value="18" class="checks" id="ck18"/><label for="ck18"></label> 미역국밥 - <input type="text" name="18num" maxlength="3" size="3" placeholder="1개"></div>
				</div>
			</div>
			<div id="insert_bt" type="submit" onclick="checkThecheckbox();">컵밥등록</div>
			</form>
			</div>
		</div>
</body>
</html>