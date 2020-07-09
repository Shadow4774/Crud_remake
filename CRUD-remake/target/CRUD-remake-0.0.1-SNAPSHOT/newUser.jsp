<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New user</title>
</head>
<body>
 <h1>New User</h1>
 <form action="/CRUD-remake/ServletControl?op=insert" method="post">
 	<label for="name">First name:</label>
	<input type="text" name="name" id="name"><br>
	<label for="surname">Last name:</label>
	<input type="text" name="surname" id="surname"><br>
	<label for="date">Birth date:</label>
	<input type="date" name="birth" id="birth" value="2000-01-01"><br>
	Type: 
	<label for="owner">Owner</label>
	<input type="radio" name="type" id="owner" value="O" checked>
	<label for="spouse">Spouse</label>
	<input type="radio" name="type" id="spouse" value="S">
	<label for="child">Child</label>
	<input type="radio" name="type" id="child" value="C"><br>
	 <input type="submit">
 </form>
</body>
</html>