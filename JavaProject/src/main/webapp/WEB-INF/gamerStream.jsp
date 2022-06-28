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
<title></title>
</head>
<body>
	<div class="container">
		<div style="display:flex;justify-content:space-evenly;">
			<div>
				<c:if test="${empty games}">
					<form action="/gamer/${user_id}" method="POST">
						<h4>Game Name:</h4>
						<input type="text" name="name"/>
						<input type="hidden" value="started" name="result"/>
						<input type="hidden" name="user_id" value="${user_id}"/>
						<input style="margin-top:.5em" type="submit" value="Start Game"/>
					</form>
				</c:if>
				<c:forEach var="game" items="${games}">
					<h1> <c:out value="${game.name}"/> </h1>
					<form action="/gamer/${game.gamer.id}" method="POST">
						<input type="hidden" name="_method" value="PUT">
						<input type="hidden" name="game_id" value="${game.id}">
						<div style="display:flex;">					
							<input type="submit" name="result"value="WIN" />
							<p style="margin:0 .5em;">|</p>
							<input type="submit" name="result" value="LOSE" />
						</div>
					</form>
				</c:forEach>
				<div>
					<h4>Game Statistics</h4>
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