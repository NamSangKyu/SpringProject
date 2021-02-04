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
</style>
  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script>
	var pageNo = 1;//전역변수
	$(function(){
		
	});
</script>
</head>
<body>
	<jsp:include page="template/header.jsp"></jsp:include>
	<div id="container">
		<table>
			<tr>
				<th>순번</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>날짜</th>
			</tr>
		<c:forEach var="dto" items="${sessionScope.list }" varStatus="status">
			<tr>
				<td>${dto.qno }</td>
				<td><a href="adminQnaDetailView.do?qno=${dto.qno}">${dto.title }</td>
				<td>${dto.writer }</td>
				<td>${dto.date }</td>
				<td>
				<c:choose>
					<c:when test="${dto.status==0}">않읽음</c:when>
					<c:when test="${dto.status==1}">읽음</c:when>
					<c:otherwise>답변완료</c:otherwise>
				</c:choose>
				</td>
			</tr>			
		</c:forEach>
			<tr>
				<td colspan="6">
					<!--
					${sessionScope.page.previousPageGroup},
					${sessionScope.page.isPreviousPageGroup()},
					${sessionScope.page.nextPageGroup},
					${sessionScope.page.isNextPageGroup()}, -->
					<c:set var="page" value="${sessionScope.page}" scope="page" />
					<c:if test="${page.previousPageGroup }">
						<a href="qnaAdminView.do?pageNo=${page.startPageOfPageGroup-1}">◀</a>
					</c:if>
					<!-- 페이지 번호 출력
						var="반복문 내부에서 사용할 변수", items="배열, Collection(List,Set)" varStatus = 반복문 상태, 속성값.count -> 현재 반복 횟수
						var, items, varStatus
						 var="반복문 내부에서 사용할 변수", begin = "시작값", end ="종료값" ,step="증감값"
						 var begin end step
					 -->
					
					<c:forEach var="i" begin="${page.startPageOfPageGroup }" end="${page.endPageOfPageGroup }" step="1">
						<a href="qnaAdminView.do?pageNo=${i }">${i}</a>					
					</c:forEach>
					<c:if test="${page.nextPageGroup }">
						<a href="qnaAdminView.do?pageNo=${page.endPageOfPageGroup+1}">▶</a>
					</c:if>
				</td>
			</tr>
		</table>
	</div>
	<jsp:include page="template/footer.jsp"></jsp:include>
</body>
</html>












