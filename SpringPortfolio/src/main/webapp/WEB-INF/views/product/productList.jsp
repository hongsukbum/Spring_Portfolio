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

	<!-- 2-2.<img src = "uploadFile/product/검사낚시.jpg"/></br> -->
	
	<h2 align = "center">상품 목록</h2>
	
	<table border = "1" cellspacing = "0">
		<tr bgcolor = orange>
			<td>상품이름</td><td>상품설명</td>
		</tr>
		
		<c:forEach items = "${productList}" var = "dto">
			<tr>
				<td>${dto.pd_name}</td><td>${dto.pd_title}</td>
			</tr>
		</c:forEach>
		
	</table>

<jsp:include page= "../common/pagingBottom.jsp" flush="false">
	<jsp:param name="paging" value="${paging}"/>
	<jsp:param name= "pageName" value = "${pageName}"/>
</jsp:include>	
	
</body>
</html>