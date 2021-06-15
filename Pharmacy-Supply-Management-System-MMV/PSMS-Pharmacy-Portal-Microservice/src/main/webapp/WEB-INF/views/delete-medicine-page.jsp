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
<title>Insert title here</title>

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
	<a type="button" class="btn btn-primary"  href="/pharmacy/getStockInformation">Stock Information</a>
	<a type="button" class="btn btn-primary"  href="/pharmacy/addMedicine">Add Medicine to Stock</a>
	<a type="button" class="btn btn-primary active"  href="/pharmacy/deleteMedicine">Delete a Medicine</a>
	<a type="button" class="btn btn-primary"  href="/pharmacy/updateMedicine">Update Medicine to Stock</a>
	<a type="button" class="btn btn-primary"  href="/pharmacy/addMedicine">Add Medicine to Stock</a>
	</div>
	
	<div class="container">
		<h3>Medical Representative Schedule</h3>
			<form:form action="/pharmacy/deleteMedicine" method="POST" modelAttribute="deleteStockInput">
				<div class="form-group">
					<form:label path="id">Select a medicine id to delete:</form:label>
					<form:select path="id" class="form-control" id="id" items="${listOfStock}" required="required"/>
				</div>
				<input type="submit" value="Delete">
				<input type="reset" value="Reset">
				
				<h3>${success }</h3>
			</form:form>
			<div>
</body>
</html>