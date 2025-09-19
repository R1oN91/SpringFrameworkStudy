<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	width: 500px;
	margin: auto;
	margin-top: 100px;
}

textarea{
	resize: non;
	}
	
	th{
		vertical-align: middle ! important;
	
	}
	
</style>

<script type="text/javascript">
	function send(f) {
		let name	= f.name.value.trim();
		let pwd		=f.pwd.value.trim();
		
		if(name == ""){
			alter("이름을 입력하세요")
			t.name.value="";
			t.name.focus();
			
			return;
			
		}
		
		f.action = "modify.do" //MemberModifyAction
		
		if (pwd == ""){
			alter("비밀번호를 입력하세요")
			t.pwd.value = "";
			t.pwd.focus();
			
			return;
		}
		
		//수정확인
		if(confirm("정말수정하시겠습니까?")==false){
			
			//자신의 페이지를 다시 호출함. 
			location.href="";//이동페이지 정보를 생략하면 페이지를 다시 호출함
			
			return;
		}
		//전송대상
		f.action = "insert.do" // MemberInsertAction
		
		//전송
		f.submit();
	}//end:send()

</script>

</head>

<body>
<input type ="hidden" name="idx" value="${vo.idx }">

<div id="box">
	<div class="panel panel-primary">
		<div class="panel-heading">
			<h4>:::수정폼:::</h4>
		</div>
		<div class="panel-body">
			<table class="table">
				<tr>
				<th>아이디</th>
				<td><input class="form-control" name="name"
				value="${vo.name }"></td>
		</tr>
			
			<tr>
				<th></th>
			
			</tr>
			
			</table>
		
		</div>
	</div>




</div>

</body>
</html>