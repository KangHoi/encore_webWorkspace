<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	#first{ background-color: threedlightshadow;}
	*{ color:  navy;}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
$(function(){
	$('[name=cartinsert]').click(function(){
		//alert(this.itemNumber + " " + this.value);
		localStorage.setItem($(this).attr('itemNumber'),$(this).val());
	});
});//function
</script>
</head>
<body>
<h1 align="center"><b>${item.name}</b></h1>
<table align="center" width="600" id="first">
	<tr>	
		<td align="center">
			조회수 : ${item.count} &nbsp;&nbsp; &nbsp;&nbsp;<button><a href="CartList.jsp">장바구니 확인</a></button>&nbsp;&nbsp;<button name="cartinsert" value="${item.name}, ${item.price}, ${item.description}">장바구니 담기</button>
		</td>
	</tr>
</table>

<table align="center" width="600">
	<tr>	
		<td rowspan="3">
			<img class=picture alt="" src="${item.url}">
		</td>
		<td>종 류 : ${item.name}</td>
	</tr>
	<tr>			
		<td>가 격 : ${item.price}</td>
	</tr>
	<tr>		
		<td>설  명: ${item.description}</td>
	</tr>
	<tr>		
		<td colspan="2" align="center"><a href="itemList.do">상품 목록 보기</a></td>
	</tr>
</table>
</body>
</html>










