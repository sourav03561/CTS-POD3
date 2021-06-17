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
<title>Delete Medicine</title>

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
	<a type="button" class="btn btn-outline-dark active"  href="/pharmacy/deleteMedicine">Delete a Medicine</a>
	<a type="button" class="btn btn-outline-dark"  href="/pharmacy/updateMedicine">Update Medicine to Stock</a>
	</div>
	
	<div class="container pt-5">
		<h3>Medical Representative Schedule</h3>
			<form:form action="/pharmacy/deleteMedicine" method="POST" modelAttribute="deleteStockInput">
				<div class="form-group">
					<form:label path="id">Select a medicine id to delete:</form:label>
					<form:select path="id" class="form-control" id="id" items="${listOfStock}" required="required"/>
				</div>
				<input type="submit" class="btn btn-danger" value="Delete">
				<input type="reset" class="btn btn-warning" value="Reset">
				
				<h3>${success }</h3>
			</form:form>
			</div>
			<%@ include file="footer-dark.jsp"%>
</body>
</html>