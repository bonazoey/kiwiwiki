<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<title>KIWI🥝WIKI - Login</title>
<link rel="stylesheet" href="/resources/css/common.css">
<link rel="stylesheet" href="/resources/css/login.css">
</head>
<body>
	<div id="title">로그인</div>
	<div style="margin: 0 auto; width: 600px;">
		<div class="form-content row-flex">
			<form id="loginForm" class="col-flex form" action="/login" method="post">
				<div class="form-input id">
					<input id="id" name="id" type="text" placeholder="아이디">
				</div>
				<div class="form-input pw">
					<input id="pw" name="pw" type="password" placeholder="비밀번호">
				</div>
				<small>${msg}</small>
				<div>
					<button type="submit">로그인</button>
				</div>
			</form>
			<form id="registerForm" class="col-flex form" action="/register" method="post">
				<div class="form-input id">
					<input id="id" type="text" placeholder="아이디">
				</div>
				<div class="form-input nick">
					<input id="nick" type="text" placeholder="닉네임">
				</div>
				<div class="form-input pw">
					<input id="pw" type="password" placeholder="비밀번호">
				</div>
				<div class="form-input re-pw">
					<input id="re-pw" type="password" placeholder="비밀번호 확인">
				</div>
				<div class="form-input email">
					<input id="email" type="text" placeholder="이메일">
					<div style="padding: 0 10px 0 10px;">@</div>
					<input id="email2" type="text">
				</div>
				<div class="form-input tel">
					<input id="tel" type="tel" placeholder="연락처">
				</div>
				<div class="form-input addr">
					<input id="addr" type="text" placeholder="주소">
				</div>
				<div>
					<button type="submit">회원가입</button>
				</div>
			</form>
		</div>
		<div id="formCover" class="form move-right col-flex">
			<p id="coverTitle">로그인</p>
			<p id="coverContent">지금 당장 접속하여 도파민을 과도하게 분비시키세요!</p>
		</div>	
	</div>
</body>
<script type="text/javascript">
	const cover = document.querySelector('#formCover');
	const title = document.querySelector('#coverTitle');
	const content = document.querySelector('#coverContent');

	cover.addEventListener('mouseenter', () => {
		if(cover.classList.contains('move-right')) {
			cover.classList.remove('move-right')
			title.textContent = '회원가입';
			content.textContent = '지금 당장 일원이 되어 exclusive한 혜택을 누리세요!';
		} else {
			cover.classList.add('move-right')
			title.textContent = '로그인';
			content.textContent = '지금 당장 접속하여 도파민을 과도하게 분비시키세요!';
		}
	})
</script>
</html>