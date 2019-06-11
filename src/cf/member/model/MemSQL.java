package cf.member.model;

class MemSQL {	
	static final String sqlI = "insert into MEMBER values( ?, ?, ?, ?, NULL, SYSDATE)";
	static final String sqlIG = "insert into GRMEM values(GRMEM_SEQ.nextval, 1, ?, 'N', SYSDATE)";
	static final String sqlD = "delete from MEMBER where M_ID=?";
	static final String sqlU = "update MEMBER set m_name=?, m_pwd=?, m_phone=?, where M_ID=? ";
}
