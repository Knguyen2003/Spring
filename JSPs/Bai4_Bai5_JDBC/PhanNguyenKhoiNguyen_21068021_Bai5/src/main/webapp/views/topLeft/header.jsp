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

header {
	display: flex;
	background-color: #333;
	color: #fff;
	background-color: #333;
	align-items: center;
	justify-content: space-around;
	width: 100%;
}

nav ul li {
	display: inline; /* 1 dòng */
	margin-right: 20px;
}

nav ul li a {
	color: #fff;
	text-decoration: none;
}

nav ul li a:hover {
	text-decoration: underline;
}
</style>
</head>
<body>
	<header>
		<h1>IUH BOOKSTORE</h1>
		<nav>
			<ul>
				<li><a href="index.jsp">HOME</a></li>
				<li><a href="login.jsp">EXAMPLES</a></li>
				<li><a href="register.jsp">SERVICES</a></li>
				<li><a href="contact.jsp">PRODUCTS</a></li>
				<li><a href="contact.jsp">CONTACT</a></li>
			</ul>
	</header>
</body>
</html>