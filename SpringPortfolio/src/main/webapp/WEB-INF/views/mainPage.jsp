<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri = "http://www.springframework.org/security/tags" prefix = "s" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2 align = "center">main page</h2>
	
	<div align = "right">
		<s:authorize ifAnyGranted="ROLE_USER, ROLE_ADMIN">
			<s:authentication property="name"/>님 어서오세요.</br>
			<a href = "${pageContext.request.contextPath}/j_spring_security_logout">로그아웃</a>
		</s:authorize>
		
		<s:authorize ifNotGranted="ROLE_USER, ROLE_ADMIN">
			<a href = "/login">로그인</a>
		</s:authorize>
		
	</div>
	
	<a href = "/product">상품보기</a></br>
	
	<s:authorize ifAnyGranted="ROLE_ADMIN">
		<a href = "/userinfo">유저정보</a></br>
	</s:authorize>
	
</body>
</html>