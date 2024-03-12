<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function cart_view() {
		location.href="/02_login/CartController2";
	}
	function cart_clear() {
		location.href="/02_login/CartController3";
	}
</script>
</head>
<body>
	<h2>장바구니</h2>
	<form action="/02_login/CartController1" method="post">
		<select name="fruits">
			<option>:: 선택하세요 ::</option>
			<option>딸기</option>
			<option>키위</option>
			<option>망고</option>
			<option>참외</option>
			<option>수박</option>
		</select>
		<input type="submit" value="장바구니에 추가">
	</form>
	<hr>
	<button onclick="cart_view()">장바구니 보기</button>
	<button onclick="cart_clear()">장바구니 비우기</button>
</body>
</html>