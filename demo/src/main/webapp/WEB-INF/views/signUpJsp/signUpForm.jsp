<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link rel="stylesheet" href="/static/css/signUpCss/signUp.css">
</head>
<script src="/static/js/singUpJs/signUp.js"></script>

<body>
	<div class="signUpFormContainer">
		<h2>회원가입</h2>
		<form action="/signUp" method="POST">

			<div class="form-group">
				<label for="user_email">이메일</label>
				<div class="input-wrap">
					<input type="text" id="user_email" name="user_email"
						placeholder="example@email.com" required>
					<div id="emailError" class="error-message"></div>
				</div>
			</div>

			<div class="form-group">
				<label for="user_name">이름</label> <input type="text" id="user_name"
					name="user_name" required>
			</div>

			<div class="form-group">
				<label for="user_password">비밀번호</label>
				<div class="input-wrap">
					<input type="password" id="user_password" name="user_password"
						placeholder="영문+숫자+특수문자, 8자 이상" required>
					<div id="passwordError" class="error-message"></div>
				</div>
			</div>

			<div class="form-group">
				<label for="user_age">나이</label> <input type="text" id="user_age" name="user_age"
					required>
			</div>

			<div class="form-group">
				<label for="user_gender">성별</label>
				<div class="gender-options">
					<label><input type="radio" name="user_gender" value="남자">
						남자 </label> <label><input type="radio" name="user_gender" value="여자">
						여자 </label>
				</div>
			</div>

			<button type="submit" class="submit-btn">가입하기</button>

		</form>

	</div>

</body>
</html>