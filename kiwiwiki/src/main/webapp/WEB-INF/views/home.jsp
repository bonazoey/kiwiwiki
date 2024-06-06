<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
	<title>KIWI🥝WIKI</title>
</head>
<%@ include file="include/header.jsp" %>
<style>
	.search {
		align-items: center;
		height: 85%;
	}
	form {
		display: flex;
		justify-content: center;
		padding: 0 0 100px 0;
		width: 100%;
	}
	.search-box img {
		width: 25px;	
		transition: 0.2s;
	}
	
	.search-box img:hover {
		width: 25px;
		transform: scale(1.2);
		transform: rotate(360deg);
		cursor: pointer;
	}
	
	.search-box input {
		border: none;
		outline: none;
	}
	
</style>
<body>
	<div class="col-flex search">
		<img alt="/resources/img/no-img.png" src="/resources/img/main-img.png" width="400">
		<form id="searchfrm" action="board">
			<div class="search-box">
				<input style="width: 440px;" type="text">
				<img alt="" src="/resources/img/kiwi.png">
			</div>
		</form>
	</div>
</body>
<%@ include file="include/footer.jsp" %>
</html>