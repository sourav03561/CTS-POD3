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
<title>Add Representative</title>
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
	<a class="btn btn-primary"  href="/pharmacy/addPharmacy">Add Pharmacy</a>
	<a class="btn btn-primary active" href="/pharmacy/addRepresentative">Add Representative</a>
		<div class="container">
			<form:form action="/pharmacy/addRepresentative" method="POST" modelAttribute="medicalRepresentative">
				<div class="form-group">
					<form:label path="name">Enter the Representative Name to be added:</form:label>
					<form:input path="name" class="form-control" id="name" type="text" required="required"/>
				</div>
				<input type="submit" value="Add Representative">
				<input type="reset" value="Reset">
				<h1>${success }</h1>
			</form:form>
		</div>
	</div>
</body>
</html>