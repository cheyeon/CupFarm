package cf.myCupbob.sql;

public class McbSQL {
	//�����Ź丮��Ʈ ��������(�ȸ�����)
	public final static String sqlS = "select c.c_idx, c.c_name, g.g_name, c.c_cdate, c.c_ddate, c.c_state"
										 + " from cupbob c, grmem gr, member m, grouplist g"
										 + " where c.gm_idx=gr.gm_idx and g.g_idx=gr.g_idx and m.m_id=gr.m_id"
										 + " and m.m_id=?";
	//�Ź�Ա�
	public final static String sqlU = "update CUPBOB set C_STATE=0 where C_IDX=?";
}
