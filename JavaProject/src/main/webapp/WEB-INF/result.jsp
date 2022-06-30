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
<title>Game Result</title>
</head>
<body>
	<div style="padding:1% 20%;display:flex;align-items:center; justify-content:space-between; background-color:#71D514">
		<a href="/" style="width:217px">
			<img src="/img/Gamer Kings-logos_transparent.png" alt="logo" style="width:100%;"/>
		</a>
		<div style="display:flex">
			<a href="/account/${user_id}" style="color:black">Account</a>
			<c:if test="${not empty user_id}">			
			<p style="margin:0 1em;">|</p>
			<a href="/logout" style="color:black">Logout</a>
			</c:if>
		</div>
	</div>
	<div class="container">
		<h1>Result Page!</h1>
		<div style="border:solid black 3px; padding: .5em;">	
			<h4>Game Statistics</h4>
		</div>
		<h2>Total Amount {WON/LOST} {bet.amount}</h2>
		<div style="text-align:center;">	
			<a href="/gamelist">BET AGAIN</a>
		</div>
	</div>
</body>
</html>