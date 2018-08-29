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

	<h3 align = "center">구매 내역</h3>
	
	<table border = "1" cellspacing = "0" align = "center">
		<tr align = "center">
			<td>상품 이름</td><td>구매 수량</td><td>결제금액</td><td>구매 시간</td><td>상태</td>
		</tr>

		<c:forEach items = "${purchaseBag}" var = "bag" varStatus = "status">
			<tr align = "center" onclick = "productDetail('${bag.pdb_pdidx}', 'purchaseBag', '${status.index}')">
				<td>${bag.pd_name}</td><td>${bag.pdb_count}</td>
				<td>
					<script>
						var tmp = parseInt('${bag.pdb_count}') * parseInt('${bag.pd_charge}');
						document.write(addComma(tmp));
					</script>원
				</td>
				<td>${bag.pdb_date}</td>
				<td>${bag.pdb_state}</td>
			</tr>
		</c:forEach>
		
	</table>
	
<jsp:include page= "../common/pagingBottom.jsp" flush="false">
	<jsp:param name="paging" value="${paging}"/>
	<jsp:param name= "pageName" value = "${pageName}"/>
</jsp:include>	
	
</body>
</html>