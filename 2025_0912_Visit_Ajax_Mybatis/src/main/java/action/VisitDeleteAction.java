package action;
import java.io.IOException;

import dao.VisitDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class VisitDeleteAction
 */
@WebServlet("/visit/delete.do")
public class VisitDeleteAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		///visit/delete.do?idx=14
		
		//String str_idx 	= request.getParameter("idx");	//"14"
		//int		idx		=Integer.parseInt(str_idx); 	//"14" ->14		
		
		//1.삭제할 게시물 idx받기
		int idx  = Integer.parseInt(request.getParameter("idx"));
		
		//2.DB delete
		int res = VisitDao.getInstance().delete(idx);
		
		//3.작업 완료 후 메인으로 이동(목록보기)
		response.sendRedirect("list.do");
		
		
		
		

		

	}

}