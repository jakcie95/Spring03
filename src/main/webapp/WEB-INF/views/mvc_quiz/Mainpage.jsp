<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>MainPage.jsp<br>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script type="text/javascript">
	var result = ${result}
	if(result == 0){
		alert('비밀번호가 틀렸습니다.')
	}else if(result == -1){
		alert('존재하지 않는 아이디입니다.')
	}
</script>
<!-- 
<c:if test="${result == 0 }">
<script type="text/javascript">alert('비밀번호틀림')</script>
</c:if>
<c:if test="${result == -1 }">
<script type="text/javascript">alert('아이디없음')</script>
</c:if>
 -->
<form action="logchk" method="post">
	<input type="text" name="id" placeholder="id"><br>
	<input type="text" name="pwd" placeholder="password"><br>
	<input type="submit" value="login">
</form>
	<a href="register_form">회원가입</a>
	<a href="list">모든 회원보기</a>

</body>
</html>