<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Edit User</h1>
 <form action="/CRUD-remake/ServletControl?op=update" method="post">
 	<input type="hidden" name="id" value="${user.id }">
 	<label for="name">First name:</label>
	<input type="text" name="name" id="name" value="${user.name }"><br>
	<label for="surname">Last name:</label>
	<input type="text" name="surname" id="surname" value="${user.surname }"><br>
	<label for="date">Birth date:</label>
	<input type="date" name="birth" id="birth" value="${user.birthDate }"><br>
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