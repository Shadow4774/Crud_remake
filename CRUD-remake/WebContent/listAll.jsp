<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!doctype html>
<html lang="en">
<head>
<title>Users List</title>
</head>
<body>
	<div class="mdl-layout mdl-js-layout mdl-layout--fixed-header">
		<%@include file="menu.jsp"%>

		<main class="mdl-layout__content ">
			<div class="page-content">
				<div class="mdl-grid center-items">
					<div class="mdl-cell mdl-cell--4-col">
						<div>
							<table
								class="mdl-data-table mdl-js-data-table mdl-data-table--selectable mdl-shadow--2dp ">
								<thead>
									<tr>
										<th class="mdl-data-table_cell--non-numeric ">NO</th>
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
											<td><a
												href="/CRUD-remake/ServletControl?op=edit&id=<c:out value ="${user.id }"/>">Edit</a>
												&nbsp;&nbsp;&nbsp;&nbsp; <a
												href="/CRUD-remake/ServletControl?op=delete&id=<c:out value ="${user.id }"/>">Delete</a>
											</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
							<br>
							<br> <a href="/CRUD-remake/menu.jsp">Main Page</a>

						</div>
					</div>
				</div>
			</div>
		</main>
	</div>
</body>
</html>