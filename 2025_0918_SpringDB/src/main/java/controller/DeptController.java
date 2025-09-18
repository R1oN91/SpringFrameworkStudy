package controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.DeptDao;
import vo.DeptVo;

@Controller
public class DeptController {
	
	DeptDao dept_dao;

	//Constructor Injection 때문에 사용하게 됨. 
	public DeptController(DeptDao dept_dao) {
		super();
		this.dept_dao = dept_dao;
	}
	
	//전체조회하는 코드
	@RequestMapping("/dept/list.do")
	public String list(Model model) {
		
		List<DeptVo> list = dept_dao.selectList();
		
		//model->DS->request binding
		model.addAttribute("list",list);
		
		return"dept/dept_list";
		// /WEB-INF/views/+dept/dept_list+.jsp
		// /WEB-INF/views/dept/dept_list.jsp
	}

}
