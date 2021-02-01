<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 수정</title>
<style>
.container{
	width:300px;
	margin:0px auto;
	height: 600px;
	padding-top:200px;
	box-sizing: border-box;
}
</style>
</head>
<body>
	<jsp:include page="template/header.jsp"></jsp:include>
	<div id="container">
		<form action="updateMemberAction.do" method="post">
			아이디 : <input type="text" name="id" value="${requestScope.dto.id}" readonly><br>
			암호 : <input type="password" name="pass"><br>
			이름 : <input type="text" name="name" value="${requestScope.dto.name }"><br>
			나이 : <input type="text" name="age" value="${requestScope.dto.age }"><br>
			<button>정보수정</button><a href="javascript:history.back();">뒤로가기</a>		
		</form>
	</div>
	<jsp:include page="template/footer.jsp"></jsp:include>
</body>
</html>











