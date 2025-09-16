<%@page import="vo.PersonVo"%>
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@page import="org.springframework.web.context.WebApplicationContext"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
 
 <%
 	//Spring생성한 bean을 관리하는 객체
 	//JSP내장객체 : request session application out pageContext...
 	WebApplicationContext wac
 					= WebApplicationContextUtils.getWebApplicationContext(application);
 
 	PersonVo p1=(PersonVo)wac.getBean("p1");
 	PersonVo p2 = wac.getBean("p2",PersonVo.class);
 	PersonVo p3 = wac.getBean("p3",PersonVo.class);
 	
 	pageContext.setAttribute("p1", p1);
 	pageContext.setAttribute("p2", p2);
 	pageContext.setAttribute("p3", p3);
 
 %>
	
	<hr>
		<h5>Use Ioc : p1's info</h5>
	<hr>
	이름 : ${p1.name }<br>
	나이 : ${p1.age }<br>
	전화 : ${p1.tel }<br>
	<hr>
		<h5>Use Ioc : p1's info</h5>
	<hr>
	이름 : ${p2.name }<br>
	나이 : ${p2.age }<br>
	전화 : ${p2.tel }<br>
	<hr>
		<h5>Use Ioc : p1's info</h5>
	<hr>
	이름 : ${p3.name }<br>
	나이 : ${p3.age }<br>
	전화 : ${p3.tel }<br>
	<hr>
		