package cf.board.model;

import java.sql.*;
import java.util.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import javax.swing.text.BoxView;




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
		rs = stmt.executeQuery("select * from BOARD order by b_idx desc");
		for(int i =0;i<cp*(ps-1);i++) {
			rs.next();
		}
	
		
		for(int i=0;i<cp;i++){
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
			
			CFBoardDTO dto = new CFBoardDTO(b_idx, b_head, b_title, m_id, b_content, c_idx, b_ox, b_ox, b_wdate);
		
			if(b_head.equals("T")) {
				System.out.println(b_idx+ b_head+ b_title+ m_id+ b_content+ c_idx+ b_ox+ b_ox+ b_wdate);
			tlist.add(dto);
			}else {
				
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
	

}
