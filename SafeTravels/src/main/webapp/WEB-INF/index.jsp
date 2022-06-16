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
				<th>Action</th>
			</tr>
			<c:forEach var="travel" items="${travels}">
			<tr>	
		    	<td><c:out value="${travel.expense}"/></td>
		    	<td><c:out value="${travel.vendor}"/></td>
		    	<td>$<c:out value="${travel.amount}"/></td>
		    	<td>
		    		<a href="/edit/${travel.id}" style="color:blue;">Edit</a>
		    		<form action="/delete/${travel.id}" method="POST">
		    		<input type="hidden" name="_method" value="delete" />
		    		<input type="submit" value="Delete">
		    		</form>
		    	</td>
			</tr>
			</c:forEach>
		</table>
		<h2>Add an Expense:</h2>
		<form:form action="/new" method="POST" modelAttribute="travelObj">
    <p>
        <form:label path="expense">Expense Name:</form:label>
        <form:input path="expense"/>
    </p>
    <p style="color:red;"><form:errors path="expense"/></p>
    <p>
        <form:label path="description">Description:</form:label>
        <form:textarea path="description"/>
    </p>
    <p style="color:red;"><form:errors path="description"/></p>
    <p>
        <form:label path="vendor">Vendor:</form:label>
        <form:input path="vendor"/>
    </p>
    <p style="color:red;"><form:errors path="vendor"/></p>
    <p>
        <form:label path="amount">Amount:</form:label>    
        <form:input type="number" path="amount"/>
    </p>    
    <p style="color:red;"><form:errors path="amount"/> </p>
    <input type="submit" value="Submit"/>
</form:form>    
	</div>
</body>
</html>