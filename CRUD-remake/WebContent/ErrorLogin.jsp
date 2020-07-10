<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <title></title>
    <link rel="stylesheet" href="ErrorLoginCreateUser.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js" charset="utf-8"></script>
 	<style type="text/css"><%@include file="/css/ErrorLoginCreateUser.css" %></style>
  </head>
  
  <body>

    <form method="post" action="ServletControl" class="login-form">
	<input type="hidden" name="op" value="login">
        
        <h1>Unsuccessfully Login<br><br><a href="/CRUD-remake/Login.jsp">BACK TO LOGIN</a></h1>
  	</form>
  	</body>
</html>