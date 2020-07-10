<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<style type="text/css"><%@include file="/css/menuStyle.css"%></style>
<meta charset="ISO-8859-1">

<div>

	<div class='mainBox'>

		<div class='line'>

			
			 <a class='words'>Home Page</a>
			 <a class='words' href="ServletControl?op=list">List Users</a>
			 <a class='words' href="newUser.jsp">Insert User</a>
			<div class='date'>
				<%
					java.text.DateFormat df = new java.text.SimpleDateFormat("dd/MM/yyyy hh:mm");
				%>
				<h5><%=df.format(new java.util.Date())%>
				</h5>
			</div>

		</div>




	</div>

</div>




</html>