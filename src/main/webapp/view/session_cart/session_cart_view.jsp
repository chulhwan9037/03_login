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
	<h2>장바구니보기</h2>
	<h3>
		<c:choose>
			<c:when test="${empty list}">
				<span>장바구니에 상품이 존재하지 않습니다.</span>
			</c:when>
			<c:otherwise>
				<c:forEach var="k" items="${list }">
					<li>${k }</li>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</h3>
</body>
</html>