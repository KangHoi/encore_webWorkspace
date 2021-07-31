<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3><b><%= request.getParameter("error") %> 이미 존재하는 회원입니다.</b></h3>
	<a href="register.html">되돌아가기</a>
</body>
</html>