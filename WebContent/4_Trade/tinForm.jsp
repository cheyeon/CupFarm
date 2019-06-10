<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8" import="java.util.*,cf.board.model.CFBoardDTO,cf.myCupbob.model.McbDTO"%>


 <html>
<head>
<title>CFBoard input</title>


</head>
<body>
      <center>
	  <hr width="600" color="Maroon" size="2" noshade>
		<font size="5" color="Navy"><b>글 쓰 기</b></font>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		
		<hr width="600" color="Maroon" size="2" noshade>
		<!-------------------- re 변화 1 ------------------------------->
		<form name="input" action="./board.do?m=tinput" method="post">
			<!-------------------------------------------------------------->
			<!-- <input type="hidden"  name="method" value="writeOk"> -->
			<table align="center" width="600" cellspacing="1" cellpadding="3"
				border="1">
				<tr>
					<td align="center" width="20%">제목</td>
					<td align="center" width="80%"><input type="text"
						name="subject" size="60"></td>
				</tr>
				<tr>
					<td align="center" width="20%">내용</td>
					<td align="center" width="80%"><textarea name="content"
							rows="10" cols="60"></textarea></td>
				</tr>
				<tr>
					<td align="center" width="20%">패스워드</td>
					<td align="center" width="80%"><input type="text" name="pwd"
						size="4" maxlength="4" onKeyup="this.value=this.value.replace(/[^0-9]/g,'');">숫자4자리
					<select name="select_cp">
					<option value="">교환할 컵밥을 선택해주세요</option>
<%
		ArrayList<McbDTO> mycupList = (ArrayList<McbDTO>)request.getAttribute("mycupList");
		for(McbDTO mcbdto : mycupList){
%>					
					<option value="<%=mcbdto.getC_idx()%>"> ::<%=mcbdto.getG_name() %>:: <%=mcbdto.getC_name() %></option>											
						
							
																		
<%
		}
%>	
						
					</select>	
						
					
					
					</td>
						
				</tr>
						<tr>
					<td align="center" colspan="2"><input type="button"
						value="전송하기" onclick="submit()"> <input type="reset"
						value="다시쓰기" ></td>
				</tr>
				
			</table>
		</form>
		<hr width="600" color="Maroon" size="2" noshade>
	</center>
  </body>
</html>
