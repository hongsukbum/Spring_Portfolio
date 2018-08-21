<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>   
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script type = "text/javascript" charset = "UTF-8" src = "/resources/js/errorCommon.js"></script>
<script type = "text/javascript" charset = "UTF-8" src = "/resources/js/common.js"></script>
	
	<h2>로그인 페이지</h2>
	
	<c:url value = "j_spring_security_check" var = "loginUrl"/>
	
	<form action = "${loginUrl}" method = "post">
		
		<c:if test = "${param.ng != null}">
			<c:if test ="${SPRING_SECURITY_LAST_EXCEPTION != NULL}">
				<script>popupError("${SPRING_SECURITY_LAST_EXCEPTION.message}");</script>
			</c:if>
		</c:if>
	
		아이디 : <input type = "text" name = "j_username" id = "j_username" required></br>
		비밀번호 : <input type = "password" name = "j_password" id = "j_password" required></br></br>
		<input type = "submit" value = "로그인">
		<input type = "button" value = "취소" onclick="goMain()">
		<input type = "button" value = "회원가입 " onclick ="goJoinPage()">
	</form>

</body>
</html>