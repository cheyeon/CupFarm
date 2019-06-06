package cf.member.model;


class LoginSQL {
	//로그인정보가져오기
	static final String sqlS = "select * from MEMBER where M_ID=?";
	
	//로그인정보 업데이트
	static final String sqlL = "update MEMBER set M_LDATE=sysdate where M_ID=?";
}
