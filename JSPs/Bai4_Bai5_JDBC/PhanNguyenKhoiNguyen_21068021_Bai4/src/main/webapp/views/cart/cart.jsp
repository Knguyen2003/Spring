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
		<header>GIỎ HÀNG</header>
		<table border="1">
			<thead>
				<tr>
					<th>XÓA</th>
					<th>ID</th>
					<th>TÊN SẢN PHẨM</th>
					<th>ẢNH</th>
					<th>GIÁ SẢN PHẨM</th>
					<th>SỐ LƯỢNG</th>
					<th>THÀNH TIỀN</th>
				</tr>
			</thead>
			<c:set var="total" value="0"></c:set>
			<c:forEach items="${sessionScope.cart}" var="item">
				<c:set var="total"
					value="${total + item.product.price * item.quanlity}"></c:set>
				<tr>
					<td><a
						href="${pageContext.request.contextPath}/CartController?action=remove&id=${item.product.id}">Remove</a></td>
					<td>${item.product.id}</td>
					<td>${item.product.name}</td>
					<td><img
						src="${pageContext.request.contextPath}/resources/images/${item.product.image}"
						width="100px" height="100px"></td>
					<td>${item.product.price}</td>
					<td>${item.quanlity}</td>
					<td>${item.product.price * item.quanlity }</td>
				</tr>
			</c:forEach>
		</table>
		<div>
		     <a href="${pageContext.request.contextPath}/CartController?action=checkout">Quay về trang chủ</a>
			<h3>Tổng số lượng: ${total}</h3>
		</div>
	</div>
</body>
</html>