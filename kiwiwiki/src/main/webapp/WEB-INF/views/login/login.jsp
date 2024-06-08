<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<title>KIWI🥝WIKI - Login</title>
<link rel="stylesheet" href="/resources/css/common.css">
<link rel="stylesheet" href="/resources/css/login.css">
</head>
<body>
	<div style="margin: 0 auto; width: 600px;">
		<div class="form-content row-flex">
			<form id="loginForm" class="col-flex test-line" action="login">
				<div class="form-input id border-radius-up">
					<input id="id" type="text" placeholder="아이디">
				</div>
				<div class="form-input pw">
					<input id="pw" type="password" placeholder="비밀번호">
				</div>
			</form>
			<form id="registerForm" class="col-flex test-line" action="login">
				<div class="form-input id border-radius-up">
					<input id="id" type="text" placeholder="아이디">
				</div>
				<div class="form-input nick">
					<input id="nick" type="text" placeholder="닉네임">
				</div>
				<div class="form-input pw">
					<input id="pw" type="password" placeholder="비밀번호">
				</div>
				<div class="form-input re-pw border-radius-down">
					<input id="re-pw" type="password" placeholder="비밀번호 확인">
				</div>
				<div class="form-input email border-radius-up">
					<input id="email" type="text" placeholder="이메일">
					<div style="padding: 0 10px 0 10px;">@</div>
					<input id="email2" type="text">
				</div>
				<div class="form-input tel">
					<input id="tel" type="tel" placeholder="연락처">
				</div>
				<div class="form-input addr border-radius-down">
					<input id="addr" type="text" placeholder="주소">
				</div>
			</form>
		</div>
	</div>
</body>
</html>