<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin="anonymous"></script>
</head>
<body>

<div class="row">
 <div class="col-8 col-md-2">	<jsp:include page="Sidebar_nav.jsp"></jsp:include>
</div>
  <div class="col-12 col-md-8">
<div class="row align-items-center justify-content-center mt-5">
			<div class="col-md-9 mx-auto text-center">
				<p class="text-success">${message}</p>
			</div>
		</div>

		<div class="card col-md-10 mx-auto mt-4">
			<form method="post" action="brandcontroller"
				class="row align-items-center justify-content-center mt-3">
				<div class="row align-items-center justify-content-center ">
					<div class="col mb-3 col-md-5">
						<label for="txtBrandName">Brand Name</label> <input type="text"
							id="txtBrandName" class="form-control" name="brandName" />
					</div>
				</div>

				<input type="hidden" name="type" value="add" />

				<div class="row align-items-center justify-content-center ">
					<div class="col mb-3 col-md-2">
						<button type="submit" id="btnsubmit"
							class="btn btn-success form-control">Add Brand</button>
					</div>
				</div>
			</form>
		</div>
</div>
 
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