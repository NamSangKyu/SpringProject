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
				url : "register.do",
				data : param,
				method : "get",
				dataType:"json",
				//정상처리부분
				success:function(result){
					console.log(result);
					var arr = JSON.parse(result);
					var text = "";
					for(i=0;i<arr.length;i++){
						text += arr[i].eno + " " + arr[i].name + " " + arr[i].department + " " + arr[i].position + "<br>"; 
					}
					$("div").html(text)
				},
				//exception 처리
				error:function(xhr,text,error){
					switch(xhr.status){
					case 100:
						alert("SQL문 에러");
						break;
					case 101:
						alert("보낸 데이터가 잘못되었습니다.");
						break;
					}
				}
				
			});
		});
	});
	
</script>
</head>
<body>
<form id="frm">
	<input type="text" name="eno">
	<input type="text" name="name">
	<input type="text" name="department">
	<select name="position">
		<option value="1">사원</option>
		<option value="2">주임</option>
		<option value="3">대리</option>
		<option value="4">과장</option>
		<option value="5">차장</option>
	</select>
	<button type="button">검색</button>
</form>
<hr>
<div>

</div>
</body>
</html>