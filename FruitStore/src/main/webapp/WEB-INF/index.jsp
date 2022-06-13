<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="/css/style.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Fruit Store</title>
</head>
<body>
	<div class="container">
		<div class="main">
			<h1>Fruit Store</h1>
			<table class="table table-striped" style="width: 50%; margin:auto;">
			<tr>
			<th>Name</th>
			<th>Price</th>
			</tr>	
			<c:forEach var="fruit" items="${fruits}">
			<tr>	
		    	<td><c:out value="${fruit.name}"/></td>
		    	<td><c:out value="${fruit.price}"/></td>
			</tr>
			</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>