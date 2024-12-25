<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
body {
	font-family: Arial, sans-serif;
	margin: 0;
	padding: 0;
	background-color: white;
}

#center {
	margin: 10px;
	display: flex;
	justify-content: space-between;
}

#right {
	width: 70%;
	display: flex;
	flex-direction: column;
}

#cart {
	display: flex;
	justify-content: center;
}

.book {
	border: 1px solid #d3d3d3;
	width: 240px;
	height: 320px;
	text-align: center;
}

table {
	width: 100%;
	border-collapse: collapse;
	margin-bottom: 20px;
}

th, td {
	border: 1px solid black;
	padding: 8px;
	text-align: left;
}

th {
	background-color: #f2f2f2;
}

.total-row {
	text-align: right;
	background-color: #e7e7e7;
}

.total-price {
	text-align: right;
}

#button_footer button {
	padding: 10px;
}
</style>
</head>

<body>
	<jsp:include page="/views/topLeft/header.jsp" />
	<div id="center">
		<jsp:include page="/views/topLeft/left.jsp" />


		<div id="right">
			<div id = "cart"><h2>Your Shopping Cart</h2></div>
			<table>
				<tr>
					<th>Product ID</th>
					<th>Product Name</th>
					<th>Price</th>
					<th>Qty</th>
					<th>Total</th>
					<th>Remove</th>
				</tr>
				<c:forEach items="${sessionScope.cart}" var="cart">
					<c:set var="total"
						value="${total + cart.book.price * cart.quantity}" />
					<tr>
						<td>${cart.book.id}</td>
						<td>${cart.book.title}</td>
						<td>${cart.book.price}</td>
						<td>${cart.quantity}</td>
						<td>${cart.book.price * cart.quantity}</td>
						<td><a href="${pageContext.request.contextPath}/CartController?action=remove&ma=${cart.book.id}">Remove</a></td>
					</tr>
				</c:forEach>

				<tr class="total-row">
					<td colspan="4" class="total-price">Total price</td>
					<td colspan="2">(VNĐ)${total}</td>
				</tr>

			</table>
			<div id="button_footer">
			     <button type="button"
				    onclick="window.location.href='${pageContext.request.contextPath}/CartController?action=save'">Checkout</button>
			     <button type="button"
				    onclick="window.location.href='${pageContext.request.contextPath}/CartController?action=continue'">Continue Shopping</button>
			</div>
		</div>

	</div>

</body>
</html>