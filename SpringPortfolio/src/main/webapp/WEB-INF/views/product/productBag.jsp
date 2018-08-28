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
<script type = "text/javascript" charset = "UTF-8" src = "/resources/js/product.js"></script>

	<h2 align = "center">장바구니</h2>
	
	<table border = "1" cellspacing = "0" align = "center">
		<tr>
			<td>상품 이름</td><td>상품 설명</td><td>장바구니 삭제</td>
		</tr>
		
		<c:forEach items = "${bagList}" var = "bag" varStatus = "status">
			<tr onclick = "productDetail('${bag.pd_idx}',true)">	
				<td>${status.index} : ${bag.pd_name}</td><td>${bag.pd_title}</td>
				<td>
					<input type = "button" value ="장바구니 삭제" onclick = "productUserBagDelete('${status.index}','${bag.pd_idx}')">
				</td>
			</tr>
		</c:forEach>
		
		<tr align = "center">
			<td colspan = "3">
				<input type = "button" value = "홈으로" onclick = "pageMain()">
			</td>
		</tr>
		
	</table>
	
	
	
</body>
</html>