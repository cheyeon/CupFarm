package cf.member.model;


class LoginSQL {
	//�α���������������
	static final String sqlS = "select * from MEMBER where M_ID=?";
	
	//�α������� ������Ʈ
	static final String sqlL = "update MEMBER set M_LDATE=sysdate where M_ID=?";
}
