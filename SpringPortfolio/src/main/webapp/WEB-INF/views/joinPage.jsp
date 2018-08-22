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
<script type = "text/javascript" charset = "UTF-8" src = "/resources/js/joinCommon.js"></script>
	<h2 align = "center">회원가입</h2>
	
	
	<form action = "" method = "get" id = "joinForm" name = "joinForm">
		<table align = "center" border = "1" cellspacing ="0">
		
			<tr>
				<td>아이디</td>
				<td>
					<input type = "text" name = "uid" id = "uid" placeholder = "아이디를 입력하세요." value = "${param.uid}" required >
					<input type = "button" value = "중복체크" onclick = "checkId()">
				</td>
			</tr>
			<tr>	
				<td>비밀번호</td>
				<td>
					<input type = "password" name = "upw" placeholder = "비밀번호를 입력하세요." required>
				</td>
			</tr>	
			<tr>
				<td>비밀번호 확인</td>
				<td>
					<input type = "password" name = "upw_check" placeholder = "비밀번호를 확인하세요." required>
				</td>
			</tr>
			<tr>
				<td>닉네임</td>
				<td>
					<input type = "text" name = "unick" placeholder = "닉네임을 입력하세요." required>
					<input type = "button" value = "중복체크">
				</td>
			</tr>
			<tr>
				<td>핸드폰번호</td>
				<td>
					<select name = "phone1">
						<option value = "010">010
						<option value = "011">011
						<option value = "016">016
						<option value = "017">017
						<option value = "019">019
					</select>
					- <input type = "number" onkeydown="javascript: return event.keyCode == 69 ? false : true" name = "phone2" required> - <input type = "number" onkeydown="javascript: return event.keyCode == 69 ? false : true" name = "phone3" required>
				</td>
			</tr>
			<tr>
				<td>주소</td>
				<td>
					<input type = "text" name = "uaddr" placeholder = "주소를 입력하세요." required>
				</td>
			</tr>
			<tr>
				<td>생년월일</td>
				<td>
					<input type = "number" max = "999999" maxlength = "6" oninput="maxLengthCheck(this)" name = "ubirth" onkeydown="javascript: return event.keyCode == 69 ? false : true" placeholder = "생년월일6자를 입력하세요.(ex>900805)" required>
				</td>
			</tr>
			<tr>
				<td>성별</td>
				<td>
					<input type = "radio" name = "ugender" value = "m" checked>남
					<input type = "radio" name = "ugender" value = "w">여
				</td>
			</tr>
			<tr>
				<td align = "center" colspan = "2">
					<input type = "submit" value = "회원가입">
				</td>
			</tr>
			
		</table>
	</form>	
	
	
	<%-- <table border = "1" cellspacing = "0">
		<c:forEach items = "${list}" var = "dto">
				<tr>
					<td>${dto.uid}</td>
				</tr>
		</c:forEach>
	</table> --%>
	
</body>
</html>