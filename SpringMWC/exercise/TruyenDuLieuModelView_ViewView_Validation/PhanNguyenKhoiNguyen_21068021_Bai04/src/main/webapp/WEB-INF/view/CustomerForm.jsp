<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.error {
	color: red;
}
</style>
</head>
<body>

   <h1>CUSTOMER FORM</h1>
   <form:form action="processCustomer" modelAttribute="customer">
   <table>
        <tr>
			<td>First Name</td>
			<td>
			   <form:input path="firstName"/> 
			   <form:errors path="firstName" cssClass="error"/>
			</td>
		</tr>
		
		<tr>
			<td>Last Name (*)</td>
			<td><form:input path="lastName"/>
			   <form:errors path="lastName" cssClass="error"/></td>
		</tr>
		
		<tr>
			<td>Free passes</td>
			<td><form:input path="freePasses"/><form:errors path="freePasses" cssClass="error"/></td>
		</tr>
		
		<tr>
			<td>Postal Code</td>
			<td><form:input path="postalCode"/><form:errors path="postalCode" cssClass="error"/></td>
		</tr>
		
		<tr>
			<td>Course Code</td>
			<td><form:input path="courseCode"/><form:errors path="courseCode" cssClass="error"/></td>
		</tr>
		
		<tr>
			<td colspan="2"><input type="submit" value="Submit"></td>
		</tr>
   
   
   </table>
   </form:form>

</body>
</html>