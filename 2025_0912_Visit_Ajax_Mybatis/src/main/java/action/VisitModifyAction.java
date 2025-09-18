package action;

import java.io.IOException;

import dao.VisitDao;
import db.vo.VisitVo;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class VisitModifyAction
 */
@WebServlet("/visit/modify_action.do")
public class VisitModifyAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		//dispatcher(forward)
		String forward_page = "";
		RequestDispatcher disp = request.getRequestDispatcher(forward_page);
		disp.forward(request, response);
		
		//1.수신 인코딩 설정
		request.setCharacterEncoding("utf-8");
		
		//2.parameter 받기
		int		idx 	= Integer.parseInt(request.getParameter("idx"));
		String 	name 	= request.getParameter("name");
		String 	content = request.getParameter("content").replace("\n", "<br>");
		String 	pwd		= request.getParameter("pwd");
		
		//3.ip받기
		String	ip		= request.getRemoteAddr();

		
		//4.VisitVo로 포장
		VisitVo vo	= new VisitVo(idx, name, content, pwd, ip);
		
		//5.DB update 
		int res = VisitDao.getInstance().update(vo);
		
		//6.메인화면(목록보기)
		response.sendRedirect("list.do");
		
		
		
				
		
		
		
		
		
		
		

	}

	private void VisitVo(int idx, String name, String content, String pwd, String ip) {
		// TODO Auto-generated method stub
		
	}

}