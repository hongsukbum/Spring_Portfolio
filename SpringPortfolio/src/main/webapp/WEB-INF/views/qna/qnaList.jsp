<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://www.springframework.org/security/tags" prefix = "s" %>
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
		<!--<c:set value = "${qnaCatelist}" var = "qna_cate"></c:set> -->
		<s:authorize ifAnyGranted="ROLE_ADMIN">
			<tr>
				<td>카테고리</td>
				<td>
					<select id="cate_state" name="cate_state">
						<c:forEach items="${qna_qnac}" var="qna">
							<option value="${qna.qnac_idx}" >${qna.qnac_name}</option>
						</c:forEach>
					</select>
				</td>
			</tr>
		</s:authorize>
		
		<tr align="center">
			<td>NO</td>
			<s:authorize ifAnyGranted = "ROLE_ADMIN">
				<td>카테고리</td>			
			</s:authorize>
			<td>제목</td>
			<td>작성자</td>
			<td>작성일</td>
			<td>답변상태</td>
		</tr>
		
		<c:forEach items="${viewQnalist}" var="view">
		<tr align="center" onclick="qna_view('${view.qna_idx}')">
			<td>${view.qna_idx}</td>
			
			<!-- 카테고리 띄우기(나중에 수정해야함)//카테고리별 목록띄우기도 추가해야함 -->
			<s:authorize ifAnyGranted = "ROLE_ADMIN">
				<c:if test="${view.qna_qnac_idx == 0 }">
					<td>카테고리</td>
				</c:if>
				<c:if test="${view.qna_qnac_idx == 1 }">
					<td>상품</td>
				</c:if>
				<c:if test="${view.qna_qnac_idx == 2 }">
					<td>배송</td>
				</c:if>
				<c:if test="${view.qna_qnac_idx == 3 }">
					<td>기타</td>
				</c:if>
			</s:authorize>	
			
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