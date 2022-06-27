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
	<div class="container">
		<h1>Game Stream Page</h1>
		<div style="display:flex;">
			<div>
				<h4>Amount Placed: {bet.amount}</h4>
				<p style="border: solid black 3px; padding:.5em">Game Statistics</p>
				<p style="border: solid black 3px; padding:.5em">Game Name. Number of Bets.</p>
			</div>
			<div style="margin:0 2em; text-align:center">
				<img src="/img/stream.png" alt="stream" style="width:100%"/>
				<a href="/bet/game/1/result">RESULTS</a>
			</div>
		</div>
	</div>
</body>
</html>