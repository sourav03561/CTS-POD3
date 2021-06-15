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


<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>



</head>
<body>
	<%@ include file="navbar.jsp"%>
	HEY THERE
	<div class="container">
		<div class="container">
			<h3>Pharmacy Medicine Supply</h3>
			<form:form action="/pharmacy/medicineSupply" method="POST"
				modelAttribute="medicineDemand">
				<div class="form-group">
					<form:label path="medicineName">Medicine Name:</form:label>
					<form:input path="medicineName" class="form-control"
						id="medicineName" type="text" required="required" />
				</div>
				<div class="form-group">
					<form:label path="demandCount">Demand Count:</form:label>
					<form:input path="demandCount" class="form-control"
						id="demandCount" type="text" required="required" />
				</div>
				<input type="submit" value="Get Supply">
				<input type="reset" value="Reset">
			</form:form>
			<div></div class="container">
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
		<div>
</body>
</html>