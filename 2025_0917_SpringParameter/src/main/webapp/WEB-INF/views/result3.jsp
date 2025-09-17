<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<hr>
  <h5>Map으로 받기 결과</h5>
<hr>
이름 : ${ requestScope.map.name } <br>
나이 : ${ map.age } <br>
전화 : ${ map['tel'] } <br>

<br>
<a href="input_param.html">다시하기</a>
</body>
</html>