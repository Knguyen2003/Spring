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
			    <div class="book">
			        <p>${bookDetail.title}</p>
			        <img src="${pageContext.request.contextPath}/resources/images/${bookDetail.image}" width="100" height="100">
			        <p>Price: ${bookDetail.price}</p>
			        <p>Quantity: ${bookDetail.soLuongTon}</p>
			        <p><a href="${pageContext.request.contextPath}/BookDetailController?action=quayLai">Back to Product List</a></p>
			    </div>
			    
		</div>

	</div>

</body>
</html>