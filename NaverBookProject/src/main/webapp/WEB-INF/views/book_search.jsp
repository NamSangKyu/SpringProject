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
	function searchBook(start) {
		var result = "";
		var str = "title="+$("#title").val()+"&start="+start;
		$.ajax({
			data : str,
			url : "search.do",
			method:"get",
			async:false,//ajax 외부에 있는 변수 사용이 가능함
			dataType:"json",
			success:function(r) {
				console.log(r);
				if(r.responseCode == "200"){
					//데이터를 읽어서 화면 출력
					var arr = r.items;
					for(i=0;i<arr.length;i++){
						result += "<figure><img src='"+arr[i].image+"'>"
							+"<figcaption><p><a href='"+arr[i].link+"'>"+arr[i].title+"</a></p>"
							+"<p>저자 : "+arr[i].author +", 출판사 : "+arr[i].publisher+"</p>"
							+"<p>"+arr[i].description+"</p></figcaption></figure>";												
					}
				}else{
					//실패한 메세지를 출력 --> 코드와 errorMessage를 출력
					result += "에러 코드 : "+r.responseCode + ", 에러 메세지 : "+r.responseMessage;					
				}
			}
		});//ajax
		return result;
	}
	$(function(){
		var start = 1;
		$("#btn_search").click(function(){
			start = 1;
			var str = searchBook(start);
			$("#result").html(str);			
		});//click
		$("#frm").submit(function(e) {
			e.preventDefault();
			$("#btn_search").click();
		});
		$("#btn_more").click(function() {
			if(start>1000)//1000넘을수 없음
				return false;
			start += 10;
			var str = searchBook(start);
			$("#result").append(str);
		});
	});//main
</script>
</head>
<body>
	<div>
		<form id="frm">
			<input type="text" id="title" placeholder="책 제목을 입력하세요">
			<button type="button" id="btn_search">검색</button> 
		</form>
	</div>
	<hr>
	<div id="result">
		
	</div>
	<button type="button" id="btn_more">더보기</button>
</body>
</html>










