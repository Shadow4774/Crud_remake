<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<link href="css/listAllStyle.css" rel="stylesheet" type="text/css">

<div class='mainBox'>

	<div class='line'>

		<a class='words' href="menu.jsp">Home Page</a> 
		<a class='words'href="ServletControl?op=list">List Users</a>
		<a class='words' href="newUser.jsp">Insert User</a>
		<a class='words' href="Login.jsp">Logout</a>
		<div class='date'>
			<%
				java.text.DateFormat df = new java.text.SimpleDateFormat("dd/MM/yyyy hh:mm");
			%>
			<h5><%=df.format(new java.util.Date())%>
			</h5>
		</div>

	</div>
<div class='space'></div>
	<div class='space'>
	<div>
	<form method="get" action="searchPage.jsp">
    <input class='btn2' type="submit" value="Search Again" />
	</form>
	</div>
	</div>
	<div class='space'></div>

						<table class='t'>

		<tr class='head'>
			<th class='words'>Id</th>
			<th class='words'>Name</th>
			<th class='words'>Surname</th>
			<th class='words'>BirthDate</th>
			<th class='words'>Creation TimeStamp</th>
			<th class='words'>Age</th>
			<th class='words'>Type</th>
			<th class='words'>Operation</th>
		</tr>
									
								
									<c:forEach items="${user}" var="user">
										
										<tr>
											
											<td class='block'>${user.id }</td>
											<td class='block'>${user.name }</td>
											<td class='block'>${user.surname }</td>
											<td class='block'>${user.birthDate }</td>
											<td class='block'>${user.creationTimestamp }</td>
											<td class='block'>${user.age}</td>
											<td class='block'>${user.type}</td>
											<td><a class='block'
												href="/CRUD-remake/ServletControl?op=edit&id=<c:out value ="${user.id }"/>">Edit</a>
												&nbsp;&nbsp;&nbsp;&nbsp; 
												<a class='block'
												href="/CRUD-remake/ServletControl?op=delete&id=<c:out value ="${user.id }"/>">Delete</a>
											</td>
										</tr>
									</c:forEach>
							</table>
							
	
</div>
</html>