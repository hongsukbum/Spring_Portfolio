<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>WritePage</title>
<meta name = "viewport" content = "width=device-width, initial-scale=1.0">
</head>
<body>
<script type = "text/javascript" charset = "UTF-8" src = "/resources/js/common.js"></script>
	<form action = "" accept-charset="UTF-8"method = "get" id = "writeForm" name = "writeForm">
		<table align = "center" border = "1">
			<tr>
				<td>제목</td>
				<td>
					<input type = "text" name = "title" id = "title" required size=100>
				</td>
			</tr>
			<tr>
				<td>내용</td>
				<td>
					<input type = "text" name = "content" required>
				</td>				
			</tr>
		</table>
		<input type="submit" Value="submit">
	</form>
</body>
</html>