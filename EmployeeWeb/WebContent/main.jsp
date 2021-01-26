<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
	$(function(){
		$("button").click(function() {
			var param = $("#frm").serialize();
			$.ajax({
				url : "search.do",
				data : param,
				method : "get",
				dataType:"json",
				//정상처리부분
				success:function(result){
					$("div").html(result);
				},
				//exception 처리
				error:function(xhr,text,error){
					//            error_code         내용
					$("div").html(xhr.status + " " + xhr.responseText + " " + text);
				}
				
			});
		});
	});
	
</script>
</head>
<body>
<form id="frm">
	이름 : <input type="text" name="name"> <button type="button">검색</button>
</form>
<hr>
<div>

</div>
</body>
</html>