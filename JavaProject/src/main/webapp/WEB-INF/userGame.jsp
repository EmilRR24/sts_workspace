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
<title>Viewer Page</title>
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
		<h1>Game Stream Page</h1>
		<div style="display:flex;">
			<div>
				<h4>Amount Placed: <c:out value="${currentBet.amount}"/></h4>
				<p>Game Statistics</p>
				<p>Number of bets: <c:out value="${allBets}"/></p>
				
			</div>
			<div style="margin:0 2em; text-align:center">
				<img src="/img/stream.png" alt="stream" style="width:100%"/>
				<a href="/bet/game/${currentBet.id}/result">RESULTS</a>
			</div>
		</div>
	</div>
</body>
</html>