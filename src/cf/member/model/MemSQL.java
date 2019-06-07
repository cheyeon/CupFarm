package cf.member.model;

class MemSQL {

	static final String sqlS = "select * from MEMBER order by m_id desc";
	static final String sqlI = "insert into MEMBER values( ?, ?, ?, ?, ?, SYSDATE)";	//sysdate 수정해야함 
	static final String sqlD = "delete from  MEMBER where M_ID=?";
	static final String sqlU = "update MEMBER set m_name=?, m_pwd=?, m_phone=?, where M_ID=? ";

}
