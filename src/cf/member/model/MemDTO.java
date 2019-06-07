package cf.member.model;

import java.sql.Date;


public class MemDTO {

	
	private String name;
	private String id;
	private String pwd;
	private String phone;
	private Date ldate;
	private Date mdate;
	
	public MemDTO( String name, String id, String pwd, String phone, Date ldate, Date mdate) {
		super();
		this.name = name;
		this.id = id;
		this.pwd = pwd;
		this.phone = phone;
		this.ldate = ldate;
		this.mdate = mdate;
	}



	public String getName() {
		return name;
	}

	public String getId() {
		return id;
	}

	public String getPwd() {
		return pwd;
	}

	public String getPhone() {
		return phone;
	}

	public Date getldate() {
		return ldate;
	}
	public Date getmdate() {
		return mdate;
	}


	public void setName(String name) {
		this.name = name;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setldate(Date ldate) {
		this.ldate = ldate;
	}
	
	public void setmdate(Date mdate) {
		this.mdate = mdate;
	}
	
	
	
}
