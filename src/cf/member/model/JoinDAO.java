package cf.member.model;

import java.sql.*;
import java.util.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import javax.swing.text.BoxView;


public class JoinDAO {
	private DataSource ds;
	JoinDAO(){
		try {
			Context initContext = new InitialContext();
			Context envContext  = (Context)initContext.lookup("java:/comp/env");
			ds = (DataSource)envContext.lookup("jdbc/myoracle");	
		}catch(NamingException ne) {	
		}
	}
	
	void join(MemDTO jdto){
		Connection con=null;
		PreparedStatement pstmt= null;
		PreparedStatement pstmt2= null;
		
		String id = jdto.getM_id();
		String name = jdto.getM_name();
		String pwd = jdto.getM_pwd();
		String phone = jdto.getM_phone();
		System.out.println(phone);
		
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(MemSQL.sqlI);
			pstmt.setString(1, id);
			pstmt.setString(2, name);
			pstmt.setString(3, pwd);
			pstmt.setString(4, phone);
			pstmt.executeUpdate();
			
			pstmt2 = con.prepareStatement(MemSQL.sqlIG);
			pstmt2.setString(1, id);
			pstmt2.executeUpdate();
		}catch(SQLException se) {
			System.out.println(se+"에러발생 join");
			
		}finally {
			try {
				if(pstmt2!=null) pstmt2.close();
				if(pstmt!=null) pstmt.close();
				if(con!=null) con.close();
			}catch(SQLException se) {}
		}
	}

}
