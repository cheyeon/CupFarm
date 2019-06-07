package cf.member.model;

class MemSQL {	
	static final String sqlI = "insert into MEMBER values( ?, ?, ?, ?, ?, SYSDATE)";
	static final String sqlD = "delete from MEMBER where M_ID=?";
	static final String sqlU = "update MEMBER set m_name=?, m_pwd=?, m_phone=?, where M_ID=? ";
}
