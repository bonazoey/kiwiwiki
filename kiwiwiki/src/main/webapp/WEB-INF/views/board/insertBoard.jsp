<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 작성</title>
</head>
<%@ include file="../include/header.jsp"%>
<body>
	<form action="insertBoard" method="post">
		<input type="hidden" name="title" value="${title}" required="required">
		<div>${title}</div>
		<input type="text" name="text">
		<input type="hidden" name="id" value="${info.id}" required="required">
		<button type="submit">작성</button>
	</form>
</body>
</html>