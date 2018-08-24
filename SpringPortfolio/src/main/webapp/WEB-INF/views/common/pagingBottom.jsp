<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
</head>
<body>

	<script>
		function fn_paging(num, strSearch, url){
			//// get 방식.
			//location.href = "/userInfo?curPage=" + num;
			
			var form = document.createElement("form");
			form.setAttribute("charset", "UTF-8");
			form.setAttribute("method", "Post");
			form.setAttribute("action", url);
			
			var hiddenField = document.createElement("input");
			hiddenField.setAttribute("type", "hidden");
			hiddenField.setAttribute("name", "curPage");
			hiddenField.setAttribute("value", num);
			
			if(strSearch != ""){
				var hiddenField_search = document.createElement("input");
				hiddenField_search.setAttribute("type", "hidden");
				hiddenField_search.setAttribute("name", "search");
				hiddenField_search.setAttribute("value", strSearch);
			
				form.appendChild(hiddenField_search);
			}
			
			form.appendChild(hiddenField);
			document.body.appendChild(form);
			
			form.submit();
			
		}
		
		
		function fn_Search(url){
		
			var form = document.getElementById('searchForm');
			var str = document.getElementById('search').value;
			
			if(str == ""){
				alert("검색어를 입력해주세요.");
				return;
			}
			
			form.setAttribute("method", "post");
			form.setAttribute("action", url);
			
			form.submit();
			
		}
		
	</script>
	test :: ${pageName} 
	:: test1
	<div>
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
			<input type = "text" name = "search" id = "search">
			<input type = "button" value = "검색" onclick = "fn_Search()">
		</form>
	</div>
	     search str :: ${search}
    <div>
		총 게시글 수 : ${paging.listCnt } /    총 페이지 수 : ${paging.pageCnt } / 현재 페이지 : ${paging.curPage } / 현재 블럭 : ${paging.curRange } / 총 블럭 수 : ${paging.rangeCnt }
	</div>
</body>
</html>