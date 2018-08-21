<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri = "http://www.springframework.org/security/tags" prefix = "s" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>login Success</h2>
	
	<s:authorize ifAnyGranted="ROLE_USER">
		is log In - user</br>
	</s:authorize>
	
	<s:authorize ifAnyGranted="ROLE_ADMIN">
		is log In - amdin</br>
	</s:authorize>
	
	USER ID : <s:authentication property="name"/></br>
	
	<a href = "${pageContext.request.contextPath}/j_spring_security_logout">Log out</a>
	
</body>
</html>