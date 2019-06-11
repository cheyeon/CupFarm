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
import cf.myCupbob.model.CupbobDTO;
import cf.myCupbob.model.McbDTO;


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
				
			}else if(m.equals("resel")){
				resel(request, response);
			}else if(m.equals("trades")){
				trade(request, response);
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
		String Strps = request.getParameter("ps");       //ps = ÂÊ¼ö
		String Strcp = request.getParameter("cp");			// cp = ÆäÀÌÁö´ç ÄÁÅÙÃ÷¼ö
		int consu = 0;								//consu= ÃÑ°Ô½Ã¹°¼ö
		CFBoardService service = CFBoardService.getInstance();
		consu = service.consuS();
		ArrayList<CFBoardDTO> tlist = service.tradelistS(Strcp,Strps);
		int cp = Integer.parseInt(Strcp);
		int pagesu = (int) Math.ceil((double)consu/cp);
		
		ArrayList<CupbobDTO> clist = service.cuplistS();
		
		
		
		
		
		request.setAttribute("clist", clist);
		request.setAttribute("pagesu", pagesu);
		request.setAttribute("list", tlist);
		RequestDispatcher rd = request.getRequestDispatcher("4_Trade/tradeList.jsp");
		rd.forward(request, response);
	}
	
	
	private void seachbox(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		String tseachval = request.getParameter("tseachval");
		
		
		
		CFBoardService service = CFBoardService.getInstance();
		ArrayList<CupbobDTO> clist = service.tseachcS(tseachval);
		
	
		
		
		
		
		ArrayList<CFBoardDTO> tslist = service.tseachS(null);
		request.setAttribute("pagesu", 1);
		request.setAttribute("list", tslist);
		request.setAttribute("clist", clist);
		RequestDispatcher rd = request.getRequestDispatcher("4_Trade/seachList.jsp");
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
		String Strc_idx = request.getParameter("select_cp");
		int c_idx = Integer.parseInt(Strc_idx);
		
		int pwd = Integer.parseInt(Strpwd);
			
		CFBoardDTO cfdto = new CFBoardDTO(-1, "T", subject, id, content, c_idx, 1, pwd, null);
		service.tinputS(cfdto);
		RequestDispatcher rd = request.getRequestDispatcher("./board.do?m=tradelist&cp=10&ps=1");
		rd.forward(request, response);
	
	}
	private void tcon(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		String uid = "uid";
		
		if(request.getSession()!=null) {
		HttpSession session=request.getSession();
			if(session.getAttribute("loginSession")!=null) {
			MemDTO mdto = (MemDTO)session.getAttribute("loginSession");
				if(mdto.getM_id()!=null) {		
				uid= mdto.getM_id();	
				}else {
					
				}
			}else {
				
			}
		}
	
		
		String idx = request.getParameter("idx");
		CFBoardService service = CFBoardService.getInstance();
		CFBoardDTO cdto = service.tconS(idx);
		ArrayList<CFReplyDTO> relist = service.replyS(idx);
		request.setAttribute("relist", relist);
		request.setAttribute("uid", uid);
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
	
	public void resel(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		String b_idx = request.getParameter("b_idx");
		String r_idx = request.getParameter("taget");
		CFBoardService service = CFBoardService.getInstance();
		service.reselS(b_idx,r_idx);
		RequestDispatcher rd = request.getRequestDispatcher("./board.do?m=tradelist&cp=10&ps=1");
		rd.forward(request, response);
		
	}
	public void trade(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		String reid=request.getParameter("target");
		String boidx = request.getParameter("b_idx");
		String c_idx=request.getParameter("c_idx");
		String boid=request.getParameter("b_id");
		CFBoardService service = CFBoardService.getInstance();
		String cname = service.cnameS(boidx);
		
		
	}
	
	
}
