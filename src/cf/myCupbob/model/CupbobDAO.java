package cf.myCupbob.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
	
	//ÄÅ¹äµî·Ï
	void insertCupbob(String id, String cupbob) {
	   Connection con = null;
	   PreparedStatement pstmtS = null;
	   PreparedStatement pstmtI = null;
	   ResultSet rs = null;
	   
	   try {
		   con = ds.getConnection();
		   pstmtS = con.prepareStatement(McbSQL.sqlIDX);
		   pstmtS.setString(1, id);
		   rs = pstmtS.executeQuery();
		  
		   rs.next();
		   int gm_idx = rs.getInt(1);
		   System.out.println("gm_idx:"+gm_idx);
		  
		   pstmtI = con.prepareStatement(McbSQL.sqlI);
		   pstmtI.setString(1, cupbob);
		   pstmtI.setInt(2, gm_idx);
		   pstmtI.executeUpdate();
	   }catch(SQLException se) {
		   
	   }finally {
		   try {
			   if(con!=null) con.close();
			   if(pstmtS!=null) pstmtS.close();
			   if(pstmtI!=null) pstmtI.close();
			   }catch(SQLException se) {
			   
		   }
	   }
	   
	   
	}
	
	//¾È¸ÔÀº ÄÅ¹äÄ«¿îÆ®
	int cupbobCount(String id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = McbSQL.sqlC;
		
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			rs.next();
			return rs.getInt(1);
		}catch(SQLException se) {
			return 0;
		}finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(con!=null) con.close();
			}catch(SQLException se) {}
		}
	}

	//¸ÔÀº ÄÅ¹äÄ«¿îÆ®
	//¾È¸ÔÀº ÄÅ¹äÄ«¿îÆ®
	int cupbobCountD(String id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = McbSQL.sqlD;
		
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			rs.next();
			return rs.getInt(1);
		}catch(SQLException se) {
			return 0;
		}finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(con!=null) con.close();
			}catch(SQLException se) {}
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
