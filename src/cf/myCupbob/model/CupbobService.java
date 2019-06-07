package cf.myCupbob.model;

import java.util.ArrayList;

public class CupbobService {
	private CupbobDAO dao;
	private static CupbobService instance = new CupbobService();
	private CupbobService() {
		dao = new CupbobDAO();
	}
	
	public static CupbobService getInstance() {
		return instance;
	}
	
	//¸®½ºÆ®°¡Á®¿À±â
	public ArrayList<McbDTO> cupbobListS(String id){
		return dao.cupbobList(id);
	}
	
	//ÄÅ¹ä¸Ô±â
	public void eatCupbobS(int idx) {
		dao.eatCupbob(idx);
	}
}
