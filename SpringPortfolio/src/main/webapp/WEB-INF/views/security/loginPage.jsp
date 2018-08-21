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
<script>
	function popupError(){
		
		alert("에러");
		
	}
</script>
	
	<h2>로그인 페이지</h2>
	
	<c:url value = "j_spring_security_check" var = "loginUrl"/>
	
	<form action = "${loginUrl}" method = "post">
		
		<c:if test = "${param.ng != null}">
			Login NG!</br>
			
			<c:if test ="${SPRING_SECURITY_LAST_EXCEPTION != NULL}">
				message : <c:out value = "${SPRING_SECURITY_LAST_EXCEPTION.message}"/></br>
				<script>popupError();</script>
			</c:if>
			
		</c:if>
	
		ID : <input type = "text" name = "j_username" id = "j_username"></br>
		PW : <input type = "password" name = "j_password" id = "j_password"></br>
		<input type = "submit" value = "로그인">
	</form>

</body>
</html>