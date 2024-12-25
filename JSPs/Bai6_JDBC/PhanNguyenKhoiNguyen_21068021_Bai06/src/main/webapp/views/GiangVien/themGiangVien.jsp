<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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

input[type="text"] {
	width: 100%;
	padding: 10px;
	border: 1px solid #ccc;
	border-radius: 5px;
	box-sizing: border-box;
}

input[type="text"]:focus {
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
	<div class="form-center"><h2>THÊM GIẢNG VIÊN</h2> </div>	
    <form action="${pageContext.request.contextPath}/GiangVienController?action=addGV"  method="post">
        <div class="form-group">
            <label for="maGV">Mã giảng viên</label>
            <input type="text" id="maGV" name="maGV">
        </div>
        <div class="form-group">
            <label for="tenGV">Tên giảng viên</label>
            <input type="text" id="tenGV" name="tenGV">
        </div>
        <div class="form-group">
            <label for="linhVuc">Lĩnh vực nghiên cứu</label>
            <input type="text" id="linhVuc" name="linhVuc">
        </div>
        <div class="form-group">
            <label for="soDT">Số điện thoại</label>
            <input type="text" id="soDT" name="soDT">
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