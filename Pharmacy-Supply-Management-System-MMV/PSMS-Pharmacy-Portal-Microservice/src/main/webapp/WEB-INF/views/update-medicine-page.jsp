<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Medicine</title>

  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</head>
<body>
<%@ include file="navbar.jsp"%>
	<div class="container pt-5">
	<a type="button" class="btn btn-outline-dark"  href="/pharmacy/getStockInformation">Stock Information</a>
	<a type="button" class="btn btn-outline-dark"  href="/pharmacy/addMedicine">Add Medicine to Stock</a>
	<a type="button" class="btn btn-outline-dark"  href="/pharmacy/deleteMedicine">Delete a Medicine</a>
	<a type="button" class="btn btn-outline-dark active"  href="/pharmacy/updateMedicine">Update Medicine to Stock</a>
	</div>
	
	<div class="container pt-5">
			<form:form action="/pharmacy/updateMedicine" method="POST" modelAttribute="medicineStock">
				<div class="form-group">
					<form:label path="id">Medicine Id:</form:label>
					<form:select path="id" class="form-control" id="id" items="${listOfStock}" required="required"/>
				</div>
				<div class="form-group">
					<form:label path="name">Medicine Name:</form:label>
					<form:input path="name" class="form-control" id="name" type="text" required="required"/>
				</div>
				<div class="form-group">
					<form:label path="chemicalComposition">Chemical Composition:</form:label>
					<form:input path="chemicalComposition" class="form-control" id="chemicalComposition" type="text" required="required"/>
				</div>
				<div class="form-group">
					<form:label path="targetAilment">Target Ailment:</form:label>
					<form:input path="targetAilment" class="form-control" id="targetAilment" type="text" required="required"/>
				</div>
				<div class="form-group">
					<form:label path="dateOfExpiry">Date of Expiry:</form:label>
					<form:input path="dateOfExpiry" class="form-control" id="dateOfExpiry" type="date" required="required"/>
				</div>
				<div class="form-group">
					<form:label path="numberOfTabletsInStock">No. of tablets in stock:</form:label>
					<form:input path="numberOfTabletsInStock" class="form-control" id="numberOfTabletsInStock" type="text" required="required"/>
				</div>
				
				<input type="submit" class="btn btn-success" value="Update Medicine">
				<input type="reset" class="btn btn-warning" value="Reset">
				<h1>${success }</h1>
			</form:form>
		</div>
		<%@ include file="footer-dark.jsp"%>
</body>
</html>