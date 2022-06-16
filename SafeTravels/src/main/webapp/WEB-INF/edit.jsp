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
<title>Edit Expense</title>
</head>
<body>
	<div class="container">
		<h1>Edit Expense</h1>
		<a href="/">Go Back</a>
		<form:form method="POST" action="/edit/${travelObj.id}" modelAttribute="travelObj">
			<input type="hidden" name="_method" value="put">
			<p>
				Name:
				<form:input type="text" path="expense" />
			</p>
   			<p style="color:red;"><form:errors path="expense"/></p>			
			<p></p>
			<p>
				Email:
				<form:input type="text" path="description" />
			</p>
			<p style="color:red;"><form:errors path="description"/></p>
			<p>
				Password:
				<form:input type="text" path="vendor" />
			</p>
			<p style="color:red;"><form:errors path="vendor"/></p>
			<p>
				Age:
				<form:input type="number" path="amount" />
			</p>
			<p style="color:red;"><form:errors path="amount"/> </p>
			<input type="submit" value="Submit"/>
		</form:form>
	</div>
</body>
</html>