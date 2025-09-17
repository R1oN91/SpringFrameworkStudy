package controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import vo.PersonVo;

@Controller
public class ParamController {

	///insert1.do?name=박길동&age=30&tel=010-111-1234
	@RequestMapping("/insert1.do")
	public String insert1(@RequestParam(name="name",required = true) String irum,
			              int age,
			              String tel,
			              @RequestParam(name="gender", defaultValue = "남자" ) String gender,
			              Model model ) {
		// method의 인자(parameter)는 호출의 주체(DS)에 대한 요구사항
		
		System.out.printf("[%s]-[%d]-[%s]-[%s]\n", irum,age,tel,gender);
		
		//Model을 통해서 전달->DS
		//DS-> model data를 request binding
		model.addAttribute("name", irum);
		model.addAttribute("age", age);
		model.addAttribute("tel", tel);
		
		return "result1";
	}
	
	///insert2.do?name=박길동&age=30&tel=010-111-1234
	@RequestMapping("/insert2.do")
	public String insert2(PersonVo vo, Model model) {
		//         memthod(인자) -> DS에 대한 요구사항
		//         1.각각의 parameter받아서-> PersonVo객체로 포장해준다
		//         2.조건: parameter이름과 VO 속성명이 동일해야 한다
		
		//결과적으로 request binding
		model.addAttribute("vo", vo);
		
		return "result2";
	}
	
	// /insert3.do?name=박길동&age=30&tel=010-111-1234
	@RequestMapping("/insert3.do")
	public String insert3(@RequestParam Map map,Model model) {
		//				DS에 대한 요구사항 : parameter->Map으로 포장해줘
		//								 반드시 @	@RequestParam붙여야함. 
		System.out.println(map);
		
		model.addAttribute("map",map);
		
		return"result3";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
