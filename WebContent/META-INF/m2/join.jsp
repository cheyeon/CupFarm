<%@ page language="java" contentType="text/html; charset=utf-8" import="java.util.*,jung.m2.model.BoardDTO"%>
<meta charset="utf-8">
  <!doctype html>

 <head>
  <meta charset="UTF-8">
 
  <title>♥회원 가입♥</title>
 </head>
 <body>
 <form name="write_form_member" method="post">
   <table width="940" style="padding:5px 0 5px 0; ">
      <tr height="2" bgcolor="#FFC8C3"><td colspan="2"></td></tr>
      <tr>
         <th> 이름</th>
         <td><input type="text" name="name"></td>
      </tr>
      <tr>
         <th>주민번</th>
         <td><input type="text" name="ssn"> - 
        <input type="password" name="ssn"></td>
       </tr>
       <tr>
         <th>아이디</th>
         <td>
         <input type="text" name="id">
         </td>
       </tr>
       <tr>
         <th>비밀번호</th>
         <td><input type="password" name="pwd"></td>
       </tr>
        <tr>
          <th>이메일</th>
          <td>
            <input type='text' name="email">@
            <input type='text' name="email_dns">
              <select name="emailaddr">
                 <option value="">직접입력</option>
                 <option value="daum.net">daum.net</option>
                 <option value="empal.com">empal.com</option>
                 <option value="gmail.com">gmail.com</option>
                 <option value="hanmail.net">hanmail.net</option>
                 <option value="msn.com">msn.com</option>
                 <option value="naver.com">naver.com</option>
                 <option value="nate.com">nate.com</option>
              </select>
            </td>
         </tr>
        <tr>
          <th>핸드폰 번호</th>
           <td><input type="text"name="phone1"> -
               <input type="text" name="phone2"> -
               <input type="text" name="phone3">
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
 </body>
</html>
 

  