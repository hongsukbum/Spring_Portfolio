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
<script type = "text/javascript" charset = "UTF-8" src = "/resources/js/qnaCommon.js"></script>

	<h1 align = "center">문의 목록</h1>
	
	<table align = "center" border="1" cellspacing="0">
		
		<tr align="center">
			<td>NO</td>
			<td>제목</td>
			<td>작성자</td>
			<td>작성일</td>
			<td>답변상태</td>
		</tr>
		
		<c:forEach items="${viewQnalist}" var="view">
		<tr align="center" onclick="qna_view('${view.qna_idx}')">
			<td>${view.qna_idx}</td>
			<td>${view.qna_title}</td>
			<td>${view.qna_unick}</td>
			<td>${view.qna_date}</td>
			<td>${view.qna_state}</td>
		</tr>
		</c:forEach>
		<tr align = "right">
			<td colspan = "5">
				<input type="button" value="글쓰기" onclick="qna_write()">
				<input type="button" value="홈으로" onclick="pageMain()">
			</td>
		</tr>
	</table>
	
	
</body>
</html>