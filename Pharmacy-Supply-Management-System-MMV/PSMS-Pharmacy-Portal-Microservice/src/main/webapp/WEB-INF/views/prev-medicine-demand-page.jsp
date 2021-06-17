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
	<a type="button" class="btn btn-outline-dark"  href="/pharmacy/medicineSupply">Get Supply</a>
	<a type="button" class="btn btn-outline-dark"  href="/pharmacy/getSupplyRecords">Supply Records</a>
	<a type="button" class="btn btn-outline-dark active"  href="/pharmacy/getDemandRecords">Demand Records</a>
	
		<div class="container pt-5">
			<h3>Medicine Demand Records</h3>
		</div>
		<div class="container pt-5">
			<table class="table">
				<thead>
					<tr>
						<th>Medicine Name</th>
						<th>Demand Count</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${prevDemand}" var="demand">
						<tr>
							<td>${demand.getMedicineName()}</td>
							<td>${demand.getDemandCount()}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
<%@ include file="footer-dark.jsp"%>
</body>
</html>