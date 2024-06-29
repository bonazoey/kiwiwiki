<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
<title>검색한 리스트래요</title>
</head>
<%@ include file="../include/header.jsp"%>
<body>
	<c:choose>
		<c:when test="${empty searchList}">
			<div>검색한 자료가 존재하지 않습니다.</div>
			<button onclick="isLogined()">새로 만들기</button>
		</c:when>
		<c:otherwise>
		<ul>
			<c:forEach var="item" items="${searchList}">
				<li class="row-flex">
					<a href="getBoard?title=${item.title}">${item.title}</a>
				</li>
			</c:forEach>
		</ul>
		</c:otherwise>
	</c:choose>
</body>
<script>
	function isLogined() {
		const id = '${info.id}';
		
		if (id == null || id === "") {
			console.log('로그인');
			location.href = "login";
		} else {
			console.log('인서트');
			location.href = "insertBoard?title=${keyword}";
		}
	}
</script>
</html>