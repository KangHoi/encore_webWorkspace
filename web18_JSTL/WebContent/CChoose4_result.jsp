<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:choose>
	<c:when test="${param.num=='1'}">
		그럭저럭 지냅니다.
	</c:when>
	<c:when test="${param.num=='2'}">
		네. 잘 지내고 있어요.
	</c:when>
	<c:otherwise>
		멋진 시간을 보내고 있습니다.
	</c:otherwise>

</c:choose>
</body>
</html>