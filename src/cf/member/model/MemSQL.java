package cf.member.model;

class MemSQL {

	static final String sqlS = "select * from MEMBER order by m_id desc";
	static final String sqlI = "insert into MEMBER values(MEMBER.nextval, ?, ?, ?, ?, ?, SYSDATE)";
	static final String sqlD = "delete from  MEMBER where no=?";
	static final String sqlU = "update MEMBER set m_id=?, m_name=?, m_pwd=?, m_phone=?, where no=? ";
}
