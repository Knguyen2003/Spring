<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <form:form action="processStudent"   modelAttribute="student">
       <table>
			<tr>
				<td>First name</td>
				<td><form:input path="firstName" /></td>
			</tr>
			
			<tr>
				<td>Last name</td>
				<td><form:input path="lastName" /></td>
			</tr>
			
			<tr>
				<td>Country</td>
				<td>
				   <form:select path="country">
						 <form:options items= "${student.countryOptions}"/> 
				  </form:select>
				</td>
			</tr>
			
			<tr>
			   <td>Favorite Language</td>
			   <td> <form:radiobuttons path="favoriteLanguage" items="${student.favoriteLanguageOptions}"/></td>
			</tr>

			<tr>
				<td>Operating System</td>
				<td>
				   <form:checkboxes path="operatingSystems" items="${student.operatingSystemOptions}" />
				</td>
		    </tr>
		    
		    <tr>
		      <td colspan="2"><input type="submit" value="Confirm"/></td>
		    </tr>
		    
		</table>
   </form:form>
   

</body>
</html>