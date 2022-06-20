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
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<div style="display:flex;">
			<h1>Add A Book!</h1>	
			<a href="/books" style="margin:auto;">back to the shelves</a>
		</div>
		<form:form action="/book/new" method="POST" modelAttribute="bookObj" style="margin-bottom:1em;">
		    <h3>
		        <form:label path="title">Title:</form:label>
		        <form:input path="title"/>
		    </h3>
		    <h3 style="color:red;"><form:errors path="title"/></h3>
		    	    <h3>
		        <form:label path="author">Author:</form:label>
		        <form:input path="author"/>
		    </h3>
		    <h3 style="color:red;"><form:errors path="author"/></h3>
		    	    <h3>
		        <form:label path="thoughts">Thoughts:</form:label>
		        <form:input path="thoughts"/>
		    </h3>
		    <h3 style="color:red;"><form:errors path="thoughts"/></h3>
		    <form:input type="hidden" path="user.id" value="${user_id}"/> 
		    <button>Submit</button>
		</form:form>    
	</div>
</body>
</html>