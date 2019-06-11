package cf.myCupbob.sql;

public class McbSQL{
	//°³ÀÎÄÅ¹ä¸®½ºÆ® °¡Á®¿À±â
	public final static String sqlS = "select c.c_idx, c.c_name, g.g_name, c.c_cdate, c.c_ddate, c.c_state"
										 + " from cupbob c, grmem gr, member m, grouplist g"
										 + " where c.gm_idx=gr.gm_idx and g.g_idx=gr.g_idx and m.m_id=gr.m_id"
										 + " and m.m_id=? order by c_idx desc";
	
	//°³ÀÎÄÅ¹äÄ«¿îÆ®(¾È¸ÔÀº°Å)
	public final static String sqlC = "select count(c.c_idx)"
										 +	" from cupbob c, grmem gr, member m"
										 +	" where c.gm_idx=gr.gm_idx and m.m_id=gr.m_id"
										 +	" and m.m_id=? and c.c_state=1";
	
	//°³ÀÎÄÅ¹äÄ«¿îÆ®(¸ÔÀº°Å)
	public final static String sqlD = "select count(c.c_idx)"
										 +	" from cupbob c, grmem gr, member m"
										 +	" where c.gm_idx=gr.gm_idx and m.m_id=gr.m_id"
										 +	" and m.m_id=? and c.c_state=0";
	
	//ÄÅ¹ä¸Ô±â
	public final static String sqlU = "update CUPBOB set C_STATE=0 where C_IDX=?";
	
	//°³ÀÎÄÅ¹ä GM_IDX°¡Á®¿À±â
	public final static String sqlIDX = "select GM_IDX from GRMEM where M_ID=? and G_IDX=1";
	
	//ÄÅ¹äÃß°¡ÇÏ±â
	public final static String sqlI = "insert into CUPBOB values(CUPBOB_SEQ.nextval, ?, ?, 1, SYSDATE, NULL)";
}
