<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.menu {
	display: flex;
	justify-content: center;
	align-items: center;
	background-color: #333;
	color: white;
	padding: 10px;
	background-color: #333;
}

.menu a {
	color: white;
	text-decoration: underline;
	margin: 0 10px;
}

img {
	width: 100%;
	height: 200px;
}

footer {
	display: flex;
	justify-content: center;
	align-items: center;
}

table {
	width: 100%;
}
}
</style>
</head>
<body>
   <header>
      <img alt="" src="../sources/images/header.png">
       <div class="menu">
            <a>Danh sách tin tức</a> |
            <a> Thêm tin tức mới</a> |
            <a> Chức năng quản lý</a>
       </div>
   </header>
   <div>
       <table border="2">
          <thead>
				<tr>
					<th>Tên danh mục</th>
					<th>Danh sách tin tức</th>
				</tr>
		  </thead>
		  <tbody>
		     <c:forEach items="${dsDM}" var="danhMuc">
		           <tr>
					 <td>${danhMuc.tenDanhMuc}</td>
					 <td>${danhMuc.tenDanhMuc}</td>
				   </tr>
		     </c:forEach>
		  </tbody>
       </table>
   </div>

   <footer>
        <p>Phan Nguyễn Khôi Nguyên - 21068021 - DHKTPM17C</p>
   </footer>

</body>
</html>