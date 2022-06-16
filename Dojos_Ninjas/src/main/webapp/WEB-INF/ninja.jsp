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
<title>Create New Ninja</title>
</head>
<body>
	<div class="container">
		<h1>Create A Ninja</h1>
		<form:form action="/ninja/new" method="POST" modelAttribute="ninjaObj" style="margin-bottom:1em;">
			<h3>Select Dojo:
			<form:select path="dojo" >
				<c:forEach var="dojo" items="${dojos}">
					<form:option value="${dojo.id}">
						<c:out value="${dojo.location}"/>
					</form:option>
				</c:forEach>
			</form:select>
			</h3>
		    <h3>
		        <form:label path="fName">First Name:</form:label>
		        <form:input path="fName"/>
		    </h3>
		    <h3 style="color:red;"><form:errors path="fName"/></h3>
		    	    <h3>
		        <form:label path="lName">Last Name:</form:label>
		        <form:input path="lName"/>
		    </h3>
		    <h3 style="color:red;"><form:errors path="lName"/></h3>
		    	    <h3>
		        <form:label path="age">Age:</form:label>
		        <form:input path="age"/>
		    </h3>
		    <h3 style="color:red;"><form:errors path="age"/></h3>
		    <button>Create</button>
		</form:form>    
	</div>
</body>
</html>