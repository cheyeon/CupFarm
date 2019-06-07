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
	
	//����Ʈ��������
	public ArrayList<McbDTO> cupbobListS(String id){
		return dao.cupbobList(id);
	}
	
	//�Ź�Ա�
	public void eatCupbobS(int idx) {
		dao.eatCupbob(idx);
	}
}
