<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">

#buttons {
	margin-top: 20px;
}
</style>
</head>
<body>
	<table border="1">
		<thead>
			<tr>
				<th>Faculty ID</th>
				<th>Full Name</th>
				<th>Research Area</th>
				<th>Telephone Number</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${dsGiangVien}" var="giangVien">
				<tr>
					<td>${giangVien.maGV}</td>
					<td>
						<p>
							<span>${giangVien.tenGV}</span>
						</p>
						<p>
							<span style="text-decoration: underline;">Danh sách đề tài
								:</span>
						</p>
						<p>
							<c:choose>
								<c:when test="${not empty dsDeTai[giangVien.maGV]}">
									<ul style="padding-left: 20px;">
										<c:forEach items="${dsDeTai[giangVien.maGV]}" var="deTai">
											<li>${deTai.tenDeTai}</li>
										</c:forEach>
									</ul>
								</c:when>
								<c:otherwise>
								</c:otherwise>
							</c:choose>
						</p>
					</td>
					<td>${giangVien.linhVucNghienCuu}</td>
					<td>${giangVien.soDienThoai}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div id="buttons">
		<button onclick="window.location.href='${pageContext.request.contextPath}/GiangVienController?action=chuyenAddGV'">Thêm giảng viên</button>
		<button onclick="window.location.href='${pageContext.request.contextPath}/DeTaiController?action=chuyenAddDT'">Thêm đề tài</button>
		
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