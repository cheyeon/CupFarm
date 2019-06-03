package cf.member.model;

import java.sql.Date;

public class MemDTO {

	private int no;
	private String name;
	private String id;
	private String pwd;
	private String phone;
	private Date joindate;
	
	public MemDTO(int no, String name, String id, String pwd, String phone, Date joindate) {
		super();
		this.no = no;
		this.name = name;
		this.id = id;
		this.pwd = pwd;
		this.phone = phone;
		this.joindate = joindate;
	}

	public int getNo() {
		return no;
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

	public Date getJoindate() {
		return joindate;
	}

	public void setNo(int no) {
		this.no = no;
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

	public void setJoindate(Date joindate) {
		this.joindate = joindate;
	}
	
	
	
	
}
