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
	figure{
		width:100%;
		padding:20px;
		box-sizing: border-box;
		display: inline-block;
		clear: both;
	}
	img{
		width: 100px;
		height:150px;
		border :1px solid black;
		display: inline-block;
		float: left;
	}
	#result{
		margin:0 auto;
	}
	figcaption{
		width:900px;
		height:150px;
		border :1px solid black;
		display: inline-block;
		text-align: left;
		float: left;
		margin-left: 20px;
	}
</style>
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("button").click(function(){
			var str = "title="+$("#title").val();
			$.ajax({
				data : str,
				url : "search.do",
				method:"get",
				dataType:"json",
				success:function(result) {
					console.log(result);
				}
			});//ajax
		});//click
	});//main
</script>
</head>
<body>
	<div>
		<form id="frm">
			<input type="text" id="title" placeholder="책 제목을 입력하세요">
			<button type="button">검색</button> 
		</form>
	</div>
	<hr>
	<div id="result">
		<figure>
			<img src="">
			<figcaption>
				<p><a href="#">책제목</a></p>
				<p>저자 : 홍길동, 출판사 : 자바 홀딩스</p>
				<p>요약 내용</p>
			</figcaption>
		</figure>
		<figure>
			<img src="">
			<figcaption>
				<p><a href="#">책제목</a></p>
				<p>저자 : 홍길동, 출판사 : 자바 홀딩스</p>
				<p>요약 내용</p>
			</figcaption>
		</figure>
		<figure>
			<img src="">
			<figcaption>
				<p><a href="#">책제목</a></p>
				<p>저자 : 홍길동, 출판사 : 자바 홀딩스</p>
				<p>요약 내용</p>
			</figcaption>
		</figure>
	</div>
</body>
</html>










