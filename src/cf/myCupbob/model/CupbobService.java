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
	
	//ÄÅ¹ä¾È¸ÔÀº°Å Ä«¿îÆ®
	public int countS(String id) {
		return dao.cupbobCount(id);
	}

	//ÄÅ¹ä¸ÔÀº°Å Ä«¿îÆ®
	public int countDS(String id) {
		return dao.cupbobCountD(id);
	}
		
	//ÄÅ¹äµî·Ï
	public void insertCupbobS(String id, int cupbob) {
		String cupbobName = null;
		if(cupbob == 1) {
			cupbobName = "ººÀº±èÄ¡µ¤¹ä";
		}else if(cupbob == 2) {
			cupbobName = "¿ÀÂ¡¾îµ¤¹ä";
		}else if(cupbob == 3) {
			cupbobName = "ºÒ´ßµ¤¹ä";
		}else if(cupbob == 4) {
			cupbobName = "°íÃßÀåÁ¦À°µ¤¹ä";
		}else if(cupbob == 5) {
			cupbobName = "À°°³Àå±¹¹ä";
		}else if(cupbob == 6) {
			cupbobName = "ºÒ°í±âµ¤¹ä";
		}else if(cupbob == 7) {
			cupbobName = "ºÎ´ëÂî°³±¹¹ä";
		}else if(cupbob == 8) {
			cupbobName = "Äá³ª¹°±¹¹ä";
		}else if(cupbob == 9) {
			cupbobName = "¿»·Î¿ìÅ©¸²Ä¿¸®µ¤¹ä";
		}else if(cupbob == 10) {
			cupbobName = "·¹µå½ºÆÄÀÌ½ÃÄ¿¸®µ¤¹ä";
		}else if(cupbob == 11) {
			cupbobName = "Á÷È­ººÀ½Â¥Àåµ¤¹ä";
		}else if(cupbob == 12) {
			cupbobName = "°íÃßÀå³ª¹°ºñºö¹ä";
		}else if(cupbob == 13) {
			cupbobName = "°­µÈÀåº¸¸®ºñºö¹ä";
		}else if(cupbob == 14) {
			cupbobName = "ÁßÈ­¸¶ÆÄµÎºÎµ¤¹ä";
		}else if(cupbob == 15) {
			cupbobName = "È²ÅÂ±¹¹ä";
		}else if(cupbob == 16) {
			cupbobName = "¼øµÎºÎÂî°³±¹¹ä";
		}else if(cupbob == 17) {
			cupbobName = "»ç°ñ°õÅÁ±¹¹ä";
		}else if(cupbob == 18) {
			cupbobName = "¹Ì¿ª±¹¹ä";
		}
		
		dao.insertCupbob(id, cupbobName);
	}
	
	//ÄÅ¹ä¸Ô±â
	public void eatCupbobS(int idx) {
		dao.eatCupbob(idx);
	}
}
