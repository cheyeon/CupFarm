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
	
	//�Ź�ȸ����� ī��Ʈ
	public int countS(String id) {
		return dao.cupbobCount(id);
	}

	//�Ź������ ī��Ʈ
	public int countDS(String id) {
		return dao.cupbobCountD(id);
	}
		
	//�Ź���
	public void insertCupbobS(String id, int cupbob) {
		String cupbobName = null;
		if(cupbob == 1) {
			cupbobName = "������ġ����";
		}else if(cupbob == 2) {
			cupbobName = "��¡���";
		}else if(cupbob == 3) {
			cupbobName = "�Ҵߵ���";
		}else if(cupbob == 4) {
			cupbobName = "��������������";
		}else if(cupbob == 5) {
			cupbobName = "�����屹��";
		}else if(cupbob == 6) {
			cupbobName = "�Ұ�ⵤ��";
		}else if(cupbob == 7) {
			cupbobName = "�δ������";
		}else if(cupbob == 8) {
			cupbobName = "�ᳪ������";
		}else if(cupbob == 9) {
			cupbobName = "���ο�ũ��Ŀ������";
		}else if(cupbob == 10) {
			cupbobName = "���彺���̽�Ŀ������";
		}else if(cupbob == 11) {
			cupbobName = "��ȭ����¥�嵤��";
		}else if(cupbob == 12) {
			cupbobName = "�����峪�������";
		}else if(cupbob == 13) {
			cupbobName = "�����庸�������";
		}else if(cupbob == 14) {
			cupbobName = "��ȭ���ĵκε���";
		}else if(cupbob == 15) {
			cupbobName = "Ȳ�±���";
		}else if(cupbob == 16) {
			cupbobName = "���κ������";
		}else if(cupbob == 17) {
			cupbobName = "����������";
		}else if(cupbob == 18) {
			cupbobName = "�̿�����";
		}
		
		dao.insertCupbob(id, cupbobName);
	}
	
	//�Ź�Ա�
	public void eatCupbobS(int idx) {
		dao.eatCupbob(idx);
	}
}
