<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

</head>
<body>

	<form action="StudentSevlet" method="post">

		<label>First name</label> <input type="text" name="txtFirstName"
			maxlength="30" placeholder="(max 30 characters a-z and A-z)">
		<br> <br> <label>Last name</label> <input type="text"
			name="txtLastName" maxlength="30"
			placeholder="(max 30 characters a-z and A-z)"><br> <br>
		<label>Date of birth</label> <select id="ngay" name="day">
			<script>
                for (var i = 1; i <= 31; i++) {
                    document.write("<option value='" + i + "'>" + i + "</option>");
                }
             </script>
		</select> <select id="thang" name="month">
			<option value="01">1</option>
			<option value="02">2</option>
			<option value="03">3</option>
			<option value="04">4</option>
			<option value="05">5</option>
			<option value="06">6</option>
			<option value="07">7</option>
			<option value="08">8</option>
			<option value="09">9</option>
			<option value="10">10</option>
			<option value="11">11</option>
			<option value="12">12</option>
		</select> <select id="name" name="year">
			<option value="2003">2003</option>
			<option value="2004">2004</option>
			<option value="2005">2005</option>
			<option value="2006">2006</option>
		</select><br> <br> <label>Email</label> <input type="text"
			name="txtEmail" maxlength="30"><br> <br> <label>Mobile
			number</label> <input type="text" name="txtPhone" maxlength="30"
			placeholder="(10 digit number)"><br> <br> <label>Gender</label>
		<label><input type="radio" name="gioitinh" value="nam"
			checked="checked">Nam</label> <label><input type="radio"
			name="gioitinh" value="nu">Nu</label><br> <br> <label>Address</label>
		<textarea rows="4" cols="20" name="txtAddress"></textarea>
		<br> <br> <label>City</label> <input type="text"
			name="txtCity" maxlength="30"
			placeholder="(max 30 characters a-z and A-z)"><br> <br>
		<label>Pin code</label> <input type="text" name="txtPincode"
			maxlength="6" placeholder="(6 dgit number)"><br> <br>
		<label>State</label> <input type="text" name="txtState" maxlength="30"
			placeholder="(max 30 characters a-z and A-z)"><br> <br>
		<label>Country</label> <input type="text" name="txtCountry"
			maxlength="30"><br> <br> <label>Hobibies</label> <label><input
			type="checkbox" name="hobbies" value="Drawing">Drawing</label> <label><input
			type="checkbox" name="hobbies" value="Singing">Singing</label> <label><input
			type="checkbox" name="hobbies" value="Dancing">Dancing</label> <label><input
			type="checkbox" name="hobbies" value="Sketching">Sketching</label> <label><input
			type="checkbox" name="hobbies" value="Others">Others</label> <input
			type="text" name="other" maxlength="30"> <br> <br>
		<table>
			<thead>
				<tr>
					<th>Sl.No.</th>
					<th>Examination</th>
					<th>Board</th>
					<th>Percentage</th>
					<th>Year of Passing</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>1</td>
					<td>Class X</td>
					<td><input type="text" maxlength="10" name="board1"></td>
					<td><input type="text" maxlength="5" name= "percentage1"></td>
					<td><input type="text" maxlength="4" name= "year1"></td>
				</tr>
				<tr>
					<td>2</td>
					<td>Class XII</td>
					<td><input type="text" maxlength="10" name="board2"></td>
					<td><input type="text" maxlength="5" name= "percentage2"></td>
					<td><input type="text" maxlength="4" name= "year2"></td>
				</tr>
				<tr>
					<td>3</td>
					<td>Graduation</td>
					<td><input type="text" maxlength="10" name="board3"></td>
					<td><input type="text" maxlength="5" name= "percentage3"></td>
					<td><input type="text" maxlength="4" name= "year3"></td>
				</tr>
				<tr>
					<td>4</td>
					<td>Masters</td>
					<td><input type="text" maxlength="10" name="board4"></td>
					<td><input type="text" maxlength="5" name= "percentage4"></td>
					<td><input type="text" maxlength="4" name= "year4"></td>
				</tr>
			</tbody>
		</table>

		<br> <br> <label>Course applies for</label> <label><input
			type="radio" name="course" value="BCA" >BCA</label> <label><input
			type="radio" name="course" value="Com">Com</label> <label><input
			type="radio" name="course" value="B.SC" required>B.SC</label> <label><input
			type="radio" name="course" value="B.A">B.A</label><br> <br>
		<input type="submit" value="Submit"> <input type="reset"
			value="Reset">

	</form>


</body>
</html>