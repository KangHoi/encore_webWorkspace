<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>


<style type="text/css">
	#wrap{
		text-align:center;
	}

</style>

</head>
<body>
	<div id="wrap">
		<h2>결과 페이지</h2><br><br>
		<h3>${bvo.title} 책이 정상적으로 저장 되었습니다.</h3><br><br>
		<a href="book/Book.html">추가 등록</a>
		<a href="${pageContext.request.contextPath}/front.do?command=bookList">도서 목록</a>	
	</div>
</body>
</html>