<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
* {
	margin: 0;
	padding: 0;
}
	div{
		width:1200px;
		margin: 0 auto;
		padding:20px 0px;
		text-align: center;
		border:1px solid black;
	}
	form{
		display: inline-block;
	}
</style>
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
	<div>
		<form id="frm">
			<input type="text" name="title" placeholder="책 제목을 입력하세요">
			<button type="button">검색</button> 
		</form>
	</div>
	<hr>
	<div id="result">
	
	</div>
</body>
</html>










