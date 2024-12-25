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
	height: 150px;
	display: flex;
	flex-wrap: wrap;
	gap: 20px;
}

.book {
	border: 1px solid #d3d3d3;
	width: 200px;
	height: 320px;
	text-align: center;
}
</style>
</head>

<body>
	<jsp:include page="/views/topLeft/header.jsp" />
	<div id = "center">
		<jsp:include page="/views/topLeft/left.jsp" />

		<div id ="right" >
			<c:forEach items="${books}" var="book"> 
			    <div class="book">
			        <p>${book.title}</p>
			        <img src="${pageContext.request.contextPath}/resources/images/${book.image}" width="100" height="100">
			        <p>Price: ${book.price}</p>
			        <p>Quantity: ${book.soLuongTon}</p>
			        <p><a href="${pageContext.request.contextPath}/BookDetailController?action=details&id=${book.id}">Product Details</a> </p>
			        <p><a href="${pageContext.request.contextPath}/CartController?action=addCart&id=${book.id}">Add to cart</a> </p>
			    </div>
				
		     </c:forEach>
		
		</div>
		<c:if test="${not empty message}">
                <script>
                    alert('${message}');
                </script>
       </c:if>

	</div>

</body>
</html>