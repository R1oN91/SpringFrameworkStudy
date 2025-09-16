<%@page import="vo.PersonVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	

	//1.생성자 Constructor
	PersonVo p1 = new PersonVo("일길동",20,"010-111-1234");

	//2.기본생성자 + setter
	PersonVo p2= new PersonVo();
	p2.setName("이길동");
	p2.setAge(30);
	p2.setTel("010-222-1234");

	//3.EL사용하려고
	pageContext.setAttribute("p1",p1);
	pageContext.setAttribute("p2",p2);
	
	
	%>
	
	<hr>
		<h5>p1's info</h5>
	<hr>
	이름 : ${p1.name }<br>
	나이 : ${p1.age }<br>
	전화 : ${p1.tel }<br>
	<hr>
		<h5>p1's info</h5>
	<hr>
	이름 : ${p2.name }<br>
	나이 : ${p2.age }<br>
	전화 : ${p2.tel }<br>
		
	
	
	
	