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
<title>Edit Book</title>
</head>
<body>
	<div class="container">
		<div style="display:flex;">
			<h1>Change your Entry</h1>
			<a href="/books" style="margin:auto">back to the shelves</a>
		</div>
		<form:form method="POST" action="/edit/${bookObj.id}" modelAttribute="bookObj">
			<input type="hidden" name="_method" value="put">
			<p>
				Title:
				<form:input type="text" path="title" />
			</p>
   			<p style="color:red;"><form:errors path="title"/></p>			
			<p></p>
			<p>
				Author:
				<form:input type="text" path="author" />
			</p>
			<p style="color:red;"><form:errors path="author"/></p>
			<p>
				My Thoughts:
				<form:input type="text" path="thoughts" />
			</p>
			<p style="color:red;"><form:errors path="thoughts"/></p>
			<form:input type="hidden" path="user.id" value="${user_id}"/> 
			<input type="submit" value="Submit"/>
		</form:form>
	</div>
</body>
</html>