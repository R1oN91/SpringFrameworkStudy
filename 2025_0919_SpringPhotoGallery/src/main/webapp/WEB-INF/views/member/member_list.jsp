<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
  <!-- JSTL Core : forEach, if, choose -->
  <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- Bootstrap3.x ver -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>


	<style type="text/css">
		#box{
			width: 1200px;
			margin: auto;
			margin-top: 30px;		
		}
		
		#title{
			text-align: center;
			font-size: 28px;
			font-weight: bold;
			color: rgb(51,122,183);
			
			text-shadow: 1px 1px 1px black;
			}
			
		.my-title{
			background: pink;
			color: purple;
			
			text-shadow: 1px 1px 1px black;
			
		}
		
		.btn-login{
		width: 80px;
		}
		
		td{
			vertical-align: middle !important;
		}
		
		
	</style>
	<script type="text/javascript">
	
	function del(mem_idx) {
		
		if(confirm( mem_idx + "번 회원정보를 정말 삭제하시겠습니까?")==false)return;
		
		//삭제처리
		location.href = "delete.do?mem_idx=" + mem_idx; //MemberDeleteAction
		
		//삭제 sql 명령
		// delete from member where mem_idx=3
		
	}
	
	</script>


</head>
<body>
	<div id ="box">
	
		<h1 id="title">:::회원목록:::</h1>
		
		<div style="margin-top: 50px; margin-bottom: 5px; text-align: right;" >
		
		<!-- 로그인이 안된 경우 -->
		<c:if test="${ empty sessionScope.user }"
			>
		<input class="btn btn-primary btn-login"  type="button" value="로그인"
		onclick="location.href='login_form.do'">
		<input class="btn btn-info btn-login" type="button" value="회원가입"
				onclick="location.href='insert_form.do'">
		</c:if>
		
		
		<!-- 로그인이 되있는 경우 
			session에 MemberVo user가 저장 
		 -->
		<c:if test="${not empty sessionScope.user }">
			<b>${user.mem_name }</b>님 환영합니다.
			<input class="btn btn-primary btn-login"  type="button" value="로그아웃"
			onclick="location.href='logout.do'"> 			
		</c:if>
		
		
		
		
		
		
		
			
		</div>
	<!-- 회원정보 출력 -->
	<table class= "table">
		<!--  -->
		<tr class="my-title">
			<th>회원정보</th>
			<th>회원명</th>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>이메일</th>
			<th>우편번호</th>
			<th>주소</th>
			<th>아이피</th>
			<th>가입일자</th>
			<th>회원구분</th>
			
			<!-- 관리자만 보여주는것 -->
			<c:if test="${user.mem_grade eq '관리자' }">
			<th>편집</th>
			</c:if>
			
			
		</tr>
		
		<!-- data -->
		
		<!-- 회원없는경우 -->
		<c:if test="${empty list}">
			 <tr>
		 		<td colspan="10"  align="center">
		 		<font color="red" size="3">등록된 회원이 없습니다</font>
		 		</td>
		 
		 	 </tr>
		 </c:if>
		 
		 <!-- for(MemberVo vo : list) 동일 -->
		 <c:forEach var="vo" items="${list}">
		 	<tr>
		 		<td>${ vo.mem_idx }</td>
		 		<td>${ vo.mem_name }</td>
		 		<td>${ vo.mem_id }</td>
		 		<td>${ vo.mem_pwd }</td>
		 		<td>${ vo.mem_email }</td>
		 		<td>${ vo.mem_zipcode }</td>
		 		<td>${ vo.mem_addr }</td>
		 		<td>${ vo.mem_ip }</td>
		 		<td>${ vo.mem_regdate }</td>
		 		<td>${ vo.mem_grade }</td>
		 		
		 		<!-- 관리자만 보여주는것 -->
			<c:if test="${user.mem_grade eq '관리자' }">
				<td>
				<input class="btn btn-info"	  type="button" value="수정"
					onclick="location.href='modify_form.do?mem_idx=${vo.mem_idx}'">
					
				<input class="btn btn-danger" type="button" value="삭제"
					onclick="del('${vo.mem_idx}');">
				</td>
			</c:if>
		 		
		 		
		 		
		 	</tr>
		 </c:forEach>
		
	</table>
	
	
	</div>	
</body>
</html>




