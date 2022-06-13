<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Omikuji</title>
</head>
<body>	
	<div style="text-align:center;">
	<h1>Here's Your Omikuji!</h1>
	<h2 style="padding:1em; height:auto; width:400px; margin:auto; border:solid black 2px; background:lightblue;">In <c:out value="${number}"/> years, you will live in <c:out value="${city}"/> with <c:out value="${name}"/> as your roommate, selling <c:out value="${profession}"/> for a living. The next time you see a <c:out value="${thing}"/>, you will have good luck. Also, <c:out value="${nice}"/>.</h2>
	<a href="/">Back</a>
	</div>
</body>
</html>