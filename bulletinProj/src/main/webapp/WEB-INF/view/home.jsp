<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
	<title>Bulletin</title>
	<link href="<c:url value="/resources/css/bootstrap.css" />" rel="stylesheet">
	<meta name="viewport" content="width=device-width", initial-scal="1">
<!--
 	<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
 -->

</head>

<script type="text/javascript">
function getContextPath() {
	var hostIndex = location.href.indexOf( location.host ) + location.host.length;
	return location.href.substring( hostIndex, location.href.indexOf('/', hostIndex + 1) );
};
</script>

<body>
	<%
		String userId = null;
		if(session.getAttribute("userId") != null){
			userId = (String) session.getAttribute("userId");
		}
	%>
	<nav class="navbar navbar-expand-sm bg-secondary navbar-dark">
	<a class="navbar-brand" href="/bulletinProj">Bulletin Home Page</a>
		<ul class="navbar-nav">
			
			<li class="nav-item"><a class="nav-link" href="">Main</a></li>
			<li class="nav-item"><a class="nav-link" href="">게시판</a></li>
			<li class="nav-item"><a class="nav-link" onclick="window.location.href='register/showFormForAdd'; return false;">회원가입</a></li>
			<%
				if(userId==null){
			%>
				<li class="nav-item"><a class="nav-link" onclick="window.location.href='showMyLoginPage'; return false;">로그인</a></li>
			
			<%
				} else {
			%>
				<li class="nav-item"><form action="${pageContext.request.contextPath}/logout" method="POST"><button class="btn" type="submit">로그아웃</button></form></li>
				
				<li class="nav-item"><form action="${pageContext.request.contextPath}/logout" method="POST"><button class="btn" type="submit">내 정보</button></form></li>
			<%
				}
			%>
			
		</ul>
	
	</nav>
	
	<hr>

	<div class="table-container">
		<div class="col-lg-4"></div>
		<table class="table table-striped">
			<thead>
				<tr>
					<th class="table-th">번호</th>
					<th class="table-th">제목</th>
					<th class="table-th">작성자</th>
					<th class="table-th">작성일</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>1</td>
					<td>Hi</td>
					<td>David</td>
					<td>2020-01-01</td>
				</tr>
			</tbody>
		</table>
		<hr />
		<div class="text-center">
			<ul class="pagination">
				<li><a href="#">1</a></li>
			</ul>
		</div>


		<%
				if(userId==null){
		%>
		
		<form action="${pageContext.request.contextPath}/showMyLoginPage" method="GET"><button class="btn" type="submit">글쓰기</button></form>

		<%
				}else{
		%>
		<form action="${pageContext.request.contextPath}/newArticle" method="GET"><button class="btn" type="submit">글쓰기</button></form>
		
		<%
				}
		%>
		
	</div>


</body>

</html>