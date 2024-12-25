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

#center {
	margin: 10px;
	display: flex;
	justify-content: space-between;
	width: 100%;
}

#right {
	width: 70%;
	display: flex;
	flex-direction: column;
}

#cart {
	display: flex;
	justify-content: center;
}

.book {
	border: 1px solid #d3d3d3;
	width: 240px;
	height: 320px;
	text-align: center;
}

table {
	width: 90%;
	border-collapse: collapse;
	margin-bottom: 20px;
}

th, td {
	border: 1px solid black;
	padding: 8px;
	text-align: left;
}

th {
	background-color: #f2f2f2;
}



#button_footer button {
	padding: 10px;
	margin: 10px;
}

#button_footer {
	display: flex;
	justify-content: center;
	align-items: center;
	justify-content: center;
}

.tdDesign {
	display: flex;
	align-items: center;
	justify-content: flex-start;
	background-color: #f2f2f2;
}


</style>
</head>
<body>
    <jsp:include page="/views/topLeft/header.jsp" />
	<div id="center">
		<jsp:include page="/views/topLeft/left.jsp" />

        
		<div id="right">
			
			<form method="post" action="${pageContext.request.contextPath}/CartController?action=luu">
			<table>
			    <div id = "cart"><h2>Checkout- Already registered</h2></div>
				<tr>
					<td>Fullname: </td>
					<td><input type="text" name="fullname" /></td>
				</tr>
				<tr>
					<td>Shipping address:</td>
					<td><input type="text" name="address"/></td>
				</tr>
				<tr>
					<td>Total price:</td>
					<td><input type="number" name="totalPrice" readonly value="${tongTien}"/></td>
				</tr>
				<tr>
					<td>Payment method:</td>
					<td class="tdDesign">
					     <input type="radio" name="paymentMethod" value="Paypal" required /> Paypal
						 <input type="radio" name="paymentMethod" value="ATM Debit" />ATM Debit
						 <input type="radio" name="paymentMethod" value="Visa/Master card" />Visa/Master card
					</td>
				</tr>
				<tr class="total-row">
					<td colspan="2">
						<div id="button_footer">
							 <button type="submit">Save</button>
							<button type="button"
								onclick="window.location.href='${pageContext.request.contextPath}/CartController?action=continue'">Cancel</button>
						</div>
					</td>

				</tr>

			</table>
            </form>
            
           
			
		</div>

	</div>
    
   

</body>
</html>