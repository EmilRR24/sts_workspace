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
<title>Place A Bet</title>
</head>
<body>
	<div class="container">
		<h1>Place A Bet!</h1>		
		<form action="">		
			<h4>{GAME NAME}</h4>
			<input type="hidden" />
			<h4>Total To Bet</h4>
			<input type="num" value=""/>
			<div style="display:flex;">			
			<h4>WIN</h4>
			<input type="radio" name="choice" value="WIN" style="margin:0 .5em;" checked/>
			<h4>LOSE</h4>
			<input type="radio" name="choice" value="LOSE" style="margin:0 .5em"/>
			</div>
			<input type="submit" value="Place Bet"/>
		</form>
		<div style="border: solid black 3px;padding:.5em;margin:1em 0;">
			<h3>Game Statistics</h3>
			<p>Win Condition</p>
			<p># of Bets</p>
		</div>
		
	</div>
</body>
</html>