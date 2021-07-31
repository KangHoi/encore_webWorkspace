<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>ConnectionPool... DataSource Test</h2>
<%
	Connection conn = null;
	//1. Naming Service를 통해 DataSource(type)를 찾아온다
	//2. javax.naming.Context의 lookup() 기능이 이때 사용되어진다.

	Context ic = new InitialContext();
	DataSource ds = (DataSource)ic.lookup("java:comp/env/jdbc/mysql");//외부이름접근법
	out.println("<b>DataSource Lookup...<br>");
	
	conn = ds.getConnection();
	out.println("Connection... Ok... Return</b>");
%>
</body>
</html>