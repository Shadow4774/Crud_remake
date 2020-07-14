<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">
<link href="css/newUserStyle.css" rel="stylesheet" type="text/css">
<meta charset="ISO-8859-1">

<div class='mainBox'>


	<div class='line'>


		<a class='w' href="menu.jsp">Home Page</a> 
		<a class='w'href="ServletControl?op=list">List Users</a>
		<a class='w' href="newUser.jsp">Insert User</a>
		<a class='w' href="Login.jsp">Logout</a>
		<div class='date'>
			<%
				java.text.DateFormat df = new java.text.SimpleDateFormat("dd/MM/yyyy hh:mm");
			%>
			<h5><%=df.format(new java.util.Date())%>
			</h5>
		</div>

	</div>

	<div class='space'></div>
	<div class='box'>
		<div class='rowLine'>
			<label class='words'>Edit User</label>
		</div>
						
							<div>
								<form name="myForm"
									action="/CRUD-remake/ServletControl?op=update" method="post">

									<div class="row">
										<input class="in" type="hidden" name="id"
											value="${user.id }">
									</div>

									<div class="row">
										<label class="word" for="name">Name:</label>
										<input class=" in" type="text" name="name"
											id="name" value="${user.name }">
									</div>

									<div class="row">
										<label class="word" for="surname">Surname:</label>
										<input class=" in" type="text"
											name="surname" id="surname" value="${user.surname }">
									</div>

									<div class="row">
										<label class="word" for="date">Birthdate:</label>
										<input class=" in" type="date" name="birth"
											id="birth" value="${user.birthDate }">
									</div>

                                    <div class="row">
									<label class='word'>Type:</label>
									<div class="typeForm">
										<label class="word" for="owner">Owner</label>
										<input class=" " type="radio" name="type"
											id="owner" value="O" checked>
									
									
										<label class="word" for="spouse">Spouse</label>
										<input class=" " type="radio" name="type"
											id="spouse" value="S">
									
										<label class="word" for="child">Child</label>
										<input class=" " type="radio" name="type"
											id="child" value="C"><br>
									</div>
                                    </div>
									<div class='block'>
		                            	<button class='btn'>EDIT</button>
		                            	</div>
								</form>
							</div>
						</div>
					</div>	

</html>