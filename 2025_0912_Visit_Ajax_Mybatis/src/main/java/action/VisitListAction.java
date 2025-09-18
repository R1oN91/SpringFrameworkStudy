package action;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.VisitDao;
import db.vo.VisitVo;

/**
 * Servlet implementation class VisitListAction
 */
@WebServlet("/visit/list.do")
public class VisitListAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		// /visit/list.do
		// /visit/list.do?search=name&search_text=길동
		
		//0.수신인코딩
		request.setCharacterEncoding("utf-8");
		
	    //1.parameter 받기
		String search	=	request.getParameter("search");
		if(search==null) search="all"; //아무것도 안들어오면 null
		String search_text = request.getParameter("search_text");
		
		//검색정보(조건)를 담을 Map을 선언
		Map<String, Object> map = new HashMap<String, Object>();
		
		if(search.equals("name_content")) {
			
			map.put("name", search_text);
			map.put("content", search_text);
		}else if(search.equals("name")) {
			
			map.put("name", search_text);
	
		}else if(search.equals("content")) {
		
			map.put("content", search_text);
		}		
		
		//방명록 목록가져오기
		List<VisitVo> list = VisitDao.getInstance().selectList(map);
				
		//request binding
		request.setAttribute("list", list);

		//dispatcher(forward)
		String forward_page = "visit_list.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(forward_page);
		disp.forward(request, response);

	}

}