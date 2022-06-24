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
<title>Book Details</title>
</head>
<body>
	<div class="container">
		<div style="display:flex;margin-bottom:2em;">
			<h1>
				<c:out value="${book.title}"/>
			</h1>
			<a href="/books" style="margin:auto;">back to the shelves</a>
		</div>
		<div class="text-justify;" style="display:inline-flex;">
			<h2 style="color:red;margin-right:.25em;">
				<c:choose>	
				    <c:when test="${user_id == book.user.id}">
						You 
	    			</c:when>
				    <c:otherwise>
				        <c:out value="${book.user.name} "/>
				    </c:otherwise>
				</c:choose>
			
			</h2>
			<h2>read</h2>
			<h2 style="color:purple;margin:0 .25em">
				<c:out value="${book.title}"/> 
			</h2>
			<h2 style="margin-right:.25em;">by </h2>
			<h2 style="color:green;"> <c:out value="${book.author}"/> </h2>
			<h2>.</h2>
		</div>
		<div>
			<h3>
				Here are <c:out value="${book.user.name}"/>'s thoughts: 	
			</h3>
		</div>
		<div style="border-top:solid black 2px;border-bottom:solid black 2px;border-radius:5px;">
			<h4>
				<c:out value="${book.thoughts}"/> 
			</h4>
		</div>
	    <c:if test="${user_id == book.user.id}">
			<div style="margin-top:1em;">
			<a href="/edit/${book.id}">Edit</a>
			</div>
    	</c:if>
	</div>
</body>
</html>