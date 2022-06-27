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
<title>Streamer Page</title>
</head>
<body>
	<div class="container">
		<div style="display:flex;justify-content:space-evenly;">
			<div>
				<h1> <c:out value="${newGame.name}"/> </h1>
				<div style="display:flex;">
					<a href="">START GAME</a>
					<c:if test=""></c:if>
					<a href="">WIN</a>
					<p style="margin:0 .5em;">|</p>
					<a href="">LOSE</a>
				</div>
				<div>
					<h4>Game Statistics</h4>
					<p>Win Conditions</p>
					<p># of Bets</p>
				</div>		
			</div>
			<div>
				<img src="/img/stream.png" alt="stream" style="width:100%; margin:1em;" />
			</div>		
		</div>
	</div>
</body>
</html>