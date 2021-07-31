<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3 align="center">${mvo.name}님이 로그인 되었습니다!!!</h3>
	<br><br><br>
	<div align="center">
		<a href="book/Book.html">도서 등록</a>
		<a href="${pageContext.request.contextPath}/front.do?command=bookList">도서 목록 보기</a>
		<a href="logout.jsp">로그 아웃</a>
	</div>
</body>
</html>