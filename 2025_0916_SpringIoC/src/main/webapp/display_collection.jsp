<%@page import="java.util.Properties"%>
<%@page import="myutil.MyProp"%>
<%@page import="java.awt.RenderingHints.Key"%>
<%@page import="java.util.Map"%>
<%@page import="myutil.MyMap"%>
<%@page import="java.util.Set"%>
<%@page import="myutil.MySet"%>
<%@page import="java.util.List"%>
<%@page import="myutil.MyList"%>
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@page import="org.springframework.web.context.WebApplicationContext"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
	WebApplicationContext wac
	= WebApplicationContextUtils.getWebApplicationContext(application);
	
	MyList 	myList = wac.getBean("myListBean",MyList.class);
	List<String> 	fruit_list = myList.getList();
	
	MySet mySet =wac.getBean("mySetBean",MySet.class);
	Set<String> sido_set = mySet.getSet();
	
	MyMap myMap = wac.getBean("myMapBean",MyMap.class);
	Map<String,String> map= myMap.getMap();
	
	MyProp myProp = wac.getBean("myPropBean",MyProp.class);
	Properties prop = myProp.getProp();
	
	
	pageContext.setAttribute("fruit_list", fruit_list);
	pageContext.setAttribute("sido_set", sido_set);
	pageContext.setAttribute("map", map);
	pageContext.setAttribute("prop", prop);
%>


<hr>
	<h4>MyList's list</h4>
<hr>
	<ul>
		<!--for (String fruit :fruit_list)  -->
		<c:forEach var="fruit" items="${fruit_list}">
		<li>${fruit }</li>		
		</c:forEach>	
	</ul>
<hr>
	<h4>MySet's map</h4>
<hr>
	<ul>
	<c:forEach var="sido" items="${sido_set }">
		<li>${sido}</li>
	</c:forEach>
</ul>
<hr>
	<h4>MyMap's set </h4>
<hr>
	<ul>
		<c:forEach var="entry" items="${map}">
			<li>[${entry.key }]의 수도는[${entry.value }]</li>
		</c:forEach>
	</ul>
<hr>
	<h4>MyProp's prop</h4>
	<ul>
		<c:forEach var="entry" items="${prop}">
			<li> [${entry.key }]는 한글로 [${entry.value }]</li>
		</c:forEach>
	</ul>
	
	
	
	
	
	
	
	
	