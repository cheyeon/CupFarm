package cf.myCupbob.sql;

public class McbSQL{
	//°³ÀÎÄÅ¹ä¸®½ºÆ® °¡Á®¿À±â(¾È¸ÔÀº°Å)
	public final static String sqlS = "select c.c_idx, c.c_name, g.g_name, c.c_cdate, c.c_ddate, c.c_state"
										 + " from cupbob c, grmem gr, member m, grouplist g"
										 + " where c.gm_idx=gr.gm_idx and g.g_idx=gr.g_idx and m.m_id=gr.m_id"
										 + " and m.m_id=?";
	
	//°³ÀÎÄÅ¹äÄ«¿îÆ®(¾È¸ÔÀº°Å)
	public final static String sqlC = "select count(c.c_idx)"
										 +	" from cupbob c, grmem gr, member m"
										 +	" where c.gm_idx=gr.gm_idx and m.m_id=gr.m_id"
										 +	" and m.m_id=? and c.c_state=1";
	
	//ÄÅ¹ä¸Ô±â
	public final static String sqlU = "update CUPBOB set C_STATE=0 where C_IDX=?";
}
