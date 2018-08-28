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

	<c:set var = "dto" value = "${productDetail}"/>
	
	<h1 align = "center">상품 정보</h1>
	
	<h3 align = "center">${dto.pd_name}</h3>
	
	<table border = "1" cellspacing = "0" align = "center">
		
		<tr align = "center">
			<td>가격</td>
			<td>${dto.pd_charge}</td>
		</tr>
		
		<tr align = "center">
			<td>보유수량</td>
			<td>${dto.pd_count}</td>
		</tr>
		
		<tr align = "center">
			<td>구매수량</td>
			<td>
				<input type = "number" min = 0 max = "${dto.pd_count}" name = "pd_purchase_count" id = "pd_purchase_count">
			</td>
		</tr>
		
		<tr align = "center">
			<td colspan = "2">
				<상세설명></br>
				${dto.pd_content}
			</td>
		</tr align = "center">
		
		<tr align = "center">
			<td colspan = "2">
				<img src = "${dto.pd_image_path}/${dto.pd_image}" width = "300"/>
			</td>
		</tr>
		
		<tr align = "center">
			<td colspan = "2">
				<input type = "button" value = "구매하기" onclick = "productPurchase('${dto.pd_idx}','${dto.pd_count}',true, '${isCheck}')">
				
				<c:if test = "${empty isCheck}">
					<input type = "button" value = "장바구니 담기" onclick = "productInputBag('${dto.pd_idx}')">
				</c:if>
			</td>
		</tr>
		
		<tr align = "center">
			<td colspan = "2">
				<input type = "button" value = "홈으로" onclick = "pageMain()">
				<input type = "button" value = "뒤로가기" onclick = "pageBack()">
			</td>
		</tr>
		
	</table>
	
	
	
</body>
</html>