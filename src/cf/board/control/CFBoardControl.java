package cf.board.control;

import java.io.IOException;
import java.math.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import java.util.*;

import cf.board.model.CFBoardDTO;
import cf.board.model.CFBoardService;
import cf.member.model.MemDTO;


@WebServlet("/board.do")
public class CFBoardControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String m = request.getParameter("m");
		System.out.println("m값들옴"+m);
	
		
	
		
		if(m !=null) {
			
			m.trim();
			if(m.equals("tradelist")) {
				tradelist(request, response);
		
			}else if(m.equals("salelist")){
				
			}else if(m.equals("tlistseach")) {
				seachbox(request, response);
			}
			else if(m.equals("tinputform")){
				tinputform(request,response);
				
			}else if(m.equals("tinput")) {
				tinput(request,response);
				
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
		String Strps = request.getParameter("ps");       //ps = 쪽수
		String Strcp = request.getParameter("cp");			// cp = 페이지당 컨텐츠수
		int consu = 0;								//consu= 총게시물수
		CFBoardService service = CFBoardService.getInstance();
		consu = service.consuS();
		ArrayList<CFBoardDTO> tlist = service.tradelistS(Strcp,Strps);
		
		int cp = Integer.parseInt(Strcp);
		
		int pagesu = (int) Math.ceil((double)consu/cp);
		System.out.println("총게시물수 : "+consu+"페이지당 게시물수 : "+cp+"그러면페이지수가어? : "+pagesu );
		request.setAttribute("pagesu", pagesu);
		request.setAttribute("list", tlist);
		RequestDispatcher rd = request.getRequestDispatcher("4_Trade/tradeList.jsp");
		rd.forward(request, response);
	}
	
	
	private void seachbox(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		String tseachval = request.getParameter("tseachval");
		CFBoardService service = CFBoardService.getInstance();
		ArrayList<CFBoardDTO> tslist = service.tseachS(tseachval);
		request.setAttribute("pagesu", 1);
		request.setAttribute("list", tslist);
		RequestDispatcher rd = request.getRequestDispatcher("4_Trade/tradeList.jsp");
		rd.forward(request, response);
		
	}
	private void tinputform(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		
		RequestDispatcher rd = request.getRequestDispatcher("4_Trade/tinForm.jsp");
		rd.forward(request, response);
	
	}
	
	private void tinput(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{	
		CFBoardService service = CFBoardService.getInstance();	
		
	
		
		
		
		
		HttpSession session=request.getSession();
		MemDTO mdto = (MemDTO)session.getAttribute("loginSession");
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		String Strpwd = request.getParameter("pwd");
		int pwd = Integer.parseInt(Strpwd);
		String id= mdto.getM_id();
		CFBoardDTO cfdto = new CFBoardDTO(-1, "T", subject, id, content, 1, 1, pwd, null);
		service.tinputS(cfdto);
		RequestDispatcher rd = request.getRequestDispatcher("./board.do?m=tradelist&cp=10&ps=1");
		rd.forward(request, response);
		
	
		
		
	}
	
	
	
}
