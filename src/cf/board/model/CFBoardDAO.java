package cf.board.model;

import java.sql.*;
import java.util.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import javax.swing.text.BoxView;

public class CFBoardDAO {
	private DataSource ds;
	CFBoardDAO(){
		try {
			Context initContext = new InitialContext();
			Context envContext  = (Context)initContext.lookup("java:/comp/env");
			ds = (DataSource)envContext.lookup("jdbc/myoracle");	
		}catch(NamingException ne) {	
		}
	}
	
	
	ArrayList<CFBoardDTO> select(){
	ArrayList<CFBoardDTO> list = new ArrayList<CFBoardDTO>();
	return list;
	}
	

}
