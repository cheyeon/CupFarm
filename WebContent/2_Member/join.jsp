<%@ page language="java" contentType="text/html; charset=utf-8" import="java.util.*,cf.member.model.MemDTO"%>
<meta charset="utf-8">
  <!doctype html>

 <head>
  <meta charset="UTF-8">
  <center>
  <title> Join us </title>

 <body>
 <jsp:include page="../0_HFooter/header.jsp"></jsp:include>

 <form name="write_form_member" method="post" action="../join.do?m=join">
   <table width="940" style="padding:5px 0 5px 0; ">
      <tr height="2" bgcolor="#FFC8C3"><td colspan="2"></td></tr>
       <tr>
         <th>아이디</th>
         <td>
         <input type="text" name="m_id">
         </td>
       </tr>
  
      <tr>
         <th> 이름</th>
         <td><input type="text" name="m_name"></td>
      </tr>
  
       <tr>
         <th>비밀번호</th>
         <td><input type="password" name="m_pwd"></td>
       </tr>
               <tr>
          <th>핸드폰 번호</th>
           <td><input type="text"name="ph1"> -
               <input type="text" name="ph2"> -
               <input type="text" name="ph3">
           </td>
          </tr>

 
           <tr height="2" bgcolor="#FFC8C3"><td colspan="2"></td></tr>
           <tr>
             <td colspan="2" align="center">
               <input type="submit" value="회원가입">
               <input type="reset" value="취소">
            </td>
           </tr>
           </table>
          </td>
          </tr>
          </form>
          </center>
 </body>
</html>
 

  