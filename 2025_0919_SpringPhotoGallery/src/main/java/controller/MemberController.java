package controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import dao.MemberDao;
import vo.MemberVo;

@Controller
public class MemberController {

	@Autowired
	MemberDao member_dao;
	
	@Autowired
	HttpSession session;
	
	@Autowired
	HttpServletRequest request;
	
	
	public MemberController() {
		// TODO Auto-generated constructor stub
		System.out.println("--MemberController()--");
	}
	
	//조회
	@RequestMapping("/member/list.do")
	public String list(Model model) {
		
		//회원목록 가져오기
		List<MemberVo> list = member_dao.selectList();
		
		//결과적으로... request binding
		model.addAttribute("list", list);
		
		return "member/member_list";
	}
	
	//로그인 폼 띄우기
	@RequestMapping("/member/login_form.do")
	public String login_form() {
		
		return "member/member_login_form";
	}
	
	
	// 로그인
	// /member/login.do?mem_id=hong&mem_pwd=123456
	@RequestMapping("/member/login.do")
	public String login(String mem_id,String mem_pwd,RedirectAttributes ra) {
		
		//mem_id에 해당되는 객체정보 얻어오기
		MemberVo user = member_dao.selectOne(mem_id);
		
		//아이디가 틀린경우
		if(user==null) {
			
			//response.sendRedirect("login_form.do?reason=fail_id");
            // RedirectAttributes에 값을 넣으면 DS가 그값을 query(parameter)로 사용한다
			ra.addAttribute("reason", "fail_id");
		    return "redirect:login_form.do";
		}
		
		//비밀번호가 틀린경우
		if(user.getMem_pwd().equals(mem_pwd)==false) {
			
			//response.sendRedirect("login_form.do?reason=fail_pwd&mem_id=" + mem_id);
			ra.addAttribute("reason", "fail_pwd");
			ra.addAttribute("mem_id", mem_id);
			
		    return "redirect:login_form.do";
		}
		
		//정상로그인 되었을 경우 세션에 로그인 정보 넣는다
		session.setAttribute("user", user);
		
		return "redirect:list.do";
	}
	
	//로그아웃
	@RequestMapping("/member/logout.do")
	public String logout() {
		
		session.removeAttribute("user");
		
		return "redirect:list.do";
	}
	
	//회원가입폼
	@RequestMapping("/member/insert_form.do")
	public String insert_form() {
		
		return "member/member_insert_form";
	}
	
	
	//중복아이디 체크
    //	 /member/check_id.do?mem_id=one
	@RequestMapping("/member/check_id.do")
	@ResponseBody
	public Map<String,Boolean> check_id(String mem_id) {
		
		MemberVo vo = member_dao.selectOne(mem_id);
		
		Map<String, Boolean> map = new HashMap<String, Boolean>();
		if(vo==null) {
			map.put("result", true); // {"result":true}
		}else {
			map.put("result", false); // {"result":false}
		}
		
		return map;
	}
	
	
	// /member/insert.do?mem_name=홍길동&mem_id=hong&mem_pwd=1234&
	//                   mem_email=hong@githrd.com&mem_zipcode=08787&
	//                   mem_addr=서울 관악구 남부순환로 1820 7층
	
	//등록하기
	@RequestMapping("/member/insert.do")
	public String insert(MemberVo vo) {
		
		
		String mem_ip = request.getRemoteAddr();
		vo.setMem_ip(mem_ip);
		
		int res = member_dao.insert(vo);
		
		
		
		return "redirect:list.do";
	}
	
	
	//삭제
	@RequestMapping("/member/delete.do")
	public String delete(int mem_idx) {
		
		int res = member_dao.delete(mem_idx);
		
		return "redirect:list.do";
	}
	
	
	//수정 폼 띄우기
	
	// /modify_form.do?mem_idx=21
	@RequestMapping("/member/modify_form.do")
	public String modify_form(int mem_idx,Model model) {
		
		MemberVo vo = member_dao.selectOne(mem_idx);
		
		model.addAttribute("vo",vo);

		return"member/member_modify_form";
	}
	
	//수정버튼
	@RequestMapping("/member/modify.do")
	public String modify(MemberVo vo) {
		
		String mem_ip = request.getRemoteAddr();
		vo.setMem_ip(mem_ip);
		member_dao.update(vo);
				
		return "redirect:list.do";
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
