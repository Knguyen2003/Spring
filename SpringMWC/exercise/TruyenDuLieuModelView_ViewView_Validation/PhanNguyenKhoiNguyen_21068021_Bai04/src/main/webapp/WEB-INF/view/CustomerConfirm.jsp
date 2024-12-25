<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.lable {
	font-weight: bold;
}
</style>
</head>
<body>
   <h1>CUSTOMER INFORMATION</h1>
	<table border="1">
		<tr>
			<td class='lable'>First Name</td>
			<td>${customer.firstName}</td>
		</tr>

		<tr>
			<td class='lable'>Last Name</td>
			<td>${customer.lastName}</td>
		</tr>

		<tr>
			<td class='lable'>Pree passes</td>
			<td>${customer.freePasses}</td>
		</tr>

		<tr>
			<td class='lable'>Postal Code</td>
			<td>${customer.postalCode}</td>
		</tr>

		<tr>
			<td class='lable'>Course Code</td>
			<td>${customer.courseCode}</td>
		</tr>

		<tr>
		   <td colspan="2"><a href="${pageContext.request.contextPath}/customer/showCustomerForm">Back to customer form</a></td>
	    </tr>
	</table>

</body>
</html>