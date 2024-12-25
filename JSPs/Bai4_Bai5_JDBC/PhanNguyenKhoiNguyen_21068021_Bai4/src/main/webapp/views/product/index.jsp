<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<header>DANH SÁCH SẢN PHẨM</header>
		<table border="1">
		    <thead>
			<tr>
				<th>ID</th>
				<th>TÊN SẢN PHẨM</th>
				<th>ẢNH</th>
				<th>GIÁ SẢN PHẨM</th>
				<th>MUA</th>
			</tr>
			</thead>
			<c:forEach items="${products}" var="product">
				<tr>
					<td>${product.id}</td>
					<td>${product.name}</td>
					<td><img src="${pageContext.request.contextPath}/resources/images/${product.image}" width="100px" height="100px"></td>
					<td>${product.price}</td>
					<td><a href="${pageContext.request.contextPath}/CartController?action=buy&id=${product.id}">Mua</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>