package cf.board.model;

public class CFBoardService {
	
	private CFBoardDAO dao;
	private static CFBoardService instance = new CFBoardService();
	
	private CFBoardService() {
		dao = new CFBoardDAO();
	}
	public static CFBoardService getInstance() {
		return instance;
	}

}
