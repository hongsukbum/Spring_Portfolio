<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script type = "text/javascript" charset = "UTF-8" src = "/resources/js/joinCommon.js"></script>
	<c:set var = "checkIdResult" value = "<%=request.getAttribute(\"checkIdResult\")%>"/>

	<h2>중복 체크</h2>
	
	<form name = "joinForm" id = "joinForm">
	
		<c:if test = "${not empty checkIdResult}">
			<c:if test = "${checkIdResult == 0}">
				${param.uid} 사용 가능한 아이디입니다.</br>
				<input type = "button" value ="사용하기" onclick = "checkUsedId()">
			</c:if>
			
			<c:if test = "${checkIdResult != 0}">
				<input type = "text" name = "uid" placeholder = "아이디를 입력해주세요." required>
				<input type = "button" value = "중복체크" onclick = "checkId()"></br>
				${param.uid} 사용 불가능한 아이디입니다.
			</c:if>
		</c:if>	
	
	</form>	
	
	
	
	
	
	
	dd :: ${param.uid}</br>
	n :: ${checkIdResult}
	
</body>
</html>