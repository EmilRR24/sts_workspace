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
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<h1>Registration</h1>
			<form:form action="/register" method="post" modelAttribute="newUser">
				<p>
					First Name:
					<form:input path="firstName" />
					<form:errors path="firstName" />
				</p>
				<p>
					Last Name:
					<form:input path="lastName" />
					<form:errors path="lastName" />
				</p>
				<p>
					User Name:
					<form:input path="userName" />
					<form:errors path="userName" />
				</p>
				<p>
					Email:
					<form:input path="email" />
					<form:errors path="email" />
				</p>
				<p>
					Password:
					<form:input path="password" />
					<form:errors path="password" />
				</p>
				<p>
					Confirm Password:
					<form:input path="confirm" />
					<form:errors path="confirm" />
				</p>
				<button>Register</button>
			</form:form>
		
		
			<h1>Login</h1>
			<form:form action="/login" method="post" modelAttribute="newLogin">
				<p>
					Email:
					<form:input path="email" />
					<form:errors path="email" />
				</p>
				<p>
					Password:
					<form:input path="password" />
					<form:errors path="password" />
				</p>
				<button>Login</button>
			</form:form>	
		
	</div>
</body>
</html>