package cf.member.model;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import java.sql.*;
import cf.member.model.MemDTO;
import cf.member.model.LoginSQL;

class LoginDAO {
	//커넥션풀
	private DataSource ds;
	LoginDAO(){
		try {
			Context initContext = new InitialContext();
			Context envContext  = (Context)initContext.lookup("java:/comp/env");
			ds = (DataSource)envContext.lookup("jdbc/myoracle");	
		}catch(NamingException ne) {	
		}
	}
	
	//로그인
	MemDTO login(String id) {
	   Connection con = null;
	   PreparedStatement pstmt = null;
	   ResultSet rs = null;
	   String sql = LoginSQL.sqlS;
	   
	   try {
		   con = ds.getConnection();
		   pstmt = con.prepareStatement(sql);
		   pstmt.setString(1, id);
		   rs = pstmt.executeQuery();
		   
		   if(rs.next()) {
			   String m_id = rs.getString(1);
			   String m_name = rs.getString(2);
			   String m_pwd = rs.getString(3);
			   String m_phone = rs.getString(4);
			   Date m_ldate = rs.getDate(5);
			   Date m_mdate = rs.getDate(6);
			   
				MemDTO dto = new MemDTO(m_id, m_name, m_pwd, m_phone, m_ldate, m_mdate);
				return dto;
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
	
	//로그인날짜 업데이트
	void updateLogin(String m_id) {
		   Connection con = null;
		   PreparedStatement pstmt = null;
		   String sql = LoginSQL.sqlL;
		   
		   try {
			   con = ds.getConnection();
			   pstmt = con.prepareStatement(sql);
			   pstmt.setString(1, m_id);
			   pstmt.executeUpdate();
		   }catch(SQLException se) {
		   }finally {
			   try {
				   if(pstmt != null) pstmt.close();
				   if(con != null) con.close();
			   }catch(SQLException se) {
			   }
		   }		   
		
	}
}
