package controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.print.DocFlavor.STRING;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import dao.VisitDao;
import vo.VisitVo;

@Controller
//@RequestMapping("/visit/")
public class VisitController {

	
	VisitDao visit_dao;
	
	@Autowired
	HttpServletRequest request;
	

	// Constructor Injection
	public VisitController(VisitDao visit_dao) {
		super();
		this.visit_dao = visit_dao;
	}
	
	//조회
	// /visit/list.do
	// /visit/list.do?search=name&search_text=길동
	
	@RequestMapping("/visit/list.do")
	public String list(@RequestParam(name="search",defaultValue = "all") String search,
			            String search_text,Model model) {
				System.out.println("list부분 통과");
		//검색정보(조건)를 담을 Map를 선언
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
		List<VisitVo> list = visit_dao.selectList(map);
				
		//결과적으로 request binding
		model.addAttribute("list", list);
				
		return "visit/visit_list";
	}
	
	
	//등록폼 띄우기
	@RequestMapping("/visit/insert_form.do")
	public String insert_form() {
		
		return "visit/visit_insert_form";
	}
	
	
	
	//등록하기
	// /visit/insert.do?name=홍길동&content=잘들어가나&pwd=1234
	@RequestMapping("/visit/insert.do")
	public String insert(VisitVo vo) {
		
		//작성자 IP구하기
		String ip = request.getRemoteAddr();
		vo.setIp(ip);
		
		//내용 : \n -> <br> 변경
		String content = vo.getContent().replaceAll("\n", "<br>");
		vo.setContent(content);
		
		//DB insert
		int res = visit_dao.insert(vo);
		
		// "redirect:list.do"->DS전달
		//  DS가 수행 :  response.sendRedirect("list.do");                   
		return "redirect:list.do";
	}
	
	//비밀번호체크
	// /visit/check_pwd.do?idx=5&c_pwd=1234
	@RequestMapping("/visit/check_pwd.do")
	@ResponseBody //현재반환되는 값을 결과값으로 직접 전송해달라 
	public Map<String, Boolean> vheck_pwd(int idx,String c_pwd) {
		//1.idx에 해당되는 게시물 1건 정보 얻어오기
		VisitVo vo = visit_dao.selectOne(idx);
		//3.비밀번호 비교
		boolean bResult = vo.getPwd().equals(c_pwd);
		
		Map<String, Boolean> map = new HashMap<String, Boolean>();
		map.put("result", bResult);
		//{"result" : true}
		
		return map;
	}
	
	//삭제
	///visit/delete.do?idx=14
	@RequestMapping("/visit/delete.do")
	public String delete(int idx) {
		
		int res= visit_dao.delete(idx);
		
		return "redirect:list.do";
	}
	
	
	//수정 폼
	
	///visit/modify_form.do?idx=13
	@RequestMapping("/visit/modify_form.do")
	public String modify_form(Model model, int idx) {
		System.out.println("수정폼 통과");
		 VisitVo vo = visit_dao.selectOne(idx);
		 String content = vo.getContent().replace("<br>","\n" );
		 vo.setContent(content);
		 
		 model.addAttribute("vo", vo);

		 
		return "visit/visit_modify_form";
	}
	
	
	
	//수정
	@RequestMapping("/visit/modify.do")
	public String modify(VisitVo vo) {
		
		String ip =  request.getRemoteAddr();
		vo.setIp(ip);
		visit_dao.update(vo);
		
//		System.out.println(vo.getIdx());
//		System.out.println(vo.getName());
//		System.out.println(vo.getPwd());
//		System.out.println(vo.getContent());
//		System.out.println(vo.getRegdate());
//		System.out.println(vo.getIp());
		
		
		return "redirect:list.do";
		//return "";
	}
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
