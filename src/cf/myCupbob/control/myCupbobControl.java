package cf.myCupbob.control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cf.myCupbob.model.CupbobService;
import cf.myCupbob.model.McbDTO;

@WebServlet("/my.do")
public class myCupbobControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String m = request.getParameter("m");
		
		if(m != null){
			m = m.trim();
			switch(m) {
			 case "cb_list" : myCupBobList(request, response); break;
			 case "eat" : eatCupbob(request, response); break;
			 case "insert_cb" : insert_cb(request, response); break;
			 case "rate_cb" : rate_cb(request, response); break;
			 default : myCupBob(request, response);
			}
		}else {
			myCupBob(request, response);
		}
	}
	
	//ÄÅ¹äÃ³¹¬
	protected void eatCupbob(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		String idxS = request.getParameter("idx");
		if(idxS!=null) {
			int idx = Integer.parseInt(idxS);
			CupbobService service = CupbobService.getInstance();
			service.eatCupbobS(idx);
		}else {	}
	}
	
	//ÄÅ¹äÈ­¸é
	protected void myCupBob(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		RequestDispatcher rd = request.getRequestDispatcher("2_Member/myCupbob.jsp");
		rd.forward(request, response);
	}

	//ÄÅ¹äµî·ÏÈ­¸é
	protected void insert_cb(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		RequestDispatcher rd = request.getRequestDispatcher("2_Member/insert_Cupbob.jsp");
		rd.forward(request, response);
	}

	//ÄÅ¹äÅë°èÈ­¸é
	protected void rate_cb(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		RequestDispatcher rd = request.getRequestDispatcher("2_Member/rate_Cupbob.jsp");
		rd.forward(request, response);
	}
	
	//ÄÅ¹ä¸®½ºÆ® Ãâ·Â
	protected void myCupBobList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		String id = request.getParameter("id");
		CupbobService service = CupbobService.getInstance();
		ArrayList<McbDTO> list = service.cupbobListS(id);
		request.setAttribute("list", list);
		
		RequestDispatcher rd = request.getRequestDispatcher("2_Member/myCupbob.jsp");
		rd.forward(request, response);
	}
}
