<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">
<link href="css/searchPageStyle.css" rel="stylesheet" type="text/css">
<meta charset="ISO-8859-1">

<div class='mainBox'>


	<div class='line'>


		<a class='w' href="menu.jsp">Home Page</a> 
		<a class='w' href="ServletControl?op=list">List Users</a> 
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
			<label class='words'>Search User</label>
		</div>
		
		<form action="ServletControl" method="POST" name="dati">
			<input type=hidden name="op" value="search">
            
            
            <div class='rowThree'>
			<div class='middleRow3'>
				<label class='word'>Name:</label> 
				<input class='in' type='text' name='name' id='name'></input> 
				</div>
				<div class='middleRow1'>		
					<label class='word'>Surname:</label>
				<input class='in' type='text' name='surname' id='surname'></input>
			</div>
            </div>
			
				   <div class='middleRow4'>
					<label class='word'>Age:</label>
					</div>
					<div class='rowThree'>
					<div class='middleRow3'>
					<label class='word'>from</label> <input class='in' type='number'
						name='lowerAgeBound' id='lowerAgeBound'></input>
			        </div>
                    <div class='middleRow1'>				
					<label class='word'>to</label> <input class='in' type='number'
						name='upperAgeBound' id='upperAgeBound'></input>
			
			</div>
			</div>	

			
				<div class='middleRow4'>
					<label class='word'>BirthDate:</label>
				</div>
                <div class='rowThree'>
				<div class='middleRow3'>
					<label class='word'>from</label> <input class='in' type="date"
						name="lowerBdBound" id="lowerBdBound" value="1970-01-01"></input>
				</div>

				<div class='middleRow1'>
					<label class='word'>to</label> <input class='in' type="date"
						name="upperBdBound" id="upperBdBound" value="2500-01-01"></input>
				</div>

			</div>
                    <div class='middleRow3'>
					<label class='word'>Type:</label> 
					 <div class='d'>
				    </div>
                <div class='rowThree'>
				
					<div class='typeForm'>
					<div class='middleRow'>
						<label class='word'>Owner</label> 
						<input class='' type="radio" name="type" value="O" id="owner"/> 
						</div>
						<div class='middleRow'>
						<label class='word'>Spouse</label>
						<input class='' type="radio" name="type" value="S" id="spouse">
                        </div>
                        <div class='middleRow'>
						<label class='word'>Child</label> 
						<input class='' type="radio" name="type" value="C" id="Child">
					
					</div>
					</div>
				</div>
				<div class='rowThree'>
			<div class='block'>
			<button class='btn'>Search</button>
				
				</div>
				</div>
			</div>
			
		</form>
	</div>
</div>
</html>