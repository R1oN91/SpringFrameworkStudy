package action;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import dao.VisitDao;
import db.vo.VisitVo;

/**
 * Servlet implementation class VisitInsertAction
 */
@WebServlet("/visit/insert.do")
public class VisitInsertAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//parameter : 요청시 전달인자(name,content,pwd)
		// /visit/insert.do?name=홍길동&content=잘들어가나&pwd=1234
		
		//0.수신인코딩 설정
		request.setCharacterEncoding("utf-8");
		
		//1.parameter 받기
		String name = request.getParameter("name");
		//			  <textarea> : \r\n <div>:<br>
		//				입력				 출력
		//						\r\n -> <br>변환
		String content 	= request.getParameter("content").replaceAll("\n","<br>");
		String pwd 		= request.getParameter("pwd");
		
		//2. ip구하기
		String ip 		=request.getRemoteAddr();//전송자(client) IP
		
		//3.VisitVo포장
		VisitVo vo 		= new VisitVo(name, content,pwd,ip);
		
		//4.DB Insert
		int res 		=VisitDao.getInstance().insert(vo); 
		
		
		
		
		//Redirect : 목록보기로 재접속 정보를 응답
		response.sendRedirect("list.do");

		
	}

}