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
    <h1>EDIT EMPLOYEE</h1>
	<form:form method="post" action="editEmployee" modelAttribute="edit">
		<table>
		   <tr>
				<td>ID</td>
				<td><form:input path="id" value="${employee.id}"/></td>
			</tr>
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
			   <td colspan="2"> <input type="submit" value="EDIT"/>  </td>
			</tr>
		</table>

	</form:form>


</body>
</html>