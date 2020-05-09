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
			<li class="nav-item"><a class="nav-link" onclick="window.location.href='register/showFormForAdd';">회원가입</a></li>
			<%
				if(userId==null){
			%>
				<li class="nav-item"><a class="nav-link" onclick="window.location.href='showMyLoginPage';">로그인</a></li>
			
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


	<form:form action="${pageContext.request.contextPath}/newArticle" 
						  	   modelAttribute="board"
						  	   class="form-horizontal"
						  	   method="post">
		<label class="control-label" for="article-title">제목</label>
		<form:input path="title" type="text" class="form-control" id="article-title" readonly="true" />
		<label class="control-label" for="article-userId">작성자</label>
		<form:input path="user.id" type="text" class="form-control" id="article-userId" readonly="true" />
		<label class="control-label" for="article-contents">내용</label>
		<div class="form-group" id="article-contents">
			<form:textarea path="content" class="form-control" rows="15" readonly="true"/>
			<form:hidden path="boardKind" value="MAIN"/>
		</div>
	</form:form>
	
	<br>
	
	<!-- comment function needed -->
	<form:form action="${pageContext.request.contextPath}/newArticle" 
						  	   modelAttribute="board"
						  	   class="form-horizontal"
						  	   method="post">
	<form:input path="" type="text" class="form-control" id="article-title" />
	<button type="submit" class="btn btn-secondary">댓글달기</button>
	</form:form>

	<br>
	<div>
		<a href="${pageContext.request.contextPath}" class="btn btn-secondary"
			role="button" aria-pressed="true">뒤로가기</a>
	</div>

	</div>


</body>

</html>