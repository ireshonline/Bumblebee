<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="tag" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<head>
<meta charset="ISO-8859-1">
<title>Bumble Bee</title>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin="anonymous"></script>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
	
	<script>
function deleted()
{
alert(${message});
}
</script>
</head>
<body>


<div class="row">
 <div class="col-8 col-md-2">	<jsp:include page="Sidebar_nav.jsp"></jsp:include>
</div>
  <div class="col-12 col-md-10">


		

		<div class="card col-md-10 mx-auto mt-4">
			<table class="table table-striped table-hover">
				<thead>
					<tr>
						<th scope="col"></th>
						<th scope="col">Category ID</th>
						<th scope="col">Category Name</th>
						<th scope="col">Action</th>
					</tr>
				</thead>
				<tbody>
					<tag:forEach var="category" items="${categoryList}">
						<tr>
							<td></td>
							<td>${category.categoryId}</td>
							<td>${category.categoryName}</td>
							<td>
								<form method="post" action="cateorycontroller">
									<input type="hidden" name="categoryId"
										value="${category.categoryId}" /> <input type="hidden"
										name="type" value="delete" />
									
									<button type="submit"
										style="border: none; background-color: transparent;">
										<i class="fa fa-trash text-danger" aria-hidden="true"></i>
									</button>
								</form>
							</td>
						</tr>
					</tag:forEach>
				</tbody>
			</table>
		</div>




	<script src="/docs/5.0/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/feather-icons@4.28.0/dist/feather.min.js"
		integrity="sha384-uO3SXW5IuS1ZpFPKugNNWqTZRRglnUJK6UAZ/gxOX80nxEkN9NcGZTftn6RzhGWE"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/chart.js@2.9.4/dist/Chart.min.js"
		integrity="sha384-zNy6FEbO50N+Cg5wap8IKA4M/ZnLJgzc6w2NqACZaK0u0FXfOWRRJOnQtpZun8ha"
		crossorigin="anonymous"></script>
	<script src="dashboard.js"></script>


</body>
</html>