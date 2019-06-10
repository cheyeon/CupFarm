package cf.board.model;

import java.sql.*;
import java.sql.Date;
import java.util.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import javax.swing.text.BoxView;
import cf.member.model.MemDTO;
import cf.myCupbob.model.McbDTO;
import cf.myCupbob.sql.McbSQL;;




class CFBoardDAO {
	private DataSource ds;
	CFBoardDAO(){
		try {
			Context initContext = new InitialContext();
			Context envContext  = (Context)initContext.lookup("java:/comp/env");
			ds = (DataSource)envContext.lookup("jdbc/myoracle");	
		}catch(NamingException ne) {	
		}
	}
	
	
	ArrayList<CFBoardDTO> tradelist(String ccp , String pps){
		int cp = Integer.parseInt(ccp);
		int ps = Integer.parseInt(pps);
	ArrayList<CFBoardDTO> tlist = new ArrayList<CFBoardDTO>();
	Connection con = null;
	Statement stmt= null;
	ResultSet rs = null;
	try {
		con = ds.getConnection();
		stmt = con.createStatement();
		rs = stmt.executeQuery("select * from board where b_head ='T' order by b_idx desc");
	
		
		int count = cp*(ps-1); //10*(7-1) = 60
		for(int i =0;i<count;i++) {
			rs.next();
		}

		for(int i=0;i<cp;){
		    
			if(rs.next()) {
			
				int b_idx = rs.getInt(1);
				String b_head = rs.getString(2);
				String b_title = rs.getString(3);
				String m_id = rs.getString(4);
				String b_content = rs.getString(5);
				int c_idx = rs.getInt(6);
				int b_ox = rs.getInt(7);
				int b_pwd = rs.getInt(8);
				java.sql.Date b_wdate = rs.getDate(9);
				CFBoardDTO dto = new CFBoardDTO(b_idx, b_head, b_title, m_id, b_content, c_idx, b_ox, b_ox, b_wdate);
				if(b_head.equals("T")) {					
					tlist.add(dto);
					i++;				
				}else {
				
				}	
			}
			else {
				break;	
							
			}
		}	
		
		return tlist;
	}catch(SQLException se) {
		return null;
	}finally {
		try {
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
			if(con != null) con.close();
		}catch(SQLException se) {}
		
	}
}
	
	int consu() {
		int consu=0;
		Connection con = null;
		Statement stmt= null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery("select * from BOARD order by b_idx desc");
			while(rs.next()) {
				String b_head = rs.getString(2);
				if(b_head.equals("T")) {
					consu = consu+1;
				}
			}		
		}catch(SQLException se) {
			
		}finally {
			try {
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(con != null) con.close();
			}catch(SQLException se) {}
		}
		
		return consu;
	}
	
	
	ArrayList<CFBoardDTO> tseach(String tseachval){
		System.out.println("dao");
		ArrayList<CFBoardDTO> tslist = new ArrayList<CFBoardDTO>();
		Connection con = null;
		Statement stmt= null;
		ResultSet rs = null;
		try {
		
			con = ds.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery("select * from board where (b_title like '%"+tseachval+"%' or m_id like '%"+tseachval+"%' or b_content like '%"+tseachval+"%')");
			while(rs.next()) {
			
				int b_idx = rs.getInt(1);
				String b_head = rs.getString(2);
				String b_title = rs.getString(3);
				String m_id = rs.getString(4);
				String b_content = rs.getString(5);
				int c_idx = rs.getInt(6);
				int b_ox = rs.getInt(7);
				int b_pwd = rs.getInt(8);
				java.sql.Date b_wdate = rs.getDate(9);
				
				CFBoardDTO dto = new CFBoardDTO(b_idx, b_head, b_title, m_id, b_content, c_idx, b_ox, b_ox, b_wdate);
				tslist.add(dto);
			
			}
		}catch(SQLException se){
			System.out.println("drrr"+se);
		}finally {
			try {
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(con != null) con.close();
			}catch(SQLException se) {}
		}
		
		
		
		return tslist;
	}
	
	void tinput(CFBoardDTO dto) {
		Connection con = null;
		PreparedStatement pstmt= null;
		String subject = dto.getB_title();
		String id = dto.getM_id();	
		String content = dto.getB_content();
		int pwd = dto.getB_pwd();
		try {
			con=ds.getConnection();
			pstmt = con.prepareStatement("INSERT INTO BOARD VALUES(BOARD_SEQ.NEXTVAL, 'T', ?, ?, ?, 2, 1, ?, SYSDATE)");
			pstmt.setString(1, subject);
			pstmt.setString(2, id);
			pstmt.setString(3, content);
			pstmt.setInt(4, pwd);
			pstmt.executeUpdate();
		}catch(SQLException se) {
			System.out.println("dao.tinput err : "+se);
		}finally {
			try {
				
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(SQLException se) {}
		}
		
		
	}
	
	ArrayList<McbDTO> mycup(String id){
		System.out.println("½ÇÇà?");
		  ArrayList<McbDTO> list = new ArrayList<McbDTO>();
		   Connection con = null;
		   PreparedStatement pstmt = null;
		   ResultSet rs = null;		   
		   try {
			   con = ds.getConnection();
			   pstmt = con.prepareStatement("select c.c_idx, c.c_name, g.g_name, c.c_cdate, c.c_ddate, c.c_state, m.m_name\r\n" + 
			   		"from cupbob c, grmem gr, member m, grouplist g\r\n" + 
			   		"where c.gm_idx=gr.gm_idx and g.g_idx=gr.g_idx and m.m_id=gr.m_id\r\n" + 
			   		"and m.m_id=? and c.c_state=1");
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
					System.out.println(c_idx+c_name+g_name+"dddddddddddddddddddddd");
					list.add(dto);
					
			   }
			   return list;
		   }catch(SQLException se) {
			   System.out.println("cfdao. mycup err"+se);
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
	
	
	CFBoardDTO tcon(String idx) {
		CFBoardDTO  cdto = null;
		 Connection con = null;
		 PreparedStatement pstmt = null;
		 ResultSet rs = null;
		try {
			 con = ds.getConnection();
			 pstmt = con.prepareStatement("select * from board where b_idx =?");
			 pstmt.setString(1, idx);
			 rs =  pstmt.executeQuery();
			 rs.next();
			 int b_idx = rs.getInt(1);
				String b_head = rs.getString(2);
				String b_title = rs.getString(3);
				String m_id = rs.getString(4);
				String b_content = rs.getString(5);
				int c_idx = rs.getInt(6);
				int b_ox = rs.getInt(7);
				int b_pwd = rs.getInt(8);
				java.sql.Date b_wdate = rs.getDate(9);
				
			cdto = new CFBoardDTO(b_idx, b_head, b_title, m_id, b_content, c_idx, b_ox, b_ox, b_wdate);
					
			 
		}catch(SQLException se) {
			System.out.println("cfdao tcon() err : "+se);
		}finally {
			   try {
				   if(rs != null) rs.close();
				   if(pstmt != null) pstmt.close();
				   if(con != null) con.close();
			   }catch(SQLException se) {
			   }			   
		   }
		return cdto;
	}
	
	
	void replyin(CFReplyDTO rdto) {
		Connection con = null;
		PreparedStatement pstmt= null;
		String m_id = rdto.getM_id();
		String r_content = rdto.getR_content();
		int r_check = rdto.getR_check();
		int b_idx= rdto.getB_idx();
		try {
			con=ds.getConnection();
			pstmt = con.prepareStatement("INSERT INTO REPLY VALUES(REPLY_SEQ.NEXTVAL, ?, ?, ?, SYSDATE, ?)");
			pstmt.setString(1, m_id);
			pstmt.setString(2, r_content);
			pstmt.setInt(3, r_check);
			pstmt.setInt(4, b_idx);
			pstmt.executeUpdate();			
		}catch(SQLException se) {
			System.out.println("cfdao. replyin err : "+ se);
		}finally {
			   try {
				   if(pstmt != null) pstmt.close();
				   if(con != null) con.close();
			   }catch(SQLException se) {
			   }			   
		   }
		
		
	}
}
