<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<title><c:out value="${dojo.location}"/> Location</title>
</head>
<body>
	<div class="container">
		<a href="/">Home</a>
		<h1><c:out value="${dojo.location}"/></h1>
		<h3>All Ninjas Here:</h3>
		<table class="table">
			<tr>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Age</th>
			</tr>
		<c:forEach var="ninja" items="${dojo.ninjas}">	
			<tr>
				<td>
					<c:out value="${ninja.fName}"/>
				</td>
				<td>
					<c:out value="${ninja.lName}"/>
				</td>
				<td>
					<c:out value="${ninja.age}"/>
				</td>
			</tr>			
		</c:forEach>
		</table>
	</div>
</body>
</html>