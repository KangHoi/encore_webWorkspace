<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<b>1. JSP 기본 element로 폼값 받아오기</b> <br>
<%= request.getParameter("userId") %>
<hr>

<b>2. EL로 폼값 받아오기 </b> <br>
ID ${param.userId}

<b>1. JSP 기본 element로 checkbox 폼값 받아오기</b> <br>
<%
String[] menus = request.getParameterValues("menu");
for(String menu: menus){
%>
<%=menu %>
<% 
}
%>
<hr>
<b>2. EL로 checkbox 폼값 받아오기</b><br>
선택한 메뉴:: <br>
${paramValues.menu[0]}
${paramValues.menu[1]}
${paramValues.menu[2]}
${paramValues.menu[3]}


</body>
</html>