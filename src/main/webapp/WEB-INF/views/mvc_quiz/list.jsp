<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<table border="1">
		<tr>
			<th>id</th><th>password</th><th>name</th>
		</tr>
	<c:if test="${list.size() == 0 }">
		<tr>
			<th colspan="3">데이터없음</th>
		</tr>
	</c:if>
	
	<c:forEach var="dto" items="${list }">
		<tr>
			<td>${dto.id }</td>
			<td>${dto.pwd }</td>
			<td>${dto.name }</td>
		</tr>
	</c:forEach>
		<tr>
			<td colspan="3"><a href="Mainpage">메인페이지이동</a></td>
		</tr>
</table>
</body>
</html>