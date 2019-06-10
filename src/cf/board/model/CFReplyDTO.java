package cf.board.model;

import java.sql.Date;


public class CFReplyDTO {
	private int R_idx;
	private String M_id;
	private String R_content;
	private int R_check;
	private Date R_date;
	private int B_idx;
	public CFReplyDTO(int r_idx, String m_id, String r_content, int r_check, Date r_date, int b_idx) {
		super();
		R_idx = r_idx;
		M_id = m_id;
		R_content = r_content;
		R_check = r_check;
		R_date = r_date;
		B_idx = b_idx;
	}
	public int getR_idx() {
		return R_idx;
	}
	public void setR_idx(int r_idx) {
		R_idx = r_idx;
	}
	public String getM_id() {
		return M_id;
	}
	public void setM_id(String m_id) {
		M_id = m_id;
	}
	public String getR_content() {
		return R_content;
	}
	public void setR_content(String r_content) {
		R_content = r_content;
	}
	public int getR_check() {
		return R_check;
	}
	public void setR_check(int r_check) {
		R_check = r_check;
	}
	public Date getR_date() {
		return R_date;
	}
	public void setR_date(Date r_date) {
		R_date = r_date;
	}
	public int getB_idx() {
		return B_idx;
	}
	public void setB_idx(int b_idx) {
		B_idx = b_idx;
	}
	
}