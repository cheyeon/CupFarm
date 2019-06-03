package cf.member.model;


import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.*;
import cf.member.model.MemDTO;
import cf.member.model.LoginSQL;

class LoginDAO {
	private DataSource ds;
	LoginDAO(){
		try {
			Context initContext = new InitialContext();
			Context envContext  = (Context)initContext.lookup("java:/comp/env");
			ds = (DataSource)envContext.lookup("jdbc/myoracle");	
		}catch(NamingException ne) {	
		}
	}	
	MemDTO getMember(String id) {
	   Connection con = null;
	   PreparedStatement pstmt = null;
	   ResultSet rs = null;
	   String sql = LoginSQL.SQL1;
	   try {
		   con = ds.getConnection();
		   pstmt = con.prepareStatement(sql);
		   pstmt.setString(3, id);
		   rs = pstmt.executeQuery();
		   if(rs.next()) {
			    int no = rs.getInt(1);
			    String name = rs.getString(1); 
				String pwd = rs.getString(4);
				String phone =rs.getString(5);
				Date joindate = rs.getDate(6);
				
				return new MemDTO(no, name, id, pwd, phone, joindate);
		   }else {
			   return null;
		   }
	   }catch(SQLException se) {
		   return null;
	   }finally {
		   try {
			   if(rs != null) rs.close();
			   if(pstmt != null) pstmt.close();
			   if(con != null) con.close();
		   }catch(SQLException se) {
		   }
	   }
	}
}
