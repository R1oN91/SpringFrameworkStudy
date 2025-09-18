package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController{

		
	public HomeController() {
		// TODO Auto-generated constructor stub
		System.out.println("--HomeController()--");
	}
	
	@RequestMapping("/home.do")
	@ResponseBody
	public String home(){
		
		
		return "home";
		
	}
	
	
}
