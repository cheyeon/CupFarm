package cf.board.model;

import java.util.*;


public class CFBoardService {
	private CFBoardDAO cfdao;
	

	private static CFBoardService instance = new CFBoardService();
	
	private CFBoardService() {
		cfdao = new CFBoardDAO();
	}
	public static CFBoardService getInstance() {
		return instance;
	}

	public ArrayList<CFBoardDTO> tradelistS(String cp, String ps){
		return cfdao.tradelist(cp,ps);
		
		
	
	}
	
}
