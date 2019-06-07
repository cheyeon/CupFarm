package cf.myCupbob.model;

import java.sql.Date;

public class McbDTO {
	private int c_idx;
	private String c_name;
	private String g_name;
	private Date c_cdate;
	private Date c_ddate;
	private int c_state;
	
	public McbDTO(int c_idx, String c_name, String g_name, Date c_cdate, Date c_ddate, int c_state) {
		super();
		this.c_idx = c_idx;
		this.c_name = c_name;
		this.g_name = g_name;
		this.c_cdate = c_cdate;
		this.c_ddate = c_ddate;
		this.c_state = c_state;
	}

	public int getC_idx() {
		return c_idx;
	}

	public void setC_idx(int c_idx) {
		this.c_idx = c_idx;
	}

	public String getC_name() {
		return c_name;
	}

	public void setC_name(String c_name) {
		this.c_name = c_name;
	}

	public String getG_name() {
		return g_name;
	}

	public void setG_name(String g_name) {
		this.g_name = g_name;
	}

	public Date getC_cdate() {
		return c_cdate;
	}

	public void setC_cdate(Date c_cdate) {
		this.c_cdate = c_cdate;
	}

	public Date getC_ddate() {
		return c_ddate;
	}

	public void setC_ddate(Date c_ddate) {
		this.c_ddate = c_ddate;
	}

	public int getC_state() {
		return c_state;
	}

	public void setC_state(int c_state) {
		this.c_state = c_state;
	}
}
