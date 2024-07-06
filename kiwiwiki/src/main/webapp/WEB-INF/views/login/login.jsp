<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<title>KIWI🥝WIKI - Login</title>
<link rel="stylesheet" href="/resources/css/common.css">
<link rel="stylesheet" href="/resources/css/login.css">
</head>
<body>
	<div id="form-container" class="col-flex">
		<div id="title">와구와구</div>
		<div id="form-box" class="form-content row-flex">
			<form id="loginForm" class="col-flex form" action="/login" method="post">
				<div class="form-input id">
					<input name="id" type="text" placeholder="아이디">
				</div>
				<div class="form-input pw">
					<input name="pw" type="password" placeholder="비밀번호">
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
				<div id="pwCheck">
				</div>
				<div class="form-input email">
					<input id="email" type="text" placeholder="이메일">
					<div style="padding: 0 10px 0 10px;">@</div>
					<input id="email2" type="text" placeholder="example.com">
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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
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
	$(document).ready(function() {
			$('#pw').on('input', function() {
					const regex = /^(?=.*[a-zA-Z\d])(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,12}$/;
					var pw = $('#pw').val();
					console.log('ddd');
					console.log(pw);
					if (!regex.test(pw)) {
						$('#pwCheck').text("8~16자의 영문 대/소문자, 숫자, 특수문자를 사용해 주세요.");
						$('#pwCheck').css('color', 'red');
					} else {
						$('#pwCheck').text("사용 가능한 비밀번호입니다.");
						$('#pwCheck').css('color', 'green');
					}
				}
			);
		}
	);
</script>
</html>