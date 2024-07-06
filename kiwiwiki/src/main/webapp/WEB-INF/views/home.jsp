<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<title>KIWI🥝WIKI</title>
<link rel="stylesheet" href="/resources/css/home.css">
</head>
<body>
	<div>
		<%@ include file="include/header.jsp"%>
		<div class="col-flex search">
			<img alt="/resources/img/no-img.png" src="/resources/img/main-img.png"
				width="400">
			<form id="searchfrm" action="getSearchList">
				<div class="search-box">
					<input name="keyword" style="width: 440px;" type="text"> <img
						alt="" src="/resources/img/kiwi.png" onclick="submit()">
				</div>
			</form>
			<div class="row-flex list-container">
				<c:set var="url" value="getBoard" />
				<div class="test-line list-div">
					<div class="list-title">인기 자료</div>
					<div>
						<c:forEach var="item" items="${hotList}">
							<c:url var="encodedURL" value="${url}">
								<c:param name="title" value="${item}" />
							</c:url>
							<div class="list-content">
								<a href="${encodedURL}">${item}</a>
							</div>
						</c:forEach>
					</div>
				</div>
				<div class="test-line list-div">
					<div class="list-title">최신 자료</div>
					<div>
						<c:forEach var="item" items="${recentList}">
							<c:url var="encodedURL" value="${url}">
								<c:param name="title" value="${item}" />
							</c:url>
							<div class="list-content">
								<a href="${encodedURL}">${item}</a>
							</div>
						</c:forEach>
					</div>
				</div>
				<div class="test-line list-div">
					<div class="list-title">랜덤 자료</div>
					<div>
						<c:forEach var="item" items="${randomList}">
							<c:url var="encodedURL" value="${url}">
								<c:param name="title" value="${item}" />
							</c:url>
							<div class="list-content">
								<a href="${encodedURL}">${item}</a>
							</div>
						</c:forEach>
					</div>
				</div>
			</div>
		</div>
		<%@ include file="include/footer.jsp"%>
	</div>
</body>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js" integrity="sha512-894YE6QWD5I59HgZOGReFYm4dnWc1Qt5NtvYSaNcOP+u1T9qYdvdihz0PPSiiqn/+/3e7Jo4EaG7TubfWGUrMQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script> 
<script type="text/javascript"></script>
</html>