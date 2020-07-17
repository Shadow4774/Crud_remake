<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">
<link href="css/menuStyle.css" rel="stylesheet" type="text/css">
<meta charset="ISO-8859-1">

<div class='mainBox'>

<div class='line'>


<a class='words'>Home Page</a>
<a class='words' href="ServletControl?op=list">List Users</a>
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
</div>

</html>