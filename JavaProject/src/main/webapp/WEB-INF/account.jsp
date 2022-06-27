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
<title>Account Page</title>
</head>
<body>
	<div class="container">
		<div>
			<h1>Welcome, <c:out value="${userObj.userName}"/> !</h1>
		</div>
		<div style="margin-bottom:1em;">
			<c:if test="${empty userObj.gamer.stream}">
				<h4>Become A Gamer!</h4>
				<form action="/account/gamer" method="POST">		
				<p>Stream Link: <c:out value="${userObj.gamer.stream}"/></p>
				<input type="text" name="stream"/>
				<input type="hidden" name="user_id" value="${userObj.id}"/>
				<input type="submit" value="Save Stream"/>
				</form>
			</c:if>
			<c:if test="${not empty userObj.gamer.stream}">
			<div style="display:flex;justify-content:space-between;">
				<div>
					<h4>Become A Gamer!</h4>
					<form action="/account/gamer/edit" method="POST">		
						<input type="hidden" name="_method" value="PUT">
						<p>Stream Link: <c:out value="${userObj.gamer.stream}"/></p>
						<input type="text" name="stream"/>
						<input type="hidden" name="user_id" value="${userObj.id}"/>
						<input type="submit" value="Save Stream"/>
					</form>
				</div>
				<div>
					<h3>Start A Game!</h3>
					<form action="/gamer/${userObj.id}" method="POST">
						<h4>Game Name:</h4>
						<input type="text" name="name"/>
						<input type="hidden" value="started" name="result"/>
						<input type="hidden" name="user_id" value="${userObj.id}"/>
						<input type="submit" value="Start Game"/>
					</form>
				</div>
			</div>
			</c:if>
		</div>
		<form method="POST" action="/account/${user_id}" ">
			<input type="hidden" name="_method" value="PUT">
			<p>
				First Name:
				<input type="text" name="firstName" value="<c:out value="${userObj.firstName}"/>" />
			</p>			
			<p>
				Last Name:
			<input type="text" name="lastName" value="<c:out value="${userObj.lastName}"/> "/>
			</p>
			<p>
				User Name:
				<input type="text" name="userName" value="<c:out value="${userObj.userName}"/> " />
			</p>

			<input type="submit" value="Update"/>
		</form>
		<div style="display:flex;justify-content: space-between;">
			<div>
				<a href="/gamelist">PLACE A BET</a>
				<h2>Active Bets</h2>
				<table class="table table-striped">
					<tr>
						<td>
						
						</td>
					</tr>
				</table>
			</div>
			<div>	
				<div style="display:flex;justify-content:space-evenly;">
					<a href="">ADD POINTS</a>
					<p style="margin:0 .5em;"> | </p>
					<a href="">SPEND POINTS</a>
				</div>		
				<h2>Total Points: <c:out value="${userObj.total}"/></h2>
				<table class="table table-striped">
					<tr>
						<th>
							<p>RESULT</p>
						</th>
						<th>
							<p>GAME ID</p>
						</th>
						<th>
							<p>WON/LOST</p>
						</th>
					</tr>
				</table>
			</div>
		</div>
	</div>
</body>
</html>