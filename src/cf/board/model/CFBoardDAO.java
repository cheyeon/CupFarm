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
import cf.myCupbob.model.CupbobDTO;
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
			rs = stmt.executeQuery("select * from board order by b_idx desc");
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
		int c_idx = dto.getC_idx();
		int pwd = dto.getB_pwd();
		try {
			con=ds.getConnection();
			pstmt = con.prepareStatement("INSERT INTO BOARD VALUES(BOARD_SEQ.NEXTVAL, 'T', ?, ?, ?, ?, 1, ?, SYSDATE)");
			pstmt.setString(1, subject);
			pstmt.setString(2, id);
			pstmt.setString(3, content);
			pstmt.setInt(4, c_idx);
			pstmt.setInt(5, pwd);
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
				
			cdto = new CFBoardDTO(b_idx, b_head, b_title, m_id, b_content, c_idx, b_ox, b_pwd, b_wdate);
					
			 
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
	
	ArrayList<CFReplyDTO> reply(String idx){
		int b_idx = Integer.parseInt(idx);
		System.out.println("DDDDDDDDDDDDDDDDDDDDDDDDDDDDDSKFJLJLKFLKJFLKJF");
		ArrayList<CFReplyDTO> relist = new ArrayList<CFReplyDTO>(); 
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement("select * from reply where b_idx=? order by r_idx asc");
			pstmt.setString(1, idx);
			rs =  pstmt.executeQuery();
			while(rs.next()) {
				int r_idx = rs.getInt(1);
				String m_id = rs.getString(2);
				String r_content = rs.getString(3);
				int r_check = rs.getInt(4);
				java.sql.Date r_date = rs.getDate(5);
				
				CFReplyDTO dto = new CFReplyDTO(r_idx, m_id, r_content, r_check, r_date, b_idx);
				relist.add(dto);
			}			
		}catch(SQLException se) {
			System.out.println("dao.reply err : "+se);
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(SQLException se) {}
		}
		
		return relist;
	}
	
	
	ArrayList<CupbobDTO> cuplist(){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<CupbobDTO> culist= new ArrayList<CupbobDTO>();
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement("select * from cupbob");
			rs =  pstmt.executeQuery();
			while(rs.next()) {
				int c_idx = rs.getInt(1);
				String c_name = rs.getString(2);
				int gm_idx = rs.getInt(3);
				int c_state = rs.getInt(4);
				CupbobDTO dto = new CupbobDTO(c_idx, c_name, gm_idx, c_state, null, null);
				culist.add(dto);
			}
			
			
		}catch(SQLException se) {
			System.out.println("cfdao.cuplist err : "+se);
		}finally {
			   try {
				   if(pstmt != null) pstmt.close();
				   if(con != null) con.close();
			   }catch(SQLException se) {
			   }			   
		   }	
		
		return culist;
	}
	
	
	
	ArrayList<CupbobDTO> tseachc(String tseachval){
		
		ArrayList<CupbobDTO> tslist = new ArrayList<CupbobDTO>();
		Connection con = null;
		Statement stmt= null;
		ResultSet rs = null;
	
		try {
		
			con = ds.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery("select * from cupbob where c_name like '%"+tseachval+"%' order by c_idx desc");
			while(rs.next()) {
			
				int c_idx = rs.getInt(1);
				String c_name = rs.getString(2);
				int gm_idx = rs.getInt(3);
				int c_state = rs.getInt(4);
			
				
				
				CupbobDTO dto = new CupbobDTO(c_idx , c_name, gm_idx, c_state, null, null);
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
	
	
	void resel(String b_idx, String r_idx) {
		Connection con = null;
		PreparedStatement pstmt= null;	
		PreparedStatement pstmt1= null;	
		
		try {
			con=ds.getConnection();
			pstmt = con.prepareStatement("update board set b_pwd=0 where b_idx=?");
			pstmt.setString(1, b_idx);
			pstmt.executeUpdate();
			pstmt1 =con.prepareStatement("update reply set r_check=1 where r_idx=?");
			pstmt1.setString(1, r_idx);
			pstmt1.executeUpdate();
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
	
	String cname(String b_idx) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement("select b.b_idx, c.c_name from cupbob c, board b where b.c_idx=c.c_idx and b.b_idx=?");
			pstmt.setString(1, b_idx);
			rs =  pstmt.executeQuery();
			rs.next();
		}catch(SQLException se) {
			System.out.println("cfdao. replyin err : "+ se);
		}finally {
			   try {
				   if(pstmt != null) pstmt.close();
				   if(con != null) con.close();
			   }catch(SQLException se) {
			   }			   
		   }		
		
		
		return null;
		
	}
	
	
}
