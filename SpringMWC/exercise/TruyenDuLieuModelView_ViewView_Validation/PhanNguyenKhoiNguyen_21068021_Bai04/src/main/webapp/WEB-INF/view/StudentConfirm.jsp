<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
.lable {
	font-weight: bold;
}

li {
	list-style-type: none;
}
</style>
<body>
	<h1>STUDENT INFORMATION</h1>
	<table border="1">
		<tr>
			<td class='lable'>First Name</td>
			<td>${student.firstName}</td>
		</tr>

		<tr>
			<td class='lable'>Last Name</td>
			<td>${student.lastName}</td>
		</tr>

		<tr>
			<td class='lable'>Country</td>
			<td>${student.country}</td>
		</tr>

		<tr>
			<td class='lable'>Favorite Language</td>
			<td>${student.favoriteLanguage}</td>
		</tr>

		<tr>
			<td class='lable'>Operating Systems</td>
			<td><c:forEach var="tempOS" items="${student.operatingSystems}">
					<li>${tempOS}</li>
				</c:forEach></td>
		</tr>

		<tr>
		   <a href="${pageContext.request.contextPath}/student/showStudentForm">Back to student form</a>
	    </tr>
	</table>

</body>
</html>