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
	<form action="loginAction.do" method="post">
		<input type="text" name="id" placeholder="아이디를 입력하세요"><br>
		<input type="password" name="pass" placeholder="암호를 입력하세요"><br>
		<button>로그인</button>
	</form>
	${sessionScope.id },${sessionScope.pass },<%=session.getId() %>
</body>
</html>