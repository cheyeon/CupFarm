package cf.board.model;
import cf.member.model.MemDTO;
import cf.myCupbob.model.CupbobDTO;
import cf.myCupbob.model.McbDTO;

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
	public int consuS() {
		return cfdao.consu();
		
	}
	public ArrayList<CFBoardDTO> tseachS(String tseachval){
		return  cfdao.tseach(tseachval);
	
	}
	public void tinputS(CFBoardDTO dto) {
		cfdao.tinput(dto);
		
	}
	
	public ArrayList<McbDTO> mycupS(String id){
		
		return cfdao.mycup(id);
	}
	public CFBoardDTO tconS(String idx) {
		
		return cfdao.tcon(idx);
	}
	public void replyinS(CFReplyDTO rdto) {
		cfdao.replyin(rdto);
		
	}
	public ArrayList<CFReplyDTO> replyS(String b_idx){
		return cfdao.reply(b_idx);
		
	}
	public ArrayList<CupbobDTO> cuplistS(){
		return cfdao.cuplist();
	}
	
	public ArrayList<CupbobDTO> tseachcS(String tseachval){
		return cfdao.tseachc(tseachval);
	}
	public void reselS(String b_idx, String r_idx) {
		cfdao.resel(b_idx, r_idx);
		
	}
	public String cnameS(String b_idx) {
		cfdao.cname(b_idx);
		return null;
	}
}
