<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<title>Omikuji Form</title>
</head>
<body>
	<div style="text-align:center;">
	<h1>Send and Omikuji!</h1>
	<form method="POST" action="/submit" class="form-horizontal">
		<label>Pick a number from 5 to 25:</label>
		<div>
		<input type="number" name="number" value="0"/>
		</div>
		<label>Enter the name of any city:</label>
		<div>
		<input type="text" name="city"/>
		</div>
		<label>Enter the name of any real person:</label>
		<div>
		<input type="text" name="name"/>
		</div>
		<label>Enter professional endeavor or hobby:</label>
		<div>
		<input type="text" name="profession"/>
		</div>
		<label>Enter any type of living thing:</label>
		<div>
		<input type="text" name="thing"/>
		</div>
		<label>Say something nice to someone:</label>
		<div>
		<textarea name="nice" rows="4" cols="50"></textarea>
		</div>
		<label>Send and show a friend</label>
		<div>
		<button>Send</button>
		</div>
	</form>
	</div>
</body>
</html>