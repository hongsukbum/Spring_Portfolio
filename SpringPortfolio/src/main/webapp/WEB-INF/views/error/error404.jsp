<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>에러페이지</title>
</head>
<body>
<script type = "text/javascript" charset = "UTF-8" src = "/resources/js/errorCommon.js"></script>
	<h2>페이지를 찾을 수 없습니다.</h2>

	<form name = "errorPage">
		<input type ="button" value = "뒤로가기" onclick="goBack()">
		<input type ="button" value = "홈으로" onclick = "goMain()">
	</form>
	
</body>
</html>