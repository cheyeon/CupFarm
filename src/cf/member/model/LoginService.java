package cf.member.model;

import java.util.Hashtable;

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
	public Object[] checkS(String id, String pwd) {
		Object[] obj = new Object[2];
		MemDTO dto = dao.getMember(id);
		obj[0] = dto;
		if(dto != null) {
			String dbPwd = dto.getPwd();
			if(dbPwd.equals(pwd)) {
				dto.setPwd("");
				obj[1] = new Integer(2);
			}else {
				dto.setPwd("");
				obj[1] = new Integer(1);
			}		
		}else {
			obj[1] = new Integer(0);
		}
		
		return obj;
	}
}
//id (X): 0
//pwd(X): 1
//success : 2
