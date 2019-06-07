package cf.myCupbob.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import cf.myCupbob.sql.McbSQL;

public class CupbobDAO {
	//Ä¿³Ø¼ÇÇ®
	private DataSource ds;
	CupbobDAO(){
		try {
			Context initContext = new InitialContext();
			Context envContext  = (Context)initContext.lookup("java:/comp/env");
			ds = (DataSource)envContext.lookup("jdbc/myoracle");	
		}catch(NamingException ne) {	
		}
	}
	
	//ÄÅ¹ä¸®½ºÆ® ³ëÃâ
	ArrayList<McbDTO> cupbobList(String id) {		
		   ArrayList<McbDTO> list = new ArrayList<McbDTO>();
		   Connection con = null;
		   PreparedStatement pstmt = null;
		   ResultSet rs = null;
		   String sql = McbSQL.sqlS;
		   
		   try {
			   con = ds.getConnection();
			   pstmt = con.prepareStatement(sql);
			   pstmt.setString(1, id);
			   rs =  pstmt.executeQuery();
			   
			   while(rs.next()) {
					int c_idx = rs.getInt(1);
					String c_name = rs.getString(2);
					String g_name = rs.getString(3);
					Date c_cdate  = rs.getDate(4);
					Date c_ddate = rs.getDate(5);
					int c_state = rs.getInt(6);
					
					McbDTO dto = new McbDTO(c_idx, c_name, g_name, c_cdate, c_ddate, c_state);
					list.add(dto);
			   }
			   return list;
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
	
	//ÄÅ¹ä¸Ô±â
	void eatCupbob(int idx) {
		   Connection con = null;
		   PreparedStatement pstmt = null;
		   String sql = McbSQL.sqlU;
		   
		   try {
			   con = ds.getConnection();
			   pstmt = con.prepareStatement(sql);
			   pstmt.setInt(1, idx);
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
