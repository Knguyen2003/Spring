<%@ page import="entity.Student" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	Student svt = new Student();
	svt = (Student) request.getAttribute("student");
	out.println(svt.toString());
	%>

</body>
</html>