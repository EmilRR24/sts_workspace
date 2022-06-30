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
		<div style="display:flex;justify-content:space-evenly;">
			<div>
				<c:if test="${empty notCompleted}">
					<form action="/gamer/${user_id}" method="POST">
						<h4>Game Name:</h4>
						<input type="text" name="name"/>
						<input type="hidden" value="started" name="result"/>
						<input type="hidden" name="user_id" value="${user_id}"/>
						<input style="margin-top:.5em" type="submit" value="Start Game"/>
					</form>
				</c:if>
				<c:if test="${not empty game}">
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
				</c:if>
				<c:if test="${not empty notPaid}">
					<c:forEach var="game" items="${notPaid}">
						<h1> <c:out value="${game.name}"/> </h1>
						<form action="/gamer/${game.gamer.id}/payout" method="POST">
							<input type="hidden" name="_method" value="PUT">
							<input type="hidden" name="game_id" value="${game.id}">
							<input type="submit" name="completed" value="Pay Out" />
						</form>
					</c:forEach>
				</c:if>
				<div>
					<h4>Game Statistics</h4>
					<p># of Bets : <c:out value="${allBets}"/> </p>
				</div>		
			</div>
			<div>
				<img src="/img/stream.png" alt="stream" style="width:100%; margin:1em;" />
				<div style="text-align:center;height:350px">
					<h4>Game History</h4>
					<table class="table table-striped" style="overflow-y:scroll;">
						<tr>
							<th>Game ID:</th>
							<th>Game Name:</th>
							<th>Game Result:</th>
							<th>Completed At:</th>
						</tr>
						<c:forEach var="game" items="${historyGames}">
							<tr>
								<td><c:out value="${game.id}"/></td>
								<td><c:out value="${game.name}"/></td>
								<td><c:out value="${game.result}"/></td>
								<td><c:out value="${game.updatedAt}"/></td>
							</tr>
						</c:forEach>
					</table>
				</div>
			</div>		
		</div>
	</div>
</body>
</html>