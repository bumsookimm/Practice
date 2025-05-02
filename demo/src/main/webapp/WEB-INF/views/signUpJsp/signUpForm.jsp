<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="signUpFormContainer" >
		<h2>회원가입</h2>
		<form action="/signUp" method="POST">
			<label for="username">이름:</label>
			<input type="text" id="username" name="username" required> <br>
			
			<label for="password">비밀번호:</label>
			<input type="password" id="password" name="password" required> <br>
			
			<button type="submit">가입하기</button>
		
		</form>
	
	</div>

</body>
</html>