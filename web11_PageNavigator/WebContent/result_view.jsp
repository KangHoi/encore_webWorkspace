<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- html주석 -->
    <%-- Servlet주석
    바인딩 된 객체를 받아와서... request.getAttribute()... 자바코드...%%
    정보 출력하는 로직 작성 --%>
    
    <%
    String id = (String)request.getAttribute("id");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>조회한 id님의 정보입니다.</h2>
이름 : 강호이<BR>
아이디 : <%= id %> <BR>
주소 : 여의도 <BR>
</body>
</html>