<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="/resources/css/common.css">
<link rel="shortcut icon" href="<c:url value='/resources/favicon.ico'/>" type="image/x-icon"/>
<link rel="icon" href="<c:url value='/resources/favicon.ico'/>" type="image/x-icon"/>

<header class="row-flex test-line">
	<c:choose>
		<c:when test="${info == null}">
			<button type="button" id="login" onclick="location.href='login'">로그인</button>
		</c:when>
		<c:otherwise>
			<div>${info.id}</div>
			<a href="logout">로그아웃</a>
		</c:otherwise>
	</c:choose>
</header>