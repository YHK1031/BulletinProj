<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
	<title>Bulletin</title>
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
</head>

<script type="text/javascript">
function getContextPath() {
	var hostIndex = location.href.indexOf( location.host ) + location.host.length;
	return location.href.substring( hostIndex, location.href.indexOf('/', hostIndex + 1) );
};
</script>

<body>

	<nav>
	<div id="menu">
		<ul class="nav-container">
			<li class="nav-item"><a href="/bulletinProj">Bulletin Home Page</a></li>
			<li class="nav-item"><a href="">Main</a></li>
			<li class="nav-item"><a href="">게시판</a></li>
			<li class="nav-item-1"><a href="${pageContext.request.contextPath}/register/showRegistrationForm">회원가입</a></li>
			<li class="nav-item-1"><a href="${pageContext.request.contextPath}/register/showRegistrationForm">로그인</a></li>
		</ul>
	</div>
	</nav>
	
	<hr>
	
	<!-- Add a logout button -->
	<form:form action="${pageContext.request.contextPath}/logout" method="POST">
		<input type="submit" value="Logout" />
	</form:form>
	
</body>

</html>