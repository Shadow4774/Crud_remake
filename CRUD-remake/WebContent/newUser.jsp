<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">
<link href="css/newUserStyle.css" rel="stylesheet" type="text/css">
<meta charset="ISO-8859-1">

<div class='mainBox'>


	<div class='line'>


		<a class='w' href="menu.jsp">Home Page</a> 
		<a class='w'href="ServletControl?op=list">ListUsers</a>
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
			<label class='words'>New User</label>
		</div><br>
<form action="ServletControl" method="POST" name="dati">
	<input type=hidden name="op" value="insert">

		<div class='row'>
			<label class='word'>Name:</label> <input class='in' type='text' name= 'name' id='name'></input>
		</div>

		<div class='row'>
			<label class='word'>Surname:</label> <input class='in' type='text' name= 'surname' id='surname'></input>
		</div>
		<div class='row'>
			<label class='word'>BirthDate:</label> <input class='in' type="date" name="birth" 
			value="2000-01-01"></input>
		</div>
	
	
		<div class='row'>
		<label class='word'>Type:</label>
		<div class= 'typeForm'>
			<label class='word'>Owner</label> <input class='' type="radio" name="type"
										value="O" id="owner" checked/>
										
			 <label class='word'>Spouse</label> <input class='' type="radio" name="type"
										value="S" id="spouse">
										
			<label class='word'>Child</label> <input class='' type="radio" name="type"
										value="C" id="Child">
		</div>
</div>
		<div class='block'>
			<button class='btn'>ADD</button>
		
			

</div>
</form>	
</div>
</div>
</html>