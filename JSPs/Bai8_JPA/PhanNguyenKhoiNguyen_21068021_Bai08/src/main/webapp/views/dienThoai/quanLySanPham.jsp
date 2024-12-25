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
	border-left: 1px solid blue;
	border-right: 1px solid blue;
	height: 500px;
	padding: 10px 10px;
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
		<table border="1">
		    <thead>
		       <tr>
					<th>Mã điện thoại</th>
					<th>Tên điện thoại</th>
					<th>Năm sản xuất</th>
					<th>Cấu hình</th>
					<th>Mã nhà cung cấp</th>
					<th>Xóa sản phẩm</th>
					<th>Sửa sản phẩm</th>
				</tr>
		    </thead>
		    <tbody>
		       <c:forEach var="phone" items="${DSDT}">
		             <tr>
		                 <td>${phone.maDT}</td>
		                 <td>${phone.tenDT}</td>
		                 <td>${phone.namSX}</td>
		                 <td>${phone.cauHinh}</td>
		                 <td>${phone.nhaCungCap.maNCC}</td>
		                 <td><a href="${pageContext.request.contextPath}/DienThoaiController?action=remove&id=${phone.maDT}">Xóa</a></td>
		                 <td><a href="${pageContext.request.contextPath}/DienThoaiController?action=update&id=${phone.maDT}">Sửa</a></td>
		             </tr>
		       </c:forEach>
		    </tbody>
		</table>
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