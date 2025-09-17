package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {
	@RequestMapping("/test.do")
	public String test(Model model) {
		
		//Data 생성/가공....
		
		String name = "홍길동";
		//model에 넣은 데이터는 DispatcherServlet전달
		//DS는 데이타를 request binding 시킨다. 
		model.addAttribute("name",name);
		
		return "test"; //ViewName : test
					   //DispatcherServlet -> ViewResolver에서 경로 완성
					   //					  /WEB-INF/views/test.jsp
					   //					  forward시킨다
	}
	
	@RequestMapping("/test2.do")
	public 	ModelAndView test2() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("name","박길동");	//data
		mv.setViewName("test2");		//view
		
		return mv;
	}
}
