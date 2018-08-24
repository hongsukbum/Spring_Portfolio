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
	
	<h2 align = "center">상품 등록</h2>
	
	<form name = "productForm" id = "productForm" enctype="multipart/form-data">
	
		<table align = "center" border = "1" cellspacing = "0">
			<tr>
				<td>상품 이름</td>
				<td>
					<input type = "text" name ="pd_name" id = "pd_name">
				</td>
			</tr>
			<tr>
				<td>상품 기본 설명</td>
				<td>
					<input type = "text" name ="pd_title" id = "pd_title">
				</td>
			</tr>
			<tr>
				<td>상품 상세 설명</td>
				<td>
					<textarea rows="20" cols="40" name = "pd_content" id = "pd_content"></textarea>
				</td>
			</tr>
			<tr>
				<td>상품 이미지</td>
				<td>
					<input type = "file" name ="pd_image" id = "pd_image">
				</td>
			</tr>
			<tr>
				<td>상품 가격</td>
				<td>
					<input type = "number" name ="pd_charge" id = "pd_charge">
				</td>
			</tr>
			<tr>
				<td>상품 수량</td>
				<td>
					<input type = "number" name ="pd_count" id = "pd_count">
				</td>
			</tr>
			<tr>
				<td align = "center" colspan = "2">
					<input type = "button" value = "등록" onclick = "productEnrollment()">&nbsp&nbsp
					<input type = "button" value = "취소" onclick = "pageMain()">
				</td>
			</tr>
		</table>
	
	</form>
	
</body>
</html>