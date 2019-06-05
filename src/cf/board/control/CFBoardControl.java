package cf.board.control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

import cf.board.model.CFBoardDTO;
import cf.board.model.CFBoardService;


@WebServlet("/board.do")
public class CFBoardControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String m = request.getParameter("m");
		System.out.println("m°ªµé¿È"+m);
	
		
		if(m !=null) {
			
			m.trim();
			if(m.equals("tradelist")) {
				tradelist(request, response);
		
			}else if(m.equals("salelist")){
				
			}else {}
			
			
			
			
		}else {
			//
			nulllist(request, response);
		}
		
	}
	private void nulllist(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
				
	} 
	
	private void tradelist(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		String ps = request.getParameter("ps");
		String cp = request.getParameter("cp");
		CFBoardService service = CFBoardService.getInstance();
		ArrayList<CFBoardDTO> tlist = service.tradelistS(cp,ps);
		for(CFBoardDTO dto: tlist) {
			System.out.println(dto.getB_content()+"ddddddddddddddddddddd");
			
		}
		
		request.setAttribute("list", tlist);
		RequestDispatcher rd = request.getRequestDispatcher("4_Trade/tradeList.jsp");
		rd.forward(request, response);
	}
}
