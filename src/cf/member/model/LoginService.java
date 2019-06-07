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
	
	//로그인
	public Object[] loginS(String login_id, String login_pwd) {
		Object[] obj = new Object[2];
		
		//회원정보가져오기
		MemDTO dto = dao.login(login_id);
		
		if(dto != null) {
			obj[0] = dto;
			String pwd = dto.getM_pwd();
			
			//비밀번호 확인
			if(pwd.equals(login_pwd)) {
				//로그인 성공
				obj[1] = new Integer(2);
				
				//로그인정보 업데이트
				dao.updateLogin(login_id);
				
				//개인정보보호
				dto.setM_pwd("");
			}else {
				//틀린 비밀번호
				obj[1] = new Integer(1);
			}
		}else {
			//없는 아이디
			obj[0] = null;
			obj[1] = new Integer(0);
		}

		//결과 반환
		return obj;
	}
}
//id (X): 0
//pwd(X): 1
//success : 2
