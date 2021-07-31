<%@page import="servlet.model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    	MemberVO vo =(MemberVO)session.getAttribute("vo");
    	if(vo==null){//로그인 하지 않고 이곳으로 바로 접속했다면.. vo정보가 없을 것이다
 
    %>
    	<h3> 로그인 부터 하세요 </h3>
    	<a href = "Login.html"><b>login.html</b></a>
    <%	
    	}
    %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Login Information....</h2>
LOGIN ID : <b><%= vo.getId()%></b><br>
LOGIN NAME : <b><%= vo.getName()%></b><br>
LOGIN ADDRESS : <b><%= vo.getAddress()%></b><br>
LOGIN JSESSION : <b><%= session.getId()%></b><br>
<hr>
<a href ="logout.jsp"> LOG OUT</a> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<a href ="index.html"> HOME... INDEX... </a>
</body>
</html>










