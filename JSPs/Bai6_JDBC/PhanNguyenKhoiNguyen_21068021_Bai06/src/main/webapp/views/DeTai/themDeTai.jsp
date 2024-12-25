<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thêm đề tài</title>
<style type="text/css">
.form-container {
	width: 300px;
	margin: 0 auto;
	padding: 20px;
	border: 1px solid #ccc;
}

.form-group {
	margin-bottom: 15px;
}

label {
	display: block;
	font-weight: bold;
	margin-bottom: 5px;
	color: #333;
}

.form-group input{
	width: 100%;
	padding: 10px;
	border: 1px solid #ccc;
	border-radius: 5px;
	box-sizing: border-box;
}

.form-group input:focus {
	border-color: #5b9bd5;
	outline: none;
}

.form-center input{
	padding: 10px 30px;
	margin-left: 10px;
	background-color: #008CBA;
	color: white;
	border: none;
}

.form-center {
	display: flex;
	justify-content: center;
}
</style>
</head>
<body>
	<div class="form-container">
		<div class="form-center">
			<h2>THÊM ĐỀ TÀI</h2>
		</div>
		<form action="${pageContext.request.contextPath}/DeTaiController?action=addDT" method="post">
			<div class="form-group">
				<label for="maDT">Mã đề tài</label> 
				<input type="text" id="maDT" name="maDT">
			</div>
			<div class="form-group">
				<label for="tenDT">Tên đề tài</label> 
				<input type="text" id="tenDT" name="tenDT">
			</div>
			<div class="form-group">
				<label for="nam">Năm đăng kí</label> 
				<input type="number" id="nam" name="nam">
			</div>
			<div class="form-group">
				<label for="moTa">Mô tả đề tài</label> 
				<input type="text" id="moTa" name="moTa">
			</div>
			<div class="form-group">
				<label for="maGV">Mã giảng viên</label> 
				<input type="text" id="maGV" name="maGV">
			</div>
			<div class="form-center">
				<input type="submit" value="Thêm"> 
				<input type="button" value="Quay Lại" onclick="window.location.href='${pageContext.request.contextPath}/GiangVienController?action=chuyenHome'">
			</div>
		</form>

	</div>
	
	<% 
		String message = (String) request.getAttribute("message");
		if (message != null) { 
	%>
		<script type="text/javascript">
			alert("<%= message %>");
		</script>
	<% 
		}
	%>

</body>
</html>