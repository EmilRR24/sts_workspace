<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<title>Ninja Gold Game</title>
</head>
<body>
	<div class="container">
		<h1>Ninja Gold Game</h1>
		<div style="display:flex; justify-content:space-between;">
		<div style="display:flex;">
		<h2>Your Gold:</h2>
		<h2 style="border: solid black 1px;"><c:out value="${gold}"/></h2>
		</div>
			<form action="/reset" method="get">
			<button>Reset Game!</button>
			</form>
		</div>
		<div style="display:flex; justify-content:space-between;">
		<form action="/farm" method="POST" style="border: solid black 2px;padding:1em;text-align:center;">
			<h3>Farm</h3>
			<h4>(earns 10-20 gold)</h4>
			<button>Find Gold!</button>
		</form>
		<form action="/cave" method="POST" style="border: solid black 2px;padding:1em;text-align:center;">
			<h3>Cave</h3>
			<h4>(earns 5-10 gold)</h4>
			<button>Find Gold!</button>
		</form>
		<form action="/house" method="POST" style="border: solid black 2px;padding:1em;text-align:center;">
			<h3>House</h3>
			<h4>(earns 2-5 gold)</h4>
			<button>Find Gold!</button>
		</form>
		<form action="/quest" method="POST" style="border: solid black 2px;padding:1em;text-align:center;">
			<h3>Quest</h3>
			<h4>(earns/loses 0-50 gold)</h4>
			<button name="quest">Find Gold!</button>
		</form>
		</div>
		<h3>Activities:</h3>
		<div style="border: solid black 2 px; width: 100%; height:200px;background-color:pink;overflow:auto;">
			<c:forEach items="${activities}" var="activity">
				<p>
				<c:out value="${activity}"/>
				</p>
			</c:forEach>>
		</div>
	</div>
</body>
</html>