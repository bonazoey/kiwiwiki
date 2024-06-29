<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
<title>꺼무위키</title>
</head>
<body>
	<h3>제목 : ${content.title}</h3>
	<h4>내용</h4>
	<div>${content.text}</div>
	<div>작성자 : 
		<c:forEach var="contributor" items="${content.contributors}">
			<div>${contributor},</div>
		</c:forEach>
	</div>	
</body>
</html>