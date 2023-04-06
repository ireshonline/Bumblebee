<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html>
<html>

	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</head>
<body>

	
	<main class="col-md-9 ms-sm-auto col-lg-10 px-md-4"><div class="chartjs-size-monitor"><div class="chartjs-size-monitor-expand"><div class=""></div></div><div class="chartjs-size-monitor-shrink"><div class=""></div></div></div>

	<div class="container mt-4">
		<nav class="nav nav-pills flex-column flex-sm-row">
		  <a class="flex-sm-fill text-sm-center nav-link border" href="product_controller">All Products</a>
		  <a class="flex-sm-fill text-sm-center nav-link active" aria-current="page" href="#">Add Product</a>
		  <a class="flex-sm-fill text-sm-center nav-link border" href="updateproduct.jsp">Update Product</a>
		</nav>
	</div>
	
	<div class="row align-items-center justify-content-center mt-5">
		<div class="col-md-9 mx-auto text-center">
			<p class="text-success">${message}</p>
		</div>
	</div>
	
	<div class="card col-md-10 mx-auto mt-4">
		<form method="post" action="product_controller" class="row align-items-center justify-content-center mt-3">
			<div class="row align-items-center justify-content-center ">
            	<div class="col mb-3 col-md-5">
					<label for="txtProductName">Product Name</label>
					<input type="text" id="txtProductName" class="form-control" name="productName" />
				</div>
			</div>
			<div class="row align-items-center justify-content-center ">
            	<div class="col mb-3 col-md-5">
					<label for="txtCategoryId">Category ID</label>
					<input type="text" id="txtCategoryId" class="form-control" name="categoryId" />
				</div>
			</div>
			<div class="row align-items-center justify-content-center ">
            	<div class="col mb-3 col-md-5">
					<label for="txtBrandId">Brand ID</label>
					<input type="text" id="txtBrandId" class="form-control" name="brandId" />
				</div>
			</div>
			<div class="row align-items-center justify-content-center ">
            	<div class="col mb-3 col-md-5">
					<label for="txtQuantity">Quantity</label>
					<input type="text" id="txtQuantity" class="form-control" name="qty" />
				</div>
			</div>
			<div class="row align-items-center justify-content-center ">
            	<div class="col mb-3 col-md-5">
					<label for="txtProductPrice">Price</label>
					<input type="text" id="txtProductPrice" class="form-control" name="price" />
				</div>
			</div>
			<div class="row align-items-center justify-content-center ">
            	<div class="col mb-3 col-md-5">
					<label for="txtDescription">Description</label>
					<input type="text" id="txtDescription" class="form-control" name="productInfo" />
				</div>
			</div>
			
			<input type="hidden" name="type" value="add" />
			
			<div class="row align-items-center justify-content-center ">
            	<div class="col mb-3 col-md-2">
            		<button type="submit" id="btnsubmit" class="btn btn-success form-control">Add Product</button>
            	</div>
            </div>
		</form>
	</div>

  	</main>

<script src="/docs/5.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/feather-icons@4.28.0/dist/feather.min.js" integrity="sha384-uO3SXW5IuS1ZpFPKugNNWqTZRRglnUJK6UAZ/gxOX80nxEkN9NcGZTftn6RzhGWE" crossorigin="anonymous"></script><script src="https://cdn.jsdelivr.net/npm/chart.js@2.9.4/dist/Chart.min.js" integrity="sha384-zNy6FEbO50N+Cg5wap8IKA4M/ZnLJgzc6w2NqACZaK0u0FXfOWRRJOnQtpZun8ha" crossorigin="anonymous"></script><script src="dashboard.js"></script>

</html>