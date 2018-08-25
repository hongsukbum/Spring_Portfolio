<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
</head>
<body>
<script type = "text/javascript" charset = "UTF-8" src = "/resources/js/common.js"></script>
<script type = "text/javascript" charset = "UTF-8" src = "/resources/js/paging.js"></script>
	
	<div align = "center">
	    <c:if test="${paging.curRange ne 1 }">
	        <a href="" onClick="fn_paging(1,'${search}', '${pageName}')">[처음]</a> 
	    </c:if>
	    <c:if test="${paging.curPage ne 1}">
	        <a href="#" onClick="fn_paging('${paging.prevPage}','${search}', '${pageName}')">[이전]</a> 
	    </c:if>
	    <c:forEach var="pageNum" begin="${paging.startPage}" end="${paging.endPage}">
	        <c:choose>
	            <c:when test="${pageNum eq  paging.curPage}">
	                <span style="font-weight: bold;"><a href="#" onClick="fn_paging('${pageNum}','${search}', '${pageName}')">${pageNum }</a></span> 
	            </c:when>
	            <c:otherwise>
	                <a href="#" onClick="fn_paging('${pageNum}','${search}', '${pageName}')">${pageNum}</a> 
	            </c:otherwise>
	        </c:choose>
	    </c:forEach>
	    <c:if test="${paging.curPage ne paging.pageCnt && paging.pageCnt > 0}">
	        <a href="#" onClick="fn_paging('${paging.nextPage }','${search}', '${pageName}')">[다음]</a> 
	    </c:if>
	    <c:if test="${paging.curRange ne paging.rangeCnt && paging.rangeCnt > 0}">
	        <a href="#" onClick="fn_paging('${paging.pageCnt }','${search}', '${pageName}')">[끝]</a> 
	    </c:if>
	</div>
      
	<div align = "center">
		<form id = "searchForm">
			<input type = "button" value = "홈으로" onclick = "pageMain()">
			<input type = "text" name = "search" id = "search">
			<input type = "button" value = "검색" onclick = "fn_Search('${pageName}')">
		</form>
	</div>
	     search str :: ${search}
    <div>
		총 게시글 수 : ${paging.listCnt } /    총 페이지 수 : ${paging.pageCnt } / 현재 페이지 : ${paging.curPage } / 현재 블럭 : ${paging.curRange } / 총 블럭 수 : ${paging.rangeCnt }
	</div>
</body>
</html>