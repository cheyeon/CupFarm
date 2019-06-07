package cf.member.model;

public class JoinService {
	private JoinDAO jdao;
	private static JoinService instance = new JoinService();
	private  JoinService() {
		jdao = new JoinDAO();
	}
	public static JoinService getInstance() {
		return instance;
	}
	
	
	public void joinS(MemDTO jdto) {
		jdao.join( jdto);
	}
}
