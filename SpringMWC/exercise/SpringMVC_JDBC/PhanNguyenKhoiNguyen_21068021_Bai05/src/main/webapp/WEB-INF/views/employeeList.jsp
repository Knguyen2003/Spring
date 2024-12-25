<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <h1>EMPLOYEE LIST</h1>
	<table border="1">
		<tr>
			<th>ID</th>
			<th>NAME</th>
			<th>SALARY</th>
			<th>DESIGNATION</th>
			<th>EDIT</th>
			<th>DELETE</th>
		</tr>
		<c:forEach var="emp" items="${employeeList}">
			<tr>
				<td>${emp.id}</td>
				<td>${emp.name}</td>
				<td>${emp.salary}</td>
				<td>${emp.designation}</td>
				<td><a href="showFormEdit/${emp.id}">EDIT</a></td>
				<td><a href="deleteEmployee/${emp.id}">REMOVE</a></td>
			</tr>
		</c:forEach>
	</table>
	<br>
	<a href="showFormAdd">ADD EMPLOYEE</a>
</body>
</html>