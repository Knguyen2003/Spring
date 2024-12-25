<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
body {
	padding: 50px;
}

img.anh {
	width: 100%;
	height: 250px;
}

header {
	border: 1px solid blue;
	text-align: center;
}

#center {
	display: flex;
	border-left: 1px solid blue;
	border-right: 1px solid blue;
	height: 500px;
	justify-content: center;
	align-items: center;
}

#menu a {
	width: 100%;
	font-size: 30px;
	margin: 10px 20px;
}

#menu {
	border-top: 1px solid blue;
	padding: 10px;
}

footer {
	border: 1px solid blue;
	text-align: center;
}

h3 {
	font-size: 30px;
}

table {
	width: 100%;
	font-size: 25px;
}

#formView {
	border: 1px solid black;
	width: 50%;
}

form {
	display: flex;
	flex-direction: column;
	padding: 20px;
}

form input {
	height: 30px;
}
form label {
	font-size: 20px;
}
</style>
</head>
<body>
	<header>
		<img alt="lỖI"
			src="${pageContext.request.contextPath}/sources/images/header.PNG"
			class="anh" />
		<div id="menu">
			<a href="${pageContext.request.contextPath}/DienThoaiController?action=showSP">Danh sách sản phẩm</a>| 
			<a href="${pageContext.request.contextPath}/DienThoaiController?action=moveAddSP">Thêm mới sản phẩm</a>| 
		    <a href="${pageContext.request.contextPath}/DienThoaiController?action=quanLi">Chức năng quản lý</a>
		</div>
	</header>

	<div id="center">
		<div id="formView">
			<form
				action="${pageContext.request.contextPath}/DienThoaiController?action=addSP"
				method="post">
				<h2>Thêm mới sản phẩm</h2>
				<label for="tenDienThoai">Tên điện thoại:</label> <input type="text"
					name="tenDienThoai" id="tenDienThoai" required><br> <label
					for="namSanXuat">Năm sản xuất:</label> <input type="text"
					name="namSanXuat" id="namSanXuat" required><br> <label
					for="cauHinh">Cấu hình:</label> 
					<input type="text" name="cauHinh" id="cauHinh" required><br> <label for="maNhaCungCap">Mã
					nhà cung cấp:</label> <input type="text" name="maNhaCungCap"
					id="maNhaCungCap" required><br>

				<div id="buttonView">
					<input type="submit" value="Thêm mới"> <input type="button"
						value="Thoát">
				</div>
			</form>



		</div>
	</div>
	<footer>
		<h3>Phan Nguyễn Khôi Nguyên - 21068021 - DHKTPM17C</h3>
	</footer>

	<c:if test="${not empty message}">
		<script>
			alert("${message}");
		</script>
	</c:if>
</body>
</html>