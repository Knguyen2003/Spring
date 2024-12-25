<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FORM ADD EMPLOYEE</title>
</head>
<body>
    <h1>ADD EMPLOYEE</h1>
	<form:form method="post" action="addEmployee" modelAttribute="employee">
		<table>
			<tr>
				<td>Name</td>
				<td><form:input path="name" /></td>
			</tr>
			<tr>
				<td>Salary</td>
				<td><form:input path="salary" /></td>
			</tr>

			<tr>
				<td>Designation</td>
				<td><form:input path="designation" /></td>
			</tr>
			<tr>
			   <td colspan="2"> <input type="submit" value="ADD"/>  </td>
			</tr>
		</table>

	</form:form>


</body>
</html>