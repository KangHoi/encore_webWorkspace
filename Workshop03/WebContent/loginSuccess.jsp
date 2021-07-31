<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3><b><%= request.getParameter("id") %>님이 로그인되었습니다!!!</b></h3>
	<b>ID</b> <%= request.getParameter("id") %><br>
	<b>PASSWORD</b> <%= request.getParameter("password") %><br>
	<b>NAME</b> <%= request.getParameter("name") %><br>
	<b>ADDRESS</b> <%= request.getParameter("address") %><br><br>
	<a href="#">도서 등록</a><br>
	<a href="login.html">로그아웃</a>
</body>
</html>