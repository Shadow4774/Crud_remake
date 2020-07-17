<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <title></title>
    <link rel="stylesheet" href="css/styleNewLoginPage.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js" charset="utf-8"></script>
 	<style type="text/css"><%@include file="/css/styleNewLoginPage.css" %></style>
  </head>
  <body>

    <form method="post" action="ServletControl" class="login-form">
	<input type="hidden" name="op" value="insertLogin">
        <h1>Create New User</h1>

        <div class="txtb">
          <input type="text" name="uname">
          <span data-placeholder="Choose your Username"></span>
        </div>

        <div class="txtb">
          <input type="password" name="pwd">
          <span data-placeholder="Choose your Password"></span>
        </div>

        <input type="submit" class="logbtn" value="Submit">
        
        <div class="bottom-text">
         You don't need? 
         <a href="Login.jsp">Go Back</a>
        </div>

      </form>

      <script type="text/javascript">
      $(".txtb input").on("focus",function(){
        $(this).addClass("focus");
      });

      $(".txtb input").on("blur",function(){
        if($(this).val() == "")
        $(this).removeClass("focus");
      });

      </script>


  </body>
</html>