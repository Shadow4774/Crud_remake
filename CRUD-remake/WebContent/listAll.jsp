<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table>
		<thead>
			<tr>
				<th>NO</th>
				<th>Id</th>
				<th>Name</th>
				<th>Surname</th>
				<th>Birthdate</th>
				<th>Creation Timestamp</th>
				<th>Age</th>
				<th>Type</th>
				<th>Operations</th>
			</tr>
		</thead>
		<tbody>
			<c:set var="count" value="0" scope="page" />
			<c:forEach var="user" items="${users }">
				<c:set var="count" value="${count + 1 }" scope="page" />
				<tr>
					<td><c:out value="${count }" /></td>
					<td><c:out value="${user.id }" /></td>
					<td><c:out value="${user.name }" /></td>
					<td><c:out value="${user.surname }" /></td>
					<td><c:out value="${user.birthDate }" /></td>
					<td><c:out value="${user.creationTimestamp }" /></td>
					<td><c:out value="${user.age }" /></td>
					<td><c:out value="${user.type }" /></td>
					<td><a href="/CRUD-remake/ServletControl?op=edit&id=<c:out value ="${user.id }"/>">Edit</a>
						&nbsp;&nbsp;&nbsp;&nbsp;
						<a href="/CRUD-remake/ServletControl?op=delete&id=<c:out value ="${user.id }"/>">Delete</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<br><br>
	<a href="/CRUD-remake/index.html">Main Page</a>
</body>
</html>