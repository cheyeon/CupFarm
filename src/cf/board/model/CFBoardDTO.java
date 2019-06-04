package cf.board.model;
import java.util.*;


public class CFBoardDTO {
	private int b_idx;
	private String b_head;
	private String b_title;
	private String m_id;
	private String b_content;
	private int c_idx;
	private int b_ox;
	private int b_pwd;
	private Date b_wdate;

	public CFBoardDTO() {}

	public CFBoardDTO(int b_idx, String b_head, String b_title, String m_id, String b_content, int c_idx, int b_ox,
			int b_pwd, Date b_wdate) {
		super();
		this.b_idx = b_idx;
		this.b_head = b_head;
		this.b_title = b_title;
		this.m_id = m_id;
		this.b_content = b_content;
		this.c_idx = c_idx;
		this.b_ox = b_ox;
		this.b_pwd = b_pwd;
		this.b_wdate = b_wdate;
	}

	public int getB_idx() {
		return b_idx;
	}

	public void setB_idx(int b_idx) {
		this.b_idx = b_idx;
	}

	public String getB_head() {
		return b_head;
	}

	public void setB_head(String b_head) {
		this.b_head = b_head;
	}

	public String getB_title() {
		return b_title;
	}

	public void setB_title(String b_title) {
		this.b_title = b_title;
	}

	public String getM_id() {
		return m_id;
	}

	public void setM_id(String m_id) {
		this.m_id = m_id;
	}

	public String getB_content() {
		return b_content;
	}

	public void setB_content(String b_content) {
		this.b_content = b_content;
	}

	public int getC_idx() {
		return c_idx;
	}

	public void setC_idx(int c_idx) {
		this.c_idx = c_idx;
	}

	public int getB_ox() {
		return b_ox;
	}

	public void setB_ox(int b_ox) {
		this.b_ox = b_ox;
	}

	public int getB_pwd() {
		return b_pwd;
	}

	public void setB_pwd(int b_pwd) {
		this.b_pwd = b_pwd;
	}

	public Date getB_wdate() {
		return b_wdate;
	}

	public void setB_wdate(Date b_wdate) {
		this.b_wdate = b_wdate;
	}

}
