<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="tag" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
th {
	text-align: inherit;
	padding: 10px;
}
</style>
</head>
<body>
	<div class="container">
		<ul class="nav">
			<li class="nav-item"><a class="nav-link active" href="#">Active</a>
			</li>
			<li class="nav-item"><a class="nav-link" href="#">Link</a></li>
			<li class="nav-item"><a class="nav-link" href="#">Link</a></li>
			<li class="nav-item"><a class="nav-link disabled" href="#"
				tabindex="-1" aria-disabled="true">Disabled</a></li>
		</ul>
	</div>

	<table class="table">
		<thead>
			<tr class="table-dark">
				<th>ID</th>
				<th>Name</th>
				<th>Category</th>
				<th>Brand ID</th>
				<th>Quantity</th>
				<th>Price</th>
				<th>Description</th>
				<th>Create Date</th>
			</tr>
		</thead>
		<tbody>
			<tag:forEach var="product" items="${productList}">
				<tr>
					<td>${product.productId}</td>
					<td>${product.name}</td>
					<td>${product.categoryId}</td>
					<td>${product.brandId}</td>
					<td>${product.qty}</td>
					<td>${product.description}</td>
					<td>${product.create}</td>
				</tr>
			</tag:forEach>
		</tbody>
	</table>

</body>
</html>