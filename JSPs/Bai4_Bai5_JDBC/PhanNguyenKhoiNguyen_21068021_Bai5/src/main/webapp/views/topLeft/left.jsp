<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

.left {
	display: flex;
	flex-direction: column;
	margin-bottom: 20px;
}


#left {
	width: 30%;
	height: 150px;
	margin-right: 20px;
}

.left * {
	margin: 10px;
}

input {
	border-radius: 5px;
	height: 20px;
	
}
.shoppingCart {
   margin-left: 12px;
   text-decoration: underline;
}
</style>
</head>
<body>

		<div id="left">
			<div class="left" style = "margin-bottom: 20px;background-color:#d3d3d3;">
				<span style = "font-size: 20px; color:gray" >ABOUT US</span> 
				<span>About us information will be here.... </span>
			</div>
			 <div class="left"  >
				<span style = "font-size: 20px; color:gray">SEARCH SITE</span> 
				<input type="text" />
				
			</div>
			<c:if test="${sLuong > 0}">
					<a class="shoppingCart" href="${pageContext.request.contextPath}/CartController?action=save">Shopping cart (${sLuong})</a>
			</c:if>
		</div>


</body>
</html>