package cf.board.control;

import java.io.IOException;
import java.math.*;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.*;

import cf.board.model.CFBoardDTO;
import cf.board.model.CFBoardService;
import cf.board.model.CFReplyDTO;
import cf.member.model.MemDTO;
import cf.myCupbob.model.McbDTO;


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
				
			}else if(m.equals("con")){
				tcon(request,response);
				
			}else if(m.equals("replyin")) {
				replyin(request, response);
				
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
		HttpSession session=request.getSession();
		CFBoardService service = CFBoardService.getInstance();	
		MemDTO mdto = (MemDTO)session.getAttribute("loginSession");
		String id= mdto.getM_id();
	

		ArrayList<McbDTO> mycupList = service.mycupS(id);
		
		request.setAttribute("mycupList", mycupList);
		for(McbDTO dto : mycupList) {
		
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("4_Trade/tinForm.jsp");
		rd.forward(request, response);
	
	}
	
	private void tinput(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		HttpSession session=request.getSession();
		CFBoardService service = CFBoardService.getInstance();			
		MemDTO mdto = (MemDTO)session.getAttribute("loginSession");
		String id= mdto.getM_id();	
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		String Strpwd = request.getParameter("pwd");
		int pwd = Integer.parseInt(Strpwd);
			
		CFBoardDTO cfdto = new CFBoardDTO(-1, "T", subject, id, content, 1, 1, pwd, null);
		service.tinputS(cfdto);
		RequestDispatcher rd = request.getRequestDispatcher("./board.do?m=tradelist&cp=10&ps=1");
		rd.forward(request, response);
	
	}
	private void tcon(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		String idx = request.getParameter("idx");
		CFBoardService service = CFBoardService.getInstance();
		CFBoardDTO cdto = service.tconS(idx);
		ArrayList<CFReplyDTO> relist = service.replyS(idx);
		
		request.setAttribute("tcon", cdto);
		RequestDispatcher rd = request.getRequestDispatcher("4_Trade/tContentform.jsp");
		rd.forward(request, response);
	}
	private void replyin(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		String r_content = request.getParameter("content");
		String Stridx = request.getParameter("b_idx");	
		int b_idx = Integer.parseInt(Stridx);
		HttpSession session=request.getSession();
		MemDTO mdto = (MemDTO)session.getAttribute("loginSession");
		String id= mdto.getM_id();
		CFBoardService service = CFBoardService.getInstance();
		CFReplyDTO rdto = new CFReplyDTO(-1, id, r_content, 0, null ,  b_idx);
		service.replyinS(rdto);
		RequestDispatcher rd = request.getRequestDispatcher("./board.do?m=tradelist&cp=10&ps=1");
		rd.forward(request, response);
		
	}
	
	
	
}
