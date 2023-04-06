<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
    
        <%@ taglib prefix="tag" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
  	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<div class="row">
 <div class="col-8 col-md-2">	<jsp:include page="Sidebar_nav.jsp"></jsp:include>
</div>
  <div class="col-12 col-md-10">
	<div class="row align-items-center justify-content-center mt-5">
		<div class="col-md-9 mx-auto text-center">
			<p class="text-success">${message}</p>
		</div>
	</div>
      
 	<div class="card col-md-10 mx-auto mt-4">
		<table class="table table-striped table-hover">
			  <thead>
			    <tr>
			      <th scope="col"></th>
			      <th scope="col">Stock ID</th>
			      <th scope="col">Product ID</th>
			      <th scope="col">Available Stock</th>
			      <th scope="col">Sold Amount</th>
			      <th scope="col">Action</th>
			    </tr>
			  </thead>
			  <tbody>
			  	<tag:forEach var="stock" items="${stockList}">
			  		<tr>
				      <td></td>
				      <td>${stock.inventoryId}</td>
				      <td>${stock.productId}</td>
				      <td>${stock.availableStock}</td>
				      <td>${stock.soldAmount}</td>
				      <td>
					      <form method="post" action="manage-inventory">
					      	<input type="hidden" name="inventoryId" value="${stock.inventoryId}" />
					      	<input type="hidden" name="type" value="delete" />
					      	<button type="submit" style="border: none; background-color: transparent;"><i class="fa fa-trash text-danger" aria-hidden="true"></i></button>
					      </form>
				      </td>
				    </tr>
			  	</tag:forEach>
			  </tbody>
			</table>
		</div>
</body>
</html>