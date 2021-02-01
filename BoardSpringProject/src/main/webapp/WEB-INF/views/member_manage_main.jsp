<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 메인 페이지</title>
<style>
.container{
	width:1200px;
	margin:0px auto;
	padding-top:30px;
	box-sizing: border-box;
}
#menu_bar{
	width:1200px;
	box-sizing: border-box;
	text-align: center;
}
#menu_bar > select{
	width:150px;
	padding:5px;
	margin-right:5px;
}
#menu_bar > input{
	width:200px;
	padding:5px;
	margin-right:5px;
}
#menu_bar > button{
	width:100px;
	padding:5px;
}
#title > li {
	width: 230px;
	font-size:16px;
	display: inline-block;
	text-align: center;
	font-weight: bold;
	padding:10px;
	box-sizing: border-box;
}
#title{
	font-size:0px;
	padding:0;
}
table{
	border-collapse: collapse;
}
td{
	width:230px;
	text-align: center;
	padding:10px;
	box-sizing: border-box;
}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
	function update_member(obj) {
		var data = "";
		$.each($(obj).parent().parent().find("input"), function(i,o) {
			console.log(i,$(o).val());
			data += $(o).attr("name") + "=" + $(o).val()  + "&"; 
		});
		console.log(data);
		$.ajax({
			url : "memberAjaxUpdate.do",
			data : data,
			method:"get",
			success:function(d){
				d = d === "true"; // 동일한 값 O, 양쪽 데이터 타입 O  1234 == "1234" --> true, 1234 === "1234" --> false
				if(d){
					alert("수정 성공");
				}else{
					alert("수정 실패");						
				}
				location.href = "memberAdminMain.do";
			}
		});
	}
	function delete_member(obj) {
		var data = "";
		data = "id=" + $(obj).parent().parent().find("input").first().val();
		console.log(data);
		$.ajax({
			url : "memberAjaxDelete.do",
			data : data,
			method:"get",
			success:function(d){
				d = Number(d);
				if(d==1){
					alert("삭제 성공");
				}else{
					alert("삭제 실패");						
				}
				location.href = "memberAdminMain.do";	
			}
		});
	}
	$(function() {
		$("#btn_submit").click(function(e) {
			var data = $("#search").serialize();//kind=id&name=검색어
			$.ajax({
				url : "memberSerach.do",
				data : data,
				method : 'get',
				dataType:'json',
				success : function(d) {
					console.log(d);
					var arr = d.result;
					console.log(arr);
					var result = "<table>";
					for(i=0;i<arr.length;i++){
						//한건당 한줄씩 표현
						result += 
						"<tr><td>"+arr[i].id+"<input type='hidden' name='id' value='"+arr[i].id+"'></td>"
						+"<td><input type='text' name='name' value='"+arr[i].name+"'></td>"
						+"<td><input type='text' name='age' value='"+arr[i].age+"'></td>"
						+"<td><input type='text' name='grade' value='"+arr[i].grade+"'></td>"
						+"<td><a href='#' class='update'>수정</a> / <a href='#' class='delete'>삭제</a></td></tr>";
					}
					arr += "</table>";
					$("#content_area").html(result);
					//동적엘리먼트에 대한 이벤트 처리
					$(".update").click(function() {
						update_member($(this));
					});			
					$(".delete").click(function() {
						delete_member($(this));
					});			
				}
			});
			e.preventDefault();	
		});
		$(".update").click(function() {
			update_member($(this));
		});
		$(".delete").click(function() {
			delete_member($(this));
		});
	});	
</script>
</head>
<body>
	
	<c:if test="${sessionScope.login == null || sessionScope.grade != 'master' }">
				<script>
					alert("권한이 없습니다. 로그인 후 이용해 주세요");
					location.href="loginView.do";
				</script>
	</c:if>
	
	<jsp:include page="template/header.jsp"></jsp:include>
	
	<div class="container">
		<div id="menu_bar">
			<form id="search">
				<select name="kind">
					<option value="id">아이디</option>
					<option value="name">이름</option>
					<option value="grade">등급</option>
				</select>
				<input type="text" name="search">
				<button id="btn_submit">검색</button>
			</form>
		</div>
		<hr>
		<div id="content">
			<ul id="title">
				<li>아이디</li>
				<li>이름</li>
				<li>나이</li>
				<li>등급</li>
				<li>비고</li>
			</ul>
			<hr>
			<div id="content_area">
				<table>
				<c:forEach var="member" items="${requestScope.list }">
					<tr> 
							<td>${member.id }
							<input type="hidden" name="id" value="${member.id }"></td>
							<td><input type="text" name="name" value="${member.name }"></td>
							<td><input type="text" name="age" value="${member.age }"></td>
							<td><input type="text" name="grade" value="${member.grade }"></td>
							<td>
								<a href="#" class="update">수정</a> / <a href="#" class="delete">삭제</a>  
							</td>
						</tr>
				</c:forEach>
				
				</table>
			</div>
		</div>
		
	</div>
			
	<jsp:include page="template/footer.jsp"></jsp:include>
</body>
</html>








