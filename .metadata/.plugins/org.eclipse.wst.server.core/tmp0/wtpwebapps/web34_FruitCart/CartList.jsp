<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
	$(function(){
		

		function refreshPage(){
			var int totalPrice=0;
		
			for(var key in localStorage){
			//alert(key);
			if(item ='length') break;
			
			var data = localStorage.getItem(${item.number}).split(",");
			html +='<tr><td>'+localStorage.length+'</td>'
					+'<td><img class=picture src='+data[4]+'></td>'
					+'<td>'+data[1]+'</td>'
					+'<td>'+data[2]+'</td>'
					+'<td>'+$('#updown')+'</td>'
					+'<td>'+$('#check')+'</td></tr>';
				totalPrice += parseInt(data[2] * $('input[name=quantity]'))
					
		}
			$('#content').html(html);
			$('#price').html("총 결제 금액 :"+totalPrice)
	}
	
	
		$('#up').click(funtion(){
			var amount = $('input[name=quantity]').val();
			amount ++;	
		});
		$('#down').click(funtion(){
			var amount = $('input[name=quantity]').val();
			amount ++;	
		});
			


	}); //function	
</script>
</head>
<body>
	<article class="main">
	<section>
	<h2 align="center"> 장바구니 </h2>
	<h6><a href="itemList.do">쇼핑계속하기</a></h6>

	<table align="center" border="1" width=80%>
	<thead>
		<tr bgcolor="orange">
			<th width="10%"> 번호 </th>
			<th width="30%"> 상품 이미지 </th>
			<th width="20%"> 상품명 </th>
			<th width="20%"> 상품가격 </th>
			<th width="10%"> 수량 </th>
			<th width="10%"> <input type=submit value="삭제" align="center"> </th>
		</tr>
	</thead>
		<tbody id="content">
	
		</tbody>
	</table>
	</section>
	<section class="totalPrice" id="price">
	</section>

	<div id="updown" >
		<button id="up" ><img src="./img/up.jpg" width=10px></image></button><br>
		<input type="text" name="quantity" value="1" readonly="readonly" style="text-align center"  width=10px><br>
		<button id="down"><img src="./img/down.jpg" width=10px></image></button>
	</div>
	 
	  <div class="check">
	  	<input type="checkbox" name="delete" value="260" >
	  </div>
	  </section>
	 </article>
</body>
</html>