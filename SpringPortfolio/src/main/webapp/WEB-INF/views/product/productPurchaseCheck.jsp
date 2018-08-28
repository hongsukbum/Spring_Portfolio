<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script type = "text/javascript" charset = "UTF-8" src = "/resources/js/common.js"></script>
<script type = "text/javascript" charset = "UTF-8" src = "/resources/js/product.js"></script>

		<h2 align = "center">구매 페이지</h2>
		
		<div align = "center">
			${pd_purchase_count}개의 상품을 구매하시겠습니까?</br></br>
			<input type = "button" value = "구매하기" onclick = "productPurchase('${pd_idx}','${pd_purchase_count}', false, '${isBag}')">&nbsp&nbsp
			<input type = "button" value = "취소" onclick = "pageBack()">
		</div>
	
</body>
</html>