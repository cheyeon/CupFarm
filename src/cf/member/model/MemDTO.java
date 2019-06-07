package cf.member.model;

import java.sql.Date;


public class MemDTO {
	 private String m_id;
	 private String m_name;
	 private String m_pwd;
	 private String m_phone;
	 private Date m_ldate;
	 private Date m_mdate;
	 
	public MemDTO(String m_id, String m_name, String m_pwd, String m_phone, Date m_ldate, Date m_mdate) {
		super();
		this.m_id = m_id;
		this.m_name = m_name;
		this.m_pwd = m_pwd;
		this.m_phone = m_phone;
		this.m_ldate = m_ldate;
		this.m_mdate = m_mdate;
	}

	public void setM_id(String m_id) {
		this.m_id = m_id;
	}

	public void setM_name(String m_name) {
		this.m_name = m_name;
	}

	public void setM_pwd(String m_pwd) {
		this.m_pwd = m_pwd;
	}

	public void setM_phone(String m_phone) {
		this.m_phone = m_phone;
	}

	public void setM_ldate(Date m_ldate) {
		this.m_ldate = m_ldate;
	}

	public void setM_mdate(Date m_mdate) {
		this.m_mdate = m_mdate;
	}

	public String getM_id() {
		return m_id;
	}

	public String getM_name() {
		return m_name;
	}

	public String getM_pwd() {
		return m_pwd;
	}

	public String getM_phone() {
		return m_phone;
	}

	public Date getM_ldate() {
		return m_ldate;
	}

	public Date getM_mdate() {
		return m_mdate;
	}
}
