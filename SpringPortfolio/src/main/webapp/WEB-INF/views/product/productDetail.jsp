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
<script type = "text/javascript" charset = "UTF-8" src = "/resources/js/common.js"></script>

	<c:set var = "dto" value = "${productDetail}"/>
	
	<h1 align = "center">상품 정보</h1>
	
	<h3 align = "center">상품 이름 : ${dto.pd_name}</h3>
	
	<div align = "center">
		<div>가격 : ${dto.pd_charge}</div>
		<div>수량 : ${dto.pd_count}</div>
		<div>상품 상세 설명 : ${dto.pd_content}</div>
	
		<img src = "${dto.pd_image_path}/${dto.pd_image}" width = "200"/>
		
		<table border = "1" cellspacing = "0">
			<tr>
				<td>
					<input type = "button" value = "홈으로" onclick = "pageMain()">
					<input type = "button" value = "뒤로가기" onclick = "pageBack()">
				</td>
			</tr>
		</table>
		
	</div>
	
	
</body>
</html>