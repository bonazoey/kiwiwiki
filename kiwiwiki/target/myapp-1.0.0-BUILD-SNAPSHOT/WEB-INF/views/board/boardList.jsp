<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
<title>검색한 리스트래요</title>
</head>
<body>
	<c:choose>
		<c:when test="${searchList == null}">
			검색한 내용이 존재하지 않습니다.
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
</html>