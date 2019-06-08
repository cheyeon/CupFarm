package cf.board.model;

import java.sql.*;
import java.util.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import javax.swing.text.BoxView;
import cf.member.model.MemDTO;;




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
		System.out.println(ps+"pssss");
		
		int count = cp*(ps-1); //10*(7-1) = 60
		for(int i =0;i<count;i++) {
			rs.next();
		}

		for(int i=0;i<cp;){
		    
			if(rs.next()) {
				System.out.println("i: " + i);
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
					System.out.println(b_idx+ b_head+ b_title+ m_id+ b_content+ c_idx+ b_ox+ b_ox+ b_wdate);
					tlist.add(dto);
					i++;
					
					System.out.println(i+"i++++++++++++++++++++++++");
				
				
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
		System.out.println(consu+"consususususu");
		return consu;
	}
	
	
	ArrayList<CFBoardDTO> tseach(String tseachval){
		System.out.println("dao");
		ArrayList<CFBoardDTO> tslist = new ArrayList<CFBoardDTO>();
		Connection con = null;
		Statement stmt= null;
		ResultSet rs = null;
		try {
			System.out.println("dao1");
			System.out.println(tseachval);
			con = ds.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery("select * from board where (b_title like '%"+tseachval+"%' or m_id like '%"+tseachval+"%' or b_content like '%"+tseachval+"%')");
			while(rs.next()) {
				System.out.println("dao2");
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
		System.out.println("durlRKwlsemfdjdhsk?");
		Connection con = null;
		PreparedStatement pstmt= null;
		String subject = dto.getB_title();
		String id = dto.getM_id();
		String content = dto.getB_content();
		int pwd = dto.getB_pwd();
		System.out.println("sub : "+subject+"id : "+id+"con : "+content+"pwd : "+pwd);
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

}
