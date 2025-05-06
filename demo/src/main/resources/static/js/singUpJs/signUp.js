/**
 * 
 */
document.addEventListener('DOMContentLoaded', function() {
	const emailInput = document.getElementById('user_email');
	const passwordInput = document.getElementById('user_password');
	const emailError = document.getElementById('emailError');
	const passwordError = document.getElementById('passwordError');

	emailInput.addEventListener('input', function() {
		const emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
		if (!emailPattern.test(emailInput.value)) {
			emailError.textContent = '올바른 이메일 형식이 아닙니다.';
		} else {
			emailError.textContent = '';
		}
	});

	passwordInput.addEventListener('input', function() {
		const pw = passwordInput.value;
		const isValid = /[A-Za-z]/.test(pw) &&
			/[0-9]/.test(pw) &&
			/[!@#$%^&*(),.?":{}|<>]/.test(pw) &&
			pw.length >= 8;
		if (!isValid) {
			passwordError.textContent = '영문+숫자+특수문자, 8자 이상';
		} else {
			passwordError.textContent = '';
		}
	});
});
