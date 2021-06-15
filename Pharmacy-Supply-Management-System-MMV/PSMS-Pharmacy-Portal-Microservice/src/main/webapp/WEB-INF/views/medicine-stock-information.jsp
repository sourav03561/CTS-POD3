<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Medicine Stock</title>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>



</head>
<body>
	<%@ include file="navbar.jsp"%>
	<div class="container">
	<a type="button" class="btn btn-primary active"  href="/pharmacy/getStockInformation">Stock Information</a>
	<a type="button" class="btn btn-primary"  href="/pharmacy/addMedicine">Add Medicine to Stock</a>
	<a type="button" class="btn btn-primary"  href="/pharmacy/deleteMedicine">Delete a Medicine</a>
	<a type="button" class="btn btn-primary"  href="/pharmacy/updateMedicine">Update Medicine to Stock</a>
	<a type="button" class="btn btn-primary"  href="/pharmacy/addMedicine">Add Medicine to Stock</a>
	</div>

	<div class="container">
		<h2>Stock Available</h2>
		<p>Medicines available in stock</p>
		<table class="table">
			<thead>
				<tr>
					<th>ID</th>
					<th>NAME</th>
					<th>CHEMICAL COMP.</th>
					<th>TARGET AILMENT</th>
					<th>DOE</th>
					<th>No. of TABLETS</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${stockInfo}" var="stock">
					<tr>
						<td>${stock.getId()}</td>
						<td>${stock.getName()}</td>
						<td>${stock.getChemicalComposition()}</td>
						<td>${stock.getTargetAilment()}</td>
						<td>${stock.getDateOfExpiry()}</td>
						<td>${stock.getNumberOfTabletsInStock()}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

</body>
</html>