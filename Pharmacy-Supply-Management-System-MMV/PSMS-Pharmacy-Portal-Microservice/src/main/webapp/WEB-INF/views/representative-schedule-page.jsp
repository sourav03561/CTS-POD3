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
<title>Representative Schedule</title>

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
		<div class="container">
		<h3>Medical Representative Schedule</h3>
			<form:form action="/pharmacy/getRepSchedule" method="POST" modelAttribute="repScheduleInput">
				<div class="form-group">
					<form:label path="date">Enter date:</form:label>
					<form:input path="date" class="form-control" id="date" type="date" required="required"/>
				</div>
				<input type="submit" value="Get Schedule">
				<input type="reset" value="Reset">
			</form:form>
			<div>
			</div class="container">
			<table class="table">
				<thead>
				<tr>
					<th>Representative Name</th>
					<th>Doctor Name</th>
					<th>Meeting Slot</th>
					<th>Meeting Date</th>
					<th>Doctor Contact Number</th>
					<th>Medicines</th>
					<th>Ailment</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${repSchedule}" var="schedule">
					<tr>
						<td>${schedule.getRepName()}</td>
						<td>${schedule.getDoctorName()}</td>
						<td>${schedule.getMeetingSlot()}</td>
						<td>${schedule.getMeetingDate()}</td>
						<td>${schedule.getDoctorContactNumber()}</td>
						<td>${schedule.getMedicines()}</td>
						<td>${schedule.getTreatingAilment()}</td>
					</tr>
				</c:forEach>
			</tbody>
 			</table>
		</div>
	</div>

</body>
</html>