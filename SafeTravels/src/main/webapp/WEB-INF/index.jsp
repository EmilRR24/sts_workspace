<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<title>Travel Expenses</title>
</head>
<body>
	<div class="container">
		<h1>Safe Travels</h1>
		<table class="table table-striped">
			<tr>
				<th>Expense</th>
				<th>Vendor</th>
				<th>Amount</th>
			</tr>
			<c:forEach var="travel" items="${travels}">
			<tr>	
		    	<td><c:out value="${travel.expense}"/></td>
		    	<td><c:out value="${travel.vendor}"/></td>
		    	<td><c:out value="${travel.amount}"/></td>
			</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>