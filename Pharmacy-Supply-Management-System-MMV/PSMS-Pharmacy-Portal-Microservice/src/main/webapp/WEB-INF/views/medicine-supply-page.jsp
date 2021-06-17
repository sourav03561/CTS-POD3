<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pharmacy Medicine Supply</title>


  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>



</head>
<body>
	<%@ include file="navbar.jsp"%>
	<div class="container pt-5 pb-5">
	
	<a type="button" class="btn btn-outline-dark active"  href="/pharmacy/medicineSupply">Get Supply</a>
	<a type="button" class="btn btn-outline-dark"  href="/pharmacy/getSupplyRecords">Supply Records</a>
	<a type="button" class="btn btn-outline-dark"  href="/pharmacy/getDemandRecords">Demand Records</a>
	
		<div class="container pt-5">
			<h3>Pharmacy Medicine Supply</h3>
			<form:form action="/pharmacy/medicineSupply" method="POST"
				modelAttribute="medicineSupplyPageInput">
				<div class="form-group">
					<form:label path="medicines">Medicine Names:</form:label>
					<br>
					<small class="text-muted">Enter comma(,) seperated names</small>
					<form:input path="medicines" class="form-control"
						id="medicines" type="text" required="required" />
				</div>
				<div class="form-group">
					<form:label path="counts">Demand Counts:</form:label>
					<br>
					<small class="text-muted">Enter comma(,) seperated count</small>
					<form:input path="counts" class="form-control"
						id="counts" type="text" required="required" />
				</div>
				<input class="btn btn-success" type="submit" value="Get Supply">
				<input class="btn btn-warning" type="reset" value="Reset">
			</form:form>
			</div>
			<div class="container pt-5">
			<table class="table">
				<thead>
					<tr>
						<th>Pharmacy Name</th>
						<th>Medicine Name</th>
						<th>Supply Count</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${pharmacyMedicineSupply}" var="supply">
						<tr>
							<td>${supply.getPharmacyName()}</td>
							<td>${supply.getSupplyCount()}</td>
							<td>${supply.getMedicineName()}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		</div>
		<%@ include file="footer-dark.jsp"%>
</body>
</html>