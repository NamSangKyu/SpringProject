<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문의하기</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<style type="text/css">
	#container{
		width:1200px;
		margin:20px auto;
	}
	#qna_form{
		width:650px;
		margin:0 auto;
	}
	#qna_form table{
		border-collapse: collapse;
		box-sizing: border-box;
		width:100%;
	}
	#qna_form td{
		padding:5px;
	}
	#qna_form table tr td:first-child{
		width:500px;
		height: 40px;
	}
	#qna_form table tr:nth-child(2){
		height: 100px;
	}
	#qna_form input, #qna_form textarea{
		width:100%;
		height: 100%;
		border-radius: 5px;
		box-sizing: border-box;
	} 
	 #qna_form textarea{
	 	padding:5px;
	 	resize: none;
	 }
	 
	 button{
	 	width: 100%;
	 	height: 140px;
	 }
	 
	 .qna_title ul{
	 	font-size: 0px;
	 	padding:0;
	 }
	 .qna_title li{
	 	display: inline-block;
	 	font-size: 16px;
	 	margin-right:50px;
	 	box-sizing: border-box;
	 }
	 #btn_more{
	 	width: 100%;
	 	border:none;
	 	border-radius:5px;	 
	 	height: 50px;
	 	font-size:18px;	
	 }
</style>
  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script>
	var pageNo = 1;//전역변수
	$(function(){
		$("#qna_list").accordion();
		$("#btn_more").click(function(){
			pageNo++;
			$.ajax({
				url:"nextQnaList.do",
				data : "pageNo="+pageNo,
				method:"get",
				success:function(result){
					alert(result);
					var json = JSON.parse(result);
					if(json.nextPage == "0"){
						$("#btn_more").off("click");
						$("#btn_more").text("더 이상 불러올 내용이 없습니다.");
					}
					arr = json.list;
					tag = "";
					//반복문 이용해서 qna_list 부분에 append로 추가	
					alert(arr.length);
					for(i=0;i<arr.length;i++){
						tag += "<h3 class='qna_title'><ul>";
						tag += "<li>제목 : "+arr[i].title+"</li>";
						tag += "<li>작성자 : "+arr[i].writer+"</li>";
						tag += "<li>작성일 : "+arr[i].date+"</li>";
						switch(arr[i].status){
						case "0":
							tag += "<li>않읽음</li>";
							break;
						case "1":
							tag += "<li>읽음</li>";
							break;
						case "2":
							tag += "<li>답변완료</li>";
							break;
						}
						tag += "</ul></h3><div>";
						tag += "<p class='qna_content'>"+arr[i].content+"</p>";
						tag += "<p class='qna_response'>"+arr[i].response+"</p></div>";
					}
					$("#qna_list").append(tag);
					$("#qna_list").accordion("refresh");
				}
			});
		});
	});
</script>
</head>
<body>
	<jsp:include page="template/header.jsp"></jsp:include>
	<div id="container">
		<div id="qna_form">
			<form action="sendQnA.do">
				<table>
					<tr>
						<td><input type="text" name="title" placeholder="제목을 입력하세요"></td>
						<td rowspan="2"><button>작성완료</button></td>
					</tr>
					<tr>
						<td>
							<textarea name="content" placeholder="문의 내용을 입력해 주세요"></textarea>
						</td>
					</tr>
				</table>
			</form>
		</div>
		<hr>
		<div id="qna_list">
			<!-- 질문 답변 목록 -->
			<c:forEach var="dto" items="${requestScope.list }">
				<h3 class="qna_title">
					<ul>
					<li>제목 : ${dto.title }</li>
					<li>작성자 : ${dto.writer }</li>
					<li>작성일 : ${dto.date }  </li>
				<c:choose>
					<c:when test="${dto.status==0}"><li>않읽음</li></c:when>
					<c:when test="${dto.status==1}"><li>읽음</li>	</c:when>
					<c:otherwise><li>답변완료</li></c:otherwise>
				</c:choose>
					</ul>
				</h3>
				<div>
					<p class="qna_content">${dto.content }</p>
					<p class="qna_response">${dto.response }</p>
				</div>
			</c:forEach>
		</div>
		<button id="btn_more">더보기</button>
	</div>
	<jsp:include page="template/footer.jsp"></jsp:include>
</body>
</html>












