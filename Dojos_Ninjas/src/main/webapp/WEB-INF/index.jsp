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
<title>Dojos and Ninjas</title>
</head>
<body>
	<div class="container">
		<h1>Create A Dojo:</h1>
		<form:form action="/new" method="POST" modelAttribute="dojoObj" style="margin-bottom:1em;">
		    <h3>
		        <form:label path="location">Dojo Location:</form:label>
		        <form:input path="location"/>
		    </h3>
		    <h3 style="color:red;"><form:errors path="location"/></h3>
		    <button>Create</button>
		</form:form>    
		<a href="/ninja" style="font-weight:bold;">CREATE A NINJA</a>
		<h1>Dojo Locations</h1>
		<c:forEach var="dojo" items="${dojos}">
		<div>
			<a href="/dojo/${dojo.id}"><c:out value="${dojo.location}"/></a>
		</div>
		</c:forEach>
	</div>
</body>
</html>