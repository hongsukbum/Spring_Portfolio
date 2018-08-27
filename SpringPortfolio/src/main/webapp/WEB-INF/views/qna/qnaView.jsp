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
<script type = "text/javascript" charset = "UTF-8" src = "/resources/js/qnaCommon.js"></script>
	<table align = "center" border="1" cellspacing = "0">
		
		<c:set var = "dto" value="${viewQnaDetail}"></c:set>
		
		<tr>
			<td>제목</td>
			<td>${dto.qna_title}</td>
		</tr>
		
		<tr>
			<td>내용</td>
			<td>${dto.qna_content}</td>
		</tr>
		<tr>
			<td>
				<input type = "button" value="목록" onclick="move_qna_list()">
				<input type = "button" value="수정" onclick="qna_modify('${dto.qna_title}','${dto.qna_content}','${dto.qna_idx}')">
				<input type = "button" value="삭제" onclick="">
			</td>
		</tr>
		
		
	</table>
</body>
</html>