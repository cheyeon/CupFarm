package cf.member.model;

import cf.member.model.MemDTO;

public class LoginService {
	private LoginDAO dao;
	private static LoginService instance = new LoginService();
	private LoginService() {
		dao = new LoginDAO();
	}
	public static LoginService getInstance() {
		return instance;
	}
	
	//�α���
	public Object[] loginS(String login_id, String login_pwd) {
		Object[] obj = new Object[2];
		
		//ȸ��������������
		MemDTO dto = dao.login(login_id);
		
		if(dto != null) {
			obj[0] = dto;
			String pwd = dto.getM_pwd();
			
			//��й�ȣ Ȯ��
			if(pwd.equals(login_pwd)) {
				//�α��� ����
				obj[1] = new Integer(2);
				
				//�α������� ������Ʈ
				dao.updateLogin(login_id);
				
				//����������ȣ
				dto.setM_pwd("");
			}else {
				//Ʋ�� ��й�ȣ
				obj[1] = new Integer(1);
			}
		}else {
			//���� ���̵�
			obj[0] = null;
			obj[1] = new Integer(0);
		}

		//��� ��ȯ
		return obj;
	}
}
//id (X): 0
//pwd(X): 1
//success : 2
