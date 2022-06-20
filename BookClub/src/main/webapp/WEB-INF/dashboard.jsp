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
<link rel="stylesheet" href="https://maxcdn.bootstdapcdn.com/bootstdap/4.0.0/css/bootstdap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<title>Dashboard</title>
</head>
<body>
	<div class="container">
		<div>	
			<div style="display:flex;">
				<h1>Welcome, <c:out value="${name}"/> </h1>
				<a href="/logout" style="margin:auto;">logout</a>
			</div>
			<div style="display:flex;">
				<h4>Books from everyone's shelves:</h4>
				<a href="/new" style="margin:auto;">Add A Book To My Shelf!</a>
			</div>
			<table class="table table-striped">
				<tr>
					<td>ID</td>
					<td>Title</td>
					<td>Author Name</td>
					<td>Posted By</td>
				</tr>
				<c:forEach var="book" items="${books}">
					<tr>
						<td>
							<c:out value="${book.id}"/>
						</td>
						<td>
							<a href="/books/${book.id}">
								<c:out value="${book.title}"/>
							</a>
						</td>
						<td>
							<c:out value="${book.author}"/>
						</td>
						<td>
							<c:out value="${book.user.name}"/>
						</td>
					</tr>
					</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>